package cn.kspshare.controller;

import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.common.restful.ResultCode;
import cn.kspshare.config.userinfo.UserInfo;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.domain.AdminUser;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.utils.JwtTokenUtils;
import io.swagger.annotations.Api;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
@Api(tags = "登录管理")
public class LoginController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private UserInfoManager userInfoManager;

    @PostMapping("/doLogin")
    public ResultBean doLogin(@RequestBody LoginDto dto) {
        if(StringUtils.isEmpty(dto.getUsername()) || StringUtils.isEmpty(dto.getPassword())) {
            return ResultBean.INFO(ResultCode.MISSING_PARAMETERS);
        }

        AdminUser userForBase = adminUserService.queryByUsername(dto.getUsername());
        if(userForBase==null){
            return ResultBean.FAIL("登录失败,用户不存在！");
        }

        String _password = DigestUtils.md5DigestAsHex(dto.getPassword().getBytes());
        if (!userForBase.getPassword().equals(_password)) {
            return ResultBean.FAIL("登录失败,密码错误！");
        }

        //封装需要保存到token的数据
        Map<String, String> tokenData = new HashMap<>();
        tokenData.put("oid", userForBase.getOid().toString());
        tokenData.put("username", userForBase.getUsername());

        //创建token
        String token = JwtTokenUtils.createToken(userForBase.getOid().toString(), userForBase.getPassword(), tokenData);

        //返回token
        Map<String, Object> resultData = new HashMap<>();
        resultData.put("token", token);
        // resultData.put("user", userForBase);
        return ResultBean.SUCCESS().setData(resultData);
    }

    /**
     * 获取登录用户信息
     * @return
     */
    @GetMapping("/user/info")
    @UserLoginToken
    public ResultBean getUserInfo() {
        UserInfo userInfo = userInfoManager.getUserInfo();
        System.out.println("当前用户信息："+userInfo);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("adminFlag", userInfo.isAdmin());
        resultMap.put("username", userInfo.getUsername());
        // List<String> authorities = userInfo.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        // resultMap.put("authorities", authorities);
        resultMap.put("enabled", userInfo.getEnabled());
        // resultMap.put("expiredSecond", userInfo.getExpiredSecond());
        // resultMap.put("tokenCreateTime", userInfo.getTokenCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return ResultBean.SUCCESS().setData(resultMap);
    }

    /**
     * 获取登录用户信息
     * @return
     */
    @PostMapping("/user/logout")
    public ResultBean logout() {
        return ResultBean.SUCCESS();
    }

    @Data
    private static class LoginDto {
        private String username;
        private String password;
    }
}
