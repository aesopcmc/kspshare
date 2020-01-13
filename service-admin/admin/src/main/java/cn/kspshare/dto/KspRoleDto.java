package cn.kspshare.dto;

import cn.kspshare.validation.Add;
import cn.kspshare.validation.Update;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/20 17:46
 */
@Setter
@Getter
public class KspRoleDto {
    /**
     *   主键
     */
    @NotNull(groups = Update.class)
    private Long oid;

    /**
     * Database Column Remarks:
     *   角色名称
     */
    @NotBlank(groups = {Add.class, Update.class})
    @NotNull(groups = {Add.class, Update.class})
    private String name;

    /**
     * Database Column Remarks:
     *   角色编码，唯一编码
     */
    @NotBlank(groups = {Add.class, Update.class})
    @NotNull(groups = {Add.class, Update.class})
    private String code;

    /**
     * Database Column Remarks:
     *   父ID, 默认顶级父级为0
     */
    private Long parentId;

    /**
     * Database Column Remarks:
     *   角色描述信息
     */
    private String description;
}