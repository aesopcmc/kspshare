package cn.kspshare.mapper;

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
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expiry_date", property="expiryDate", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspVerificationToken> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(KspVerificationTokenDynamicSqlSupport.kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, KspVerificationTokenDynamicSqlSupport.kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .where(KspVerificationTokenDynamicSqlSupport.oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int insert(KspVerificationToken record) {
        return insert(SqlBuilder.insert(record)
                .into(KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .map(KspVerificationTokenDynamicSqlSupport.oid).toProperty("oid")
                .map(KspVerificationTokenDynamicSqlSupport.userId).toProperty("userId")
                .map(KspVerificationTokenDynamicSqlSupport.token).toProperty("token")
                .map(KspVerificationTokenDynamicSqlSupport.createTime).toProperty("createTime")
                .map(KspVerificationTokenDynamicSqlSupport.expiryDate).toProperty("expiryDate")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int insertSelective(KspVerificationToken record) {
        return insert(SqlBuilder.insert(record)
                .into(KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .map(KspVerificationTokenDynamicSqlSupport.oid).toPropertyWhenPresent("oid", record::getOid)
                .map(KspVerificationTokenDynamicSqlSupport.userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(KspVerificationTokenDynamicSqlSupport.token).toPropertyWhenPresent("token", record::getToken)
                .map(KspVerificationTokenDynamicSqlSupport.createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(KspVerificationTokenDynamicSqlSupport.expiryDate).toPropertyWhenPresent("expiryDate", record::getExpiryDate)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspVerificationToken>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, KspVerificationTokenDynamicSqlSupport.oid, KspVerificationTokenDynamicSqlSupport.userId, KspVerificationTokenDynamicSqlSupport.token, KspVerificationTokenDynamicSqlSupport.createTime, KspVerificationTokenDynamicSqlSupport.expiryDate)
                .from(KspVerificationTokenDynamicSqlSupport.kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspVerificationToken>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, KspVerificationTokenDynamicSqlSupport.oid, KspVerificationTokenDynamicSqlSupport.userId, KspVerificationTokenDynamicSqlSupport.token, KspVerificationTokenDynamicSqlSupport.createTime, KspVerificationTokenDynamicSqlSupport.expiryDate)
                .from(KspVerificationTokenDynamicSqlSupport.kspVerificationToken);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default KspVerificationToken selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, KspVerificationTokenDynamicSqlSupport.oid, KspVerificationTokenDynamicSqlSupport.userId, KspVerificationTokenDynamicSqlSupport.token, KspVerificationTokenDynamicSqlSupport.createTime, KspVerificationTokenDynamicSqlSupport.expiryDate)
                .from(KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .where(KspVerificationTokenDynamicSqlSupport.oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .set(KspVerificationTokenDynamicSqlSupport.oid).equalTo(record::getOid)
                .set(KspVerificationTokenDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(KspVerificationTokenDynamicSqlSupport.token).equalTo(record::getToken)
                .set(KspVerificationTokenDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(KspVerificationTokenDynamicSqlSupport.expiryDate).equalTo(record::getExpiryDate);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .set(KspVerificationTokenDynamicSqlSupport.oid).equalToWhenPresent(record::getOid)
                .set(KspVerificationTokenDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(KspVerificationTokenDynamicSqlSupport.token).equalToWhenPresent(record::getToken)
                .set(KspVerificationTokenDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(KspVerificationTokenDynamicSqlSupport.expiryDate).equalToWhenPresent(record::getExpiryDate);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int updateByPrimaryKey(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .set(KspVerificationTokenDynamicSqlSupport.userId).equalTo(record::getUserId)
                .set(KspVerificationTokenDynamicSqlSupport.token).equalTo(record::getToken)
                .set(KspVerificationTokenDynamicSqlSupport.createTime).equalTo(record::getCreateTime)
                .set(KspVerificationTokenDynamicSqlSupport.expiryDate).equalTo(record::getExpiryDate)
                .where(KspVerificationTokenDynamicSqlSupport.oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    default int updateByPrimaryKeySelective(KspVerificationToken record) {
        return UpdateDSL.updateWithMapper(this::update, KspVerificationTokenDynamicSqlSupport.kspVerificationToken)
                .set(KspVerificationTokenDynamicSqlSupport.userId).equalToWhenPresent(record::getUserId)
                .set(KspVerificationTokenDynamicSqlSupport.token).equalToWhenPresent(record::getToken)
                .set(KspVerificationTokenDynamicSqlSupport.createTime).equalToWhenPresent(record::getCreateTime)
                .set(KspVerificationTokenDynamicSqlSupport.expiryDate).equalToWhenPresent(record::getExpiryDate)
                .where(KspVerificationTokenDynamicSqlSupport.oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}