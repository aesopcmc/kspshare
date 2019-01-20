package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspVerificationTokenDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    public static final KspVerificationToken kspVerificationToken = new KspVerificationToken();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.oid")
    public static final SqlColumn<Long> oid = kspVerificationToken.oid;

    /**
     * Database Column Remarks:
     *   用户主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.user_id")
    public static final SqlColumn<Long> userId = kspVerificationToken.userId;

    /**
     * Database Column Remarks:
     *   TOKEN
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.token")
    public static final SqlColumn<String> token = kspVerificationToken.token;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_verification_token.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspVerificationToken.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_verification_token")
    public static final class KspVerificationToken extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> token = column("token", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public KspVerificationToken() {
            super("ksp_verification_token");
        }
    }
}