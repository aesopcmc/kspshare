package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 后台管理用户表
 * admin_user
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class AdminUser {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 用户登录名
     * username
     */
    private String username;

    /**
     * 用户真实姓名
     * realname
     */
    private String realname;

    /**
     * 用户登录密码
     * password
     */
    private String password;

    /**
     * 0保密 1男 2女，默认0
     * gender
     */
    private Byte gender;

    /**
     * 邮箱
     * email
     */
    private String email;

    /**
     * enabled	是否可以登录	 0禁止 1允许
     * enabled
     */
    private Byte enabled;

    /**
     * 创建时间
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
     * 创建时间
     * update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}