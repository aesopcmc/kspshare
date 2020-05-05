package cn.kspshare.interceptor;


import cn.kspshare.annotation.PassToken;
import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.config.RedisUtils;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.domain.AdminUser;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.utils.JwtTokenUtils;
import cn.kspshare.config.userinfo.UserInfo;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Token拦截器
 *
 * 保存当前用户信息到redis
 * 验证token注解，执行拦截
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AdminUserService userService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserInfoManager userInfoManager;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查Controller类上有没有UserLoginToken注解
        if(handlerMethod.getBeanType().isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = handlerMethod.getBeanType().getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                return checkAuth(httpServletRequest);
            }
        }
        //检查方法上有没有UserLoginToken注解
        else if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                return checkAuth(httpServletRequest);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * 检测身份信息
     * @param httpServletRequest
     * @return
     */
    private boolean checkAuth(HttpServletRequest httpServletRequest) {
        //获取请求头的token
        String token;
        try {
            token = httpServletRequest.getHeader("Authorization").replace("Bearer ", "");// 从 http 请求头中取出 token
        }catch (Exception e) {
            throw new RuntimeException("没有检测到请求头包含token，请重新登录",e);
        }

        // 获取 token 中的 user id
        String userId;
        try {
            DecodedJWT decodedJWT = JwtTokenUtils.decodedJWT(token);
            userId = decodedJWT.getAudience().get(0);

            //获取token自定义中的信息
            System.out.println(decodedJWT.getClaim("oid").asString());
            System.out.println(decodedJWT.getClaim("username").asString());
        } catch (JWTDecodeException j) {
            throw new RuntimeException("Token解析出错，请重新登录", j);
        }


        if(redisUtils.exists(token)) {
            //用户信息存在，从redis取出，验证token信息
            UserInfo userInfo = userInfoManager.getUserInfo();
            String secret = userInfo.getPassword();
            checkToken(token, secret);
        }else {
            //用户信息不存在，从数据库读取，验证token信息，存入redis
            AdminUser user = userService.queryById(Long.valueOf(userId));
            if (user == null) {
                throw new RuntimeException("用户不存在，请重新登录");
            }
            checkToken(token, user.getPassword());
            userInfoManager.setUserInfoToRedis(token, user);
        }
        return true;
    }

    /**
     * 验证 token
     * @param token
     * @param secret
     */
    private void checkToken(String token, String secret) {
        try {
            JwtTokenUtils.verifyToken(token, secret);
        } catch (TokenExpiredException e) {
            throw new RuntimeException("token过期，请重新登录", e);
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}