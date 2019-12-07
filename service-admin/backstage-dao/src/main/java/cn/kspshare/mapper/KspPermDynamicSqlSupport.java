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
     *   权限值
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.perm_value")
    public static final SqlColumn<String> permValue = kspPerm.permValue;

    /**
     * Database Column Remarks:
     *   权限名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_perm.perm_name")
    public static final SqlColumn<String> permName = kspPerm.permName;

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

        public final SqlColumn<String> permValue = column("perm_value", JDBCType.VARCHAR);

        public final SqlColumn<String> permName = column("perm_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public KspPerm() {
            super("ksp_perm");
        }
    }
}