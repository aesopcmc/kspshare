package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspAdminUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspAdminUser;
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
public interface KspAdminUserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspAdminUser> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspAdminUserResult")
    KspAdminUser selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspAdminUserResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspAdminUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspAdminUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspAdminUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspAdminUser)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int insert(KspAdminUser record) {
        return insert(SqlBuilder.insert(record)
                .into(kspAdminUser)
                .map(oid).toProperty("oid")
                .map(username).toProperty("username")
                .map(realname).toProperty("realname")
                .map(password).toProperty("password")
                .map(enabled).toProperty("enabled")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int insertSelective(KspAdminUser record) {
        return insert(SqlBuilder.insert(record)
                .into(kspAdminUser)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(username).toPropertyWhenPresent("username", record::getUsername)
                .map(realname).toPropertyWhenPresent("realname", record::getRealname)
                .map(password).toPropertyWhenPresent("password", record::getPassword)
                .map(enabled).toPropertyWhenPresent("enabled", record::getEnabled)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspAdminUser>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, username, realname, password, enabled, createTime)
                .from(kspAdminUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspAdminUser>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, username, realname, password, enabled, createTime)
                .from(kspAdminUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default KspAdminUser selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, username, realname, password, enabled, createTime)
                .from(kspAdminUser)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspAdminUser record) {
        return UpdateDSL.updateWithMapper(this::update, kspAdminUser)
                .set(oid).equalTo(record::getOid)
                .set(username).equalTo(record::getUsername)
                .set(realname).equalTo(record::getRealname)
                .set(password).equalTo(record::getPassword)
                .set(enabled).equalTo(record::getEnabled)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspAdminUser record) {
        return UpdateDSL.updateWithMapper(this::update, kspAdminUser)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(realname).equalToWhenPresent(record::getRealname)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(enabled).equalToWhenPresent(record::getEnabled)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int updateByPrimaryKey(KspAdminUser record) {
        return UpdateDSL.updateWithMapper(this::update, kspAdminUser)
                .set(username).equalTo(record::getUsername)
                .set(realname).equalTo(record::getRealname)
                .set(password).equalTo(record::getPassword)
                .set(enabled).equalTo(record::getEnabled)
                .set(createTime).equalTo(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int updateByPrimaryKeySelective(KspAdminUser record) {
        return UpdateDSL.updateWithMapper(this::update, kspAdminUser)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(realname).equalToWhenPresent(record::getRealname)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(enabled).equalToWhenPresent(record::getEnabled)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}