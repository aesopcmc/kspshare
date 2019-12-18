package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspResourceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspResource;
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
public interface KspResourceMapper {
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
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspResourceResult")
    KspResource selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspResourceResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="resource_type", property="resourceType", jdbcType=JdbcType.BIT),
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
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspResource);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspResource);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspResource)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int insert(KspResource record) {
        return insert(SqlBuilder.insert(record)
                .into(kspResource)
                .map(oid).toProperty("oid")
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
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int insertSelective(KspResource record) {
        return insert(SqlBuilder.insert(record)
                .into(kspResource)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
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
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspResource>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, name, code, parentId, resourceType, url, icon, componeName, sort, createTime, createUser)
                .from(kspResource);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspResource>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, name, code, parentId, resourceType, url, icon, componeName, sort, createTime, createUser)
                .from(kspResource);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default KspResource selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, name, code, parentId, resourceType, url, icon, componeName, sort, createTime, createUser)
                .from(kspResource)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspResource record) {
        return UpdateDSL.updateWithMapper(this::update, kspResource)
                .set(oid).equalTo(record::getOid)
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
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspResource record) {
        return UpdateDSL.updateWithMapper(this::update, kspResource)
                .set(oid).equalToWhenPresent(record::getOid)
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
        return UpdateDSL.updateWithMapper(this::update, kspResource)
                .set(name).equalTo(record::getName)
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
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_resource")
    default int updateByPrimaryKeySelective(KspResource record) {
        return UpdateDSL.updateWithMapper(this::update, kspResource)
                .set(name).equalToWhenPresent(record::getName)
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
                .build()
                .execute();
    }
}