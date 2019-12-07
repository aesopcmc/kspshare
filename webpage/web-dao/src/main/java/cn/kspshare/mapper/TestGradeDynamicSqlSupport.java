package cn.kspshare.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TestGradeDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    public static final TestGrade testGrade = new TestGrade();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_grade.tid")
    public static final SqlColumn<Long> tid = testGrade.tid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_grade.grade_name")
    public static final SqlColumn<String> gradeName = testGrade.gradeName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_grade.grade_code")
    public static final SqlColumn<String> gradeCode = testGrade.gradeCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: test_grade.level")
    public static final SqlColumn<Integer> level = testGrade.level;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    public static final class TestGrade extends SqlTable {
        public final SqlColumn<Long> tid = column("tid", JDBCType.BIGINT);

        public final SqlColumn<String> gradeName = column("grade_name", JDBCType.VARCHAR);

        public final SqlColumn<String> gradeCode = column("grade_code", JDBCType.VARCHAR);

        public final SqlColumn<Integer> level = column("level", JDBCType.INTEGER);

        public TestGrade() {
            super("test_grade");
        }
    }
}