/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : ksp

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 15/06/2020 23:26:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登录名',
  `realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登录密码',
  `gender` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0保密 1男 2女，默认0',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT 'enabled	是否可以登录	 0禁止 1允许',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  INDEX `search_index`(`username`, `realname`, `email`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台管理用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_user
-- ----------------------------
INSERT INTO `admin_user` VALUES (1, 'super', '超级管理员', 'e10adc3949ba59abbe56e057f20f883e', 0, NULL, 1, '2019-12-18 15:53:20', 0, '2019-12-24 12:05:46');
INSERT INTO `admin_user` VALUES (666007671261888512, '老狗1', '灌灌灌灌', 'e10adc3949ba59abbe56e057f20f883e', 0, '', 1, '2020-01-12 19:56:40', NULL, '2020-01-12 22:50:31');
INSERT INTO `admin_user` VALUES (666007804112273408, 'aesop123', '本里啊123', 'e10adc3949ba59abbe56e057f20f883e', 0, 'aesopcmc@gmail.cox', 0, '2020-01-12 19:57:12', NULL, '2020-04-15 21:38:25');
INSERT INTO `admin_user` VALUES (666012500919058432, '老哥啊', '', 'e10adc3949ba59abbe56e057f20f883e', 0, '', 1, '2020-01-12 20:15:52', NULL, '2020-01-12 23:43:25');
INSERT INTO `admin_user` VALUES (700085729472020480, 'test', '', 'e10adc3949ba59abbe56e057f20f883e', 0, '', 1, '2020-04-15 20:50:44', NULL, '2020-04-15 20:50:44');

-- ----------------------------
-- Table structure for bbs_context
-- ----------------------------
DROP TABLE IF EXISTS `bbs_context`;
CREATE TABLE `bbs_context`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `theme_id` bigint(20) NOT NULL COMMENT '主题ID',
  `context_type` tinyint(1) NOT NULL COMMENT '评论类型：0文章、1评论、2回复',
  `context` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '评论内容',
  `profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论摘要，在回复时，摘取父评论的简要',
  `audit_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '审核状态：0待审核 1审核通过 2审核拒绝',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) NULL DEFAULT NULL COMMENT '更新人ID',
  `publish_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '发布状态 1已发布 0存草稿未发布',
  `author` bigint(20) NULL DEFAULT NULL COMMENT '作者ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_context
-- ----------------------------
INSERT INTO `bbs_context` VALUES (716427662041546752, 716427660808421376, 0, '<p>烦烦烦<strong>方法</strong></p>', '烦烦烦方法', 1, '2020-05-30 23:07:45', 1, '2020-06-03 21:59:11', 1, 0, NULL);
INSERT INTO `bbs_context` VALUES (717872387860725760, 717872387604873216, 0, '<p>42343243243243243243232432432324</p>', '432423432', 1, '2020-06-03 22:48:34', 1, '2020-06-03 22:48:34', NULL, 1, NULL);

-- ----------------------------
-- Table structure for bbs_parent_child
-- ----------------------------
DROP TABLE IF EXISTS `bbs_parent_child`;
CREATE TABLE `bbs_parent_child`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `parent_context_id` bigint(20) NOT NULL COMMENT '父评论ID',
  `child_context_id` bigint(20) NOT NULL COMMENT '子评论ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛评论关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for bbs_session
