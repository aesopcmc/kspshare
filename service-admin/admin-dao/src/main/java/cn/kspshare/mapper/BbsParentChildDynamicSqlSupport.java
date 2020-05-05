package cn.kspshare.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BbsParentChildDynamicSqlSupport {
    public static final BbsParentChild bbsParentChild = new BbsParentChild();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = bbsParentChild.oid;

    /**
     * 父评论ID
     * parent_context_id
     */
    public static final SqlColumn<Long> parentContextId = bbsParentChild.parentContextId;

    /**
     * 子评论ID
     * child_context_id
     */
    public static final SqlColumn<Long> childContextId = bbsParentChild.childContextId;

    public static final class BbsParentChild extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> parentContextId = column("parent_context_id", JDBCType.BIGINT);

        public final SqlColumn<Long> childContextId = column("child_context_id", JDBCType.BIGINT);

        public BbsParentChild() {
            super("bbs_parent_child");
        }
    }
}