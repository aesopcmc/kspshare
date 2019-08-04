package cn.kspshare.backstage.perm;

import lombok.Data;
import java.util.List;

/**
 * 角色定义
 */
@Data
public class Role {

    /**
     * ID
     */
    private String id;

    /**
     * 是否被移除
     */
    private Boolean isRemoved = false;

    /**
     * 角色名，用于权限校验
     */
    private String name;

    /**
     * 角色中文名，用于显示
     */
    private String nickname;

    /**
     * 角色描述信息
     */
    private String description;

    /**
     * 是否为内置
     */
    private boolean builtIn = false;

    /**
     * 角色状态，是否已禁用
     */
    private Boolean banned = false;

    /**
     * 角色可进行的操作列表
     */
    private List<JsonPermissions.SimplePermission> permissions;

    /**
     * 角色创建者
     */
    private String proposer;

    /**
     * 创建时间
     */
    private Long createdTime = System.currentTimeMillis();

    /**
     * Spring Security 4.0以上版本角色都默认以'ROLE_'开头
     * @param name
     */
    public void setName(String name) {
        if (name.indexOf("ROLE_") == -1) {
            this.name = "ROLE_" + name;
        } else {
            this.name = name;
        }
    }
}
