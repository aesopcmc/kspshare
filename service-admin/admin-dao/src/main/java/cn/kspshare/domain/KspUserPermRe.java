package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 用户-权限关系表
 * ksp_user_perm_re
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class KspUserPermRe {
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
     * 权限ID
     * perm_id
     */
    private Long permId;

    /**
     * 0可访问 1可授权
     * perm_type
     */
    private Byte permType;

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