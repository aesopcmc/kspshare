package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspBbsThemeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspBbsTheme;
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
public interface KspBbsThemeMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, title, profile, sessionId, replyCount, lastReplyUser, lastReplyTime, createTime, createUser, updateTime, updateUser);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspBbsTheme> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspBbsTheme> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspBbsThemeResult")
    Optional<KspBbsTheme> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspBbsThemeResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="profile", property="profile", jdbcType=JdbcType.VARCHAR),
        @Result(column="session_id", property="sessionId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_count", property="replyCount", jdbcType=JdbcType.INTEGER),
        @Result(column="last_reply_user", property="lastReplyUser", jdbcType=JdbcType.BIGINT),
        @Result(column="last_reply_time", property="lastReplyTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.BIGINT)
    })
    List<KspBbsTheme> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspBbsTheme, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspBbsTheme, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(KspBbsTheme record) {
        return MyBatis3Utils.insert(this::insert, record, kspBbsTheme, c ->
            c.map(oid).toProperty("oid")
            .map(title).toProperty("title")
            .map(profile).toProperty("profile")
            .map(sessionId).toProperty("sessionId")
            .map(replyCount).toProperty("replyCount")
            .map(lastReplyUser).toProperty("lastReplyUser")
            .map(lastReplyTime).toProperty("lastReplyTime")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
            .map(updateUser).toProperty("updateUser")
        );
    }

    default int insertMultiple(Collection<KspBbsTheme> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspBbsTheme, c ->
            c.map(oid).toProperty("oid")
            .map(title).toProperty("title")
            .map(profile).toProperty("profile")
            .map(sessionId).toProperty("sessionId")
            .map(replyCount).toProperty("replyCount")
            .map(lastReplyUser).toProperty("lastReplyUser")
            .map(lastReplyTime).toProperty("lastReplyTime")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
            .map(updateUser).toProperty("updateUser")
        );
    }

    default int insertSelective(KspBbsTheme record) {
        return MyBatis3Utils.insert(this::insert, record, kspBbsTheme, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(title).toPropertyWhenPresent("title", record::getTitle)
            .map(profile).toPropertyWhenPresent("profile", record::getProfile)
            .map(sessionId).toPropertyWhenPresent("sessionId", record::getSessionId)
            .map(replyCount).toPropertyWhenPresent("replyCount", record::getReplyCount)
            .map(lastReplyUser).toPropertyWhenPresent("lastReplyUser", record::getLastReplyUser)
            .map(lastReplyTime).toPropertyWhenPresent("lastReplyTime", record::getLastReplyTime)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", record::getUpdateUser)
        );
    }

    default Optional<KspBbsTheme> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspBbsTheme, completer);
    }

    default List<KspBbsTheme> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspBbsTheme, completer);
    }

    default List<KspBbsTheme> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspBbsTheme, completer);
    }

    default Optional<KspBbsTheme> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspBbsTheme, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(KspBbsTheme record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(title).equalTo(record::getTitle)
                .set(profile).equalTo(record::getProfile)
                .set(sessionId).equalTo(record::getSessionId)
                .set(replyCount).equalTo(record::getReplyCount)
                .set(lastReplyUser).equalTo(record::getLastReplyUser)
                .set(lastReplyTime).equalTo(record::getLastReplyTime)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(updateUser).equalTo(record::getUpdateUser);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspBbsTheme record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(profile).equalToWhenPresent(record::getProfile)
                .set(sessionId).equalToWhenPresent(record::getSessionId)
                .set(replyCount).equalToWhenPresent(record::getReplyCount)
                .set(lastReplyUser).equalToWhenPresent(record::getLastReplyUser)
                .set(lastReplyTime).equalToWhenPresent(record::getLastReplyTime)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(updateUser).equalToWhenPresent(record::getUpdateUser);
    }

    default int updateByPrimaryKey(KspBbsTheme record) {
        return update(c ->
            c.set(title).equalTo(record::getTitle)
            .set(profile).equalTo(record::getProfile)
            .set(sessionId).equalTo(record::getSessionId)
            .set(replyCount).equalTo(record::getReplyCount)
            .set(lastReplyUser).equalTo(record::getLastReplyUser)
            .set(lastReplyTime).equalTo(record::getLastReplyTime)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(updateUser).equalTo(record::getUpdateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(KspBbsTheme record) {
        return update(c ->
            c.set(title).equalToWhenPresent(record::getTitle)
            .set(profile).equalToWhenPresent(record::getProfile)
            .set(sessionId).equalToWhenPresent(record::getSessionId)
            .set(replyCount).equalToWhenPresent(record::getReplyCount)
            .set(lastReplyUser).equalToWhenPresent(record::getLastReplyUser)
            .set(lastReplyTime).equalToWhenPresent(record::getLastReplyTime)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(updateUser).equalToWhenPresent(record::getUpdateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}