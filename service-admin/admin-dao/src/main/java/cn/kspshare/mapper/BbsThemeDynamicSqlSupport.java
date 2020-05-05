package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BbsThemeDynamicSqlSupport {
    public static final BbsTheme bbsTheme = new BbsTheme();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = bbsTheme.oid;

    /**
     * 标题
     * title
     */
    public static final SqlColumn<String> title = bbsTheme.title;

    /**
     * 摘要
     * profile
     */
    public static final SqlColumn<String> profile = bbsTheme.profile;

    /**
     * 版块ID
     * session_id
     */
    public static final SqlColumn<Long> sessionId = bbsTheme.sessionId;

    /**
     * 回复数量，包含评论和回复
     * reply_count
     */
    public static final SqlColumn<Integer> replyCount = bbsTheme.replyCount;

    /**
     * 最后回复用户ID
     * last_reply_user
     */
    public static final SqlColumn<Long> lastReplyUser = bbsTheme.lastReplyUser;

    /**
     * 最后回复时间
     * last_reply_time
     */
    public static final SqlColumn<LocalDateTime> lastReplyTime = bbsTheme.lastReplyTime;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = bbsTheme.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = bbsTheme.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = bbsTheme.updateTime;

    /**
     * 更新人ID
     * update_user
     */
    public static final SqlColumn<Long> updateUser = bbsTheme.updateUser;

    public static final class BbsTheme extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> title = column("title", JDBCType.VARCHAR);

        public final SqlColumn<String> profile = column("profile", JDBCType.VARCHAR);

        public final SqlColumn<Long> sessionId = column("session_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> replyCount = column("reply_count", JDBCType.INTEGER);

        public final SqlColumn<Long> lastReplyUser = column("last_reply_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> lastReplyTime = column("last_reply_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateUser = column("update_user", JDBCType.BIGINT);

        public BbsTheme() {
            super("bbs_theme");
        }
    }
}