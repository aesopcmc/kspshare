package cn.kspshare.mapper;

import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class MemberDynamicSqlSupport {
    public static final Member member = new Member();

    /**
     * 主键
     * oid
     */
    public static final SqlColumn<Long> oid = member.oid;

    /**
     * 账号
     * username
     */
    public static final SqlColumn<String> username = member.username;

    /**
     * 密码
     * password
     */
    public static final SqlColumn<String> password = member.password;

    /**
     * 昵称
     * nickname
     */
    public static final SqlColumn<String> nickname = member.nickname;

    /**
     * 唯一邮箱
     * email
     */
    public static final SqlColumn<String> email = member.email;

    /**
     * 邮箱验证： 0未验证 1已验证 ， 默认0
     * enabled
     */
    public static final SqlColumn<Byte> enabled = member.enabled;

    /**
     * 用户状态：1允许登录 0禁止登录 ， 默认1
     * user_status
     */
    public static final SqlColumn<Byte> userStatus = member.userStatus;

    /**
     * 头像url路径
     * avatar
     */
    public static final SqlColumn<String> avatar = member.avatar;

    /**
     * 0保密 1男 2女，默认0
     * gender
     */
    public static final SqlColumn<Byte> gender = member.gender;

    /**
     * 简单地址信息
     * location
     */
    public static final SqlColumn<String> location = member.location;

    /**
     * 兴趣爱好
     * hobbies
     */
    public static final SqlColumn<String> hobbies = member.hobbies;

    /**
     * 
     * create_time
     */
    public static final SqlColumn<LocalDateTime> createTime = member.createTime;

    /**
     * 创建人ID
     * create_user
     */
    public static final SqlColumn<Long> createUser = member.createUser;

    /**
     * 身份权限
     * roles
     */
    public static final SqlColumn<String> roles = member.roles;

    /**
     * 创建时间
     * update_time
     */
    public static final SqlColumn<LocalDateTime> updateTime = member.updateTime;

    public static final class Member extends SqlTable {
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

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public Member() {
            super("member");
        }
    }
}