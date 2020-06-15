package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BbsContextDynamicSqlSupport {
    public static final BbsContext bbsContext = new BbsContext();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = bbsContext.oid;

    /**
     * 主题ID
     * theme_id
     */
    public static final SqlColumn<Long> themeId = bbsContext.themeId;

    /**
     * 评论类型：0文章、1评论、2回复
     * context_type
     */
    public static final SqlColumn<Byte> contextType = bbsContext.contextType;

    /**
     * 评论摘要，在回复时，摘取父评论的简要
     * profile
     */
    public static final SqlColumn<String> profile = bbsContext.profile;

    /**
     * 审核状态：0待审核 1审核通过 2审核拒绝
     * audit_status
     */
    public static final SqlColumn<Byte> auditStatus = bbsContext.auditStatus;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = bbsContext.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = bbsContext.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = bbsContext.updateTime;

    /**
     * 更新人ID
     * update_user
     */
    public static final SqlColumn<Long> updateUser = bbsContext.updateUser;

    /**
     * 发布状态 1已发布 0存草稿未发布
     * publish_status
     */
    public static final SqlColumn<Byte> publishStatus = bbsContext.publishStatus;

    /**
     * 作者ID
     * author
     */
    public static final SqlColumn<Long> author = bbsContext.author;

    /**
     * 评论内容
     * context
     */
    public static final SqlColumn<String> context = bbsContext.context;

    public static final class BbsContext extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> themeId = column("theme_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> contextType = column("context_type", JDBCType.TINYINT);

        public final SqlColumn<String> profile = column("profile", JDBCType.VARCHAR);

        public final SqlColumn<Byte> auditStatus = column("audit_status", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateUser = column("update_user", JDBCType.BIGINT);

        public final SqlColumn<Byte> publishStatus = column("publish_status", JDBCType.TINYINT);

        public final SqlColumn<Long> author = column("author", JDBCType.BIGINT);

        public final SqlColumn<String> context = column("context", JDBCType.LONGVARCHAR);

        public BbsContext() {
            super("bbs_context");
        }
    }
}