package cn.kspshare.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ksp_verification_token
 */
public class KspVerificationToken {
    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.oid")
    private Long oid;

    /**
     * Database Column Remarks:
     *   用户主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.user_id")
    private Long userId;

    /**
     * Database Column Remarks:
     *   TOKEN
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.token")
    private String token;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.create_time")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.oid")
    public Long getOid() {
        return oid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.oid")
    public void setOid(Long oid) {
        this.oid = oid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.user_id")
    public Long getUserId() {
        return userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.token")
    public String getToken() {
        return token;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.token")
    public void setToken(String token) {
        this.token = token;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.create_time")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.create_time")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}