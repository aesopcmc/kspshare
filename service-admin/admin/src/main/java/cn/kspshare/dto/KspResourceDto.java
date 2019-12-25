package cn.kspshare.dto;

import cn.kspshare.ResourceType;
import cn.kspshare.validation.Add;
import cn.kspshare.validation.Update;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/24 17:52
 *
 */
@Setter
@Getter
public class KspResourceDto {
    /**
     *   主键
     */
    @NotNull(groups = Update.class)
    private Long oid;

    /**
     *   资源名称
     */
    @NotBlank(groups = {Add.class, Update.class})
    @NotNull(groups = {Add.class, Update.class})
    private String name;

    /**
     *   资源编码，唯一
     */
    @NotBlank(groups = {Add.class, Update.class})
    @NotNull(groups = {Add.class, Update.class})
    private String code;

    /**
     *   父资源ID
     */
    private Long parentId;

    /**
     *   资源类型 1菜单 2按钮
     */
    @NotNull
    private ResourceType resourceType;

    /**
     *   资源URL
     */
    private String url;

    /**
     *   图标
     */
    private String icon;

    /**
     *   vue组件名，用于路由配置
     */
    private String componentName;
}
