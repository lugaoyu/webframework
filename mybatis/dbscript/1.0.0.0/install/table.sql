/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50529
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50529
File Encoding         : 65001

Date: 2018-03-30 16:42:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- create database
-- ----------------------------
CREATE DATABASE mybatis DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryname` varchar(255) DEFAULT NULL,
  `countrycode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', '中国', 'CN');
INSERT INTO `country` VALUES ('2', '美国', 'US');
INSERT INTO `country` VALUES ('3', '俄罗斯', 'RU');
INSERT INTO `country` VALUES ('4', '英国', 'GB');
INSERT INTO `country` VALUES ('5', '法国', 'FR');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` bigint(20) NOT NULL,
  `privilege_name` varchar(255) DEFAULT NULL,
  `privilege_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `create_by` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `role_id` bigint(20) DEFAULT NULL,
  `privilege_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_info` text,
  `head_img` blob,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

INSERT INTO sys_user VALUES ('1','admin','123456','admin@mybatis.tk','管理员',null,'2016-04-01 17:00:58');
INSERT INTO sys_user VALUES ('1001','test','123456','test@mybatis.tk','测试用户',null,'2016-04-01 17:01:52');

INSERT INTO sys_role VALUES ('1','管理员','1','1','2016-04-01 17:02:14');
INSERT INTO sys_role VALUES ('2','普通用户','1','1','2016-04-01 17:02:34');

INSERT INTO sys_user_role VALUES ('1','1');
INSERT INTO sys_user_role VALUES ('1','2');
INSERT INTO sys_user_role VALUES ('1001','2');

INSERT INTO sys_privilege VALUES ('1','用户管理','/users');
INSERT INTO sys_privilege VALUES ('2','角色管理','/roles');
INSERT INTO sys_privilege VALUES ('3','系统日志','/logs');
INSERT INTO sys_privilege VALUES ('4','人员维护','/persons');
INSERT INTO sys_privilege VALUES ('5','单位维护','/companies');

INSERT INTO sys_role_privilege VALUES('1','1');
INSERT INTO sys_role_privilege VALUES('1','3');
INSERT INTO sys_role_privilege VALUES('1','2');
INSERT INTO sys_role_privilege VALUES('2','4');
INSERT INTO sys_role_privilege VALUES('2','5');


