package cn.kspshare.backstage.perm;
import java.io.Serializable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 在接口方法上面增加了PreAuthorize注解后还需要实现自己的PermissionEvaluator，Spring Security将在hasPermission()方法中对当前登录用户正在访问的资源及其对资源进行的操作进行合法性校验。
 * 注意，这里targetDomainObject即是我们之前定义的resourceId，而permission即为privilege，在校验时要将其组合为和UserDetailsService中存储格式一致的格式，我们这里是使用-中划线进行连接的。
 */
@Configuration
public class MyPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        boolean accessable = false;
        if(authentication.getPrincipal().toString().compareToIgnoreCase("anonymousUser") != 0){
            String privilege = targetDomainObject + "-" + permission;
            for(GrantedAuthority authority : authentication.getAuthorities()){
                if(privilege.equalsIgnoreCase(authority.getAuthority())){
                    accessable = true;
                    break;
                }
            }

            return accessable;
        }

        return accessable;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // TODO Auto-generated method stub
        return false;
    }
}
