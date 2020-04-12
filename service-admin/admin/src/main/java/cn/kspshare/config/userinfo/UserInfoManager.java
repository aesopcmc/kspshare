package cn.kspshare.config.userinfo;

import cn.kspshare.config.RedisUtils;
import cn.kspshare.domain.KspAdminUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Component
public class UserInfoManager {
    @Autowired
    RedisUtils redisUtils;

    public void setUserInfoToRedis(String token, KspAdminUser user) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(user, userInfo);
        if(user.getOid()==1) {
            userInfo.setAdmin(true);
        }
        redisUtils.set(token, userInfo, 60*60);//1小时
    }

    public UserInfo getUserInfo() {
        try {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = httpServletRequest.getHeader("Authorization").replace("Bearer ", "");// 从 http 请求头中取出 token

            UserInfo userInfo = redisUtils.get(token);
            if(userInfo==null) {
                throw new RuntimeException("用户身份认证失败，无法获取当前用户信息！");
            }
            return userInfo;
        }catch (Exception e) {
            log.error("获取当前用户信息失败！", e);
            return null;
        }
    }
}
