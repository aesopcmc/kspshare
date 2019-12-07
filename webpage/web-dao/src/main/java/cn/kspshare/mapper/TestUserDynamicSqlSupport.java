package cn.kspshare.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TestUserDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    public static final TestUser testUser = new TestUser();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_user.tid")
    public static final SqlColumn<Long> tid = testUser.tid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_user.user_name")
    public static final SqlColumn<String> userName = testUser.userName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_user.age")
    public static final SqlColumn<Integer> age = testUser.age;

    /**
     * Database Column Remarks:
     *   1
     *               2
     *               3
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_user.grade_id")
    public static final SqlColumn<Long> gradeId = testUser.gradeId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
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