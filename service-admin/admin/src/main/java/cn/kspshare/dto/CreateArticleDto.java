package cn.kspshare.dto;

import lombok.Data;

@Data
public class CreateArticleDto {
    /**
     * 主题ID
     */
    private Long themeId;
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
     * 创建人ID
     * create_user
     */
    private Long createUser;

    /**
     * 评论内容(文章内容html)
     * context
     */
    private String content;
}
