package cn.kspshare.controller;

import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.common.restful.ResultCode;
import cn.kspshare.config.userinfo.UserInfo;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.domain.BbsContext;
import cn.kspshare.dto.ReplyDto;
import cn.kspshare.service.BbsContextService;
import cn.kspshare.vo.ReplyListVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        return ResultBean.SUCCESS().setData(pageInfo);
    }

    /**
     * 查看帖子详情：查看文章、评论、回复
     * @param themeId 主题id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("查看帖子详情：查看文章、评论、回复")
    @GetMapping("/bbs/context/showContent")
    public ResultBean showContent(Long themeId, Integer pageNum, Integer pageSize) {
        if(themeId==null){
            return ResultBean.INFO(ResultCode.MISSING_PARAMETERS);
        }
        if(pageNum==null) pageNum=1;
        if(pageSize==null) pageSize=10;

        Map<String, Object> data = service.showContent(themeId, pageNum, pageSize);
        return ResultBean.SUCCESS().setData(data);
    }

    /**
     * 审核文章、评论、回复
     * @return
     */
    @Data
    private static class AuditContentParam {
        /**
         * 文章、评论、回复  id
         */
        private Long contextId;
        /**
         *  0待审核 1审核通过 2审核拒绝
         */
        private Byte auditStatus;
    }
    @ApiOperation("审核文章、评论、回复")
    @PostMapping("/bbs/context/auditContent")
    public ResultBean auditContent(@RequestBody AuditContentParam param) {
        int i = service.auditContent(param.getContextId(), param.getAuditStatus());
        return ResultBean.SUCCESS().setData(i);
    }

    /**
     * 查找评论、回复列表
     * @return
     */
    @ApiOperation("查看帖子详情：查看文章、评论、回复")
    @GetMapping("/bbs/context/replyList")
    public ResultBean replyList(Integer pageNum, Integer pageSize) {
        if(pageNum==null) pageNum=1;
        if(pageSize==null) pageSize=10;
        PageHelper.startPage(pageNum, pageSize);
        List<ReplyListVO> list = service.replyList(pageNum, pageSize);
        PageInfo<ReplyListVO> pageInfo = new PageInfo<>(list);
        return ResultBean.SUCCESS().setData(pageInfo);
    }

    /**
     * 获取评论、回复
     * @return
     */
    @ApiOperation("查看帖子详情：查看文章、评论、回复")
    @GetMapping("/bbs/context/getReply/{contextId}")
    public ResultBean getReply(@PathVariable Long contextId) {
        if(contextId==null){
            return ResultBean.INFO(ResultCode.MISSING_PARAMETERS);
        }
        ReplyDto bbsContext = service.getReply(contextId);
        return ResultBean.SUCCESS().setData(bbsContext);
    }

    /**
     * 修改评论、回复
     * @param dto
     * @return
     */
    @ApiOperation("修改")
    @PutMapping("/bbs/context/updateReply")
    public ResultBean updateReply(@RequestBody ReplyDto dto) {
        dto.setUpdateUser(userInfoManager.getUserInfo().getOid());
        int i = service.updateReply(dto);
        return ResultBean.SUCCESS().setData(i);
    }

    /**
     * 删除评论、回复
     * @param oid
     * @return
     */
    @ApiOperation("删除")
    @DeleteMapping("/bbs/context/deleteReply/{oid}")
    public ResultBean deleteReply(@PathVariable Long oid) {
        service.delete(oid);
        return ResultBean.SUCCESS();
    }

}