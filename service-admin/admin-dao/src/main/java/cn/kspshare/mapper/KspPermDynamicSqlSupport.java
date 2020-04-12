package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspPermDynamicSqlSupport {
    public static final KspPerm kspPerm = new KspPerm();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = kspPerm.oid;

    /**
     * 权限名称
     * name
     */
    public static final SqlColumn<String> name = kspPerm.name;

    /**
     * 权限编码，唯一
     * code
     */
    public static final SqlColumn<String> code = kspPerm.code;

    /**
     * 资源ID
     * resource_id
     */
    public static final SqlColumn<Long> resourceId = kspPerm.resourceId;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = kspPerm.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = kspPerm.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = kspPerm.updateTime;

    public static final class KspPerm extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<Long> resourceId = column("resource_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public KspPerm() {
            super("ksp_perm");
        }
    }
}