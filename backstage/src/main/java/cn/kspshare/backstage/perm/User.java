package cn.kspshare.backstage.perm;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.*;

/**
 * 用户定义，并关联角色
 */
@Data
@NoArgsConstructor
public class User implements UserDetails {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    /**
     * ID
     */
    private String id;

    /**
     * 创建时间
     */
    private Long createdTime = System.currentTimeMillis();

    /**
     * 用户登录名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户登录密码，用户的密码不应该暴露给客户端
     */
    @JsonIgnore
    private String password;

    /**
     * 用户类型
     */
    private String type;

    /**
     * 该用户关联的企业/区块id
     */
    private Map<String, Object> associatedResources = new HashMap<>();

    /**
     * 用户关注的企业列表
     */
    private List<String> favourite = new ArrayList<>();

    /**
     * 用户在系统中的角色列表，将根据角色对用户操作权限进行限制
     */
    private List<String> roles = new ArrayList<>();

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
}
