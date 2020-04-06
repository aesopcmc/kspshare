package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspBbsSessionDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    public static final KspBbsSession kspBbsSession = new KspBbsSession();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.oid")
    public static final SqlColumn<Long> oid = kspBbsSession.oid;

    /**
     * Database Column Remarks:
     *   板块名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.name")
    public static final SqlColumn<String> name = kspBbsSession.name;

    /**
     * Database Column Remarks:
     *   板块主题、简要
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.profile")
    public static final SqlColumn<String> profile = kspBbsSession.profile;

    /**
     * Database Column Remarks:
     *   总发帖数
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.topic_count")
    public static final SqlColumn<Integer> topicCount = kspBbsSession.topicCount;

    /**
     * Database Column Remarks:
     *   总浏览量
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.view_count")
    public static final SqlColumn<Integer> viewCount = kspBbsSession.viewCount;

    /**
     * Database Column Remarks:
     *   总点击率
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.click_rate")
    public static final SqlColumn<Float> clickRate = kspBbsSession.clickRate;

    /**
     * Database Column Remarks:
     *   排序
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.sort")
    public static final SqlColumn<Integer> sort = kspBbsSession.sort;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspBbsSession.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.create_user")
    public static final SqlColumn<Long> createUser = kspBbsSession.createUser;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = kspBbsSession.updateTime;

    /**
     * Database Column Remarks:
     *   更新人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_bbs_session.update_user")
    public static final SqlColumn<Long> updateUser = kspBbsSession.updateUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
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