package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspAdminUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    public static final KspAdminUser kspAdminUser = new KspAdminUser();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.oid")
    public static final SqlColumn<Long> oid = kspAdminUser.oid;

    /**
     * Database Column Remarks:
     *   用户登录名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.username")
    public static final SqlColumn<String> username = kspAdminUser.username;

    /**
     * Database Column Remarks:
     *   用户真实姓名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.realname")
    public static final SqlColumn<String> realname = kspAdminUser.realname;

    /**
     * Database Column Remarks:
     *   用户登录密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.password")
    public static final SqlColumn<String> password = kspAdminUser.password;

    /**
     * Database Column Remarks:
     *   是可以登录 true1启用 false0禁用
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.enabled")
    public static final SqlColumn<Boolean> enabled = kspAdminUser.enabled;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspAdminUser.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    public static final class KspAdminUser extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> realname = column("realname", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> enabled = column("enabled", JDBCType.BIT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public KspAdminUser() {
            super("ksp_admin_user");
        }
    }
}