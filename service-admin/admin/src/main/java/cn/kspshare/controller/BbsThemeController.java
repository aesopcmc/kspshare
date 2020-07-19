package cn.kspshare.controller;

import cn.kspshare.annotation.UserLoginToken;
import cn.kspshare.common.restful.ResultBean;
import cn.kspshare.config.userinfo.UserInfo;
import cn.kspshare.config.userinfo.UserInfoManager;
import cn.kspshare.domain.BbsTheme;
import cn.kspshare.dto.CreateArticleDto;
import cn.kspshare.service.BbsThemeService;
import cn.kspshare.vo.ArticleVO;
import cn.kspshare.vo.ListArticleVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 《由Mybatis Generator extend插件自动生成》
 * 
 * @author Mybatis Generator
 * @date 2020-05-05
 */
@RestController
@UserLoginToken
@Slf4j
@Api(tags = "论坛主题表")
public class BbsThemeController {
    @Autowired
    private UserInfoManager userInfoManager;

    @Autowired
    private BbsThemeService service;

    /**
     * 添加
     * @param po
     * @return
     */
    @ApiOperation("添加")
    @PostMapping("/bbs/theme")
    public ResultBean add(@RequestBody BbsTheme po) {
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
    @PutMapping("/bbs/theme")
    public ResultBean update(@RequestBody BbsTheme po) {
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
    @DeleteMapping("/bbs/theme/{oid}")
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
    @GetMapping("/bbs/theme")
    public ResultBean queryCondition(Integer pageNum, Integer pageSize) {
        if(pageNum==null) pageNum=1;
        if(pageSize==null) pageSize=10;
        PageInfo<ListArticleVO> pageInfo = service.listArticle(pageNum, pageSize);
        return ResultBean.SUCCESS().setData(pageInfo);
    }

    /**
     * 文章编辑回显
     * @return
     */
    @ApiOperation("查看文章详情、编辑回显")
    @GetMapping("/bbs/theme/getArticle/{articleId}")
    public ResultBean getArticle(@PathVariable Long articleId) {
        ArticleVO vo = service.getArticle(articleId);
        return ResultBean.SUCCESS().setData(vo);
    }

    /**
     * 创建、修改文章
     * @return
     */
    @ApiOperation("创建、修改文章")
    @PostMapping("/bbs/theme/createArticle")
    public ResultBean createOrUpdateArticle(@RequestBody CreateArticleDto dto) {
        UserInfo userInfo = userInfoManager.getUserInfo();
        dto.setCreateUser(userInfo.getOid());
        int i = service.createOrUpdateArticle(dto);
        return ResultBean.SUCCESS().setData(i);
    }

}