package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 角色表
 * ksp_role
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class KspRole {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 角色名称
     * name
     */
    private String name;

    /**
     * 角色编码，唯一编码
     * code
     */
    private String code;

    /**
     * 编码链，通过“-”拼接，不包含自身，最顶级为NULL
     * code_link
     */
    private String codeLink;

    /**
     * 父ID, 默认顶级父级为0
     * parent_id
     */
    private Long parentId;

    /**
     * 角色描述信息
     * description
     */
    private String description;

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