package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 资源表
 * resource
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class Resource {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 资源名称
     * name
     */
    private String name;

    /**
     * 资源编码，唯一
     * code
     */
    private String code;

    /**
     * 编码链，通过“-”拼接，不包含自身，最顶级为NULL
     * code_link
     */
    private String codeLink;

    /**
     * 父资源ID
     * parent_id
     */
    private Long parentId;

    /**
     * 资源类型 1菜单 2按钮 
     * resource_type
     */
    private Byte resourceType;

    /**
     * 资源URL
     * url
     */
    private String url;

    /**
     * 图标
     * icon
     */
    private String icon;

    /**
     * vue组件名，用于路由配置
     * component_name
     */
    private String componentName;

    /**
     * 排序
     * sort
     */
    private Integer sort;

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