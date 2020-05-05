package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 论坛主题表
 * bbs_theme
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class BbsTheme {
    /**
     * 主键
     * oid
     */
    private Long oid;

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
     * 回复数量，包含评论和回复
     * reply_count
     */
    private Integer replyCount;

    /**
     * 最后回复用户ID
     * last_reply_user
     */
    private Long lastReplyUser;

    /**
     * 最后回复时间
     * last_reply_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastReplyTime;

    /**
     * 创建时间
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 创建人ID
     * create_user
     */
    private Long createUser;

    /**
     * 创建时间
     * update_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 更新人ID
     * update_user
     */
    private Long updateUser;
}