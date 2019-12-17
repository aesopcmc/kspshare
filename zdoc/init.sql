DROP TABLE IF EXISTS `ksp_verification_token`;
CREATE TABLE `ksp_verification_token`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `token` varchar(255) NOT NULL COMMENT 'TOKEN',
  `expiry_date` datetime(0) NULL DEFAULT NULL COMMENT '失效日期',
	`create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员邮件注册激活验证表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ksp_member`;
CREATE TABLE `ksp_member`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(100) NULL DEFAULT NULL COMMENT '昵称',
	`email` varchar(50) NULL DEFAULT NULL COMMENT '唯一邮箱',
	`enabled` tinyint(1) NOT NULL DEFAULT 0 COMMENT '邮箱验证： 0未验证 1已验证 ， 默认0',
	`user_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态：1允许登录 0禁止登录 ， 默认1',
	`avatar` varchar(255) COMMENT '头像url路径',
	`gender` 	TINYINT(1) NOT NULL DEFAULT 0 COMMENT '0保密 1男 2女，默认0',
	`location` varchar(255) COMMENT '简单地址信息',
	`hobbies` varchar(255)  COMMENT '兴趣爱好',
	`create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
	`create_user` bigint(20) COMMENT '创建人ID',
	`roles` varchar(255) NULL DEFAULT NULL COMMENT '身份权限',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛会员表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `ksp_admin_user`;
CREATE TABLE `ksp_admin_user`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '用户登录名',
  `realname` varchar(50) COMMENT '用户真实姓名',
  `password` varchar(255) NOT NULL COMMENT '用户登录密码',
  `gender` 	TINYINT(1) NOT NULL DEFAULT 0 COMMENT '0保密 1男 2女，默认0',
	`email` varchar(50) COMMENT '邮箱',
	`enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT 'enabled	是否可以登录	 0禁止 1允许',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台管理用户表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ksp_role`;
CREATE TABLE `ksp_role`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `code` varchar(50) NOT NULL COMMENT '角色编码，唯一编码',
  `parent_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '父ID, 默认顶级父级为0',
	`description` varchar(255) NULL DEFAULT NULL COMMENT '角色描述信息',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;



DROP TABLE IF EXISTS `ksp_perm`;
CREATE TABLE `ksp_perm`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) COMMENT '权限名称',
  `code` varchar(50) NOT NULL COMMENT '权限编码，唯一',
	`resource_id` bigint(20) COMMENT '资源ID',
	`create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ksp_resource`;
CREATE TABLE `ksp_resource`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) COMMENT '资源名称',
  `code` varchar(50) NOT NULL COMMENT '资源编码，唯一',
	`parent_id` bigint(20) NOT NULL COMMENT '父资源ID',
	`resource_type` tinyint(1) NOT NULL COMMENT '资源类型 1菜单 2按钮 ',
	`url` varchar(500) COMMENT '资源URL',
	`icon` varchar(500) COMMENT '图标',
	`compone_name` varchar(50) COMMENT 'vue组件名，用于路由配置',
	`sort` int NOT NULL DEFAULT 0 COMMENT '排序',
	`create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ksp_role_perm_re`;
CREATE TABLE `ksp_role_perm_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
	`role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `perm_id` bigint(20) NOT NULL COMMENT '权限ID',
	`perm_type` tinyint(1) NOT NULL COMMENT '0可访问 1可授权',
	`create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-权限关系表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ksp_user_perm_re`;
CREATE TABLE `ksp_user_perm_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `perm_id` bigint(20) NOT NULL COMMENT '权限ID',
	`perm_type` tinyint(1) NOT NULL COMMENT '0可访问 1可授权',
	`create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-权限关系表' ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `ksp_user_perm_re`;
CREATE TABLE `ksp_user_role_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
	`create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_user` bigint(20) COMMENT '创建人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;


-- 测试表
DROP TABLE IF EXISTS `test_grade`;
CREATE TABLE `test_grade`  (
  `tid` bigint(20) NOT NULL,
  `grade_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user`  (
  `tid` bigint(20) NOT NULL COMMENT '主键',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `grade_id` bigint(20) NULL DEFAULT NULL COMMENT '1\r\n            2\r\n            3',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
