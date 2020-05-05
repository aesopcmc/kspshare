package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ResourceDynamicSqlSupport {
    public static final Resource resource = new Resource();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = resource.oid;

    /**
     * 资源名称
     * name
     */
    public static final SqlColumn<String> name = resource.name;

    /**
     * 资源编码，唯一
     * code
     */
    public static final SqlColumn<String> code = resource.code;

    /**
     * 编码链，通过“-”拼接，不包含自身，最顶级为NULL
     * code_link
     */
    public static final SqlColumn<String> codeLink = resource.codeLink;

    /**
     * 父资源ID
     * parent_id
     */
    public static final SqlColumn<Long> parentId = resource.parentId;

    /**
     * 资源类型 1菜单 2按钮 
     * resource_type
     */
    public static final SqlColumn<Byte> resourceType = resource.resourceType;

    /**
     * 资源URL
     * url
     */
    public static final SqlColumn<String> url = resource.url;

    /**
     * 图标
     * icon
     */
    public static final SqlColumn<String> icon = resource.icon;

    /**
     * vue组件名，用于路由配置
     * component_name
     */
    public static final SqlColumn<String> componentName = resource.componentName;

    /**
     * 排序
     * sort
     */
    public static final SqlColumn<Integer> sort = resource.sort;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = resource.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = resource.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = resource.updateTime;

    public static final class Resource extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> codeLink = column("code_link", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> resourceType = column("resource_type", JDBCType.TINYINT);

        public final SqlColumn<String> url = column("url", JDBCType.VARCHAR);

        public final SqlColumn<String> icon = column("icon", JDBCType.VARCHAR);

        public final SqlColumn<String> componentName = column("component_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sort = column("sort", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Resource() {
            super("resource");
        }
    }
}