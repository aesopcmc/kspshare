package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspRolePermReDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    public static final KspRolePermRe kspRolePermRe = new KspRolePermRe();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role_perm_re.oid")
    public static final SqlColumn<Long> oid = kspRolePermRe.oid;

    /**
     * Database Column Remarks:
     *   角色ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role_perm_re.role_id")
    public static final SqlColumn<Long> roleId = kspRolePermRe.roleId;

    /**
     * Database Column Remarks:
     *   权限ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role_perm_re.perm_id")
    public static final SqlColumn<Long> permId = kspRolePermRe.permId;

    /**
     * Database Column Remarks:
     *   0可访问 1可授权
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role_perm_re.perm_type")
    public static final SqlColumn<Boolean> permType = kspRolePermRe.permType;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role_perm_re.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspRolePermRe.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role_perm_re.create_user")
    public static final SqlColumn<Long> createUser = kspRolePermRe.createUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    public static final class KspRolePermRe extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permId = column("perm_id", JDBCType.BIGINT);

        public final SqlColumn<Boolean> permType = column("perm_type", JDBCType.BIT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public KspRolePermRe() {
            super("ksp_role_perm_re");
        }
    }
}