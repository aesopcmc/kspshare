package cn.kspshare.controller;

import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.config.RedisUtils;
import cn.kspshare.config.userinfo.UserInfo;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.service.ResourceService;
import cn.kspshare.service.TestService;
import cn.kspshare.validation.Add;
import cn.kspshare.validation.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@UserLoginToken
@RestController
@RequestMapping("/test")
@Api(tags = "测试接口")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    UserInfoManager userInfoManager;

    @Autowired
    DataSource dataSource;

    /**
     * 测试druid数据库连接池配置是否成功
     * @throws SQLException
     */
    @GetMapping("/druid")
    public void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement prepareStatement = connection
                .prepareStatement("select * from ksp_admin_user where oid=1");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()) {
            String cityName = resultSet.getString("username");
            System.out.println(cityName);
        }
    }

    /**
     * 更新用户
     * @return
     */
    @GetMapping("/resource/treeList")
    public ResultBean update() {
        return resourceService.treeList();
    }

    /**
     * 更新用户
     * @param dto
     * @return
     */
    @PostMapping("/user/update")
    public ResultBean update(@RequestBody @Validated({Update.class}) KspAdminUserDto dto) {
        return adminUserService.update(dto);
    }

    /**
     * 添加用户
     * @param dto
     * @return
     */
    @PostMapping("/user/add")
    public ResultBean add(@RequestBody @Validated({Add.class}) KspAdminUserDto dto) {
        return adminUserService.add(dto);
    }

    @ApiOperation("查找所有")
    @GetMapping("/list")
    public ResultBean list(){
        return testService.list();
    }

    /**
     * 条件查询
     * @param dto
     * @return
     */
    @GetMapping("/listCondition")
    public ResultBean listCondition(KspAdminUserListConditionDto dto) {
        return adminUserService.queryByCondition(dto);
    }
    // @GetMapping(value = "/test/perm")
    // @PreAuthorize("hasPermission('user', 'read') or hasRole('ROLE_ADMINISTRATOR')")
    // public String getUserList() {
    //
    //     return "成功";
    // }

    /**
     * 任何人都可以访问，包括登录和未登录的
     * 在ApplicationConfigurerAdapter 添加放行的url
     * @return
     */
    @GetMapping("/anyMsg")
    public String anyMsg() {
        return "you get the message!";
    }

    /**
     * 任何登录的人才能访问
     * 新添加的接口，不做任何配置，默认是登录才能访问
     * @return
     */
    @GetMapping("/publicMsg")
    public String getMsg(){
        // JwtUserInfo userInfo = (JwtUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // String userStr = JSON.toJSONString(userInfo);
        // System.out.println(userStr);
        //
        // JwtUserInfo userInfo2 = (JwtUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // String userStr2 = JSON.toJSONString(userInfo);
        // System.out.println(userStr2);


        // return userStr;
        return "you get the message!";
    }

    /**
     * 拥有innerkey权限才能访问
     * @return
     */
    @GetMapping("/innerMsg")
    // @PreAuthorize("hasPermission('', 'innerkey')")
    public String innerMsg(){
        return "you get the message!";
    }

    /**
     * 拥有管理者权限才能访问
     * @return
     */
    @GetMapping("/secret")
    // @PreAuthorize("hasPermission('', 'managerkey')")
    public String secret(){
        return "you get the message!";
    }


    @GetMapping("/a")
    public String a() {
        redisUtils.set("aaa", 998, 10);
        // System.out.println("是否存在："+redisUtils.exists("aaa"));
        // Object aaa = redisUtils.get("aaa");
        // System.out.println(aaa);
        return "普通请求";
    }

    @GetMapping("/b")
    @UserLoginToken
    public String b() {
        UserInfo userInfo = userInfoManager.getUserInfo();
        System.out.println(userInfo);
        return "有用户信息";
    }
}
