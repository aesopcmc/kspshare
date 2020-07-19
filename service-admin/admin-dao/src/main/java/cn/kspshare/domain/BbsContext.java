package cn.kspshare.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.*;

/**
 * 论坛评论表
 * bbs_context
 * 
 * @author Mybatis Generator
 */
@Getter
@Setter
public class BbsContext {
    /**
     * 主键
     * oid
     */
    private Long oid;

    /**
     * 主题ID
     * theme_id
     */
    private Long themeId;

    /**
     * 评论类型：0文章、1评论、2回复
     * context_type
     */
    private Byte contextType;

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
     * 评论内容
     * context
     */
    private String context;
}