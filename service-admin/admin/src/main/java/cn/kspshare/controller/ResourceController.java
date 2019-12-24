package cn.kspshare.controller;

import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.domain.KspResource;
import cn.kspshare.dto.KspAdminUserDto;
import cn.kspshare.dto.KspResourceDto;
import cn.kspshare.service.KspAdminUserService;
import cn.kspshare.service.KspResourceService;
import io.swagger.annotations.Api;
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
     * 添加用户
     * @param dto
     * @return
     */
    @PostMapping("/resource/add")
    public ResultBean add(@RequestBody @Validated KspResourceDto dto) {
        return kspResourceService.add(dto);
    }

    /**
     * 更新用户
     * @param dto
     * @return
     */
    @PostMapping("/resource/update")
    public ResultBean update(@RequestBody @Validated KspResourceDto dto) {
        return kspResourceService.update(dto);
    }

    /**
     * 删除用户
     * @param oid
     * @return
     */
    @PostMapping("/resource/delete")
    public ResultBean delete(Long oid) {
        return kspResourceService.delete(oid);
    }

    /**
     * 树形列表
     * @return
     */
    @GetMapping("/resource/treeList")
    public ResultBean treeList() {
        return kspResourceService.treeList();
    }
}
