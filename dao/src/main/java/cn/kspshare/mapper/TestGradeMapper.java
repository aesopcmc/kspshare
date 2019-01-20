package cn.kspshare.mapper;

import static cn.kspshare.mapper.TestGradeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.TestGrade;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface TestGradeMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TestGrade> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TestGradeResult")
    TestGrade selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TestGradeResult", value = {
        @Result(column="tid", property="tid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="grade_name", property="gradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade_code", property="gradeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER)
    })
    List<TestGrade> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(testGrade);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, testGrade);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default int deleteByPrimaryKey(Long tid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, testGrade)
                .where(tid, isEqualTo(tid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default int insert(TestGrade record) {
        return insert(SqlBuilder.insert(record)
                .into(testGrade)
                .map(tid).toProperty("tid")
                .map(gradeName).toProperty("gradeName")
                .map(gradeCode).toProperty("gradeCode")
                .map(level).toProperty("level")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default int insertSelective(TestGrade record) {
        return insert(SqlBuilder.insert(record)
                .into(testGrade)
                .map(tid).toPropertyWhenPresent("tid", record::getTid)
                .map(gradeName).toPropertyWhenPresent("gradeName", record::getGradeName)
                .map(gradeCode).toPropertyWhenPresent("gradeCode", record::getGradeCode)
                .map(level).toPropertyWhenPresent("level", record::getLevel)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TestGrade>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, tid, gradeName, gradeCode, level)
                .from(testGrade);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TestGrade>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, tid, gradeName, gradeCode, level)
                .from(testGrade);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default TestGrade selectByPrimaryKey(Long tid_) {
        return SelectDSL.selectWithMapper(this::selectOne, tid, gradeName, gradeCode, level)
                .from(testGrade)
                .where(tid, isEqualTo(tid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(TestGrade record) {
        return UpdateDSL.updateWithMapper(this::update, testGrade)
                .set(tid).equalTo(record::getTid)
                .set(gradeName).equalTo(record::getGradeName)
                .set(gradeCode).equalTo(record::getGradeCode)
                .set(level).equalTo(record::getLevel);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(TestGrade record) {
        return UpdateDSL.updateWithMapper(this::update, testGrade)
                .set(tid).equalToWhenPresent(record::getTid)
                .set(gradeName).equalToWhenPresent(record::getGradeName)
                .set(gradeCode).equalToWhenPresent(record::getGradeCode)
                .set(level).equalToWhenPresent(record::getLevel);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default int updateByPrimaryKey(TestGrade record) {
        return UpdateDSL.updateWithMapper(this::update, testGrade)
                .set(gradeName).equalTo(record::getGradeName)
                .set(gradeCode).equalTo(record::getGradeCode)
                .set(level).equalTo(record::getLevel)
                .where(tid, isEqualTo(record::getTid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_grade")
    default int updateByPrimaryKeySelective(TestGrade record) {
        return UpdateDSL.updateWithMapper(this::update, testGrade)
                .set(gradeName).equalToWhenPresent(record::getGradeName)
                .set(gradeCode).equalToWhenPresent(record::getGradeCode)
                .set(level).equalToWhenPresent(record::getLevel)
                .where(tid, isEqualTo(record::getTid))
                .build()
                .execute();
    }
}