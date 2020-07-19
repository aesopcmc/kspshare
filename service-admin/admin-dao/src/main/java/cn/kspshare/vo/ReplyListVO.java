package cn.kspshare.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 评论回复列表
 */
@Data
public class ReplyListVO {
    /**
     * 内容表id
     * title
     */
    private Long contextId;
    /**
     * 主题id
     * title
     */
    private Long themeId;
    /**
     * 主题标题
     * title
     */
    private String themeTitle;
    /**
     * 评论摘要，在回复时，摘取评论前100个字
     * profile
     */
    private String profile;

    /**
     * 审核状态：0待审核 1审核通过 2审核拒绝
     * audit_status
     */
    private Byte auditStatus;

    /**
     * 发布状态 1已发布 0存草稿未发布
     * publish_status
     */
    private Byte publishStatus;

    /**
     * 作者ID
     * author
     */
    private Long author;

    /**
     * 作者昵称
     * author
     */
    private String authorName;

    /**
     * 创建时间、评论时间
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
