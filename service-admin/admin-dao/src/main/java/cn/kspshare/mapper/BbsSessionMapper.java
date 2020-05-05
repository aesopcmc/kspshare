package cn.kspshare.mapper;

import static cn.kspshare.mapper.BbsSessionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.BbsSession;
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
public interface BbsSessionMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, name, profile, topicCount, viewCount, clickRate, sort, createTime, createUser, updateTime, updateUser);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BbsSession> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BbsSession> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BbsSessionResult")
    Optional<BbsSession> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BbsSessionResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="profile", property="profile", jdbcType=JdbcType.VARCHAR),
        @Result(column="topic_count", property="topicCount", jdbcType=JdbcType.INTEGER),
        @Result(column="view_count", property="viewCount", jdbcType=JdbcType.INTEGER),
        @Result(column="click_rate", property="clickRate", jdbcType=JdbcType.REAL),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.BIGINT)
    })
    List<BbsSession> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, bbsSession, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, bbsSession, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(BbsSession record) {
        return MyBatis3Utils.insert(this::insert, record, bbsSession, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(profile).toProperty("profile")
            .map(topicCount).toProperty("topicCount")
            .map(viewCount).toProperty("viewCount")
            .map(clickRate).toProperty("clickRate")
            .map(sort).toProperty("sort")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
            .map(updateUser).toProperty("updateUser")
        );
    }

    default int insertMultiple(Collection<BbsSession> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, bbsSession, c ->
            c.map(oid).toProperty("oid")
            .map(name).toProperty("name")
            .map(profile).toProperty("profile")
            .map(topicCount).toProperty("topicCount")
            .map(viewCount).toProperty("viewCount")
            .map(clickRate).toProperty("clickRate")
            .map(sort).toProperty("sort")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
            .map(updateUser).toProperty("updateUser")
        );
    }

    default int insertSelective(BbsSession record) {
        return MyBatis3Utils.insert(this::insert, record, bbsSession, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(profile).toPropertyWhenPresent("profile", record::getProfile)
            .map(topicCount).toPropertyWhenPresent("topicCount", record::getTopicCount)
            .map(viewCount).toPropertyWhenPresent("viewCount", record::getViewCount)
            .map(clickRate).toPropertyWhenPresent("clickRate", record::getClickRate)
            .map(sort).toPropertyWhenPresent("sort", record::getSort)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", record::getUpdateUser)
        );
    }

    default Optional<BbsSession> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, bbsSession, completer);
    }

    default List<BbsSession> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, bbsSession, completer);
    }

    default List<BbsSession> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, bbsSession, completer);
    }

    default Optional<BbsSession> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, bbsSession, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(BbsSession record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(name).equalTo(record::getName)
                .set(profile).equalTo(record::getProfile)
                .set(topicCount).equalTo(record::getTopicCount)
                .set(viewCount).equalTo(record::getViewCount)
                .set(clickRate).equalTo(record::getClickRate)
                .set(sort).equalTo(record::getSort)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(updateUser).equalTo(record::getUpdateUser);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(BbsSession record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(name).equalToWhenPresent(record::getName)
                .set(profile).equalToWhenPresent(record::getProfile)
                .set(topicCount).equalToWhenPresent(record::getTopicCount)
                .set(viewCount).equalToWhenPresent(record::getViewCount)
                .set(clickRate).equalToWhenPresent(record::getClickRate)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(updateUser).equalToWhenPresent(record::getUpdateUser);
    }

    default int updateByPrimaryKey(BbsSession record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(profile).equalTo(record::getProfile)
            .set(topicCount).equalTo(record::getTopicCount)
            .set(viewCount).equalTo(record::getViewCount)
            .set(clickRate).equalTo(record::getClickRate)
            .set(sort).equalTo(record::getSort)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(updateUser).equalTo(record::getUpdateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(BbsSession record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(profile).equalToWhenPresent(record::getProfile)
            .set(topicCount).equalToWhenPresent(record::getTopicCount)
            .set(viewCount).equalToWhenPresent(record::getViewCount)
            .set(clickRate).equalToWhenPresent(record::getClickRate)
            .set(sort).equalToWhenPresent(record::getSort)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(updateUser).equalToWhenPresent(record::getUpdateUser)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}