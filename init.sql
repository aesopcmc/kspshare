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

 Date: 13/11/2019 22:34:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ksp_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `ksp_admin_user`;
CREATE TABLE `ksp_admin_user`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登录名',
  `realname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户登录密码',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是可以登录 true1启用 false0禁用',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台管理用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ksp_perm
-- ----------------------------
DROP TABLE IF EXISTS `ksp_perm`;
CREATE TABLE `ksp_perm`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `perm_value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限值',
  `perm_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父主键',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ksp_role
-- ----------------------------
DROP TABLE IF EXISTS `ksp_role`;
CREATE TABLE `ksp_role`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名，用于权限校验',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色中文名，用于显示',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述信息',
  `banned` tinyint(1) NOT NULL DEFAULT 0 COMMENT '角色状态，是否已禁用 0启用 1禁用',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ksp_role_perm_re
-- ----------------------------
DROP TABLE IF EXISTS `ksp_role_perm_re`;
CREATE TABLE `ksp_role_perm_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `perm_id` bigint(20) NOT NULL COMMENT '权限主键',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ksp_user
-- ----------------------------
DROP TABLE IF EXISTS `ksp_user`;
CREATE TABLE `ksp_user`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '身份权限',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是可以登录 true1启用 false0禁用',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '论坛用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ksp_user_role_re
-- ----------------------------
DROP TABLE IF EXISTS `ksp_user_role_re`;
CREATE TABLE `ksp_user_role_re`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色主键',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户-角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ksp_verification_token
-- ----------------------------
DROP TABLE IF EXISTS `ksp_verification_token`;
CREATE TABLE `ksp_verification_token`  (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'TOKEN',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `expiry_date` datetime(0) NULL DEFAULT NULL COMMENT '失效日期',
  PRIMARY KEY (`oid`) USING BTREE,
  UNIQUE INDEX `token`(`token`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

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

SET FOREIGN_KEY_CHECKS = 1;
