package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspUserPermReDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    public static final KspUserPermRe kspUserPermRe = new KspUserPermRe();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.oid")
    public static final SqlColumn<Long> oid = kspUserPermRe.oid;

    /**
     * Database Column Remarks:
     *   用户ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.user_id")
    public static final SqlColumn<Long> userId = kspUserPermRe.userId;

    /**
     * Database Column Remarks:
     *   权限ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.perm_id")
    public static final SqlColumn<Long> permId = kspUserPermRe.permId;

    /**
     * Database Column Remarks:
     *   0可访问 1可授权
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.perm_type")
    public static final SqlColumn<Byte> permType = kspUserPermRe.permType;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspUserPermRe.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.create_user")
    public static final SqlColumn<Long> createUser = kspUserPermRe.createUser;

    /**
     * Database Column Remarks:
     *   创建时间
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_user_perm_re.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = kspUserPermRe.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_user_perm_re")
    public static final class KspUserPermRe extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Long> permId = column("perm_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> permType = column("perm_type", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public KspUserPermRe() {
            super("ksp_user_perm_re");
        }
    }
}