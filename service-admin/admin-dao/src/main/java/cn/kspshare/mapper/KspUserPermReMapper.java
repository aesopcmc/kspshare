package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspUserPermReDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspUserPermRe;
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
public interface KspUserPermReMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    BasicColumn[] selectList = BasicColumn.columnList(oid, userId, permId, permType, createTime, createUser, updateTime);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspUserPermRe> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspUserPermRe> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspUserPermReResult")
    Optional<KspUserPermRe> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspUserPermReResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.BIGINT),
        @Result(column="perm_type", property="permType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<KspUserPermRe> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspUserPermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspUserPermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int insert(KspUserPermRe record) {
        return MyBatis3Utils.insert(this::insert, record, kspUserPermRe, c ->
            c.map(oid).toProperty("oid")
            .map(userId).toProperty("userId")
            .map(permId).toProperty("permId")
            .map(permType).toProperty("permType")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int insertMultiple(Collection<KspUserPermRe> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspUserPermRe, c ->
            c.map(oid).toProperty("oid")
            .map(userId).toProperty("userId")
            .map(permId).toProperty("permId")
            .map(permType).toProperty("permType")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int insertSelective(KspUserPermRe record) {
        return MyBatis3Utils.insert(this::insert, record, kspUserPermRe, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(permId).toPropertyWhenPresent("permId", record::getPermId)
            .map(permType).toPropertyWhenPresent("permType", record::getPermType)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default Optional<KspUserPermRe> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspUserPermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default List<KspUserPermRe> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspUserPermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default List<KspUserPermRe> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspUserPermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default Optional<KspUserPermRe> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspUserPermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    static UpdateDSL<UpdateModel> updateAllColumns(KspUserPermRe record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(userId).equalTo(record::getUserId)
                .set(permId).equalTo(record::getPermId)
                .set(permType).equalTo(record::getPermType)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspUserPermRe record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(permId).equalToWhenPresent(record::getPermId)
                .set(permType).equalToWhenPresent(record::getPermType)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int updateByPrimaryKey(KspUserPermRe record) {
        return update(c ->
            c.set(userId).equalTo(record::getUserId)
            .set(permId).equalTo(record::getPermId)
            .set(permType).equalTo(record::getPermType)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    default int updateByPrimaryKeySelective(KspUserPermRe record) {
        return update(c ->
            c.set(userId).equalToWhenPresent(record::getUserId)
            .set(permId).equalToWhenPresent(record::getPermId)
            .set(permType).equalToWhenPresent(record::getPermType)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}