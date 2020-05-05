package cn.kspshare.mapper;

import static cn.kspshare.mapper.BbsContextDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import cn.kspshare.domain.BbsContext;
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
public interface BbsContextMapper {
    BasicColumn[] selectList = BasicColumn.columnList(oid, themeId, contextType, profile, auditStatus, createTime, createUser, updateTime, updateUser, context);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BbsContext> insertStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<BbsContext> multipleInsertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BbsContextResult")
    Optional<BbsContext> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BbsContextResult", value = {
        @Result(column="oid", property="oid", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="theme_id", property="themeId", jdbcType=JdbcType.BIGINT),
        @Result(column="context_type", property="contextType", jdbcType=JdbcType.TINYINT),
        @Result(column="profile", property="profile", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user", property="updateUser", jdbcType=JdbcType.BIGINT),
        @Result(column="context", property="context", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<BbsContext> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, bbsContext, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, bbsContext, completer);
    }

    default int deleteByPrimaryKey(Long oid_) {
        return delete(c -> 
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int insert(BbsContext record) {
        return MyBatis3Utils.insert(this::insert, record, bbsContext, c ->
            c.map(oid).toProperty("oid")
            .map(themeId).toProperty("themeId")
            .map(contextType).toProperty("contextType")
            .map(profile).toProperty("profile")
            .map(auditStatus).toProperty("auditStatus")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
            .map(updateUser).toProperty("updateUser")
            .map(context).toProperty("context")
        );
    }

    default int insertMultiple(Collection<BbsContext> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, bbsContext, c ->
            c.map(oid).toProperty("oid")
            .map(themeId).toProperty("themeId")
            .map(contextType).toProperty("contextType")
            .map(profile).toProperty("profile")
            .map(auditStatus).toProperty("auditStatus")
            .map(createTime).toProperty("createTime")
            .map(createUser).toProperty("createUser")
            .map(updateTime).toProperty("updateTime")
            .map(updateUser).toProperty("updateUser")
            .map(context).toProperty("context")
        );
    }

    default int insertSelective(BbsContext record) {
        return MyBatis3Utils.insert(this::insert, record, bbsContext, c ->
            c.map(oid).toPropertyWhenPresent("oid", record::getOid)
            .map(themeId).toPropertyWhenPresent("themeId", record::getThemeId)
            .map(contextType).toPropertyWhenPresent("contextType", record::getContextType)
            .map(profile).toPropertyWhenPresent("profile", record::getProfile)
            .map(auditStatus).toPropertyWhenPresent("auditStatus", record::getAuditStatus)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(createUser).toPropertyWhenPresent("createUser", record::getCreateUser)
            .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
            .map(updateUser).toPropertyWhenPresent("updateUser", record::getUpdateUser)
            .map(context).toPropertyWhenPresent("context", record::getContext)
        );
    }

    default Optional<BbsContext> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, bbsContext, completer);
    }

    default List<BbsContext> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, bbsContext, completer);
    }

    default List<BbsContext> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, bbsContext, completer);
    }

    default Optional<BbsContext> selectByPrimaryKey(Long oid_) {
        return selectOne(c ->
            c.where(oid, isEqualTo(oid_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, bbsContext, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(BbsContext record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalTo(record::getOid)
                .set(themeId).equalTo(record::getThemeId)
                .set(contextType).equalTo(record::getContextType)
                .set(profile).equalTo(record::getProfile)
                .set(auditStatus).equalTo(record::getAuditStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUser).equalTo(record::getCreateUser)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(updateUser).equalTo(record::getUpdateUser)
                .set(context).equalTo(record::getContext);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(BbsContext record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(oid).equalToWhenPresent(record::getOid)
                .set(themeId).equalToWhenPresent(record::getThemeId)
                .set(contextType).equalToWhenPresent(record::getContextType)
                .set(profile).equalToWhenPresent(record::getProfile)
                .set(auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUser).equalToWhenPresent(record::getCreateUser)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(updateUser).equalToWhenPresent(record::getUpdateUser)
                .set(context).equalToWhenPresent(record::getContext);
    }

    default int updateByPrimaryKey(BbsContext record) {
        return update(c ->
            c.set(themeId).equalTo(record::getThemeId)
            .set(contextType).equalTo(record::getContextType)
            .set(profile).equalTo(record::getProfile)
            .set(auditStatus).equalTo(record::getAuditStatus)
            .set(createTime).equalTo(record::getCreateTime)
            .set(createUser).equalTo(record::getCreateUser)
            .set(updateTime).equalTo(record::getUpdateTime)
            .set(updateUser).equalTo(record::getUpdateUser)
            .set(context).equalTo(record::getContext)
            .where(oid, isEqualTo(record::getOid))
        );
    }

    default int updateByPrimaryKeySelective(BbsContext record) {
        return update(c ->
            c.set(themeId).equalToWhenPresent(record::getThemeId)
            .set(contextType).equalToWhenPresent(record::getContextType)
            .set(profile).equalToWhenPresent(record::getProfile)
            .set(auditStatus).equalToWhenPresent(record::getAuditStatus)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(createUser).equalToWhenPresent(record::getCreateUser)
            .set(updateTime).equalToWhenPresent(record::getUpdateTime)
            .set(updateUser).equalToWhenPresent(record::getUpdateUser)
            .set(context).equalToWhenPresent(record::getContext)
            .where(oid, isEqualTo(record::getOid))
        );
    }
}