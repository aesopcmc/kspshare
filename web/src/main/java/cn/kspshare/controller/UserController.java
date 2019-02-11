package cn.kspshare.controller;

import cn.kspshare.common.JsonUtils;
import cn.kspshare.config.UserInfo;
import cn.kspshare.service.KspUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@Api(description = "用户管理")
public class UserController {
    @Autowired
    private KspUserService userService;

    /**
     * 用户信息页面
     * 扩展org.springframework.security.core.userdetails.User ，
     * 自定义当前登录用户信息类UserInfo，获取扩展信息
     * @return
     */
    @GetMapping("/user")
    public String user(@AuthenticationPrincipal UserInfo userInfo, Model model) {
        Map<String, Object> mapInfo = new HashMap<>();
        mapInfo.put("username", userInfo.getUsername());
        mapInfo.put("nickname", userInfo.getNickname());
        model.addAttribute("userInfo", JsonUtils.encodeObject(mapInfo));
        return "user_profile";
    }

    /**
     * 用户信息页面
     * 使用原始的 Principal
     * @return
     */
    //@GetMapping("/user")
    //public String user(@AuthenticationPrincipal Principal principal, Model model) {
    //    model.addAttribute("username", principal.getName());
    //    return "user_profile";
    //}

    /**
     * vip权限访问控制
     * @return
     */
    @GetMapping("/user/vip")
    @Secured("ROLE_VIP")
    @ResponseBody
    public String vipResource() {
        return "有vip权限";
    }
}
