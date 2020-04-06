package cn.kspshare.jwt;

import cn.kspshare.service.AdminUserService;
import cn.kspshare.domain.KspAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 提供根据用户名查询用户信息的功能
 * JwtAuthenticationProvider在进行登录信息校验时就会通过它查询用户信息
 * @author niXueChao
 * @date 2019/4/8 11:26.
 */
@Component
public class JwtUserDetailServiceImpl implements UserDetailsService {
    // private final PasswordEncoder passwordEncoder;
    // @Autowired
    // public JwtUserDetailServiceImpl(PasswordEncoder passwordEncoder) {
    //     this.passwordEncoder = passwordEncoder;
    // }

    @Autowired
    private AdminUserService userService;
    // @Autowired
    // private PermService permService;


    /**
     * 查找数据库用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // if ("admin".equals(username)) {
        //     // return new JwtUserInfo("admin", passwordEncoder.encode("123456"));
        //     return new JwtUserInfo("admin", new BCryptPasswordEncoder().encode("123456"));
        // }
        // if ("user".equals(username)) {
        //     return new JwtUserInfo("user", new BCryptPasswordEncoder().encode("123456"));
        // }
        //

        KspAdminUser user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username: %s", username));
        }
        //查找权限值，封装到JwtUser 的authorities里
        // List<String> permValues = permService.listResourceIdByUser(user.getOid());
        // List<SimpleGrantedAuthority> authorities = permValues.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        JwtUserInfo jwtUserInfo = new JwtUserInfo(user.getUsername(), user.getPassword());
        return jwtUserInfo;//authorities
    }
}
