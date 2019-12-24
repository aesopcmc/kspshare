package cn.kspshare.controller;

import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.jwt.JwtUserInfo;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.KspAdminUserService;
import cn.kspshare.validation.Add;
import cn.kspshare.validation.Update;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
     * 添加用户
     * @param dto
     * @return
     */
    @PostMapping("/user/add")
    public ResultBean add(@RequestBody @Validated({Add.class}) KspAdminUserDto dto) {
        return kspAdminUserService.add(dto);
    }

    /**
     * 更新用户
     * @param dto
     * @return
     */
    @PostMapping("/user/update")
    public ResultBean update(@RequestBody @Validated({Update.class}) KspAdminUserDto dto) {
        return kspAdminUserService.update(dto);
    }

    /**
     * 删除用户
     * @param oid
     * @return
     */
    @PostMapping("/user/delete")
    public ResultBean delete(Long oid) {
        return kspAdminUserService.delete(oid);
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

    /**
     * 更改状态
     * @param oid 主键
     * @param enable 状态，是否可以登 0禁止 1允许
     * @return
     */
    @PostMapping("/user/enabled")
    public ResultBean enabled(Long oid, Byte enable) {
        return kspAdminUserService.enabled(oid, enable);
    }

}
