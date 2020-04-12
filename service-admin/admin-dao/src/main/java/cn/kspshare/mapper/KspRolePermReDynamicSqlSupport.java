package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspRolePermReDynamicSqlSupport {
    public static final KspRolePermRe kspRolePermRe = new KspRolePermRe();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = kspRolePermRe.oid;

    /**
     * 角色ID
     * role_id
     */
    public static final SqlColumn<Long> roleId = kspRolePermRe.roleId;

    /**
     * 权限ID
     * perm_id
     */
    public static final SqlColumn<Long> permId = kspRolePermRe.permId;

    /**
     * 0可访问 1可授权
     * perm_type
     */
    public static final SqlColumn<Byte> permType = kspRolePermRe.permType;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = kspRolePermRe.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = kspRolePermRe.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = kspRolePermRe.updateTime;

    public static final class KspRolePermRe extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permId = column("perm_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> permType = column("perm_type", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public KspRolePermRe() {
            super("ksp_role_perm_re");
        }
    }
}