package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspResourceDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    public static final KspResource kspResource = new KspResource();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.oid")
    public static final SqlColumn<Long> oid = kspResource.oid;

    /**
     * Database Column Remarks:
     *   资源名称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.name")
    public static final SqlColumn<String> name = kspResource.name;

    /**
     * Database Column Remarks:
     *   资源编码，唯一
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.code")
    public static final SqlColumn<String> code = kspResource.code;

    /**
     * Database Column Remarks:
     *   父资源ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.parent_id")
    public static final SqlColumn<Long> parentId = kspResource.parentId;

    /**
     * Database Column Remarks:
     *   资源类型 1菜单 2按钮 
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.resource_type")
    public static final SqlColumn<Boolean> resourceType = kspResource.resourceType;

    /**
     * Database Column Remarks:
     *   资源URL
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.url")
    public static final SqlColumn<String> url = kspResource.url;

    /**
     * Database Column Remarks:
     *   图标
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.icon")
    public static final SqlColumn<String> icon = kspResource.icon;

    /**
     * Database Column Remarks:
     *   vue组件名，用于路由配置
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.compone_name")
    public static final SqlColumn<String> componeName = kspResource.componeName;

    /**
     * Database Column Remarks:
     *   排序
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.sort")
    public static final SqlColumn<Integer> sort = kspResource.sort;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspResource.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_resource.create_user")
    public static final SqlColumn<Long> createUser = kspResource.createUser;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    public static final class KspResource extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<Boolean> resourceType = column("resource_type", JDBCType.BIT);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<String> componeName = column("compone_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public KspResource() {
            super("ksp_resource");
        }
    }
}