package cn.kspshare.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TestGradeDynamicSqlSupport {
    public static final TestGrade testGrade = new TestGrade();

    /**
     * 
     * tid
     */
    public static final SqlColumn<Long> tid = testGrade.tid;

    /**
     * 
     * grade_name
     */
    public static final SqlColumn<String> gradeName = testGrade.gradeName;

    /**
     * 
     * grade_code
     */
    public static final SqlColumn<String> gradeCode = testGrade.gradeCode;

    /**
     * 
     * level
     */
    public static final SqlColumn<Integer> level = testGrade.level;

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