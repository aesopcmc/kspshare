// package cn.kspshare.backstage.perm;
//
// import cn.kspshare.backstage.service.KspAdminUserService;
// import cn.kspshare.backstage.service.KspPermService;
// import cn.kspshare.backstage.service.KspRoleService;
// import cn.kspshare.domain.KspAdminUser;
// import cn.kspshare.domain.KspPerm;
// import cn.kspshare.domain.KspRole;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
//
// import java.util.ArrayList;
// import java.util.List;
//
// @Service
// public class SecurityUserDetailsService implements UserDetailsService {
//
//     @Autowired
//     private KspAdminUserService userService;
//     @Autowired
//     private KspRoleService roleService;
//     @Autowired
//     private KspPermService permService;
//
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//         KspAdminUser user = userService.findByUsername(username);
//         if (user == null) {
//             throw new UsernameNotFoundException(String.format("No user found with username: %s", username));
//         }
//
//         List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//         //查找角色
//         List<KspRole> roleList = roleService.listByAdminUserId(user.getOid());
//         //TODO 此处查询可能会有重复的权限
//         for (KspRole kspRole : roleList) {
//
//             //查找权限
//             List<KspPerm> permList = permService.listByRoleId(kspRole.getOid());
//             for (KspPerm kspPerm : permList) {
//                 authorities.add(new SimpleGrantedAuthority(kspPerm.getResourceid()));
//             }
//         }
//
//         //, user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(),
//         return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
//     }
// }