-- ----------------------------
DROP TABLE IF EXISTS `bbs_session`;
CREATE TABLE `bbs_session`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '板块名称',
  `profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '板块主题、简要',
  `topic_count` int(11) NOT NULL DEFAULT 0 COMMENT '总发帖数',
  `view_count` int(11) NOT NULL DEFAULT 0 COMMENT '总浏览量',
  `click_rate` float NOT NULL DEFAULT 0 COMMENT '总点击率',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) NULL DEFAULT NULL COMMENT '更新人ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛版块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_session
-- ----------------------------
INSERT INTO `bbs_session` VALUES (696503208784166912, '开放共享123', '开放共享开放共享开放共享开放共享', 0, 0, 0, 2, '2020-04-05 23:35:05', NULL, '2020-05-05 13:14:09', 1);
INSERT INTO `bbs_session` VALUES (698956025541165056, '牛逼', '', 0, 0, 0, 0, '2020-04-12 18:01:42', NULL, '2020-04-12 18:01:42', NULL);
INSERT INTO `bbs_session` VALUES (698956376495357952, '奥德赛', '是', 0, 0, 0, 0, '2020-04-12 18:03:06', NULL, '2020-04-12 18:03:06', NULL);
INSERT INTO `bbs_session` VALUES (706912980557627392, 'a', '', 0, 0, 0, 0, '2020-05-04 16:59:48', 1, '2020-05-04 16:59:48', NULL);

-- ----------------------------
-- Table structure for bbs_theme
-- ----------------------------
DROP TABLE IF EXISTS `bbs_theme`;
CREATE TABLE `bbs_theme`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `session_id` bigint(20) NOT NULL COMMENT '版块ID',
  `reply_count` int(11) NOT NULL DEFAULT 0 COMMENT '回复数量，包含评论和回复',
  `last_reply_user` bigint(20) NULL DEFAULT NULL COMMENT '最后回复用户ID',
  `last_reply_time` datetime(0) NULL DEFAULT NULL COMMENT '最后回复时间',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_user` bigint(20) NULL DEFAULT NULL COMMENT '更新人ID',
  `author` bigint(20) NULL DEFAULT NULL COMMENT '作者ID',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛主题表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bbs_theme
-- ----------------------------
INSERT INTO `bbs_theme` VALUES (716427660808421376, '超1235', '烦烦烦方法', 698956025541165056, 0, NULL, NULL, '2020-05-30 23:07:45', 1, '2020-06-03 21:59:11', 1, NULL);

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '唯一邮箱',
  `enabled` tinyint(1) NOT NULL DEFAULT 0 COMMENT '邮箱验证： 0未验证 1已验证 ， 默认0',
  `user_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态：1允许登录 0禁止登录 ， 默认1',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像url路径',
  `gender` tinyint(1) NOT NULL DEFAULT 0 COMMENT '0保密 1男 2女，默认0',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简单地址信息',
  `hobbies` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '兴趣爱好',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份权限',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛会员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES (524019159298736128, 'chao1', '$2a$10$GnCDh42o5ZEcrfP48ykqxuxwyu6TLfGOFj2nRMxmYzLKpQuua27d2', '超1', NULL, 1, 1, NULL, 0, NULL, NULL, '2019-01-20 20:25:34', NULL, 'ROLE_USER', '2019-12-24 12:06:22');
INSERT INTO `member` VALUES (529644340201390080, 'chao2', '$2a$10$GnCDh42o5ZEcrfP48ykqxuxwyu6TLfGOFj2nRMxmYzLKpQuua27d2', '超2', NULL, 1, 1, NULL, 0, NULL, NULL, '2019-01-20 20:25:37', NULL, 'ROLE_USER,ROLE_VIP', '2019-12-24 12:06:22');
INSERT INTO `member` VALUES (529644340201390081, 'admin', '$2a$10$GnCDh42o5ZEcrfP48ykqxuxwyu6TLfGOFj2nRMxmYzLKpQuua27d2', '超级管理员', NULL, 1, 1, NULL, 0, NULL, NULL, '2019-01-20 20:25:39', NULL, 'ROLE_ADMIN', '2019-12-24 12:06:22');
INSERT INTO `member` VALUES (539231828473544704, 'chao123', '$2a$10$GnCDh42o5ZEcrfP48ykqxuxwyu6TLfGOFj2nRMxmYzLKpQuua27d2', 'chao123', 'chao_c_c@163.com', 1, 1, NULL, 0, NULL, NULL, '2019-01-27 23:54:46', NULL, 'ROLE_USER', '2019-12-24 12:06:22');

-- ----------------------------
-- Table structure for perm
-- ----------------------------
DROP TABLE IF EXISTS `perm`;
CREATE TABLE `perm`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限编码，唯一',
  `resource_id` bigint(20) NULL DEFAULT NULL COMMENT '资源ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源编码，唯一',
  `code_link` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码链，通过“-”拼接，不包含自身，最顶级为NULL',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父资源ID',
  `resource_type` tinyint(1) NOT NULL COMMENT '资源类型 1菜单 2按钮 ',
  `url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源URL',
  `icon` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图标',
  `component_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'vue组件名，用于路由配置',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '首页', 'aaa', NULL, 0, 0, NULL, NULL, NULL, 0, '2019-12-26 16:00:02', NULL, '2019-12-26 16:00:02');
INSERT INTO `resource` VALUES (2, '会员列表', 'bbbb', NULL, 1, 0, NULL, NULL, NULL, 0, '2019-12-26 16:00:40', NULL, '2019-12-26 16:00:40');
INSERT INTO `resource` VALUES (3, '角色列表', 'ccc', NULL, 1, 0, NULL, NULL, NULL, 0, '2019-12-26 16:00:50', NULL, '2019-12-26 16:00:50');
INSERT INTO `resource` VALUES (4, '统计', 'ddd', NULL, 0, 0, NULL, NULL, NULL, 0, '2019-12-26 16:00:58', NULL, '2019-12-26 16:00:58');
INSERT INTO `resource` VALUES (5, '角色分配', 'cccd', NULL, 3, 0, NULL, NULL, NULL, 0, '2019-12-26 16:01:16', NULL, '2019-12-26 16:01:16');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编码，唯一编码',
  `code_link` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编码链，通过“-”拼接，不包含自身，最顶级为NULL',
  `parent_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '父ID, 默认顶级父级为0',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述信息',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_perm_re
