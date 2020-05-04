package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspBbsContextDynamicSqlSupport {
    public static final KspBbsContext kspBbsContext = new KspBbsContext();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = kspBbsContext.oid;

    /**
     * 主题ID
     * theme_id
     */
    public static final SqlColumn<Long> themeId = kspBbsContext.themeId;

    /**
     * 评论类型：0文章、1评论、2回复
     * context_type
     */
    public static final SqlColumn<Byte> contextType = kspBbsContext.contextType;

    /**
     * 评论摘要，在回复时，摘取父评论的简要
     * profile
     */
    public static final SqlColumn<String> profile = kspBbsContext.profile;

    /**
     * 审核状态：0待审核 1审核通过 2审核拒绝
     * audit_status
     */
    public static final SqlColumn<Byte> auditStatus = kspBbsContext.auditStatus;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = kspBbsContext.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = kspBbsContext.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = kspBbsContext.updateTime;

    /**
     * 更新人ID
     * update_user
     */
    public static final SqlColumn<Long> updateUser = kspBbsContext.updateUser;

    /**
     * 评论内容
     * context
     */
    public static final SqlColumn<String> context = kspBbsContext.context;

    public static final class KspBbsContext extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> themeId = column("theme_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> contextType = column("context_type", JDBCType.TINYINT);

        public final SqlColumn<String> profile = column("profile", JDBCType.VARCHAR);

        public final SqlColumn<Byte> auditStatus = column("audit_status", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateUser = column("update_user", JDBCType.BIGINT);

        public final SqlColumn<String> context = column("context", JDBCType.LONGVARCHAR);

        public KspBbsContext() {
            super("ksp_bbs_context");
        }
    }
}