package cn.kspshare.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/12/18 16:55
 */
@Setter
@Getter
public class KspAdminUserListConditionDto {
    /**
     * 用户、姓名、邮箱模糊查询
     */
    private String userNameOrRealNameOrEmail;
    /**
     * 性别 0保密 1男 2女
     */
    private Byte gender;
    /**
     * 登录状态 是否可以登录	 0禁止 1允许
     */
    private Byte enabled;
}
