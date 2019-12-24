package cn.kspshare.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 管理员模块工具
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/24 16:21
 */
public class AdminUtils {
    public static String passwordEncode(String text) {
        return new BCryptPasswordEncoder().encode(text);
    }
}
