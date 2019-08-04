package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspUserRoleReDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspUserRoleRe;
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
public interface KspUserRoleReMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspUserRoleRe> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspUserRoleReResult")
    KspUserRoleRe selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspUserRoleReResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspUserRoleRe> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspUserRoleRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspUserRoleRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspUserRoleRe)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default int insert(KspUserRoleRe record) {
        return insert(SqlBuilder.insert(record)
                .into(kspUserRoleRe)
                .map(oid).toProperty("oid")
                .map(userId).toProperty("userId")
                .map(roleId).toProperty("roleId")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default int insertSelective(KspUserRoleRe record) {
        return insert(SqlBuilder.insert(record)
                .into(kspUserRoleRe)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspUserRoleRe>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, userId, roleId, createTime)
                .from(kspUserRoleRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspUserRoleRe>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, userId, roleId, createTime)
                .from(kspUserRoleRe);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default KspUserRoleRe selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, userId, roleId, createTime)
                .from(kspUserRoleRe)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspUserRoleRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspUserRoleRe)
                .set(oid).equalTo(record::getOid)
                .set(userId).equalTo(record::getUserId)
                .set(roleId).equalTo(record::getRoleId)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspUserRoleRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspUserRoleRe)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default int updateByPrimaryKey(KspUserRoleRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspUserRoleRe)
                .set(userId).equalTo(record::getUserId)
                .set(roleId).equalTo(record::getRoleId)
                .set(createTime).equalTo(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_role_re")
    default int updateByPrimaryKeySelective(KspUserRoleRe record) {
        return UpdateDSL.updateWithMapper(this::update, kspUserRoleRe)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}