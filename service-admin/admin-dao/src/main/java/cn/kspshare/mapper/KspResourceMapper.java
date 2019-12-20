package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspResource;
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
public interface KspResourceMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    BasicColumn[] selectList = BasicColumn.columnList(oid, name, code, parentId, resourceType, url, icon, componeName, sort, createTime, createUser);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspResource> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspResource> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspResourceResult")
    Optional<KspResource> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspResourceResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.TINYINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="compone_name", property="componeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT)
    })
    List<KspResource> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int insert(KspResource record) {
        return MyBatis3Utils.insert(this::insert, record, kspResource, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(parentId).toProperty("parentId")
            .map(resourceType).toProperty("resourceType")
            .map(url).toProperty("url")
            .map(icon).toProperty("icon")
            .map(componeName).toProperty("componeName")
            .map(sort).toProperty("sort")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int insertMultiple(Collection<KspResource> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspResource, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(parentId).toProperty("parentId")
            .map(resourceType).toProperty("resourceType")
            .map(url).toProperty("url")
            .map(icon).toProperty("icon")
            .map(componeName).toProperty("componeName")
            .map(sort).toProperty("sort")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int insertSelective(KspResource record) {
        return MyBatis3Utils.insert(this::insert, record, kspResource, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(code).toPropertyWhenPresent("code", record::getCode)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(resourceType).toPropertyWhenPresent("resourceType", record::getResourceType)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(componeName).toPropertyWhenPresent("componeName", record::getComponeName)
            .map(sort).toPropertyWhenPresent("sort", record::getSort)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default Optional<KspResource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default List<KspResource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default List<KspResource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default Optional<KspResource> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspResource, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    static UpdateDSL<UpdateModel> updateAllColumns(KspResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(name).equalTo(record::getName)
                .set(code).equalTo(record::getCode)
                .set(parentId).equalTo(record::getParentId)
                .set(resourceType).equalTo(record::getResourceType)
                .set(url).equalTo(record::getUrl)
                .set(icon).equalTo(record::getIcon)
                .set(componeName).equalTo(record::getComponeName)
                .set(sort).equalTo(record::getSort)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspResource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(name).equalToWhenPresent(record::getName)
                .set(code).equalToWhenPresent(record::getCode)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(resourceType).equalToWhenPresent(record::getResourceType)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(componeName).equalToWhenPresent(record::getComponeName)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int updateByPrimaryKey(KspResource record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(code).equalTo(record::getCode)
            .set(parentId).equalTo(record::getParentId)
            .set(resourceType).equalTo(record::getResourceType)
            .set(url).equalTo(record::getUrl)
            .set(icon).equalTo(record::getIcon)
            .set(componeName).equalTo(record::getComponeName)
            .set(sort).equalTo(record::getSort)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int updateByPrimaryKeySelective(KspResource record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(code).equalToWhenPresent(record::getCode)
            .set(parentId).equalToWhenPresent(record::getParentId)
            .set(resourceType).equalToWhenPresent(record::getResourceType)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(componeName).equalToWhenPresent(record::getComponeName)
            .set(sort).equalToWhenPresent(record::getSort)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}