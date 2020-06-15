package cn.kspshare.service;

import cn.kspshare.domain.BbsTheme;
import cn.kspshare.dto.CreateArticleDto;
import cn.kspshare.vo.ArticleVO;
import cn.kspshare.vo.ListArticleVO;
import com.github.pagehelper.PageInfo;

/**
 * 《由Mybatis Generator extend插件自动生成》
 * 
 * @author Mybatis Generator
 * @date 2020-05-05
 */
public interface BbsThemeService {
    /**
     * 添加
     * @param po
     * @return
     */
    int add(BbsTheme po);

    /**
     * 修改
     * @param po
     * @return
     */
    int update(BbsTheme po);

    /**
     * 删除
     * @param oid
     * @return
     */
    int delete(Long oid);

    /**
     * 基本条件查询
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo<ListArticleVO> listArticle(int pageNum, int pageSize);

    /**
     * 创建文章
     * @param dto
     * @return
     */
    int createOrUpdateArticle(CreateArticleDto dto);

    /**
     * 查看文章详情
     * @param articleId
     * @return
     */
    ArticleVO getArticle(Long articleId);
}