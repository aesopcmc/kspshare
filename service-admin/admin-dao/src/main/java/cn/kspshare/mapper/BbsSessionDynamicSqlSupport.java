package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BbsSessionDynamicSqlSupport {
    public static final BbsSession bbsSession = new BbsSession();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = bbsSession.oid;

    /**
     * 板块名称
     * name
     */
    public static final SqlColumn<String> name = bbsSession.name;

    /**
     * 板块主题、简要
     * profile
     */
    public static final SqlColumn<String> profile = bbsSession.profile;

    /**
     * 总发帖数
     * topic_count
     */
    public static final SqlColumn<Integer> topicCount = bbsSession.topicCount;

    /**
     * 总浏览量
     * view_count
     */
    public static final SqlColumn<Integer> viewCount = bbsSession.viewCount;

    /**
     * 总点击率
     * click_rate
     */
    public static final SqlColumn<Float> clickRate = bbsSession.clickRate;

    /**
     * 排序
     * sort
     */
    public static final SqlColumn<Integer> sort = bbsSession.sort;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = bbsSession.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = bbsSession.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = bbsSession.updateTime;

    /**
     * 更新人ID
     * update_user
     */
    public static final SqlColumn<Long> updateUser = bbsSession.updateUser;

    public static final class BbsSession extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> profile = column("profile", JDBCType.VARCHAR);

        public final SqlColumn<Integer> topicCount = column("topic_count", JDBCType.INTEGER);

        public final SqlColumn<Integer> viewCount = column("view_count", JDBCType.INTEGER);

        public final SqlColumn<Float> clickRate = column("click_rate", JDBCType.REAL);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> updateUser = column("update_user", JDBCType.BIGINT);

        public BbsSession() {
            super("bbs_session");
        }
    }
}