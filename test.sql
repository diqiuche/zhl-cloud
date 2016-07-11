SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `zhl_country`
-- ----------------------------
DROP TABLE IF EXISTS `zhl_country`;
CREATE TABLE `zhl_country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `ccode` varchar(56) NOT NULL DEFAULT ' ' COMMENT '编号',
  `cname` varchar(32) NOT NULL DEFAULT ' ' COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhl_country
-- ----------------------------
INSERT INTO `zhl_country` VALUES ('1', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('2', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('3', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('4', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('5', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('6', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('7', '1000', 'china');
INSERT INTO `zhl_country` VALUES ('8', '1000', 'china');

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

ALTER TABLE `j_rolegroup`
ADD COLUMN `model`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '系统模块',
ADD COLUMN `tag`  bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义';



-- ----------------------------
-- Records of j_usergroup
-- ----------------------------
-- ----------------------------
-- Table structure for `r_group`
-- ----------------------------
DROP TABLE IF EXISTS `r_group`;
CREATE TABLE `r_group` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `UserId` bigint(20) NOT NULL COMMENT '创建人',
  `ClassId` bigint(20) NOT NULL DEFAULT '0' COMMENT '班级id',
  `SchoolId` bigint(20) NOT NULL DEFAULT '0' COMMENT '学校id',
  `Name` char(100) NOT NULL DEFAULT '' COMMENT '小组名称',
  `ChkTime` datetime NOT NULL DEFAULT '2012-06-30 00:00:00' COMMENT '审核通过时间',
  `Flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除，0-----否；1------是',
  `model` varchar(32) NOT NULL DEFAULT ' ' COMMENT '系统模块',
  `tag` bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义',
  PRIMARY KEY (`Id`),
  KEY `group_IDX1` (`UserId`),
  KEY `group_IDX2` (`ClassId`),
  KEY `group_IDX3` (`SchoolId`)
) ENGINE=InnoDB AUTO_INCREMENT=3340106 DEFAULT CHARSET=utf8 COMMENT='角色用的小组表（r_group）';

-- ----------------------------
-- Records of r_group
-- ----------------------------

-- ----------------------------
-- Table structure for `r_groupuser`
-- ----------------------------
DROP TABLE IF EXISTS `r_groupuser`;
CREATE TABLE `r_groupuser` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `UserId` bigint(20) NOT NULL COMMENT '用户id',
  `GroupId` bigint(20) NOT NULL COMMENT '小组id',
  `Flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除；0------否；1-----是',
  PRIMARY KEY (`Id`),
  KEY `j_groupuser_idx1` (`GroupId`)
) ENGINE=InnoDB AUTO_INCREMENT=20740126 DEFAULT CHARSET=utf8 COMMENT='用户角色分组表（r_group_User）';

ALTER TABLE `r_groupuser`
ADD COLUMN `model`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '系统模块',
ADD COLUMN `tag`  bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义';

ALTER TABLE `j_roleconfig`
ADD COLUMN `model`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT ' ' COMMENT '系统模块',
ADD COLUMN `tag`  bit(1) NOT NULL DEFAULT b'0' COMMENT '0-公共,1-子系统自定义';
