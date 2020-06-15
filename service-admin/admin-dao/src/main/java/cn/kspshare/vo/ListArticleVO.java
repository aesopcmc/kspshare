package cn.kspshare.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ListArticleVO {

    /**
     * 主题ID
     * theme_id
     */
    private Long themeId;
    /**
     * 内容ID
     * oid
     */
    private Long contextId;
    /**
     * 标题
     * title
     */
    private String title;
    /**
     * 摘要
     * profile
     */
    private String profile;
    /**
     * 版块ID
     * session_id
     */
    private Long sessionId;

    /**
     * 发布状态 1已发布 0草稿未发布
     * theme_status
     */
    private Byte publishStatus;

    /**
     * 审核状态：0待审核 1审核通过 2审核拒绝
     * audit_status
     */
    private Byte auditStatus;

    /**
     * 创建人ID
     * create_user
     */
    private String createUser;

    /**
     * 创建人名称
     * create_user
     */
    private String createUserName;

    /**
     * 作者ID
     * create_user
     */
    private String author;

    /**
     * 作者名称
     * create_user
     */
    private String authorName;
    /**
     * 回复数量，包含评论和回复
     * reply_count
     */
    private Integer replyCount;
    /**
     * 创建时间
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建时间
     * update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 版块名称
     */
    private String sessionName;
}
