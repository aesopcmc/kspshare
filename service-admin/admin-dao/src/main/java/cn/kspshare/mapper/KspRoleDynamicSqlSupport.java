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
     *   角色名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.name")
    public static final SqlColumn<String> name = kspRole.name;

    /**
     * Database Column Remarks:
     *   角色编码，唯一编码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.code")
    public static final SqlColumn<String> code = kspRole.code;

    /**
     * Database Column Remarks:
     *   编码链，通过“-”拼接，不包含自身，最顶级为NULL
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.code_link")
    public static final SqlColumn<String> codeLink = kspRole.codeLink;

    /**
     * Database Column Remarks:
     *   父ID, 默认顶级父级为0
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.parent_id")
    public static final SqlColumn<Long> parentId = kspRole.parentId;

    /**
     * Database Column Remarks:
     *   角色描述信息
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.description")
    public static final SqlColumn<String> description = kspRole.description;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspRole.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.create_user")
    public static final SqlColumn<Long> createUser = kspRole.createUser;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_role.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = kspRole.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    public static final class KspRole extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> codeLink = column("code_link", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public KspRole() {
            super("ksp_role");
        }
    }
}