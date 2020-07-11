package cn.kspshare.controller;

import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.config.userinfo.UserInfo;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.domain.BbsContext;
import cn.kspshare.service.BbsContextService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 《由Mybatis Generator extend插件自动生成》
 * 
 * @author Mybatis Generator
 * @date 2020-05-05
 */
@RestController
@UserLoginToken
@Slf4j
@Api(tags = "论坛评论表")
public class BbsContextController {
    @Autowired
    private UserInfoManager userInfoManager;

    @Autowired
    private BbsContextService service;

    /**
     * 添加
     * @param po
     * @return
     */
    @ApiOperation("添加")
    @PostMapping("/bbs/context")
    public ResultBean add(@RequestBody BbsContext po) {
        UserInfo userInfo = userInfoManager.getUserInfo();
        po.setCreateUser(userInfo.getOid());
        service.add(po);
        return ResultBean.SUCCESS();
    }

    /**
     * 修改
     * @param po
     * @return
     */
    @ApiOperation("修改")
    @PutMapping("/bbs/context")
    public ResultBean update(@RequestBody BbsContext po) {
        UserInfo userInfo = userInfoManager.getUserInfo();
        po.setUpdateUser(userInfo.getOid());
        service.update(po);
        return ResultBean.SUCCESS();
    }

    /**
     * 删除
     * @param oid
     * @return
     */
    @ApiOperation("删除")
    @DeleteMapping("/bbs/context/{oid}")
    public ResultBean delete(@PathVariable Long oid) {
        service.delete(oid);
        return ResultBean.SUCCESS();
    }

    /**
     * 基本条件查询
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     */
    @ApiOperation("基本条件查询")
    @GetMapping("/bbs/context")
    public ResultBean queryCondition(Integer pageNum, Integer pageSize) {
        if(pageNum==null) pageNum=1;
        if(pageSize==null) pageSize=10;
        PageInfo<BbsContext> pageInfo = service.queryCondition(pageNum, pageSize);
        return ResultBean.SUCCESS(pageInfo);
    }

    /**
     * 查看帖子
     * @param themeId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("查看帖子")
    @GetMapping("/bbs/context/showContent/{themeId}")
    public ResultBean showContent(@PathVariable Long themeId, Integer pageNum, Integer pageSize) {
        if(themeId==null){
            return ResultBean.MISSING_PARAMETERS();
        }
        if(pageNum==null) pageNum=1;
        if(pageSize==null) pageSize=10;

        Map<String, Object> data = service.showContent(themeId, pageNum, pageSize);
        return ResultBean.SUCCESS(data);
    }
}