package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspUserRoleReDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    public static final KspUserRoleRe kspUserRoleRe = new KspUserRoleRe();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_role_re.oid")
    public static final SqlColumn<Long> oid = kspUserRoleRe.oid;

    /**
     * Database Column Remarks:
     *   用户ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_role_re.user_id")
    public static final SqlColumn<Long> userId = kspUserRoleRe.userId;

    /**
     * Database Column Remarks:
     *   角色ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_role_re.role_id")
    public static final SqlColumn<Long> roleId = kspUserRoleRe.roleId;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_role_re.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspUserRoleRe.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_role_re.create_user")
    public static final SqlColumn<Long> createUser = kspUserRoleRe.createUser;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_role_re.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = kspUserRoleRe.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    public static final class KspUserRoleRe extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> roleId = column("role_id", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public KspUserRoleRe() {
            super("ksp_user_role_re");
        }
    }
}