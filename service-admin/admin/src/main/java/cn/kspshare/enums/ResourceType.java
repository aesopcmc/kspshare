package cn.kspshare.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/25 14:15
 */
@Getter
@AllArgsConstructor
public enum ResourceType {
    MENU((byte)1, "菜单"),
    BUTTON((byte)2, "按钮");
    private Byte code;
    private String name;
}
