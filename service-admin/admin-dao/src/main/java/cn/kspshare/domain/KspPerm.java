package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 
 * ksp_perm
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class KspPerm {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 权限名称
     * name
     */
    private String name;

    /**
     * 权限编码，唯一
     * code
     */
    private String code;

    /**
     * 资源ID
     * resource_id
     */
    private Long resourceId;

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