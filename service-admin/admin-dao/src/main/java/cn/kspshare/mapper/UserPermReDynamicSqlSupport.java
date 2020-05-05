package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserPermReDynamicSqlSupport {
    public static final UserPermRe userPermRe = new UserPermRe();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = userPermRe.oid;

    /**
     * 用户ID
     * user_id
     */
    public static final SqlColumn<Long> userId = userPermRe.userId;

    /**
     * 权限ID
     * perm_id
     */
    public static final SqlColumn<Long> permId = userPermRe.permId;

    /**
     * 0可访问 1可授权
     * perm_type
     */
    public static final SqlColumn<Byte> permType = userPermRe.permType;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = userPermRe.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = userPermRe.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = userPermRe.updateTime;

    public static final class UserPermRe extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permId = column("perm_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> permType = column("perm_type", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public UserPermRe() {
            super("user_perm_re");
        }
    }
}