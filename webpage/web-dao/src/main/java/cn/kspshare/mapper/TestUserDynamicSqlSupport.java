package cn.kspshare.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TestUserDynamicSqlSupport {
    public static final TestUser testUser = new TestUser();

    /**
     * 主键
     * tid
     */
    public static final SqlColumn<Long> tid = testUser.tid;

    /**
     * 
     * user_name
     */
    public static final SqlColumn<String> userName = testUser.userName;

    /**
     * 
     * age
     */
    public static final SqlColumn<Integer> age = testUser.age;

    /**
     * 1
            2
            3
     * grade_id
     */
    public static final SqlColumn<Long> gradeId = testUser.gradeId;

    public static final class TestUser extends SqlTable {
        public final SqlColumn<Long> tid = column("tid", JDBCType.BIGINT);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

        public final SqlColumn<Long> gradeId = column("grade_id", JDBCType.BIGINT);

        public TestUser() {
            super("test_user");
        }
    }
}