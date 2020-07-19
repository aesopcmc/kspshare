package cn.kspshare.service;

import cn.kspshare.domain.BbsContext;
import cn.kspshare.dto.ReplyDto;
import cn.kspshare.vo.ReplyListVO;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 《由Mybatis Generator extend插件自动生成》
 * 
 * @author Mybatis Generator
 * @date 2020-05-05
 */
public interface BbsContextService {
    /**
     * 添加
     * @param po
     * @return
     */
    int add(BbsContext po);

    /**
     * 修改
     * @param po
     * @return
     */
    int update(BbsContext po);

    /**
     *删除评论、回复
     * @param oid
     * @return
     */
    int delete(Long oid);

    BbsContext selectByPrimaryKey(Long oid);

    /**
     * 基本条件查询
     * @param pageNum 当前页码
     * @param pageSize 每页显示数量
     * @return
     */
    PageInfo<BbsContext> queryCondition(int pageNum, int pageSize);

    /**
     * 查看帖子：查看文章、评论、回复
     * @param themeId 文章id
     * @param pageNum
     * @param pageSize
     * @return
     */
    Map<String, Object> showContent(Long themeId, Integer pageNum, Integer pageSize);

    /**
     * 审核文章、评论、回复
     * @param contextId 文章、评论、回复  id
     * @param auditStatus 0待审核 1审核通过 2审核拒绝
     * @return
     */
    int auditContent(Long contextId, Byte auditStatus);

    /**
     * 评论回复列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ReplyListVO> replyList(Integer pageNum, Integer pageSize);

    /**
     * 获取评论、回复
     * @param contextId
     * @return
     */
    ReplyDto getReply(Long contextId);

    /**
     * 修改评论、回复
     * @param dto
     * @return
     */
    int updateReply(ReplyDto dto);

}