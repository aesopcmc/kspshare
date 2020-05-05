package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 会员邮件注册激活验证表
 * verification_token
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class VerificationToken {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 用户主键
     * user_id
     */
    private Long userId;

    /**
     * TOKEN
     * token
     */
    private String token;

    /**
     * 失效日期
     * expiry_date
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expiryDate;

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