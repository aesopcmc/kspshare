package cn.kspshare.controller;

import cn.kspshare.domain.KspUser;
import cn.kspshare.service.KspUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    private KspUserService userService;

    @ApiOperation("跳转首页")
    @GetMapping({"/", "/index", "/home"})
    public String index(){
        return "index";
    }

    /**
     * 此处可get和post请求
     * @return
     */
    @ApiOperation("跳转登录页")
    @RequestMapping("/login")
    public String login(){
        System.out.println("..loginPage");
        System.out.println("bbbbb");
        System.out.println("sfef ");
        System.out.println("sfef ");
        return "user_login";
    }

    @ApiOperation("跳转注册页")
    @GetMapping("/register")
    public String register(){
        return "user_register";
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public String doRegister(KspUser kspUser){
        //注册
        if(userService.doRegister(kspUser))
            return "redirect:register?success";
        return "redirect:register?error";
    }
}
