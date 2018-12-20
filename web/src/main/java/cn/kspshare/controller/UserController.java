package cn.kspshare.controller;

import cn.kspshare.service.KspUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@Api(description = "用户管理")
public class UserController {
    @Autowired
    private KspUserService userService;

    /**
     * 用户信息页面
     * @return
     */
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user_profile";
    }




}
