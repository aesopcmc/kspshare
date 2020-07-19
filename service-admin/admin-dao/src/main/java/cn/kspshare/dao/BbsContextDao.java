package cn.kspshare.dao;

import cn.kspshare.dto.ReplyDto;
import cn.kspshare.vo.ContentVO;
import cn.kspshare.vo.ReplyListVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BbsContextDao {
    /**
     * 查看帖子：查看文章、评论、回复
     * @param themeId
     * @return
     */
    List<ContentVO> showContent(@Param("themeId") Long themeId);

    /**
     * 评论回复列表
     * @return
     */
    List<ReplyListVO> selectReplyList();

    /**
     * 获取评论、回复内容
     * @param contextId 内容id
     * @return
     */
    ReplyDto getReply(Long contextId);
}
