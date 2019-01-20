package cn.kspshare.controller;

import cn.kspshare.dto.request.KspUserDto;
import cn.kspshare.service.KspUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private KspUserService userService;

    @ApiOperation("跳转首页")
    @GetMapping({"/", "/index", "/home"})
    public String index() {
        return "index";
    }

    /**
     * 此处可get和post请求
     *
     * @return
     */
    @ApiOperation("跳转登录页")
    @RequestMapping("/login")
    public String login() {
        return "user_login";
    }

    @ApiOperation("跳转注册页")
    @GetMapping("/register")
    public String register() {
        return "user_register";
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public String doRegister(@ModelAttribute @Valid KspUserDto user, BindingResult result, Model model) {
        System.out.println("11111");
        model.addAttribute("user", user);

        if (result.hasErrors()) {
            //字段校验错误
            model.addAttribute("errors", result.getAllErrors());
            return "user_register";
        } else if (userService.findByUserName(user.getUsername()) != null) {
            result.rejectValue("username", "username.exits", "该账号已被注册");//注册一个字段错误
            model.addAttribute("errors", result.getAllErrors());
            return "user_register";
        } else if (userService.findByEmail(user.getEmail()) != null) {
            //校验邮箱是否存在
            result.rejectValue("email", "email.exits", "该邮箱已被注册");//注册一个字段错误
            model.addAttribute("errors", result.getAllErrors());
            return "user_register";
        }

        if (userService.doRegister(user))
            return "redirect:register?success";
        return "redirect:register?error";

        //TODO 优化mybatis查询
    }

}
