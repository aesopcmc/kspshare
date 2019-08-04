package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspRole;
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
public interface KspRoleMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspRole> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspRoleResult")
    KspRole selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspRoleResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="banned", property="banned", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspRole> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspRole)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default int insert(KspRole record) {
        return insert(SqlBuilder.insert(record)
                .into(kspRole)
                .map(oid).toProperty("oid")
                .map(name).toProperty("name")
                .map(nickname).toProperty("nickname")
                .map(description).toProperty("description")
                .map(banned).toProperty("banned")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default int insertSelective(KspRole record) {
        return insert(SqlBuilder.insert(record)
                .into(kspRole)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
                .map(description).toPropertyWhenPresent("description", record::getDescription)
                .map(banned).toPropertyWhenPresent("banned", record::getBanned)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspRole>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, name, nickname, description, banned, createTime)
                .from(kspRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspRole>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, name, nickname, description, banned, createTime)
                .from(kspRole);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default KspRole selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, name, nickname, description, banned, createTime)
                .from(kspRole)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspRole record) {
        return UpdateDSL.updateWithMapper(this::update, kspRole)
                .set(oid).equalTo(record::getOid)
                .set(name).equalTo(record::getName)
                .set(nickname).equalTo(record::getNickname)
                .set(description).equalTo(record::getDescription)
                .set(banned).equalTo(record::getBanned)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspRole record) {
        return UpdateDSL.updateWithMapper(this::update, kspRole)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(name).equalToWhenPresent(record::getName)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(banned).equalToWhenPresent(record::getBanned)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default int updateByPrimaryKey(KspRole record) {
        return UpdateDSL.updateWithMapper(this::update, kspRole)
                .set(name).equalTo(record::getName)
                .set(nickname).equalTo(record::getNickname)
                .set(description).equalTo(record::getDescription)
                .set(banned).equalTo(record::getBanned)
                .set(createTime).equalTo(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role")
    default int updateByPrimaryKeySelective(KspRole record) {
        return UpdateDSL.updateWithMapper(this::update, kspRole)
                .set(name).equalToWhenPresent(record::getName)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(banned).equalToWhenPresent(record::getBanned)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}