package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RoleDynamicSqlSupport {
    public static final Role role = new Role();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = role.oid;

    /**
     * 角色名称
     * name
     */
    public static final SqlColumn<String> name = role.name;

    /**
     * 角色编码，唯一编码
     * code
     */
    public static final SqlColumn<String> code = role.code;

    /**
     * 编码链，通过“-”拼接，不包含自身，最顶级为NULL
     * code_link
     */
    public static final SqlColumn<String> codeLink = role.codeLink;

    /**
     * 父ID, 默认顶级父级为0
     * parent_id
     */
    public static final SqlColumn<Long> parentId = role.parentId;

    /**
     * 角色描述信息
     * description
     */
    public static final SqlColumn<String> description = role.description;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = role.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = role.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = role.updateTime;

    public static final class Role extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<String> codeLink = column("code_link", JDBCType.VARCHAR);

        public final SqlColumn<Long> parentId = column("parent_id", JDBCType.BIGINT);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Role() {
            super("role");
        }
    }
}