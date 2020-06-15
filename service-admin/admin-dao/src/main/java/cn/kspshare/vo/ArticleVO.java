package cn.kspshare.vo;

import lombok.Data;

@Data
public class ArticleVO {
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
     * 评论内容(文章内容html)
     * context
     */
    private String content;
}
