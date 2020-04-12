package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspBbsSessionDynamicSqlSupport {
    public static final KspBbsSession kspBbsSession = new KspBbsSession();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = kspBbsSession.oid;

    /**
     * 板块名称
     * name
     */
    public static final SqlColumn<String> name = kspBbsSession.name;

    /**
     * 板块主题、简要
     * profile
     */
    public static final SqlColumn<String> profile = kspBbsSession.profile;

    /**
     * 总发帖数
     * topic_count
     */
    public static final SqlColumn<Integer> topicCount = kspBbsSession.topicCount;

    /**
     * 总浏览量
     * view_count
     */
    public static final SqlColumn<Integer> viewCount = kspBbsSession.viewCount;

    /**
     * 总点击率
     * click_rate
     */
    public static final SqlColumn<Float> clickRate = kspBbsSession.clickRate;

    /**
     * 排序
     * sort
     */
    public static final SqlColumn<Integer> sort = kspBbsSession.sort;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = kspBbsSession.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = kspBbsSession.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = kspBbsSession.updateTime;

    /**
     * 更新人ID
     * update_user
     */
    public static final SqlColumn<Long> updateUser = kspBbsSession.updateUser;

    public static final class KspBbsSession extends SqlTable {
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

        public KspBbsSession() {
            super("ksp_bbs_session");
        }
    }
}