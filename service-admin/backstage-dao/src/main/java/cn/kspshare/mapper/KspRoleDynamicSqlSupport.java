package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspRoleDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    public static final KspRole kspRole = new KspRole();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.oid")
    public static final SqlColumn<Long> oid = kspRole.oid;

    /**
     * Database Column Remarks:
     *   角色名，用于权限校验
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.name")
    public static final SqlColumn<String> name = kspRole.name;

    /**
     * Database Column Remarks:
     *   角色中文名，用于显示
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.nickname")
    public static final SqlColumn<String> nickname = kspRole.nickname;

    /**
     * Database Column Remarks:
     *   角色描述信息
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.description")
    public static final SqlColumn<String> description = kspRole.description;

    /**
     * Database Column Remarks:
     *   角色状态，是否已禁用 0启用 1禁用
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.banned")
    public static final SqlColumn<Boolean> banned = kspRole.banned;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspRole.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    public static final class KspRole extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> banned = column("banned", JDBCType.BIT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public KspRole() {
            super("ksp_role");
        }
    }
}