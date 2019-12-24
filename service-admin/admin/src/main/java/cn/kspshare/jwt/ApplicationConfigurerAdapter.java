package cn.kspshare.jwt;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.KspAdminUserService;
import cn.kspshare.service.KspPermService;
import cn.kspshare.config.KspConstants;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 配置登录过滤器
 * 配置JWT校验过滤器
 * 配置拦截规则
 * @author niXueChao
 * @date 2019/4/2 22:58.
 */
@Configuration
public class ApplicationConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private RsaVerifier verifier;
    @Autowired
    private RsaSigner signer;
    @Autowired
    private JwtUserDetailServiceImpl jwtUserDetailService;
    @Autowired
    private KspAdminUserService kspAdminUserService;
    @Autowired
    private KspPermService kspPermService;
    @Autowired
    private KspConstants kspConstants;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //登录过滤器
        JwtLoginFilter jwtLoginFilter = new JwtLoginFilter();
        jwtLoginFilter.setAuthenticationManager(this.authenticationManagerBean());

        //登录成功和失败的操作
        LoginSuccessHandler loginSuccessHandler = new LoginSuccessHandler();
        loginSuccessHandler.setSigner(signer);
        loginSuccessHandler.setKspConstants(kspConstants);
        jwtLoginFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        jwtLoginFilter.setAuthenticationFailureHandler(new LoginFailureHandler());

        //登录过滤器的授权提供者(就这么叫吧)
        JwtAuthenticationProvider provider = new JwtAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(jwtUserDetailService);

        //JWT校验过滤器
        JwtHeadFilter headFilter = new JwtHeadFilter();
        headFilter.setVerifier(verifier);
        headFilter.setKspPermService(kspPermService);
        headFilter.setKspAdminUserService(kspAdminUserService);

        //添加放行的url， 放行后不用认证，没有用户状态
        String[] permAll = new String[]{
                "/js/**",
                "/css/**",
                "/img/**",
                "/login/**",
                "/anyMsg/**",
                "/test/**"
        };

        http
                //身份验证入口,当需要登录却没登录时调用
                //具体为,当抛出AccessDeniedException异常时且当前是匿名用户时调用
                //匿名用户: 当过滤器链走到匿名过滤器(AnonymousAuthenticationFilter)时,
                //会进行判断SecurityContext是否有凭证(Authentication),若前面的过滤器都没有提供凭证,
                //匿名过滤器会给SecurityContext提供一个匿名的凭证(可以理解为用户名和权限为anonymous的Authentication),
                //这也是JwtHeadFilter发现请求头中没有jwtToken不作处理而直接进入下一个过滤器的原因
            .exceptionHandling().authenticationEntryPoint((request, response, authException) -> {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JSON.toJSONString(ResultBean.FAIL("需要登陆")));
        })

            //拒绝访问处理,当已登录,但权限不足时调用
            //抛出AccessDeniedException异常时且当不是匿名用户时调用
            .accessDeniedHandler((request, response, accessDeniedException) -> {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().write(JSON.toJSONString(ResultBean.NO_PERMISSION()));
            })
            .and()
            .authorizeRequests()
            .antMatchers(permAll).permitAll()
            .anyRequest().authenticated()
            // .antMatchers("/", "/home").access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
            // .anyRequest().access("@accessDecisionService.hasPermission(request , authentication)")
            .and()
            //将授权提供者注册到授权管理器中(AuthenticationManager)
            .authenticationProvider(provider)
            .addFilterAfter(jwtLoginFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilterAfter(headFilter, JwtLoginFilter.class)
            //禁用session
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf().disable();
    }

    /**
     * 密码加密方式：BCryptPasswordEncoder
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
