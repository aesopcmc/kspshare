package cn.kspshare.mapper;

import static cn.kspshare.mapper.KspBbsSessionDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.KspBbsSession;
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
public interface KspBbsSessionMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    BasicColumn[] selectList = BasicColumn.columnList(oid, name, profile, topicCount, viewCount, clickRate, sort, createTime, createUser, updateTime, updateUser);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<KspBbsSession> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<KspBbsSession> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("KspBbsSessionResult")
    Optional<KspBbsSession> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="KspBbsSessionResult", value = {
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
    List<KspBbsSession> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, kspBbsSession, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, kspBbsSession, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int insert(KspBbsSession record) {
        return MyBatis3Utils.insert(this::insert, record, kspBbsSession, c ->
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int insertMultiple(Collection<KspBbsSession> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, kspBbsSession, c ->
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int insertSelective(KspBbsSession record) {
        return MyBatis3Utils.insert(this::insert, record, kspBbsSession, c ->
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default Optional<KspBbsSession> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, kspBbsSession, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default List<KspBbsSession> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, kspBbsSession, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default List<KspBbsSession> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, kspBbsSession, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default Optional<KspBbsSession> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, kspBbsSession, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    static UpdateDSL<UpdateModel> updateAllColumns(KspBbsSession record, UpdateDSL<UpdateModel> dsl) {
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(KspBbsSession record, UpdateDSL<UpdateModel> dsl) {
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int updateByPrimaryKey(KspBbsSession record) {
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_bbs_session")
    default int updateByPrimaryKeySelective(KspBbsSession record) {
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