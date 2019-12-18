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
     *   0保密 1男 2女，默认0
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.gender")
    public static final SqlColumn<Boolean> gender = kspAdminUser.gender;

    /**
     * Database Column Remarks:
     *   邮箱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.email")
    public static final SqlColumn<String> email = kspAdminUser.email;

    /**
     * Database Column Remarks:
     *   enabled	是否可以登录	 0禁止 1允许
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.enabled")
    public static final SqlColumn<Boolean> enabled = kspAdminUser.enabled;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspAdminUser.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_admin_user.create_user")
    public static final SqlColumn<Long> createUser = kspAdminUser.createUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    public static final class KspAdminUser extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> realname = column("realname", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> gender = column("gender", JDBCType.BIT);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> enabled = column("enabled", JDBCType.BIT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public KspAdminUser() {
            super("ksp_admin_user");
        }
    }
}