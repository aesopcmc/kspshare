package cn.kspshare.dao;

import cn.kspshare.vo.ContentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsContextDao {
    /**
     * 查看文章、评论、回复
     * @param themeId
     * @return
     */
    List<ContentVo> showContent(@Param("themeId") Long themeId);
}
