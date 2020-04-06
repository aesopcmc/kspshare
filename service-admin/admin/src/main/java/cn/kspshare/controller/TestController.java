package cn.kspshare.controller;

import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.jwt.JwtUserInfo;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.service.ResourceService;
import cn.kspshare.service.TestService;
import cn.kspshare.validation.Add;
import cn.kspshare.validation.Update;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(tags = "测试接口")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 更新用户
     * @return
     */
    @GetMapping("/test/resource/treeList")
    public ResultBean update() {
        return resourceService.treeList();
    }

    /**
     * 更新用户
     * @param dto
     * @return
     */
    @PostMapping("/test/user/update")
    public ResultBean update(@RequestBody @Validated({Update.class}) KspAdminUserDto dto) {
        return adminUserService.update(dto);
    }

    /**
     * 添加用户
     * @param dto
     * @return
     */
    @PostMapping("/test/user/add")
    public ResultBean add(@RequestBody @Validated({Add.class}) KspAdminUserDto dto) {
        return adminUserService.add(dto);
    }

    @ApiOperation("查找所有")
    @GetMapping("/test/list")
    public ResultBean list(){
        return testService.list();
    }

    /**
     * 条件查询
     * @param dto
     * @return
     */
    @GetMapping("/test/listCondition")
    public ResultBean listCondition(KspAdminUserListConditionDto dto) {
        return adminUserService.listCondition(dto);
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
        JwtUserInfo userInfo = (JwtUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userStr = JSON.toJSONString(userInfo);
        System.out.println(userStr);

        JwtUserInfo userInfo2 = (JwtUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userStr2 = JSON.toJSONString(userInfo);
        System.out.println(userStr2);


        return userStr;
        // return "you get the message!";
    }

    /**
     * 拥有innerkey权限才能访问
     * @return
     */
    @GetMapping("/innerMsg")
    @PreAuthorize("hasPermission('', 'innerkey')")
    public String innerMsg(){
        return "you get the message!";
    }

    /**
     * 拥有管理者权限才能访问
     * @return
     */
    @GetMapping("/secret")
    @PreAuthorize("hasPermission('', 'managerkey')")
    public String secret(){
        return "you get the message!";
    }



}
