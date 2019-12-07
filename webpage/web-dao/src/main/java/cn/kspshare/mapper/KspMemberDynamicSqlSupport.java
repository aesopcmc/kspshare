package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class KspMemberDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    public static final KspMember kspMember = new KspMember();

    /**
     * Database Column Remarks:
     *   主键
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.oid")
    public static final SqlColumn<Long> oid = kspMember.oid;

    /**
     * Database Column Remarks:
     *   账号
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.username")
    public static final SqlColumn<String> username = kspMember.username;

    /**
     * Database Column Remarks:
     *   密码
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.password")
    public static final SqlColumn<String> password = kspMember.password;

    /**
     * Database Column Remarks:
     *   昵称
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.nickname")
    public static final SqlColumn<String> nickname = kspMember.nickname;

    /**
     * Database Column Remarks:
     *   身份权限
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.roles")
    public static final SqlColumn<String> roles = kspMember.roles;

    /**
     * Database Column Remarks:
     *   邮箱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.email")
    public static final SqlColumn<String> email = kspMember.email;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspMember.createTime;

    /**
     * Database Column Remarks:
     *   是可以登录 true1启用 false0禁用
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.enabled")
    public static final SqlColumn<Boolean> enabled = kspMember.enabled;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    public static final class KspMember extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> roles = column("roles", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> enabled = column("enabled", JDBCType.BIT);

        public KspMember() {
            super("ksp_member");
        }
    }
}