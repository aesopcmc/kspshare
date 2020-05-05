package cn.kspshare.mapper;

import static cn.kspshare.mapper.MemberDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.Member;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
public interface MemberMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, username, password, nickname, email, enabled, userStatus, avatar, gender, location, hobbies, createTime, createUser, roles, updateTime);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Member> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Member> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MemberResult")
    Optional<Member> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MemberResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.TINYINT),
        @Result(column="user_status", property="userStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.TINYINT),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="hobbies", property="hobbies", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="roles", property="roles", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Member> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, member, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, member, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(Member record) {
        return MyBatis3Utils.insert(this::insert, record, member, c ->
            c.map(oid).toProperty("oid")
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
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertMultiple(Collection<Member> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, member, c ->
            c.map(oid).toProperty("oid")
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
            .map(updateTime).toProperty("updateTime")
        );
    }

    default int insertSelective(Member record) {
        return MyBatis3Utils.insert(this::insert, record, member, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
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
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
        );
    }

    default Optional<Member> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, member, completer);
    }

    default List<Member> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, member, completer);
    }

    default List<Member> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, member, completer);
    }

    default Optional<Member> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, member, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(Member record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
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
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(Member record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
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
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    default int updateByPrimaryKey(Member record) {
        return update(c ->
            c.set(username).equalTo(record::getUsername)
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
            .set(updateTime).equalTo(record::getUpdateTime)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(Member record) {
        return update(c ->
            c.set(username).equalToWhenPresent(record::getUsername)
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
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}