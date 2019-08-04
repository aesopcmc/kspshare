package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspPermDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspPerm;
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
public interface KspPermMapper {
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
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspPermResult")
    KspPerm selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspPermResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="resourceId", property="resourceid", jdbcType=JdbcType.VARCHAR),
        @Result(column="resourceName", property="resourcename", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspPerm> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspPerm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspPerm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspPerm)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int insert(KspPerm record) {
        return insert(SqlBuilder.insert(record)
                .into(kspPerm)
                .map(oid).toProperty("oid")
                .map(resourceid).toProperty("resourceid")
                .map(resourcename).toProperty("resourcename")
                .map(parentId).toProperty("parentId")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int insertSelective(KspPerm record) {
        return insert(SqlBuilder.insert(record)
                .into(kspPerm)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(resourceid).toPropertyWhenPresent("resourceid", record::getResourceid)
                .map(resourcename).toPropertyWhenPresent("resourcename", record::getResourcename)
                .map(parentId).toPropertyWhenPresent("parentId", record::getParentId)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspPerm>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, resourceid, resourcename, parentId, createTime)
                .from(kspPerm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspPerm>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, resourceid, resourcename, parentId, createTime)
                .from(kspPerm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default KspPerm selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, resourceid, resourcename, parentId, createTime)
                .from(kspPerm)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspPerm record) {
        return UpdateDSL.updateWithMapper(this::update, kspPerm)
                .set(oid).equalTo(record::getOid)
                .set(resourceid).equalTo(record::getResourceid)
                .set(resourcename).equalTo(record::getResourcename)
                .set(parentId).equalTo(record::getParentId)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspPerm record) {
        return UpdateDSL.updateWithMapper(this::update, kspPerm)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(resourceid).equalToWhenPresent(record::getResourceid)
                .set(resourcename).equalToWhenPresent(record::getResourcename)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int updateByPrimaryKey(KspPerm record) {
        return UpdateDSL.updateWithMapper(this::update, kspPerm)
                .set(resourceid).equalTo(record::getResourceid)
                .set(resourcename).equalTo(record::getResourcename)
                .set(parentId).equalTo(record::getParentId)
                .set(createTime).equalTo(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_perm")
    default int updateByPrimaryKeySelective(KspPerm record) {
        return UpdateDSL.updateWithMapper(this::update, kspPerm)
                .set(resourceid).equalToWhenPresent(record::getResourceid)
                .set(resourcename).equalToWhenPresent(record::getResourcename)
                .set(parentId).equalToWhenPresent(record::getParentId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}