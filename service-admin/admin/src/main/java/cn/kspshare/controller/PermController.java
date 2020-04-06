package cn.kspshare.controller;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.dto.PermDto;
import cn.kspshare.service.PermService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@Slf4j
@Api(tags = "权限管理")
public class PermController {
    @Autowired
    private PermService permService;

    /**
     * 添加权限
     * @param dto
     * @return
     */
    @ApiOperation("添加权限")
    @PostMapping("/perm")
    public ResultBean add(@RequestBody @Validated PermDto dto) {
        return permService.add(dto);
    }

    /**
     * 更新权限
     * @param dto
     * @return
     */
    @ApiOperation("更新权限")
    @PutMapping(value = "/perm/{oid}")
    public ResultBean update(@RequestBody @Validated PermDto dto, @PathVariable Long oid) {
        return permService.update(dto, oid);
    }

    /**
     * 删除权限
     * @param oid
     * @return
     */
    @ApiOperation("删除权限")
    @DeleteMapping("/perm/{oid}")
    public ResultBean delete(@PathVariable Long oid) {
        return permService.delete(oid);
    }

    /**
     * 根据资源查找权限列表
     * @return
     */
    @ApiOperation("查找权限列表")
    @GetMapping("/perm/list/{resourceId}")
    public ResultBean listByResource(@PathVariable Long resourceId) {
        return permService.listByResource(resourceId);
    }

}
