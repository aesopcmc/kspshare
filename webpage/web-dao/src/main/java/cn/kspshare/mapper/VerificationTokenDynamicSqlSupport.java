package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class VerificationTokenDynamicSqlSupport {
    public static final VerificationToken verificationToken = new VerificationToken();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = verificationToken.oid;

    /**
     * 用户主键
     * user_id
     */
    public static final SqlColumn<Long> userId = verificationToken.userId;

    /**
     * TOKEN
     * token
     */
    public static final SqlColumn<String> token = verificationToken.token;

    /**
     * 失效日期
     * expiry_date
     */
    public static final SqlColumn<LocalDateTime> expiryDate = verificationToken.expiryDate;

    /**
     * 创建时间
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = verificationToken.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = verificationToken.createUser;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = verificationToken.updateTime;

    public static final class VerificationToken extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> token = column("token", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public VerificationToken() {
            super("verification_token");
        }
    }
}