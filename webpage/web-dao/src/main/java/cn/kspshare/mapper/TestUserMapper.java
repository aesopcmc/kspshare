package cn.kspshare.mapper;

import static cn.kspshare.mapper.TestUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.TestUser;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface TestUserMapper {
    BasicColumn[] selectList = BasicColumn.columnList(tid, userName, age, gradeId);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TestUser> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TestUser> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TestUserResult")
    Optional<TestUser> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TestUserResult", value = {
        @Result(column="tid", property="tid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="grade_id", property="gradeId", jdbcType=JdbcType.BIGINT)
    })
    List<TestUser> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, testUser, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, testUser, completer);
    }

    default int deleteByPrimaryKey(Long tid_) {
        return delete(c -> 
            c.where(tid, isEqualTo(tid_))
        );
    }

    default int insert(TestUser record) {
        return MyBatis3Utils.insert(this::insert, record, testUser, c ->
            c.map(tid).toProperty("tid")
            .map(userName).toProperty("userName")
            .map(age).toProperty("age")
            .map(gradeId).toProperty("gradeId")
        );
    }

    default int insertMultiple(Collection<TestUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, testUser, c ->
            c.map(tid).toProperty("tid")
            .map(userName).toProperty("userName")
            .map(age).toProperty("age")
            .map(gradeId).toProperty("gradeId")
        );
    }

    default int insertSelective(TestUser record) {
        return MyBatis3Utils.insert(this::insert, record, testUser, c ->
            c.map(tid).toPropertyWhenPresent("tid", record::getTid)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(age).toPropertyWhenPresent("age", record::getAge)
            .map(gradeId).toPropertyWhenPresent("gradeId", record::getGradeId)
        );
    }

    default Optional<TestUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, testUser, completer);
    }

    default List<TestUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, testUser, completer);
    }

    default List<TestUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, testUser, completer);
    }

    default Optional<TestUser> selectByPrimaryKey(Long tid_) {
        return selectOne(c ->
            c.where(tid, isEqualTo(tid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, testUser, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TestUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tid).equalTo(record::getTid)
                .set(userName).equalTo(record::getUserName)
                .set(age).equalTo(record::getAge)
                .set(gradeId).equalTo(record::getGradeId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TestUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tid).equalToWhenPresent(record::getTid)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(age).equalToWhenPresent(record::getAge)
                .set(gradeId).equalToWhenPresent(record::getGradeId);
    }

    default int updateByPrimaryKey(TestUser record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(age).equalTo(record::getAge)
            .set(gradeId).equalTo(record::getGradeId)
            .where(tid, isEqualTo(record::getTid))
        );
    }

    default int updateByPrimaryKeySelective(TestUser record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(age).equalToWhenPresent(record::getAge)
            .set(gradeId).equalToWhenPresent(record::getGradeId)
            .where(tid, isEqualTo(record::getTid))
        );
    }
}