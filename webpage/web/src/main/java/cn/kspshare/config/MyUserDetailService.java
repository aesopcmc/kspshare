package cn.kspshare.config;

import cn.kspshare.domain.KspMember;
import cn.kspshare.service.KspUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    private KspUserService userService;

    @Autowired
    MyUserDetailService(KspUserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        KspMember userEntity = userService.findByUserNameOrEmail(username);
        if (userEntity == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        if(userEntity.getEnabled()==0){
            //TODO 需要把该消息抛出
            throw new UsernameNotFoundException("账号未激活！");
        }

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(userEntity.getRoles());

        cn.kspshare.config.UserInfo userInfo = new cn.kspshare.config.UserInfo(userEntity.getUsername(), userEntity.getPassword(), simpleGrantedAuthorities);
        userInfo.setUserId(userEntity.getOid());
        userInfo.setNickname(userEntity.getNickname());
        return userInfo;

        //return new User(userEntity.getUsername(), userEntity.getPassword(), simpleGrantedAuthorities);
    }

    /**
     * 权限字符串转化
     *
     * 如 "USER,ADMIN" -> SimpleGrantedAuthority("USER") + SimpleGrantedAuthority("ADMIN")
     *
     * @param roleStr 权限字符串
     */
    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
        String[] roles = roleStr.split(",");
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for (String role : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleGrantedAuthorities;
    }
}
