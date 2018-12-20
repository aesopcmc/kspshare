package cn.kspshare.domain;

import javax.persistence.*;

@Table(name = "ksp_user")
public class KspUser {
    /**
     * 主键
     */
    @Id
    private Long oid;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 身份
     */
    private String roles;

    /**
     * 获取主键
     *
     * @return oid - 主键
     */
    public Long getOid() {
        return oid;
    }

    /**
     * 设置主键
     *
     * @param oid 主键
     */
    public void setOid(Long oid) {
        this.oid = oid;
    }

    /**
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取身份
     *
     * @return roles - 身份
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置身份
     *
     * @param roles 身份
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }
}