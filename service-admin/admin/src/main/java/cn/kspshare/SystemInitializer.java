package cn.kspshare;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
/**
 * 系统初始化配置类，主要用于加载内置数据到目标数据库上
 */
@Component
public class SystemInitializer {

    @Value("${initialzation.file.users:users.json}")
    private String userFileName;

    @Value("${initialzation.file.roles:roles.json}")
    private String roleFileName;
    //
    // @Autowired
    // private UserRepository userRepository;
    //
    // @Autowired
    // private RoleRepository roleRepository;

    // @Autowired
    // private KspAdminUserMapper adminUserMapper;
    //
    // @Autowired
    // private KspRoleMapper roleMapper;

    @PostConstruct
    public boolean initialize() throws Exception {
        // try {
        //     InputStream userInputStream = getClass().getClassLoader().getResourceAsStream(userFileName);
        //     if(userInputStream == null){
        //         throw new Exception("initialzation user file not found: " + userFileName);
        //     }
        //
        //     InputStream roleInputStream = getClass().getClassLoader().getResourceAsStream(roleFileName);
        //     if(roleInputStream == null){
        //         throw new Exception("initialzation role file not found: " + roleFileName);
        //     }
        //
        //     //导入初始的系统超级管理员角色
        //     Type roleTokenType = new TypeToken<ArrayList<Role>>(){}.getType();
        //     ArrayList<Role> roles = CommonGsonBuilder.create().fromJson(new InputStreamReader(roleInputStream, StandardCharsets.UTF_8), roleTokenType);
        //     for (Role role: roles) {
        //         if (roleRepository.findByName(role.getName()) == null) {
        //             roleRepository.save(role);
        //         }
        //     }
        //
        //     //导入初始的系统管理员用户
        //     Type teacherTokenType = new TypeToken<ArrayList<User>>(){}.getType();
        //     ArrayList<User> users = CommonGsonBuilder.create().fromJson(new InputStreamReader(userInputStream, StandardCharsets.UTF_8), teacherTokenType);
        //     for (User user : users) {
        //         if (userRepository.findByUsername(user.getUsername()) == null) {
        //             userRepository.save(user);
        //         }
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        return true;
    }
}
