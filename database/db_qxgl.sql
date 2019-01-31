/*
Navicat MySQL Data Transfer

Source Server         : keshe
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : db_qxgl

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-12-25 11:27:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_permissions
-- ----------------------------
DROP TABLE IF EXISTS `tb_permissions`;
CREATE TABLE `tb_permissions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_permissions
-- ----------------------------
INSERT INTO `tb_permissions` VALUES ('1', '1', '1');
INSERT INTO `tb_permissions` VALUES ('2', '2', '2');
INSERT INTO `tb_permissions` VALUES ('3', '3', '3');
INSERT INTO `tb_permissions` VALUES ('4', '啊啊啊', '啊啊啊');
INSERT INTO `tb_permissions` VALUES ('7', '1212', '是的发生大发 ');
INSERT INTO `tb_permissions` VALUES ('8', '阿斯顿发', '阿斯顿发');

-- ----------------------------
-- Table structure for tb_permission_resources
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission_resources`;
CREATE TABLE `tb_permission_resources` (
  `permission_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  PRIMARY KEY (`resource_id`,`permission_id`),
  KEY `tb_permission_resources_ibfk_1` (`permission_id`),
  CONSTRAINT `tb_permission_resources_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `tb_permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_permission_resources_ibfk_2` FOREIGN KEY (`resource_id`) REFERENCES `tb_resources` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_permission_resources
-- ----------------------------
INSERT INTO `tb_permission_resources` VALUES ('1', '1');
INSERT INTO `tb_permission_resources` VALUES ('1', '4');
INSERT INTO `tb_permission_resources` VALUES ('1', '6');
INSERT INTO `tb_permission_resources` VALUES ('1', '7');
INSERT INTO `tb_permission_resources` VALUES ('2', '4');
INSERT INTO `tb_permission_resources` VALUES ('2', '5');
INSERT INTO `tb_permission_resources` VALUES ('3', '6');
INSERT INTO `tb_permission_resources` VALUES ('3', '7');

-- ----------------------------
-- Table structure for tb_resources
-- ----------------------------
DROP TABLE IF EXISTS `tb_resources`;
CREATE TABLE `tb_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_resources
-- ----------------------------
INSERT INTO `tb_resources` VALUES ('1', '123', '。id');
INSERT INTO `tb_resources` VALUES ('4', '百度', 'http://www.baidu.com');
INSERT INTO `tb_resources` VALUES ('5', '必应', 'http://cn.bing.com');
INSERT INTO `tb_resources` VALUES ('6', '163', '0');
INSERT INTO `tb_resources` VALUES ('7', 'layui', 'https://www.layui.com');
INSERT INTO `tb_resources` VALUES ('8', '22', '22');
INSERT INTO `tb_resources` VALUES ('10', '33', '33');

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '管理员');
INSERT INTO `tb_role` VALUES ('2', '哈哈哈');
INSERT INTO `tb_role` VALUES ('27', '是打发');
INSERT INTO `tb_role` VALUES ('28', '是打发阿斯顿发');
INSERT INTO `tb_role` VALUES ('29', '是是是 ');
INSERT INTO `tb_role` VALUES ('30', '烦烦烦');
INSERT INTO `tb_role` VALUES ('31', '阿斯顿发');

-- ----------------------------
-- Table structure for tb_role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permissions`;
CREATE TABLE `tb_role_permissions` (
  `role_id` int(11) NOT NULL,
  `permissions_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permissions_id`),
  KEY `tb_role_permissions_ibfk_2` (`permissions_id`),
  CONSTRAINT `tb_role_permissions_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_role_permissions_ibfk_2` FOREIGN KEY (`permissions_id`) REFERENCES `tb_permissions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_role_permissions
-- ----------------------------
INSERT INTO `tb_role_permissions` VALUES ('1', '1');
INSERT INTO `tb_role_permissions` VALUES ('27', '1');
INSERT INTO `tb_role_permissions` VALUES ('29', '1');
INSERT INTO `tb_role_permissions` VALUES ('30', '1');
INSERT INTO `tb_role_permissions` VALUES ('31', '1');
INSERT INTO `tb_role_permissions` VALUES ('1', '2');
INSERT INTO `tb_role_permissions` VALUES ('2', '2');
INSERT INTO `tb_role_permissions` VALUES ('30', '2');
INSERT INTO `tb_role_permissions` VALUES ('31', '2');
INSERT INTO `tb_role_permissions` VALUES ('1', '3');
INSERT INTO `tb_role_permissions` VALUES ('2', '3');
INSERT INTO `tb_role_permissions` VALUES ('30', '3');
INSERT INTO `tb_role_permissions` VALUES ('31', '3');
INSERT INTO `tb_role_permissions` VALUES ('30', '4');
INSERT INTO `tb_role_permissions` VALUES ('1', '7');
INSERT INTO `tb_role_permissions` VALUES ('30', '7');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `emal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '李俊杰', '18993338171', 'lijunjiee@163.com');
INSERT INTO `tb_user` VALUES ('5', '111111', '1616270104', '刘铁辉', '17693125015', '15754221127');
INSERT INTO `tb_user` VALUES ('7', '1616270106', '1616270106', '柳宝科', '18693250738', '18793363239');
INSERT INTO `tb_user` VALUES ('9', '1616270108', '1616270108', '白宝宝', '17361563948', '15349332233');
INSERT INTO `tb_user` VALUES ('10', '1616270109', '1616270109', '李俊杰', '18993337191', '18793326380');
INSERT INTO `tb_user` VALUES ('11', '1616270110', '1616270110', '白浩谋', '17693166798', '15002535630');
INSERT INTO `tb_user` VALUES ('12', '1616270111', '1616270111', '朱海熊', '17361563968', '15193050528');
INSERT INTO `tb_user` VALUES ('13', '1616270112', '1616270112', '张帅帅', '17361563977', '15593316723');
INSERT INTO `tb_user` VALUES ('14', '1616270113', '1616270113', '贾旺军', '17693169695', '15683975728');
INSERT INTO `tb_user` VALUES ('15', '1616270114', '1616270114', '李子哲', '18809494121', '15025995983');
INSERT INTO `tb_user` VALUES ('16', '1616270115', '1616270115', '李增强', '18894001963', '18793250036');
INSERT INTO `tb_user` VALUES ('17', '1616270116', '1616270116', '窦长兴', '18894001883', '18794955269');
INSERT INTO `tb_user` VALUES ('18', '1616270117', '1616270117', '陈学凯', '17361564011', '13399445181');
INSERT INTO `tb_user` VALUES ('19', '1616270119', '1616270119', '陈振鑫', '13369347988', '18152276788');
INSERT INTO `tb_user` VALUES ('20', '1616270120', '1616270120', '刘成发', '15769396375', '15095618455');
INSERT INTO `tb_user` VALUES ('21', '1616270121', '1616270121', '廖辘', '17361564028', '18409441706');
INSERT INTO `tb_user` VALUES ('22', '1616270122', '1616270122', '陈玉杰', '17361564033', '17693133026');
INSERT INTO `tb_user` VALUES ('23', '1616270123', '1616270123', '马良', '17361564038', '17693241801');
INSERT INTO `tb_user` VALUES ('24', '1616270124', '1616270124', '詹富德', '17361564048', '15294613610');
INSERT INTO `tb_user` VALUES ('25', '1616270125', '1616270125', '张世凯', '18419161771', '15248316773');
INSERT INTO `tb_user` VALUES ('26', '1616270126', '1616270126', '张玉林', '15773954542', '13873957425');
INSERT INTO `tb_user` VALUES ('27', '1616270127', '1616270127', '曾羿铭', '17361564066', '15773397168');
INSERT INTO `tb_user` VALUES ('28', '1616270128', '1616270128', '张宇翀', '17693462069', '18971729698');
INSERT INTO `tb_user` VALUES ('29', '1616270129', '1616270129', '程胜', '17361564077', '15971533727');
INSERT INTO `tb_user` VALUES ('30', '1616270130', '1616270130', '温在鑫', '17361564078', '15035123789');
INSERT INTO `tb_user` VALUES ('32', '1616270132', '1616270132', '王珠峰', '17361564098', '13569499121');
INSERT INTO `tb_user` VALUES ('33', '1616270134', '1616270134', '董帅帅', '18595420506', '13168816098');
INSERT INTO `tb_user` VALUES ('34', '1616270135', '1616270135', '吴秀来', '17693257089', '16602672017');
INSERT INTO `tb_user` VALUES ('35', '1616270137', '1616270137', '王云飞', '18215117867', '15194712138');
INSERT INTO `tb_user` VALUES ('36', '1616270139', '1616270139', '周宇轩', '17693192489', '13182981322');
INSERT INTO `tb_user` VALUES ('37', '1616270140', '1616270140', '林启明', '17361564133', '13044265293');
INSERT INTO `tb_user` VALUES ('38', '1616270141', '1616270141', '张沃民', '13717471498', '13702258558');
INSERT INTO `tb_user` VALUES ('39', '1616270142', '1616270142', '贾兴虎', '18295722636', '13466924387');
INSERT INTO `tb_user` VALUES ('40', '1616270143', '1616270143', '任恩亮', '17693437145', '18636421715');
INSERT INTO `tb_user` VALUES ('41', '1616270144', '1616270144', '徐泽松', '18419160081', '15275688083');
INSERT INTO `tb_user` VALUES ('42', '1616270145', '1616270145', '扈书鹏', '18394166443', '18189554248');
INSERT INTO `tb_user` VALUES ('43', '1616270146', '1616270146', '杨金权', '15760632076', '15282609322');
INSERT INTO `tb_user` VALUES ('44', '1616270147', '1616270147', '吴剑峰', '18782837159', '15775601763');
INSERT INTO `tb_user` VALUES ('45', '1616270148', '1616270148', '彭宏', '17729855856', '17729855896');
INSERT INTO `tb_user` VALUES ('46', '1616270149', '1616270149', '李宇晨', '15294145208', '13944578367');
INSERT INTO `tb_user` VALUES ('47', '1616270150', '1616270150', '王禹臻', '17693251015', '13089244865');
INSERT INTO `tb_user` VALUES ('48', '1616270151', '1616270151', '王雪梅', '17361564199', '13195924807');
INSERT INTO `tb_user` VALUES ('49', '1616270152', '1616270152', '蔡文婷', '17739897233', '18696097604');
INSERT INTO `tb_user` VALUES ('50', '1616270153', '1616270153', '刘依琳', '17361564208', '15339791177');
INSERT INTO `tb_user` VALUES ('51', '1616270154', '1616270154', '李嘉新', '18894002949', '13993260969');
INSERT INTO `tb_user` VALUES ('52', '1616270155', '1616270155', '薛媛', '17361564211', '15095665194');
INSERT INTO `tb_user` VALUES ('53', '1616270156', '1616270156', '杨婷玉', '17361564218', '13321217085');
INSERT INTO `tb_user` VALUES ('54', '1616270157', '1616270157', '丁雪纯', '13659413857', '17693170195');
INSERT INTO `tb_user` VALUES ('55', '1616270158', '1616270158', '张佳敏', '18234724623', '13111116509');
INSERT INTO `tb_user` VALUES ('56', '1616270159', '1616270159', '刘思盈', '17361564234', '13754689007');
INSERT INTO `tb_user` VALUES ('57', '1616270160', '1616270160', '孙梦媛', '17693474044', '15948462836');
INSERT INTO `tb_user` VALUES ('58', '1607550160', '1607550160', '曹倩', '17361566986', '15972293229');
INSERT INTO `tb_user` VALUES ('60', '1603430130', '1603430130', '赵子初', '18263603002', '15165678617');
INSERT INTO `tb_user` VALUES ('61', '1601110144', '1601110144', '刘宏望', '17361565141', '13994550468');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `tb_user_role_ibfk_1` (`user_id`),
  CONSTRAINT `tb_user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('5', '2');
