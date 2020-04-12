package cn.kspshare.controller;

import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspAdminUserListConditionDto;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.service.AdminUserService;
import cn.kspshare.validation.Add;
import cn.kspshare.validation.Update;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Api(tags = "用户管理")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * 添加用户
     * @param dto
     * @return
     */
    @PostMapping("/user/add")
    public ResultBean add(@RequestBody @Validated({Add.class}) KspAdminUserDto dto) {
        return adminUserService.add(dto);
    }

    /**
     * 更新用户
     * @param dto
     * @return
     */
    @PostMapping("/user/update")
    public ResultBean update(@RequestBody @Validated({Update.class}) KspAdminUserDto dto) {
        return adminUserService.update(dto);
    }

    /**
     * 删除用户
     * @param oid
     * @return
     */
    @DeleteMapping("/user/delete/{oid}")
    public ResultBean delete(@PathVariable Long oid) {
        return adminUserService.delete(oid);
    }

    /**
     * 条件查询
     * @param dto
     * @return
     */
    @GetMapping("/user/listCondition")
    public ResultBean listCondition(KspAdminUserListConditionDto dto) {
        return adminUserService.queryByCondition(dto);
    }

    /**
     * 更改状态
     * @param oid 主键
     * @param enable 状态，是否可以登 0禁止 1允许
     * @return
     */
    @PostMapping("/user/enabled")
    public ResultBean enabled(Long oid, Byte enable) {
        return adminUserService.enabled(oid, enable);
    }

}
