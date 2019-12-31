package cn.kspshare.dto;

import cn.kspshare.validation.Update;
import lombok.Getter;
import lombok.Setter;

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

}
