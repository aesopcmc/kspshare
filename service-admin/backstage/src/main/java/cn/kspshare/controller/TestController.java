package cn.kspshare.controller;

import cn.kspshare.jwt.JwtUserInfo;
import cn.kspshare.restful.ResultBean;
import cn.kspshare.service.TestService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ResponseBody
@Api(tags = "测试接口")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation("查找所有")
    @GetMapping("/test/list")
    public ResultBean list(){
        return testService.list();
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
