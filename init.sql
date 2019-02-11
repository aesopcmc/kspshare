CREATE DATABASE ksp;

## 测试表 ##

DROP TABLE IF EXISTS  `test_grade`;
CREATE TABLE `test_grade` (
  `tid` bigint(20) NOT NULL,
  `grade_name` varchar(20) DEFAULT NULL,
  `grade_code` varchar(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS  `test_grade`;
CREATE TABLE `test_user` (
  `tid` bigint(20) NOT NULL COMMENT '主键',
  `user_name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `grade_id` bigint(20) DEFAULT NULL COMMENT '1 2 3',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


## 论坛表 ##

# 用户表
DROP TABLE IF EXISTS  `ksp_user`;
CREATE TABLE `ksp_user` (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `username` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(100) DEFAULT NULL COMMENT '昵称',
  `roles` varchar(255) DEFAULT NULL COMMENT '身份权限',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `enabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是可以登录 true1启用 false0禁用',
  PRIMARY KEY (`oid`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

# 邮件校验
DROP TABLE IF EXISTS  `ksp_verification_token`;
CREATE TABLE `ksp_verification_token` (
  `oid` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户主键',
  `token` varchar(255) NOT NULL COMMENT 'TOKEN',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `expiry_date` datetime DEFAULT NULL COMMENT '失效时间',
  PRIMARY KEY (`oid`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;