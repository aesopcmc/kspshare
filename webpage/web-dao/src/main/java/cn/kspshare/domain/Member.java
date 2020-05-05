package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 论坛会员表
 * member
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class Member {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 账号
     * username
     */
    private String username;

    /**
     * 密码
     * password
     */
    private String password;

    /**
     * 昵称
     * nickname
     */
    private String nickname;

    /**
     * 唯一邮箱
     * email
     */
    private String email;

    /**
     * 邮箱验证： 0未验证 1已验证 ， 默认0
     * enabled
     */
    private Byte enabled;

    /**
     * 用户状态：1允许登录 0禁止登录 ， 默认1
     * user_status
     */
    private Byte userStatus;

    /**
     * 头像url路径
     * avatar
     */
    private String avatar;

    /**
     * 0保密 1男 2女，默认0
     * gender
     */
    private Byte gender;

    /**
     * 简单地址信息
     * location
     */
    private String location;

    /**
     * 兴趣爱好
     * hobbies
     */
    private String hobbies;

    /**
     * 
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
     * 身份权限
     * roles
     */
    private String roles;

    /**
     * 创建时间
     * update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}