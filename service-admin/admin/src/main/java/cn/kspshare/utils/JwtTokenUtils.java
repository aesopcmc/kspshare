package cn.kspshare.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtTokenUtils {
    /**
     * 有效时间：单位秒
     */
    private static final int EXPIRES_TIME_SECOND = 24*60*60;

    /**
     * 创建TOKEN
     * @param oid 用户id
     * @param secret 秘钥，可以使用用户的密码作为秘钥
     * @param customClaim 自定义要保存的数据
     * @return
     */
    public static String createToken(String oid, String secret, Map<String, String> customClaim) {
        /**
         * iss: jwt签发者
         * sub: 面向的用户(jwt所面向的用户)
         * aud: 接收jwt的一方
         * exp: 过期时间戳(jwt的过期时间，这个过期时间必须要大于签发时间)
         * nbf: 定义在什么时间之前，该jwt都是不可用的.
         * iat: jwt的签发时间
         * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
         */

        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.SECOND, EXPIRES_TIME_SECOND);

        JWTCreator.Builder builder = JWT.create()
                .withAudience(oid)// 将 user id 保存到 token 里面
                .withExpiresAt(calendar.getTime());
        if(customClaim!=null){
            customClaim.forEach(builder::withClaim);
        }

        String token=builder.sign(Algorithm.HMAC256(secret));// 以 password 作为 token 的密钥

        return token;
    }

    /**
     * 验证token
     *
     * @param token
     * @return 验证通过，返回一个已解码的DecodedJWT对象，否则抛出异常。
     *
     * @throws AlgorithmMismatchException     if the algorithm stated in the token's header it's not equal to the one defined in the {@link JWTVerifier}.
     * @throws SignatureVerificationException 验签失败抛出异常
     * @throws TokenExpiredException          Token过期抛出异常
     * @throws InvalidClaimException          if a claim contained a different value than the expected one.
     */
    public static DecodedJWT verifyToken(String token, String secret) throws JWTVerificationException{
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).build();
        return jwtVerifier.verify(token);
    }

    /**
     * 解码Token
     * @param token
     * @return
     */
    public static DecodedJWT decodedJWT(String token) throws JWTDecodeException{
        return JWT.decode(token);
    }
}
