package cn.kspshare.jwt;


import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

import java.util.HashMap;

/**
 *
 * TODO token有效时间？
 * @author niXueChao
 * @date 2019/3/29 14:30.
 */
@Configuration
public class JwtKeyConfig {

    /**RSA私钥  可访问http://web.chacuo.net/netrsakeypair 选择密钥格式pkcs#1，生成密钥对，拷贝私钥到此处*/
    private static final String PRIVATE_KEY ="-----BEGIN RSA PRIVATE KEY-----" +
            "MIICWwIBAAKBgQCAAZtkf8O2MO/eqYZOkoSG2E6TW1skyUTpLFXciVE3+eIHCrMN" +
            "nd7a2H1TcgCB+ZQGi4vNDLIls6ivTC7stzPg63r1tQs39ljeq/1a1FGhizt4pwts" +
            "PEzbF5Uc/ZLOy7vHRh64kWe4mpvjtAz8fcA6JxBZuFB8rcoJge4LMLslBwIDAQAB" +
            "AoGAGos6w+5SkTc4pn2U4jozzRqRwLDTB5/M8GVHMMIw22Cv5DHty0cPbWYzJtif" +
            "DlTIw0qwpMabMoI82oz7tg6PbScJDtsAwB0SHyLYHXoJSSAAFkwre8yTwhzxFItX" +
            "PTDhO8RKqTy7sS73xMF1/ghnk2z5obQKXjy7ZAzmxozdkpECQQCAD13jHCw/lfJd" +
            "D1GRyPWAb9S6yICEgSHeGZ/rYoUh1eCkU+IbF0sxkfLg0cfjOBmXRVNlW9Q346p5" +
            "PEa7B9rtAkEA/+R+UCbSMBt+F2lNTDOxjl7eICTIE5RxEG6dDIqfLuHIPMc61tHE" +
            "M1WYyzFE1YAHwuXWG0Vjy+F1ceeKJWAdQwJAPcOrm9NFwDFZIOs3g2HyjszhRGla" +
            "Gw6RQCcJy6TL42Ldo0RWBIz6lmD3TNnBV+UB6sTkETn2JDKpUSnyT1jdjQJAbUnT" +
            "QLwzzOQRCEKrBr6VOK7/w06yPNqLJ292l6KktcssT/jvAkx4tUv7g9y4/049AlpT" +
            "BTavlqXmGQ3AjJHuLQJAGhwd28ZVhmJ4317C9swufJ9TmSU7f2hZyx+x9sCBxXPY" +
            "fxyy6Fd/NyM/ttWxakp7PrLxdSKOl0SiSXRVEnEOFg==" +
            "-----END RSA PRIVATE KEY-----";



    /**使用私钥签名*/
    @Bean
    public RsaSigner getSigner(){
        return new RsaSigner(PRIVATE_KEY);
    }

    /**使用公钥验签(这里是可以通过私钥生成密钥对,包含公钥)*/
    @Bean
    public RsaVerifier getVerifier(){
        return new RsaVerifier(PRIVATE_KEY);
    }

   // public static void main(String[] args) {
   //     String jsonString = JSON.toJSONString(new HashMap<String, String>() {{
   //         put("name", "zhangsan");
   //         put("id", "343");
   //     }});
   //     System.out.println(JwtHelper.encode(jsonString, getSigner()).getEncoded());
   //     Jwt decode = JwtHelper.decode("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.aGhoaGhoaGhoaGhoaGhoaA.NXL4cJ9zMkKmaT2JnuYmr_sMRm51mil5ueje73NP5s96pOWPdHgUU875iFL-DabNu3hYOGEjO47rWnxTjzug9S_XOry7aAcKFA-cN3ROAD8rXON-dIH0gNnBYYcIWzcTAfvtGCNQjUrXyL4nxypBqog5Plw8k7V-6hS1L4PZYnM");
   //     System.out.println(decode.getClaims());
   // }
}