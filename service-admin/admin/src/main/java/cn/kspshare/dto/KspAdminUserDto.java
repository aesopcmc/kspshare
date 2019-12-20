package cn.kspshare.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/20 17:46
 */
@Setter
@Getter
public class KspAdminUserDto {
    /**
     *   主键
     */
    private Long oid;

    /**
     *   用户登录名
     */
    @NotNull
    @NotBlank
    private String username;

    /**
     *   用户真实姓名
     */
    private String realname;

    /**
     *   0保密 1男 2女，默认0
     */
    @Min(value = 0, message = "性别选择有误0")
    @Max(value = 2,message = "性别选择有误2")
    private Byte gender;

    /**
     *   邮箱
     */
    private String email;

    /**
     *   enabled	是否可以登录	 0禁止 1允许
     */
    @Min(0)
    @Max(1)
    private Byte enabled;

}
