package cn.kspshare.common;


import org.apache.commons.lang3.StringUtils;

/**
 * 公共方法
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/20 10:29
 */
public class CommonUtils {
    /**
     * 判断字符串是否为空，空字符也是空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if(str==null)
            return true;
        return StringUtils.isEmpty(str.trim());
    }
}
