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
     *   唯一邮箱
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.email")
    public static final SqlColumn<String> email = kspMember.email;

    /**
     * Database Column Remarks:
     *   邮箱验证： 0未验证 1已验证 ， 默认0
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.enabled")
    public static final SqlColumn<Byte> enabled = kspMember.enabled;

    /**
     * Database Column Remarks:
     *   用户状态：1允许登录 0禁止登录 ， 默认1
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.user_status")
    public static final SqlColumn<Byte> userStatus = kspMember.userStatus;

    /**
     * Database Column Remarks:
     *   头像url路径
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.avatar")
    public static final SqlColumn<String> avatar = kspMember.avatar;

    /**
     * Database Column Remarks:
     *   0保密 1男 2女，默认0
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.gender")
    public static final SqlColumn<Byte> gender = kspMember.gender;

    /**
     * Database Column Remarks:
     *   简单地址信息
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.location")
    public static final SqlColumn<String> location = kspMember.location;

    /**
     * Database Column Remarks:
     *   兴趣爱好
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.hobbies")
    public static final SqlColumn<String> hobbies = kspMember.hobbies;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.create_time")
    public static final SqlColumn<LocalDateTime> createTime = kspMember.createTime;

    /**
     * Database Column Remarks:
     *   创建人ID
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.create_user")
    public static final SqlColumn<Long> createUser = kspMember.createUser;

    /**
     * Database Column Remarks:
     *   身份权限
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: ksp_member.roles")
    public static final SqlColumn<String> roles = kspMember.roles;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: ksp_member")
    public static final class KspMember extends SqlTable {
        public final SqlColumn<Long> oid = column("oid", JDBCType.BIGINT);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> nickname = column("nickname", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<Byte> enabled = column("enabled", JDBCType.TINYINT);

        public final SqlColumn<Byte> userStatus = column("user_status", JDBCType.TINYINT);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<Byte> gender = column("gender", JDBCType.TINYINT);

        public final SqlColumn<String> location = column("location", JDBCType.VARCHAR);

        public final SqlColumn<String> hobbies = column("hobbies", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> createUser = column("create_user", JDBCType.BIGINT);

        public final SqlColumn<String> roles = column("roles", JDBCType.VARCHAR);

        public KspMember() {
            super("ksp_member");
        }
    }
}