package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspPermDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    public static final KspPerm kspPerm = new KspPerm();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.oid")
    public static final SqlColumn<Long> oid = kspPerm.oid;

    /**
     * Database Column Remarks:
     *   权限名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.name")
    public static final SqlColumn<String> name = kspPerm.name;

    /**
     * Database Column Remarks:
     *   权限编码，唯一
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.code")
    public static final SqlColumn<String> code = kspPerm.code;

    /**
     * Database Column Remarks:
     *   资源ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.resource_id")
    public static final SqlColumn<Long> resourceId = kspPerm.resourceId;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspPerm.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.create_user")
    public static final SqlColumn<Long> createUser = kspPerm.createUser;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = kspPerm.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
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