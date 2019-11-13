package cn.kspshare.backstage.jwt;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 登录过滤器
 *
 * @author niXueChao
 * @date 2019/4/2 14:07.
 */
@Slf4j
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    JwtLoginFilter() {
        super(new AntPathRequestMatcher("/jwtLogin", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {

            Map<String, String> requestParams = this.getRequestParams(request);

            String userName = requestParams.get("username");
            String password = requestParams.get("password");
            //创建未认证的凭证(etAuthenticated(false)),注意此时凭证中的主体principal为用户名
            JwtLoginToken jwtLoginToken = new JwtLoginToken(userName, password);
            //将认证详情(ip,sessionId)写到凭证
            jwtLoginToken.setDetails(new WebAuthenticationDetails(request));
            //AuthenticationManager获取受支持的AuthenticationProvider(这里也就是JwtAuthenticationProvider),
            //生成已认证的凭证,此时凭证中的主体为userDetails
            Authentication authenticatedToken = this.getAuthenticationManager().authenticate(jwtLoginToken);
            return authenticatedToken;
        } catch (Exception e) {
            log.warn(e.getMessage());
            throw new BadCredentialsException("账号或密码错误！");
        }
    }

    private Map<String, String> getRequestParams(HttpServletRequest request) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
        return JSON.parseObject(stringBuilder.toString(), Map.class);
    }
}
