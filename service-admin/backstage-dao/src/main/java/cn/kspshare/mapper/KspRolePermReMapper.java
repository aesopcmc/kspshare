package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspRolePermReDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspRolePermRe;
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
public interface KspRolePermReMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspRolePermRe> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspRolePermReResult")
    KspRolePermRe selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspRolePermReResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspRolePermRe> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspRolePermRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspRolePermRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspRolePermRe)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int insert(KspRolePermRe record) {
        return insert(SqlBuilder.insert(record)
                .into(kspRolePermRe)
                .map(oid).toProperty("oid")
                .map(roleId).toProperty("roleId")
                .map(permId).toProperty("permId")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int insertSelective(KspRolePermRe record) {
        return insert(SqlBuilder.insert(record)
                .into(kspRolePermRe)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
                .map(permId).toPropertyWhenPresent("permId", record::getPermId)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspRolePermRe>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, roleId, permId, createTime)
                .from(kspRolePermRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspRolePermRe>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, roleId, permId, createTime)
                .from(kspRolePermRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default KspRolePermRe selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, roleId, permId, createTime)
                .from(kspRolePermRe)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspRolePermRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspRolePermRe)
                .set(oid).equalTo(record::getOid)
                .set(roleId).equalTo(record::getRoleId)
                .set(permId).equalTo(record::getPermId)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspRolePermRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspRolePermRe)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(permId).equalToWhenPresent(record::getPermId)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int updateByPrimaryKey(KspRolePermRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspRolePermRe)
                .set(roleId).equalTo(record::getRoleId)
                .set(permId).equalTo(record::getPermId)
                .set(createTime).equalTo(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int updateByPrimaryKeySelective(KspRolePermRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspRolePermRe)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(permId).equalToWhenPresent(record::getPermId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}