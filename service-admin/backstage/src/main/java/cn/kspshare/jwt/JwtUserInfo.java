package cn.kspshare.jwt;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 当前用户信息
 * @author niXueChao
 * @date 2019/4/8 11:29.
 */
public class JwtUserInfo implements UserDetails {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码（已加密），仅在登录时用于密码校验
     */
    private String password;
    /**
     * true 超级管理员 , false 普通用户
     */
    private Boolean adminFlag = Boolean.FALSE;
    /**
     * token创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tokenCreateTime;
    /**
     * 失效时长，单位：秒
     */
    private Integer expiredSecond;
    /**
     * 权限集合
     */
    private List<SimpleGrantedAuthority> authorities;

    public JwtUserInfo() {
    }

    public JwtUserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 获取当前用户信息
     * @return
     */
    public static JwtUserInfo getUserInfo() {
        return (JwtUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Integer getExpiredSecond() {
        return expiredSecond;
    }

    public void setExpiredSecond(Integer expiredSecond) {
        this.expiredSecond = expiredSecond;
    }

    public LocalDateTime getTokenCreateTime() {
        return tokenCreateTime;
    }

    public void setTokenCreateTime(LocalDateTime tokenCreateTime) {
        this.tokenCreateTime = tokenCreateTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Boolean adminFlag) {
        this.adminFlag = adminFlag;
    }
}
