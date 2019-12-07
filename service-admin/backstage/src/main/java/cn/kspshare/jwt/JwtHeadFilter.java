package cn.kspshare.jwt;

import cn.kspshare.service.KspAdminUserService;
import cn.kspshare.service.KspPermService;
import cn.kspshare.config.KspException;
import cn.kspshare.domain.KspAdminUser;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 拦截请求，解析TOKEN，验证token, 加载用户当前用户信息到spring security 上下文
 * @author niXueChao
 * @date 2019/4/3 15:03.
 */
@Slf4j
public class JwtHeadFilter extends OncePerRequestFilter {

    private RsaVerifier verifier;

    private KspAdminUserService kspAdminUserService;

    private KspPermService kspPermService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        if (token==null || token.isEmpty()){
            filterChain.doFilter(request,response);
            return;
        }

        JwtUserInfo user;
        try {
            //
            Jwt jwt = JwtHelper.decodeAndVerify(token.replace("Bearer ", ""), verifier);//token.replace("Bearer ", "")
            String claims = jwt.getClaims();
            user = JSON.parseObject(claims, JwtUserInfo.class);

            //添加检查用户是否过期,冻结...
            if(user.getTokenCreateTime().plusSeconds(user.getExpiredSecond()).isBefore(LocalDateTime.now())) {
                throw new KspException("登录已过期，请重新登录");
            }

            //根据用户名判断是否是超级管理员
            if("super".equalsIgnoreCase(user.getUsername())) {
                user.setAdminFlag(true);
            }

            //TODO 需要优化：通过Redis 拿用户、权限信息
            //根据用户名，从数据库拿取该用户的详细信息（密码，权限等）
            KspAdminUser kspUser = kspAdminUserService.findByUsername(user.getUsername());
            if(!kspUser.getEnabled()) {
                throw new KspException("当前用户被冻结，禁止登录");
            }
            List<String> permValues = kspPermService.listResourceIdByUser(kspUser.getOid());
            List<SimpleGrantedAuthority> authorities = permValues.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
            user.setAuthorities(authorities);
        } catch (KspException e) {
            log.warn(e.getMessage());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(e.getMessage());
            return;
        } catch (Exception e){
            //这里也可以filterChain.doFilter(request,response)然后return,那最后就会调用
            //.exceptionHandling().authenticationEntryPoint,也就是本列中的"需要登陆"
            log.error(e.getMessage(), e);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("token 失效");
            return;
        }

        //把用户和权限信息设置到Spring Security 的上下文
        JwtLoginToken jwtLoginToken = new JwtLoginToken(user, "", user.getAuthorities());
        jwtLoginToken.setDetails(new WebAuthenticationDetails(request));
        SecurityContextHolder.getContext().setAuthentication(jwtLoginToken);
        filterChain.doFilter(request,response);
    }


    public void setVerifier(RsaVerifier verifier) {
        this.verifier = verifier;
    }

    public void setKspAdminUserService(KspAdminUserService kspAdminUserService) {
        this.kspAdminUserService = kspAdminUserService;
    }

    public void setKspPermService(KspPermService kspPermService) {
        this.kspPermService = kspPermService;
    }
}
