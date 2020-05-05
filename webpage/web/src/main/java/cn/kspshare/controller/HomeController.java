package cn.kspshare.controller;

import cn.kspshare.domain.Member;
import cn.kspshare.domain.VerificationToken;
import cn.kspshare.dto.request.KspUserDto;
import cn.kspshare.event.OnRegistrationCompleteEvent;
import cn.kspshare.service.KspUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
public class HomeController {
    @Autowired
    private KspUserService userService;

    @Autowired
    private ApplicationEventPublisher eventPublisher;


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
    public String toRegister() {
        return "user_register";
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public String doRegister(@ModelAttribute @Valid KspUserDto user, BindingResult result, Model model, WebRequest request) throws UnsupportedEncodingException {
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

        Member kspUser = userService.doRegister(user);
        if (kspUser!=null) {
            try {
                String appUrl = request.getContextPath();
                new Thread(()->{
                    eventPublisher.publishEvent(new OnRegistrationCompleteEvent(kspUser, request.getLocale(), appUrl));
                }).start();
            } catch (Exception me) {
                //TODO 发送邮件异常统一处理
                me.printStackTrace();
            }

            return "redirect:/message?type=success&message="+URLEncoder.encode("注册成功，请注意查收邮件进行激活!!", "UTF-8");
        }
        return "redirect:register?error";
    }

    @ApiOperation("确认邮件激活")
    @GetMapping(value = "/registrationConfirm")
    public String confirmRegistration(WebRequest request, Model model, @RequestParam String token) throws UnsupportedEncodingException {

        VerificationToken verificationToken = userService.findVerificationToken(token);
        if (verificationToken == null) {
            return "redirect:/message?type=info&message="+URLEncoder.encode("邮箱验证失败", "UTF-8");
        }

        Member user = userService.getUser(verificationToken.getUserId());
        if (LocalDateTime.now().isAfter(verificationToken.getExpiryDate())) {
            return "redirect:/message?type=info&message="+URLEncoder.encode("邮箱验证失败，链接已失效，请重新 <a href='/register'>注册</a>", "UTF-8");
        }

        user.setEnabled((byte)1);
        userService.updateUser(user);
        return "redirect:/message?type=success&message="+URLEncoder.encode("激活成功，立即 <a href='/login'>登陆</a>", "UTF-8");

    }

    @ApiOperation("跳转消息页面")
    @GetMapping(value = "/message")
    public String toMessage(Model model){
        return "message";
    }

    //int a = 1/0;
    //
    //return "redirect:/message?type=info&message="+URLEncoder.encode("邮箱验证失败<a href='/register'>注册</a>", "UTF-8");

    //TODO 邮件验证失败跳转页面 已过期 处理邮箱重复校验的问题  处理登录提示问题

    @GetMapping(value = "/test")
    public String test(Model model) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                System.out.println("doing...");
                Thread.sleep(5000);
                System.out.println("doing end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "返回字符串结果";

        });

        //阻塞等待返回结果
        String res = future.get();
        System.out.println(res);

        System.out.println("结束");
        return "";
    }
}
