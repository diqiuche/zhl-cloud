/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : j2ee_demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-04-01 17:08:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `j_rolegroup`
-- ----------------------------
DROP TABLE IF EXISTS `j_rolegroup`;
CREATE TABLE `j_rolegroup` (
  `id` bigint(15) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `group_id` bigint(15) NOT NULL DEFAULT '0' COMMENT '用户组编号',
  `role_id` bigint(15) NOT NULL DEFAULT '0' COMMENT '用户编号',
  PRIMARY KEY (`id`),
  KEY `fk_j_usergroup_0` (`group_id`),
  KEY `fk_j_usergroup_1` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_rolegroup
-- ----------------------------
ALTER TABLE `j_group`
ADD COLUMN `model`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '系统模块',
ADD COLUMN `tag`  bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义';

ALTER TABLE `j_role`
ADD COLUMN `model`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '系统模块',
ADD COLUMN `tag`  bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义';

ALTER TABLE `j_funclist`
ADD COLUMN `model`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '系统模块',
ADD COLUMN `tag`  bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义';

-- ----------------------------
-- Records of j_usergroup
-- ----------------------------
