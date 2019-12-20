package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspAdminUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspAdminUser;
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
public interface KspAdminUserMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    BasicColumn[] selectList = BasicColumn.columnList(oid, username, realname, password, gender, email, enabled, createTime, createUser);

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
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspAdminUser> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspAdminUserResult")
    Optional<KspAdminUser> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspAdminUserResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT)
    })
    List<KspAdminUser> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspAdminUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspAdminUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int insert(KspAdminUser record) {
        return MyBatis3Utils.insert(this::insert, record, kspAdminUser, c ->
            c.map(oid).toProperty("oid")
            .map(username).toProperty("username")
            .map(realname).toProperty("realname")
            .map(password).toProperty("password")
            .map(gender).toProperty("gender")
            .map(email).toProperty("email")
            .map(enabled).toProperty("enabled")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int insertMultiple(Collection<KspAdminUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspAdminUser, c ->
            c.map(oid).toProperty("oid")
            .map(username).toProperty("username")
            .map(realname).toProperty("realname")
            .map(password).toProperty("password")
            .map(gender).toProperty("gender")
            .map(email).toProperty("email")
            .map(enabled).toProperty("enabled")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int insertSelective(KspAdminUser record) {
        return MyBatis3Utils.insert(this::insert, record, kspAdminUser, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(realname).toPropertyWhenPresent("realname", record::getRealname)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(gender).toPropertyWhenPresent("gender", record::getGender)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(enabled).toPropertyWhenPresent("enabled", record::getEnabled)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default Optional<KspAdminUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspAdminUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default List<KspAdminUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspAdminUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default List<KspAdminUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspAdminUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default Optional<KspAdminUser> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspAdminUser, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    static UpdateDSL<UpdateModel> updateAllColumns(KspAdminUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(username).equalTo(record::getUsername)
                .set(realname).equalTo(record::getRealname)
                .set(password).equalTo(record::getPassword)
                .set(gender).equalTo(record::getGender)
                .set(email).equalTo(record::getEmail)
                .set(enabled).equalTo(record::getEnabled)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspAdminUser record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(realname).equalToWhenPresent(record::getRealname)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(enabled).equalToWhenPresent(record::getEnabled)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int updateByPrimaryKey(KspAdminUser record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
            .set(realname).equalTo(record::getRealname)
            .set(password).equalTo(record::getPassword)
            .set(gender).equalTo(record::getGender)
            .set(email).equalTo(record::getEmail)
            .set(enabled).equalTo(record::getEnabled)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_admin_user")
    default int updateByPrimaryKeySelective(KspAdminUser record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
            .set(realname).equalToWhenPresent(record::getRealname)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(gender).equalToWhenPresent(record::getGender)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(enabled).equalToWhenPresent(record::getEnabled)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}