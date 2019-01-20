package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspVerificationTokenDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspVerificationToken;
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
public interface KspVerificationTokenMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspVerificationToken> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspVerificationTokenResult")
    KspVerificationToken selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspVerificationTokenResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspVerificationToken> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspVerificationToken)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int insert(KspVerificationToken record) {
        return insert(SqlBuilder.insert(record)
                .into(kspVerificationToken)
                .map(oid).toProperty("oid")
                .map(userId).toProperty("userId")
                .map(token).toProperty("token")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int insertSelective(KspVerificationToken record) {
        return insert(SqlBuilder.insert(record)
                .into(kspVerificationToken)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(token).toPropertyWhenPresent("token", record::getToken)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspVerificationToken>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, userId, token, createTime)
                .from(kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspVerificationToken>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, userId, token, createTime)
                .from(kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default KspVerificationToken selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, userId, token, createTime)
                .from(kspVerificationToken)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, kspVerificationToken)
                .set(oid).equalTo(record::getOid)
                .set(userId).equalTo(record::getUserId)
                .set(token).equalTo(record::getToken)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, kspVerificationToken)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(token).equalToWhenPresent(record::getToken)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int updateByPrimaryKey(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, kspVerificationToken)
                .set(userId).equalTo(record::getUserId)
                .set(token).equalTo(record::getToken)
                .set(createTime).equalTo(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int updateByPrimaryKeySelective(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, kspVerificationToken)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(token).equalToWhenPresent(record::getToken)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}