package cn.kspshare.dao;

import cn.kspshare.vo.ArticleVO;
import cn.kspshare.vo.ListArticleVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsThemeDao {
    /**
     * 查看文章详情
     * @param articleId
     * @return
     */
    ArticleVO getArticle(@Param("articleId") Long articleId);

    List<ListArticleVO> listArticle();

}
