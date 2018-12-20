package cn.kspshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private MyUserDetailService myUserDetailsService;

    @Autowired
    public void setMyUserDetailsService(MyUserDetailService myUserDetailsService){
        this.myUserDetailsService = myUserDetailsService;
    }

    /**
     * 匹配 "/" 路径，不需要权限即可访问
     * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
     * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"  ， 登录失败跳转/login?error
     * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
     * 默认启用 CSRF， POST请求需要添加 _csrf.token 处理
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().disable() //禁用csrf
                .authorizeRequests()
                .antMatchers("/").permitAll()
                //.anyRequest().authenticated() //其它访问都拦截
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/user")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }


    /**
     * 登录账号密码验证
     *
     * 类 AuthenticationManagerBuilder
     * 意思是，AuthenticationManagerBuilder 用于创建一个 AuthenticationManager，
     * 让我能够轻松的实现内存验证、LADP验证、基于JDBC的验证、添加UserDetailsService、添加AuthenticationProvider。
     */

    //方式一：基于内存验证
    //@Bean
    //@Override
    //protected UserDetailsService userDetailsService() {
    //    User.UserBuilder users = User.withDefaultPasswordEncoder();
    //    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //    manager.createUser(users.username("user").password("pwd").roles("USER").build());
    //    return manager;
    //}

    //方式二：基于UserDetailsService， 实现自定义登录校验
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(myUserDetailsService);
    }

    /**
     * 密码加密
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
