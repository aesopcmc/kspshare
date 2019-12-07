package cn.kspshare.dto.request;

import cn.kspshare.validation.PasswordMatches;
import cn.kspshare.validation.ValidEmail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * 用户DTO
 * DTO对象的字段上使用了标准的javax.validation注释，还实现自己的自定义验证注释，以验证电子邮件地址的格式以及密码确认。
 */
@PasswordMatches(message = "两次密码不匹配")
@ApiModel
public class KspUserDto {
    /**
     * 账号
     */
    @NotNull
    @NotEmpty(message = "账号名称不能为空")
    @ApiModelProperty("账号")
    private String username;

    /**
     * 密码
     */
    @NotNull
    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String password;
    private String matchingPassword;

    /**
     * 邮箱
     */
    @NotNull
    @NotEmpty(message = "邮箱不能为空")
    @ValidEmail(message = "邮箱不合法")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
