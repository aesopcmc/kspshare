package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspRolePermReDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspRolePermRe;
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
public interface KspRolePermReMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    BasicColumn[] selectList = BasicColumn.columnList(oid, roleId, permId, permType, createTime, createUser);

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
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspRolePermRe> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspRolePermReResult")
    Optional<KspRolePermRe> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspRolePermReResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.BIGINT),
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.BIGINT),
        @Result(column="perm_type", property="permType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT)
    })
    List<KspRolePermRe> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspRolePermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspRolePermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int insert(KspRolePermRe record) {
        return MyBatis3Utils.insert(this::insert, record, kspRolePermRe, c ->
            c.map(oid).toProperty("oid")
            .map(roleId).toProperty("roleId")
            .map(permId).toProperty("permId")
            .map(permType).toProperty("permType")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int insertMultiple(Collection<KspRolePermRe> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspRolePermRe, c ->
            c.map(oid).toProperty("oid")
            .map(roleId).toProperty("roleId")
            .map(permId).toProperty("permId")
            .map(permType).toProperty("permType")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int insertSelective(KspRolePermRe record) {
        return MyBatis3Utils.insert(this::insert, record, kspRolePermRe, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(roleId).toPropertyWhenPresent("roleId", record::getRoleId)
            .map(permId).toPropertyWhenPresent("permId", record::getPermId)
            .map(permType).toPropertyWhenPresent("permType", record::getPermType)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default Optional<KspRolePermRe> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspRolePermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default List<KspRolePermRe> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspRolePermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default List<KspRolePermRe> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspRolePermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default Optional<KspRolePermRe> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspRolePermRe, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    static UpdateDSL<UpdateModel> updateAllColumns(KspRolePermRe record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(roleId).equalTo(record::getRoleId)
                .set(permId).equalTo(record::getPermId)
                .set(permType).equalTo(record::getPermType)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspRolePermRe record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(roleId).equalToWhenPresent(record::getRoleId)
                .set(permId).equalToWhenPresent(record::getPermId)
                .set(permType).equalToWhenPresent(record::getPermType)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int updateByPrimaryKey(KspRolePermRe record) {
        return update(c ->
            c.set(roleId).equalTo(record::getRoleId)
            .set(permId).equalTo(record::getPermId)
            .set(permType).equalTo(record::getPermType)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_role_perm_re")
    default int updateByPrimaryKeySelective(KspRolePermRe record) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(record::getRoleId)
            .set(permId).equalToWhenPresent(record::getPermId)
            .set(permType).equalToWhenPresent(record::getPermType)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}