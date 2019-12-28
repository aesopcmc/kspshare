package cn.kspshare.controller;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.domain.KspResource;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspResourceDto;
import cn.kspshare.service.KspAdminUserService;
import cn.kspshare.service.KspResourceService;
import cn.kspshare.validation.Add;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ResponseBody
@Slf4j
@Api(tags = "资源管理")
public class ResourceController {
    @Autowired
    private KspResourceService kspResourceService;

    /**
     * 添加资源
     * @param dto
     * @return
     */
    @ApiOperation("添加资源")
    @PostMapping("/resource/add")
    public ResultBean add(@RequestBody @Validated({Add.class}) KspResourceDto dto) {
        return kspResourceService.add(dto);
    }

    /**
     * 更新资源
     * @param dto
     * @return
     */
    @ApiOperation("更新资源")
    @PostMapping("/resource/update")
    public ResultBean update(@RequestBody @Validated KspResourceDto dto) {
        return kspResourceService.update(dto);
    }

    /**
     * 删除资源
     * @param oid
     * @return
     */
    @ApiOperation("删除资源")
    @PostMapping("/resource/delete")
    public ResultBean delete(Long oid) {
        return kspResourceService.delete(oid);
    }

    /**
     * 资源树形列表
     * @return
     */
    @ApiOperation("资源树形列表")
    @GetMapping("/resource/treeList")
    public ResultBean treeList() {
        return kspResourceService.treeList();
    }
}
