package cn.kspshare.jwt;

import cn.kspshare.config.KspConstants;
import cn.kspshare.common.restful.ResultBean;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功
 * @author niXueChao
 * @date 2019/3/12.
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RsaSigner signer;
    private KspConstants kspConstants;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        //写入基本用户基本信息到token。
        JwtUserInfo principal = (JwtUserInfo) authentication.getPrincipal();
        Map<String, Object> tokeInfo = new HashMap<>();
        tokeInfo.put("username", principal.getUsername());
        tokeInfo.put("expiredSecond", kspConstants.jwtExpiredSecend);
        tokeInfo.put("tokenCreateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //签发token
        String token = JwtHelper.encode(JSON.toJSONString(tokeInfo), signer).getEncoded();
        // String token = JwtHelper.encode(JSON.toJSONString(authentication.getPrincipal()), signer).getEncoded();
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        response.getWriter().write(JSON.toJSONString(ResultBean.SUCCESS(data)));
    }

    public void setSigner(RsaSigner signer) {
        this.signer = signer;
    }

    public void setKspConstants(KspConstants kspConstants) {
        this.kspConstants = kspConstants;
    }

    public static void main(String[] args) {
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(format);
    }
}
