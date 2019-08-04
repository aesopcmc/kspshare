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
     *   资源id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.resourceId")
    public static final SqlColumn<String> resourceid = kspPerm.resourceid;

    /**
     * Database Column Remarks:
     *   资源名
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.resourceName")
    public static final SqlColumn<String> resourcename = kspPerm.resourcename;

    /**
     * Database Column Remarks:
     *   父主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.parent_id")
    public static final SqlColumn<Long> parentId = kspPerm.parentId;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspPerm.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    public static final class KspPerm extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> resourceid = column("resourceId", JDBCType.VARCHAR);

        public final SqlColumn<String> resourcename = column("resourceName", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public KspPerm() {
            super("ksp_perm");
        }
    }
}