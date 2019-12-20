package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspPermDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspPerm;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
public interface KspPermMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    BasicColumn[] selectList = BasicColumn.columnList(oid, name, code, resourceId, createTime, createUser);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspPerm> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspPerm> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspPermResult")
    Optional<KspPerm> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspPermResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT)
    })
    List<KspPerm> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspPerm, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspPerm, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int insert(KspPerm record) {
        return MyBatis3Utils.insert(this::insert, record, kspPerm, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(resourceId).toProperty("resourceId")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int insertMultiple(Collection<KspPerm> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspPerm, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(resourceId).toProperty("resourceId")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int insertSelective(KspPerm record) {
        return MyBatis3Utils.insert(this::insert, record, kspPerm, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(code).toPropertyWhenPresent("code", record::getCode)
            .map(resourceId).toPropertyWhenPresent("resourceId", record::getResourceId)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default Optional<KspPerm> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspPerm, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default List<KspPerm> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspPerm, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default List<KspPerm> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspPerm, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default Optional<KspPerm> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspPerm, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    static UpdateDSL<UpdateModel> updateAllColumns(KspPerm record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(name).equalTo(record::getName)
                .set(code).equalTo(record::getCode)
                .set(resourceId).equalTo(record::getResourceId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspPerm record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(name).equalToWhenPresent(record::getName)
                .set(code).equalToWhenPresent(record::getCode)
                .set(resourceId).equalToWhenPresent(record::getResourceId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int updateByPrimaryKey(KspPerm record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(code).equalTo(record::getCode)
            .set(resourceId).equalTo(record::getResourceId)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int updateByPrimaryKeySelective(KspPerm record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(code).equalToWhenPresent(record::getCode)
            .set(resourceId).equalToWhenPresent(record::getResourceId)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}