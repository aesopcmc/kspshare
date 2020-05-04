package cn.kspshare.controller;

import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.config.userinfo.UserInfo;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.domain.KspBbsSession;
import cn.kspshare.dto.BaseSearchDto;
import cn.kspshare.service.BbsSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@Slf4j
@UserLoginToken
@Api(tags = "论坛版块管理")
public class BbsSessionController {
    @Autowired
    private UserInfoManager userInfoManager;

    @Autowired
    private BbsSessionService bbsSessionService;

    /**
     * 添加
     * @param po
     * @return
     */
    @ApiOperation("添加")
    @PostMapping("/bbs/session")
    public ResultBean add(@RequestBody KspBbsSession po) {
        UserInfo userInfo = userInfoManager.getUserInfo();
        po.setCreateUser(userInfo.getOid());
        return bbsSessionService.add(po);
    }

    /**
     * 更新
     * @param po
     * @return
     */
    @ApiOperation("更新")
    @PutMapping(value = "/bbs/session")
    public ResultBean update(@RequestBody @Validated KspBbsSession po) {
        UserInfo userInfo = userInfoManager.getUserInfo();
        po.setCreateUser(userInfo.getOid());
        return bbsSessionService.update(po);
    }

    /**
     * 删除
     * @param oid
     * @return
     */
    @ApiOperation("删除")
    @DeleteMapping("/bbs/session/{oid}")
    public ResultBean delete(@PathVariable Long oid) {
        return bbsSessionService.delete(oid);
    }

    /**
     * 查询
     * @return
     */
    @ApiOperation("查询")
    @GetMapping("/bbs/session")
    public ResultBean queryCondition(BaseSearchDto param) {
        return bbsSessionService.queryCondition(param);
    }

}
