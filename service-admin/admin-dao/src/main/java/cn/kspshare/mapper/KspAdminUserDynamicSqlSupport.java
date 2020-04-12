package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspAdminUserDynamicSqlSupport {
    public static final KspAdminUser kspAdminUser = new KspAdminUser();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = kspAdminUser.oid;

    /**
     * 用户登录名
     * username
     */
    public static final SqlColumn<String> username = kspAdminUser.username;

    /**
     * 用户真实姓名
     * realname
     */
    public static final SqlColumn<String> realname = kspAdminUser.realname;

    /**
     * 用户登录密码
     * password
     */
    public static final SqlColumn<String> password = kspAdminUser.password;

    /**
     * 0保密 1男 2女，默认0
     * gender
     */
    public static final SqlColumn<Byte> gender = kspAdminUser.gender;

    /**
     * 邮箱
     * email
     */
    public static final SqlColumn<String> email = kspAdminUser.email;

    /**
     * enabled	是否可以登录	 0禁止 1允许
     * enabled
     */
    public static final SqlColumn<Byte> enabled = kspAdminUser.enabled;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = kspAdminUser.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = kspAdminUser.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = kspAdminUser.updateTime;

    public static final class KspAdminUser extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> realname = column("realname", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<Byte> gender = column("gender", JDBCType.TINYINT);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Byte> enabled = column("enabled", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public KspAdminUser() {
            super("ksp_admin_user");
        }
    }
}