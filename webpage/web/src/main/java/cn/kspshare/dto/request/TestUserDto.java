package cn.kspshare.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel
public class TestUserDto {
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不允许为空")
    private String userName;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("等级")
    private Long gradeId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
}
