package cn.kspshare.controller;

import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.jwt.JwtUserInfo;
import cn.kspshare.restful.ResultBean;
import cn.kspshare.service.KspAdminUserService;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@ResponseBody
@Slf4j
@Api(tags = "用户管理")
public class AdminUserController {
    @Autowired
    private KspAdminUserService kspAdminUserService;
    /**
     * 获取登录用户信息
     * @return
     */
    @GetMapping("/user/info")
    public ResultBean getUserInfo() {
         JwtUserInfo userInfo = (JwtUserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userStr = JSON.toJSONString(userInfo);
        log.info("userinfo", userStr);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("adminFlag", userInfo.getAdminFlag());
        resultMap.put("username", userInfo.getUsername());
        List<String> authorities = userInfo.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        resultMap.put("authorities", authorities);
        resultMap.put("enabled", userInfo.isEnabled());
        resultMap.put("expiredSecond", userInfo.getExpiredSecond());
        resultMap.put("tokenCreateTime", userInfo.getTokenCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return ResultBean.SUCCESS(resultMap);
    }

    /**
     * 获取登录用户信息
     * @return
     */
    @PostMapping("/user/logout")
    public ResultBean logout() {
        return ResultBean.SUCCESS();
    }

    /**
     * 条件查询
     * @param dto
     * @return
     */
    @GetMapping("/user/listCondition")
    public ResultBean listCondition(KspAdminUserListConditionDto dto) {
        return kspAdminUserService.listCondition(dto);
    }
}
