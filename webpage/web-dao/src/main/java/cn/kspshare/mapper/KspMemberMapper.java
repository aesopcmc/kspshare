package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspMemberDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspMember;
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
public interface KspMemberMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspMember> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspMemberResult")
    KspMember selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspMemberResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.BIT),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.BIT),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="hobbies", property="hobbies", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="roles", property="roles", jdbcType=JdbcType.VARCHAR)
    })
    List<KspMember> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(kspMember);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspMember);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default int deleteByPrimaryKey(Long oid_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, kspMember)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default int insert(KspMember record) {
        return insert(SqlBuilder.insert(record)
                .into(kspMember)
                .map(oid).toProperty("oid")
                .map(username).toProperty("username")
                .map(password).toProperty("password")
                .map(nickname).toProperty("nickname")
                .map(email).toProperty("email")
                .map(enabled).toProperty("enabled")
                .map(userStatus).toProperty("userStatus")
                .map(avatar).toProperty("avatar")
                .map(gender).toProperty("gender")
                .map(location).toProperty("location")
                .map(hobbies).toProperty("hobbies")
                .map(createTime).toProperty("createTime")
                .map(createUser).toProperty("createUser")
                .map(roles).toProperty("roles")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default int insertSelective(KspMember record) {
        return insert(SqlBuilder.insert(record)
                .into(kspMember)
                .map(oid).toPropertyWhenPresent("oid", record::getOid)
                .map(username).toPropertyWhenPresent("username", record::getUsername)
                .map(password).toPropertyWhenPresent("password", record::getPassword)
                .map(nickname).toPropertyWhenPresent("nickname", record::getNickname)
                .map(email).toPropertyWhenPresent("email", record::getEmail)
                .map(enabled).toPropertyWhenPresent("enabled", record::getEnabled)
                .map(userStatus).toPropertyWhenPresent("userStatus", record::getUserStatus)
                .map(avatar).toPropertyWhenPresent("avatar", record::getAvatar)
                .map(gender).toPropertyWhenPresent("gender", record::getGender)
                .map(location).toPropertyWhenPresent("location", record::getLocation)
                .map(hobbies).toPropertyWhenPresent("hobbies", record::getHobbies)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
                .map(roles).toPropertyWhenPresent("roles", record::getRoles)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspMember>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, oid, username, password, nickname, email, enabled, userStatus, avatar, gender, location, hobbies, createTime, createUser, roles)
                .from(kspMember);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<KspMember>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, oid, username, password, nickname, email, enabled, userStatus, avatar, gender, location, hobbies, createTime, createUser, roles)
                .from(kspMember);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default KspMember selectByPrimaryKey(Long oid_) {
        return SelectDSL.selectWithMapper(this::selectOne, oid, username, password, nickname, email, enabled, userStatus, avatar, gender, location, hobbies, createTime, createUser, roles)
                .from(kspMember)
                .where(oid, isEqualTo(oid_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(KspMember record) {
        return UpdateDSL.updateWithMapper(this::update, kspMember)
                .set(oid).equalTo(record::getOid)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(nickname).equalTo(record::getNickname)
                .set(email).equalTo(record::getEmail)
                .set(enabled).equalTo(record::getEnabled)
                .set(userStatus).equalTo(record::getUserStatus)
                .set(avatar).equalTo(record::getAvatar)
                .set(gender).equalTo(record::getGender)
                .set(location).equalTo(record::getLocation)
                .set(hobbies).equalTo(record::getHobbies)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(roles).equalTo(record::getRoles);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(KspMember record) {
        return UpdateDSL.updateWithMapper(this::update, kspMember)
                .set(oid).equalToWhenPresent(record::getOid)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(enabled).equalToWhenPresent(record::getEnabled)
                .set(userStatus).equalToWhenPresent(record::getUserStatus)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(location).equalToWhenPresent(record::getLocation)
                .set(hobbies).equalToWhenPresent(record::getHobbies)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(roles).equalToWhenPresent(record::getRoles);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default int updateByPrimaryKey(KspMember record) {
        return UpdateDSL.updateWithMapper(this::update, kspMember)
                .set(username).equalTo(record::getUsername)
                .set(password).equalTo(record::getPassword)
                .set(nickname).equalTo(record::getNickname)
                .set(email).equalTo(record::getEmail)
                .set(enabled).equalTo(record::getEnabled)
                .set(userStatus).equalTo(record::getUserStatus)
                .set(avatar).equalTo(record::getAvatar)
                .set(gender).equalTo(record::getGender)
                .set(location).equalTo(record::getLocation)
                .set(hobbies).equalTo(record::getHobbies)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(roles).equalTo(record::getRoles)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    default int updateByPrimaryKeySelective(KspMember record) {
        return UpdateDSL.updateWithMapper(this::update, kspMember)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(nickname).equalToWhenPresent(record::getNickname)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(enabled).equalToWhenPresent(record::getEnabled)
                .set(userStatus).equalToWhenPresent(record::getUserStatus)
                .set(avatar).equalToWhenPresent(record::getAvatar)
                .set(gender).equalToWhenPresent(record::getGender)
                .set(location).equalToWhenPresent(record::getLocation)
                .set(hobbies).equalToWhenPresent(record::getHobbies)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(roles).equalToWhenPresent(record::getRoles)
                .where(oid, isEqualTo(record::getOid))
                .build()
                .execute();
    }
}