package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserRoleReDynamicSqlSupport {
    public static final UserRoleRe userRoleRe = new UserRoleRe();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = userRoleRe.oid;

    /**
     * 用户ID
     * user_id
     */
    public static final SqlColumn<Long> userId = userRoleRe.userId;

    /**
     * 角色ID
     * role_id
     */
    public static final SqlColumn<Long> roleId = userRoleRe.roleId;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = userRoleRe.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = userRoleRe.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = userRoleRe.updateTime;

    public static final class UserRoleRe extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public UserRoleRe() {
            super("user_role_re");
        }
    }
}