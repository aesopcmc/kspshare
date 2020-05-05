package cn.kspshare.mapper;

import static cn.kspshare.mapper.TestGradeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.TestGrade;
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
public interface TestGradeMapper {
    BasicColumn[] selectList = BasicColumn.columnList(tid, gradeName, gradeCode, level);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TestGrade> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TestGrade> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TestGradeResult")
    Optional<TestGrade> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TestGradeResult", value = {
        @Result(column="tid", property="tid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="grade_name", property="gradeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="grade_code", property="gradeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER)
    })
    List<TestGrade> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, testGrade, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, testGrade, completer);
    }

    default int deleteByPrimaryKey(Long tid_) {
        return delete(c -> 
            c.where(tid, isEqualTo(tid_))
        );
    }

    default int insert(TestGrade record) {
        return MyBatis3Utils.insert(this::insert, record, testGrade, c ->
            c.map(tid).toProperty("tid")
            .map(gradeName).toProperty("gradeName")
            .map(gradeCode).toProperty("gradeCode")
            .map(level).toProperty("level")
        );
    }

    default int insertMultiple(Collection<TestGrade> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, testGrade, c ->
            c.map(tid).toProperty("tid")
            .map(gradeName).toProperty("gradeName")
            .map(gradeCode).toProperty("gradeCode")
            .map(level).toProperty("level")
        );
    }

    default int insertSelective(TestGrade record) {
        return MyBatis3Utils.insert(this::insert, record, testGrade, c ->
            c.map(tid).toPropertyWhenPresent("tid", record::getTid)
            .map(gradeName).toPropertyWhenPresent("gradeName", record::getGradeName)
            .map(gradeCode).toPropertyWhenPresent("gradeCode", record::getGradeCode)
            .map(level).toPropertyWhenPresent("level", record::getLevel)
        );
    }

    default Optional<TestGrade> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, testGrade, completer);
    }

    default List<TestGrade> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, testGrade, completer);
    }

    default List<TestGrade> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, testGrade, completer);
    }

    default Optional<TestGrade> selectByPrimaryKey(Long tid_) {
        return selectOne(c ->
            c.where(tid, isEqualTo(tid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, testGrade, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(TestGrade record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tid).equalTo(record::getTid)
                .set(gradeName).equalTo(record::getGradeName)
                .set(gradeCode).equalTo(record::getGradeCode)
                .set(level).equalTo(record::getLevel);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(TestGrade record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(tid).equalToWhenPresent(record::getTid)
                .set(gradeName).equalToWhenPresent(record::getGradeName)
                .set(gradeCode).equalToWhenPresent(record::getGradeCode)
                .set(level).equalToWhenPresent(record::getLevel);
    }

    default int updateByPrimaryKey(TestGrade record) {
        return update(c ->
            c.set(gradeName).equalTo(record::getGradeName)
            .set(gradeCode).equalTo(record::getGradeCode)
            .set(level).equalTo(record::getLevel)
            .where(tid, isEqualTo(record::getTid))
        );
    }

    default int updateByPrimaryKeySelective(TestGrade record) {
        return update(c ->
            c.set(gradeName).equalToWhenPresent(record::getGradeName)
            .set(gradeCode).equalToWhenPresent(record::getGradeCode)
            .set(level).equalToWhenPresent(record::getLevel)
            .where(tid, isEqualTo(record::getTid))
        );
    }
}