-- ----------------------------
DROP TABLE IF EXISTS `role_perm_re`;
CREATE TABLE `role_perm_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `perm_id` bigint(20) NOT NULL COMMENT '权限ID',
  `perm_type` tinyint(1) NOT NULL COMMENT '0可访问 1可授权',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_grade
-- ----------------------------
DROP TABLE IF EXISTS `test_grade`;
CREATE TABLE `test_grade`  (
  `tid` bigint(20) NOT NULL,
  `grade_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for test_user
-- ----------------------------
DROP TABLE IF EXISTS `test_user`;
CREATE TABLE `test_user`  (
  `tid` bigint(20) NOT NULL COMMENT '主键',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `grade_id` bigint(20) NULL DEFAULT NULL COMMENT '1\r\n            2\r\n            3',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_user
-- ----------------------------
INSERT INTO `test_user` VALUES (0, '超123', 12, 8);
INSERT INTO `test_user` VALUES (2, '大卫', 333, 8);
INSERT INTO `test_user` VALUES (656447984761831424, '王思聪2222', 30, 8);
INSERT INTO `test_user` VALUES (656447990101180416, '王思聪0', 2016963008, 8);
INSERT INTO `test_user` VALUES (656447990466084864, '王思聪1', 681934408, 8);
INSERT INTO `test_user` VALUES (656447990830989312, '王思聪2', -1256163266, 8);
INSERT INTO `test_user` VALUES (656447991195893760, '王思聪3', -1929310864, 8);
INSERT INTO `test_user` VALUES (656447991560798208, '王思聪4', 576517683, 8);
INSERT INTO `test_user` VALUES (656447991934091264, '王思聪5', -1161213526, 8);
INSERT INTO `test_user` VALUES (656447992290607104, '王思聪6', 1446745618, 8);
INSERT INTO `test_user` VALUES (656447992651317248, '王思聪7', 1531413872, 8);
INSERT INTO `test_user` VALUES (656447993007833088, '王思聪8', 576238773, 8);
INSERT INTO `test_user` VALUES (656447993368543232, '王思聪9', 953335810, 8);
INSERT INTO `test_user` VALUES (656447993729253376, '王思聪10', -521733025, 8);
INSERT INTO `test_user` VALUES (656447994089963520, '王思聪11', -1437186082, 8);
INSERT INTO `test_user` VALUES (656447994459062272, '王思聪12', 950863042, 8);
INSERT INTO `test_user` VALUES (656447994815578112, '王思聪13', -2056389664, 8);
INSERT INTO `test_user` VALUES (656447995180482560, '王思聪14', -375867547, 8);
INSERT INTO `test_user` VALUES (656447995549581312, '王思聪15', 460430945, 8);
INSERT INTO `test_user` VALUES (656447995952234496, '王思聪16', 2059379859, 8);
INSERT INTO `test_user` VALUES (656447996312944640, '王思聪17', -337211946, 8);
INSERT INTO `test_user` VALUES (656447996673654784, '王思聪18', 264131114, 8);
INSERT INTO `test_user` VALUES (656447997038559232, '王思聪19', 165267751, 8);
INSERT INTO `test_user` VALUES (656447997403463680, '王思聪20', 1115250512, 8);
INSERT INTO `test_user` VALUES (656447997764173824, '王思聪21', -1674186836, 8);
INSERT INTO `test_user` VALUES (656447998124883968, '王思聪22', -263662137, 8);
INSERT INTO `test_user` VALUES (656447998489788416, '王思聪23', 995850086, 8);
INSERT INTO `test_user` VALUES (656447998863081472, '王思聪24', 1152351782, 8);
INSERT INTO `test_user` VALUES (656447999223791616, '王思聪25', -1895580186, 8);
INSERT INTO `test_user` VALUES (656447999584501760, '王思聪26', -1932579068, 8);
INSERT INTO `test_user` VALUES (656447999945211904, '王思聪27', 698353763, 8);
INSERT INTO `test_user` VALUES (656448000310116352, '王思聪28', -633198786, 8);
INSERT INTO `test_user` VALUES (656448000691798016, '王思聪29', 2070617534, 8);
INSERT INTO `test_user` VALUES (656448001052508160, '王思聪30', -1301057269, 8);
INSERT INTO `test_user` VALUES (656448001413218304, '王思聪31', 1660282543, 8);
INSERT INTO `test_user` VALUES (656448001778122752, '王思聪32', 1074793561, 8);
INSERT INTO `test_user` VALUES (656448002147221504, '王思聪33', -276188106, 8);
INSERT INTO `test_user` VALUES (656448002503737344, '王思聪34', -24207612, 8);
INSERT INTO `test_user` VALUES (656448002864447488, '王思聪35', 2052363449, 8);
INSERT INTO `test_user` VALUES (656448003220963328, '王思聪36', -1159412331, 8);
INSERT INTO `test_user` VALUES (656448003581673472, '王思聪37', -1689218098, 8);
INSERT INTO `test_user` VALUES (656448003938189312, '王思聪38', -265019095, 8);
INSERT INTO `test_user` VALUES (656448004298899456, '王思聪39', -2099644149, 8);
INSERT INTO `test_user` VALUES (656448004659609600, '王思聪40', 75999057, 8);
INSERT INTO `test_user` VALUES (656448005020319744, '王思聪41', -375434028, 8);
INSERT INTO `test_user` VALUES (656448005385224192, '王思聪42', -1619109529, 8);
INSERT INTO `test_user` VALUES (656448005741740032, '王思聪43', -175647216, 8);
INSERT INTO `test_user` VALUES (656448006102450176, '王思聪44', -427832159, 8);
INSERT INTO `test_user` VALUES (656448006471548928, '王思聪45', 931099782, 8);
INSERT INTO `test_user` VALUES (656448006886785024, '王思聪46', 1307691150, 8);
INSERT INTO `test_user` VALUES (656448007247495168, '王思聪47', -307520452, 8);
INSERT INTO `test_user` VALUES (656448007620788224, '王思聪48', 1528577676, 8);
INSERT INTO `test_user` VALUES (656448007981498368, '王思聪49', 699318475, 8);
INSERT INTO `test_user` VALUES (656448008346402816, '王思聪50', -1678460845, 8);
INSERT INTO `test_user` VALUES (656448008707112960, '王思聪51', -1042062917, 8);
INSERT INTO `test_user` VALUES (656448009067823104, '王思聪52', 63304943, 8);
INSERT INTO `test_user` VALUES (656448009428533248, '王思聪53', -1252265649, 8);
INSERT INTO `test_user` VALUES (656448009789243392, '王思聪54', -1080579742, 8);
INSERT INTO `test_user` VALUES (656448010149953536, '王思聪55', 515651531, 8);
INSERT INTO `test_user` VALUES (656448010506469376, '王思聪56', -721861540, 8);
INSERT INTO `test_user` VALUES (656448010867179520, '王思聪57', -499953250, 8);
INSERT INTO `test_user` VALUES (656448011223695360, '王思聪58', -1503163531, 8);
INSERT INTO `test_user` VALUES (656448011601182720, '王思聪59', 1409158197, 8);
INSERT INTO `test_user` VALUES (656448011961892864, '王思聪60', 1801994054, 8);
INSERT INTO `test_user` VALUES (656448012318408704, '王思聪61', 1651125293, 8);
INSERT INTO `test_user` VALUES (656448012679118848, '王思聪62', -820948434, 8);
INSERT INTO `test_user` VALUES (656448013039828992, '王思聪63', 2035781244, 8);
INSERT INTO `test_user` VALUES (656448013400539136, '王思聪64', -405413255, 8);
INSERT INTO `test_user` VALUES (656448013761249280, '王思聪65', 1454532059, 8);
INSERT INTO `test_user` VALUES (656448014117765120, '王思聪66', -1026656211, 8);
INSERT INTO `test_user` VALUES (656448014486863872, '王思聪67', 1982425552, 8);
INSERT INTO `test_user` VALUES (656448014847574016, '王思聪68', 1816400198, 8);
INSERT INTO `test_user` VALUES (656448015229255680, '王思聪69', -579955087, 8);
INSERT INTO `test_user` VALUES (656448015585771520, '王思聪70', -498553807, 8);
INSERT INTO `test_user` VALUES (656448015946481664, '王思聪71', 1833795353, 8);
INSERT INTO `test_user` VALUES (656448016307191808, '王思聪72', -1547473928, 8);
INSERT INTO `test_user` VALUES (656448016667901952, '王思聪73', -1965961428, 8);
INSERT INTO `test_user` VALUES (656448017032806400, '王思聪74', -428746351, 8);
INSERT INTO `test_user` VALUES (656448017393516544, '王思聪75', -2077247447, 8);
INSERT INTO `test_user` VALUES (656448017754226688, '王思聪76', -1942829217, 8);
INSERT INTO `test_user` VALUES (656448018119131136, '王思聪77', -902311722, 8);
INSERT INTO `test_user` VALUES (656448018496618496, '王思聪78', -2089312458, 8);
INSERT INTO `test_user` VALUES (656448018886688768, '王思聪79', -904630368, 8);
INSERT INTO `test_user` VALUES (656448019343867904, '王思聪80', 11763512, 8);
INSERT INTO `test_user` VALUES (656448019759104000, '王思聪81', 136565262, 8);
INSERT INTO `test_user` VALUES (656448020203700224, '王思聪82', 743915043, 8);
INSERT INTO `test_user` VALUES (656448020572798976, '王思聪83', -651465845, 8);
INSERT INTO `test_user` VALUES (656448020941897728, '王思聪84', -485431268, 8);
INSERT INTO `test_user` VALUES (656448021315190784, '王思聪85', -1917570194, 8);
INSERT INTO `test_user` VALUES (656448021717843968, '王思聪86', -1080317937, 8);
INSERT INTO `test_user` VALUES (656448022082748416, '王思聪87', -610609322, 8);
INSERT INTO `test_user` VALUES (656448022447652864, '王思聪88', -1404008851, 8);
INSERT INTO `test_user` VALUES (656448022825140224, '王思聪89', -618807301, 8);
INSERT INTO `test_user` VALUES (656448023198433280, '王思聪90', -1420016308, 8);
INSERT INTO `test_user` VALUES (656448023563337728, '王思聪91', 1803285020, 8);
INSERT INTO `test_user` VALUES (656448023928242176, '王思聪92', -1846842191, 8);
INSERT INTO `test_user` VALUES (656448024293146624, '王思聪93', -666981741, 8);
INSERT INTO `test_user` VALUES (656448024662245376, '王思聪94', -445086196, 8);
INSERT INTO `test_user` VALUES (656448025027149824, '王思聪95', 1779415331, 8);
INSERT INTO `test_user` VALUES (656448025392054272, '王思聪96', -398736310, 8);
INSERT INTO `test_user` VALUES (656448025756958720, '王思聪97', -1779826403, 8);
INSERT INTO `test_user` VALUES (656448026126057472, '王思聪98', -1456569076, 8);
INSERT INTO `test_user` VALUES (656448026486767616, '王思聪99', 1061436847, 8);

-- ----------------------------
-- Table structure for user_perm_re
-- ----------------------------
DROP TABLE IF EXISTS `user_perm_re`;
CREATE TABLE `user_perm_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `perm_id` bigint(20) NOT NULL COMMENT '权限ID',
  `perm_type` tinyint(1) NOT NULL COMMENT '0可访问 1可授权',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-权限关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role_re
-- ----------------------------
DROP TABLE IF EXISTS `user_role_re`;
CREATE TABLE `user_role_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for verification_token
-- ----------------------------
DROP TABLE IF EXISTS `verification_token`;
CREATE TABLE `verification_token`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'TOKEN',
  `expiry_date` datetime(0) NULL DEFAULT NULL COMMENT '失效日期',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '会员邮件注册激活验证表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
