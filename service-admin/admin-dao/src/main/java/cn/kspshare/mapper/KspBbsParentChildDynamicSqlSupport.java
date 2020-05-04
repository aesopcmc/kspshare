package cn.kspshare.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspBbsParentChildDynamicSqlSupport {
    public static final KspBbsParentChild kspBbsParentChild = new KspBbsParentChild();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = kspBbsParentChild.oid;

    /**
     * 父评论ID
     * parent_context_id
     */
    public static final SqlColumn<Long> parentContextId = kspBbsParentChild.parentContextId;

    /**
     * 子评论ID
     * child_context_id
     */
    public static final SqlColumn<Long> childContextId = kspBbsParentChild.childContextId;

    public static final class KspBbsParentChild extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> parentContextId = column("parent_context_id", JDBCType.BIGINT);

        public final SqlColumn<Long> childContextId = column("child_context_id", JDBCType.BIGINT);

        public KspBbsParentChild() {
            super("ksp_bbs_parent_child");
        }
    }
}