package cn.kspshare.mapper;

import static cn.kspshare.mapper.BbsParentChildDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.BbsParentChild;
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
public interface BbsParentChildMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, parentContextId, childContextId);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BbsParentChild> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BbsParentChild> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BbsParentChildResult")
    Optional<BbsParentChild> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BbsParentChildResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_context_id", property="parentContextId", jdbcType=JdbcType.BIGINT),
        @Result(column="child_context_id", property="childContextId", jdbcType=JdbcType.BIGINT)
    })
    List<BbsParentChild> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, bbsParentChild, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, bbsParentChild, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(BbsParentChild record) {
        return MyBatis3Utils.insert(this::insert, record, bbsParentChild, c ->
            c.map(oid).toProperty("oid")
            .map(parentContextId).toProperty("parentContextId")
            .map(childContextId).toProperty("childContextId")
        );
    }

    default int insertMultiple(Collection<BbsParentChild> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, bbsParentChild, c ->
            c.map(oid).toProperty("oid")
            .map(parentContextId).toProperty("parentContextId")
            .map(childContextId).toProperty("childContextId")
        );
    }

    default int insertSelective(BbsParentChild record) {
        return MyBatis3Utils.insert(this::insert, record, bbsParentChild, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(parentContextId).toPropertyWhenPresent("parentContextId", record::getParentContextId)
            .map(childContextId).toPropertyWhenPresent("childContextId", record::getChildContextId)
        );
    }

    default Optional<BbsParentChild> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, bbsParentChild, completer);
    }

    default List<BbsParentChild> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, bbsParentChild, completer);
    }

    default List<BbsParentChild> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, bbsParentChild, completer);
    }

    default Optional<BbsParentChild> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, bbsParentChild, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(BbsParentChild record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(parentContextId).equalTo(record::getParentContextId)
                .set(childContextId).equalTo(record::getChildContextId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(BbsParentChild record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(parentContextId).equalToWhenPresent(record::getParentContextId)
                .set(childContextId).equalToWhenPresent(record::getChildContextId);
    }

    default int updateByPrimaryKey(BbsParentChild record) {
        return update(c ->
            c.set(parentContextId).equalTo(record::getParentContextId)
            .set(childContextId).equalTo(record::getChildContextId)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(BbsParentChild record) {
        return update(c ->
            c.set(parentContextId).equalToWhenPresent(record::getParentContextId)
            .set(childContextId).equalToWhenPresent(record::getChildContextId)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}