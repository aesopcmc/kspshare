package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user")
    public static final KspUser kspUser = new KspUser();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.oid")
    public static final SqlColumn<Long> oid = kspUser.oid;

    /**
     * Database Column Remarks:
     *   账号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.username")
    public static final SqlColumn<String> username = kspUser.username;

    /**
     * Database Column Remarks:
     *   密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.password")
    public static final SqlColumn<String> password = kspUser.password;

    /**
     * Database Column Remarks:
     *   昵称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.nickname")
    public static final SqlColumn<String> nickname = kspUser.nickname;

    /**
     * Database Column Remarks:
     *   身份权限
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.roles")
    public static final SqlColumn<String> roles = kspUser.roles;

    /**
     * Database Column Remarks:
     *   邮箱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.email")
    public static final SqlColumn<String> email = kspUser.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspUser.createTime;

    /**
     * Database Column Remarks:
     *   是可以登录 true1启用 false0禁用
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user.enabled")
    public static final SqlColumn<Boolean> enabled = kspUser.enabled;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user")
    public static final class KspUser extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> roles = column("roles", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> enabled = column("enabled", JDBCType.BIT);

        public KspUser() {
            super("ksp_user");
        }
    }
}