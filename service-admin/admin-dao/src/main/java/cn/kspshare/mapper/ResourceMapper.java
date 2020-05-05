package cn.kspshare.mapper;

import static cn.kspshare.mapper.ResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.Resource;
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
public interface ResourceMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, name, code, codeLink, parentId, resourceType, url, icon, componentName, sort, createTime, createUser, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Resource> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Resource> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ResourceResult")
    Optional<Resource> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ResourceResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="code_link", property="codeLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.TINYINT),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="component_name", property="componentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Resource> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, resource, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, resource, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(codeLink).toProperty("codeLink")
            .map(parentId).toProperty("parentId")
            .map(resourceType).toProperty("resourceType")
            .map(url).toProperty("url")
            .map(icon).toProperty("icon")
            .map(componentName).toProperty("componentName")
            .map(sort).toProperty("sort")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<Resource> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, resource, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(code).toProperty("code")
            .map(codeLink).toProperty("codeLink")
            .map(parentId).toProperty("parentId")
            .map(resourceType).toProperty("resourceType")
            .map(url).toProperty("url")
            .map(icon).toProperty("icon")
            .map(componentName).toProperty("componentName")
            .map(sort).toProperty("sort")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(Resource record) {
        return MyBatis3Utils.insert(this::insert, record, resource, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(code).toPropertyWhenPresent("code", record::getCode)
            .map(codeLink).toPropertyWhenPresent("codeLink", record::getCodeLink)
            .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
            .map(resourceType).toPropertyWhenPresent("resourceType", record::getResourceType)
            .map(url).toPropertyWhenPresent("url", record::getUrl)
            .map(icon).toPropertyWhenPresent("icon", record::getIcon)
            .map(componentName).toPropertyWhenPresent("componentName", record::getComponentName)
            .map(sort).toPropertyWhenPresent("sort", record::getSort)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<Resource> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, resource, completer);
    }

    default List<Resource> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, resource, completer);
    }

    default List<Resource> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, resource, completer);
    }

    default Optional<Resource> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, resource, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(name).equalTo(record::getName)
                .set(code).equalTo(record::getCode)
                .set(codeLink).equalTo(record::getCodeLink)
                .set(parentId).equalTo(record::getParentId)
                .set(resourceType).equalTo(record::getResourceType)
                .set(url).equalTo(record::getUrl)
                .set(icon).equalTo(record::getIcon)
                .set(componentName).equalTo(record::getComponentName)
                .set(sort).equalTo(record::getSort)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Resource record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(name).equalToWhenPresent(record::getName)
                .set(code).equalToWhenPresent(record::getCode)
                .set(codeLink).equalToWhenPresent(record::getCodeLink)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(resourceType).equalToWhenPresent(record::getResourceType)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(icon).equalToWhenPresent(record::getIcon)
                .set(componentName).equalToWhenPresent(record::getComponentName)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(Resource record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(code).equalTo(record::getCode)
            .set(codeLink).equalTo(record::getCodeLink)
            .set(parentId).equalTo(record::getParentId)
            .set(resourceType).equalTo(record::getResourceType)
            .set(url).equalTo(record::getUrl)
            .set(icon).equalTo(record::getIcon)
            .set(componentName).equalTo(record::getComponentName)
            .set(sort).equalTo(record::getSort)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(Resource record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(code).equalToWhenPresent(record::getCode)
            .set(codeLink).equalToWhenPresent(record::getCodeLink)
            .set(parentId).equalToWhenPresent(record::getParentId)
            .set(resourceType).equalToWhenPresent(record::getResourceType)
            .set(url).equalToWhenPresent(record::getUrl)
            .set(icon).equalToWhenPresent(record::getIcon)
            .set(componentName).equalToWhenPresent(record::getComponentName)
            .set(sort).equalToWhenPresent(record::getSort)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}