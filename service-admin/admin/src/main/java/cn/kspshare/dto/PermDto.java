package cn.kspshare.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2020/1/19 10:44
 */
@Setter
@Getter
public class PermDto {
    @NotNull
    private Long resourceId;
    /**
     * 权限名称
     */
    @NotBlank
    @NotNull
    private String name;

    /**
     * 权限编码
     */
    @NotBlank
    @NotNull
    private String code;
}
