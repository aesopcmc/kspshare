package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 用户-角色关系表
 * ksp_user_role_re
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class KspUserRoleRe {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 用户ID
     * user_id
     */
    private Long userId;

    /**
     * 角色ID
     * role_id
     */
    private Long roleId;

    /**
     * 创建时间
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建人ID
     * create_user
     */
    private Long createUser;

    /**
     * 创建时间
     * update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}