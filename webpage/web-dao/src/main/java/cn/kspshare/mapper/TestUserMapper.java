package cn.kspshare.mapper;

import static cn.kspshare.mapper.TestUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.TestUser;
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
public interface TestUserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TestUser> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TestUserResult")
    TestUser selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TestUserResult", value = {
        @Result(column="tid", property="tid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_id", property="gradeId", jdbcType=JdbcType.BIGINT)
    })
    List<TestUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(testUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, testUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default int deleteByPrimaryKey(Long tid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, testUser)
                .where(tid, isEqualTo(tid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default int insert(TestUser record) {
        return insert(SqlBuilder.insert(record)
                .into(testUser)
                .map(tid).toProperty("tid")
                .map(userName).toProperty("userName")
                .map(age).toProperty("age")
                .map(gradeId).toProperty("gradeId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default int insertSelective(TestUser record) {
        return insert(SqlBuilder.insert(record)
                .into(testUser)
                .map(tid).toPropertyWhenPresent("tid", record::getTid)
                .map(userName).toPropertyWhenPresent("userName", record::getUserName)
                .map(age).toPropertyWhenPresent("age", record::getAge)
                .map(gradeId).toPropertyWhenPresent("gradeId", record::getGradeId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TestUser>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, tid, userName, age, gradeId)
                .from(testUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TestUser>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, tid, userName, age, gradeId)
                .from(testUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default TestUser selectByPrimaryKey(Long tid_) {
        return SelectDSL.selectWithMapper(this::selectOne, tid, userName, age, gradeId)
                .from(testUser)
                .where(tid, isEqualTo(tid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(TestUser record) {
        return UpdateDSL.updateWithMapper(this::update, testUser)
                .set(tid).equalTo(record::getTid)
                .set(userName).equalTo(record::getUserName)
                .set(age).equalTo(record::getAge)
                .set(gradeId).equalTo(record::getGradeId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(TestUser record) {
        return UpdateDSL.updateWithMapper(this::update, testUser)
                .set(tid).equalToWhenPresent(record::getTid)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(age).equalToWhenPresent(record::getAge)
                .set(gradeId).equalToWhenPresent(record::getGradeId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default int updateByPrimaryKey(TestUser record) {
        return UpdateDSL.updateWithMapper(this::update, testUser)
                .set(userName).equalTo(record::getUserName)
                .set(age).equalTo(record::getAge)
                .set(gradeId).equalTo(record::getGradeId)
                .where(tid, isEqualTo(record::getTid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: test_user")
    default int updateByPrimaryKeySelective(TestUser record) {
        return UpdateDSL.updateWithMapper(this::update, testUser)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(age).equalToWhenPresent(record::getAge)
                .set(gradeId).equalToWhenPresent(record::getGradeId)
                .where(tid, isEqualTo(record::getTid))
                .build()
                .execute();
    }
}