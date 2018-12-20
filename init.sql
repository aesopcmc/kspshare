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
`oid` BIGINT ( 20 ) NOT NULL COMMENT '主键',
`username` VARCHAR ( 50 ) DEFAULT NULL COMMENT '账号',
`password` VARCHAR ( 50 ) DEFAULT NULL COMMENT '密码',
`nickname` VARCHAR ( 100 ) COMMENT '昵称',
`roles` VARCHAR ( 255 ) DEFAULT NULL COMMENT '身份',
PRIMARY KEY ( `oid` )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

