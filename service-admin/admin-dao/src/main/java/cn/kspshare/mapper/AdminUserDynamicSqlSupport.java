package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class AdminUserDynamicSqlSupport {
    public static final AdminUser adminUser = new AdminUser();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = adminUser.oid;

    /**
     * 用户登录名
     * username
     */
    public static final SqlColumn<String> username = adminUser.username;

    /**
     * 用户真实姓名
     * realname
     */
    public static final SqlColumn<String> realname = adminUser.realname;

    /**
     * 用户登录密码
     * password
     */
    public static final SqlColumn<String> password = adminUser.password;

    /**
     * 0保密 1男 2女，默认0
     * gender
     */
    public static final SqlColumn<Byte> gender = adminUser.gender;

    /**
     * 邮箱
     * email
     */
    public static final SqlColumn<String> email = adminUser.email;

    /**
     * enabled	是否可以登录	 0禁止 1允许
     * enabled
     */
    public static final SqlColumn<Byte> enabled = adminUser.enabled;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = adminUser.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = adminUser.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = adminUser.updateTime;

    public static final class AdminUser extends SqlTable {
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

        public AdminUser() {
            super("admin_user");
        }
    }
}