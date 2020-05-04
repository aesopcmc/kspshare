package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspBbsParentChildDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspBbsParentChild;
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
public interface KspBbsParentChildMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, parentContextId, childContextId);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspBbsParentChild> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspBbsParentChild> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspBbsParentChildResult")
    Optional<KspBbsParentChild> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspBbsParentChildResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="parent_context_id", property="parentContextId", jdbcType=JdbcType.BIGINT),
        @Result(column="child_context_id", property="childContextId", jdbcType=JdbcType.BIGINT)
    })
    List<KspBbsParentChild> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspBbsParentChild, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspBbsParentChild, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(KspBbsParentChild record) {
        return MyBatis3Utils.insert(this::insert, record, kspBbsParentChild, c ->
            c.map(oid).toProperty("oid")
            .map(parentContextId).toProperty("parentContextId")
            .map(childContextId).toProperty("childContextId")
        );
    }

    default int insertMultiple(Collection<KspBbsParentChild> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspBbsParentChild, c ->
            c.map(oid).toProperty("oid")
            .map(parentContextId).toProperty("parentContextId")
            .map(childContextId).toProperty("childContextId")
        );
    }

    default int insertSelective(KspBbsParentChild record) {
        return MyBatis3Utils.insert(this::insert, record, kspBbsParentChild, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(parentContextId).toPropertyWhenPresent("parentContextId", record::getParentContextId)
            .map(childContextId).toPropertyWhenPresent("childContextId", record::getChildContextId)
        );
    }

    default Optional<KspBbsParentChild> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspBbsParentChild, completer);
    }

    default List<KspBbsParentChild> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspBbsParentChild, completer);
    }

    default List<KspBbsParentChild> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspBbsParentChild, completer);
    }

    default Optional<KspBbsParentChild> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspBbsParentChild, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(KspBbsParentChild record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(parentContextId).equalTo(record::getParentContextId)
                .set(childContextId).equalTo(record::getChildContextId);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspBbsParentChild record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(parentContextId).equalToWhenPresent(record::getParentContextId)
                .set(childContextId).equalToWhenPresent(record::getChildContextId);
    }

    default int updateByPrimaryKey(KspBbsParentChild record) {
        return update(c ->
            c.set(parentContextId).equalTo(record::getParentContextId)
            .set(childContextId).equalTo(record::getChildContextId)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(KspBbsParentChild record) {
        return update(c ->
            c.set(parentContextId).equalToWhenPresent(record::getParentContextId)
            .set(childContextId).equalToWhenPresent(record::getChildContextId)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}