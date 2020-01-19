package cn.kspshare.dto;

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
     * Database Column Remarks:
     *   角色名称
     */
    @NotBlank
    @NotNull
    private String name;

    /**
     * Database Column Remarks:
     *   角色编码，唯一编码
     */
    @NotBlank
    @NotNull
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
