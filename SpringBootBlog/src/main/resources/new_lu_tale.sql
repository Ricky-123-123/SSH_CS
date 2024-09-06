/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : lu_tale

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2024-09-02 10:00:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_attach`
-- ----------------------------
DROP TABLE IF EXISTS `t_attach`;
CREATE TABLE `t_attach` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) NOT NULL DEFAULT '',
  `ftype` varchar(50) DEFAULT '',
  `fkey` text NOT NULL,
  `authorId` int(10) DEFAULT NULL,
  `created` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_attach
-- ----------------------------
INSERT INTO `t_attach` VALUES ('7', '222', '222', '222', '2', '1724738271');
INSERT INTO `t_attach` VALUES ('9', '123', '123', '123', null, '1724739528');

-- ----------------------------
-- Table structure for `t_comments`
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `coid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cid` int(10) unsigned DEFAULT '0',
  `created` int(10) unsigned DEFAULT '0',
  `author` varchar(200) DEFAULT NULL,
  `authorId` int(10) unsigned DEFAULT '0',
  `ownerId` int(10) unsigned DEFAULT '0',
  `mail` varchar(200) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `ip` varchar(64) DEFAULT NULL,
  `agent` varchar(200) DEFAULT NULL,
  `content` text,
  `type` varchar(16) DEFAULT 'comment',
  `status` varchar(16) DEFAULT 'approved',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`coid`) USING BTREE,
  KEY `cid` (`cid`) USING BTREE,
  KEY `created` (`created`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_comments
-- ----------------------------
INSERT INTO `t_comments` VALUES ('4', '34', '0', '222', '0', '0', null, null, null, null, '222', 'comment', 'approved', '0');
INSERT INTO `t_comments` VALUES ('6', '36', '1724740711', '热心网友', null, null, '1476713020@qq.com', null, null, null, '000123', null, 'not_audit', null);

-- ----------------------------
-- Table structure for `t_contents`
-- ----------------------------
DROP TABLE IF EXISTS `t_contents`;
CREATE TABLE `t_contents` (
  `cid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `titlePic` varchar(55) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `modified` int(10) unsigned DEFAULT '0',
  `content` text COMMENT '内容文字',
  `authorId` int(10) unsigned DEFAULT '0',
  `type` varchar(16) DEFAULT 'post',
  `status` varchar(16) DEFAULT 'publish',
  `tags` varchar(200) DEFAULT NULL,
  `categories` varchar(200) DEFAULT NULL,
  `hits` int(10) unsigned DEFAULT '0',
  `commentsNum` int(10) unsigned DEFAULT '0',
  `allowComment` tinyint(1) DEFAULT '1',
  `allowPing` tinyint(1) DEFAULT '1',
  `allowFeed` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`cid`) USING BTREE,
  UNIQUE KEY `slug` (`slug`) USING BTREE,
  KEY `created` (`created`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_contents
-- ----------------------------
INSERT INTO `t_contents` VALUES ('34', '333', null, null, '1724736541', '1724752088', '333', null, 'post', 'publish', '123', '默认分类', '1', '0', '1', null, null);
INSERT INTO `t_contents` VALUES ('36', '555', null, null, '1724738183', '1724752088', '555', null, 'post', 'publish', '666', '默认分类', '1', '1', '1', null, null);
INSERT INTO `t_contents` VALUES ('37', '456', null, null, '1724738271', '0', '456', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_contents` VALUES ('38', '456', null, null, '1724752088', '0', '456', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_course`
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `courseid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `titlePic` varchar(55) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `modified` int(10) unsigned DEFAULT '0',
  `content` text COMMENT '内容文字',
  `authorId` int(10) unsigned DEFAULT '0',
  `type` varchar(16) DEFAULT 'post',
  `status` varchar(16) DEFAULT 'publish',
  `tags` varchar(200) DEFAULT NULL,
  `categories` varchar(200) DEFAULT NULL,
  `hits` int(10) unsigned DEFAULT '0',
  `commentsNum` int(10) unsigned DEFAULT '0',
  `allowComment` tinyint(1) DEFAULT '1',
  `allowPing` tinyint(1) DEFAULT '1',
  `allowFeed` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`courseid`) USING BTREE,
  UNIQUE KEY `slug` (`slug`) USING BTREE,
  KEY `created` (`created`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('34', '333', null, null, '0', '0', '333', '0', 'post', 'publish', '666', '默认分类', '0', '0', '1', '1', '1');
INSERT INTO `t_course` VALUES ('35', '444', null, null, '0', '0', '444', '0', 'post', 'publish', '123', '默认分类', '0', '0', '1', '1', '1');
INSERT INTO `t_course` VALUES ('37', '123222', null, null, '1724817036', '1724817059', '22444123', null, 'photo', 'publish', '', '默认分类', '1', '0', '1', null, null);

-- ----------------------------
-- Table structure for `t_logs`
-- ----------------------------
DROP TABLE IF EXISTS `t_logs`;
CREATE TABLE `t_logs` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `action` varchar(100) DEFAULT NULL COMMENT '事件',
  `data` varchar(2000) DEFAULT NULL COMMENT '数据',
  `authorId` int(10) DEFAULT NULL COMMENT '作者编号',
  `ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `created` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=208 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_logs
-- ----------------------------
INSERT INTO `t_logs` VALUES ('184', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724724293');
INSERT INTO `t_logs` VALUES ('185', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724724308');
INSERT INTO `t_logs` VALUES ('186', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724724490');
INSERT INTO `t_logs` VALUES ('187', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724724549');
INSERT INTO `t_logs` VALUES ('188', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724724553');
INSERT INTO `t_logs` VALUES ('189', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724725384');
INSERT INTO `t_logs` VALUES ('190', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724730339');
INSERT INTO `t_logs` VALUES ('191', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724736474');
INSERT INTO `t_logs` VALUES ('192', '123', '123', '1', '123', '1724740973');
INSERT INTO `t_logs` VALUES ('193', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724743470');
INSERT INTO `t_logs` VALUES ('194', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724743519');
INSERT INTO `t_logs` VALUES ('195', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724813040');
INSERT INTO `t_logs` VALUES ('196', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814422');
INSERT INTO `t_logs` VALUES ('197', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814426');
INSERT INTO `t_logs` VALUES ('198', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814432');
INSERT INTO `t_logs` VALUES ('199', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814438');
INSERT INTO `t_logs` VALUES ('200', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814440');
INSERT INTO `t_logs` VALUES ('201', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814444');
INSERT INTO `t_logs` VALUES ('202', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724814469');
INSERT INTO `t_logs` VALUES ('203', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724815915');
INSERT INTO `t_logs` VALUES ('204', '删除文章', '36', '1', '0:0:0:0:0:0:0:1', '1724815937');
INSERT INTO `t_logs` VALUES ('205', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724816082');
INSERT INTO `t_logs` VALUES ('206', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724816085');
INSERT INTO `t_logs` VALUES ('207', '登录后台', 'admin用户', '1', '0:0:0:0:0:0:0:1', '1724821341');

-- ----------------------------
-- Table structure for `t_metas`
-- ----------------------------
DROP TABLE IF EXISTS `t_metas`;
CREATE TABLE `t_metas` (
  `mid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `slug` varchar(200) DEFAULT NULL,
  `type` varchar(32) NOT NULL DEFAULT '',
  `contentType` varchar(32) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `sort` int(10) unsigned DEFAULT '0',
  `parent` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`mid`) USING BTREE,
  KEY `slug` (`slug`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_metas
-- ----------------------------
INSERT INTO `t_metas` VALUES ('49', '123', '123', 'tag', null, null, null, null);
INSERT INTO `t_metas` VALUES ('50', '默认分类', '默认分类', 'category', null, null, null, null);
INSERT INTO `t_metas` VALUES ('51', '222', '222', 'tag', null, null, null, null);
INSERT INTO `t_metas` VALUES ('52', '555', '555', 'tag', null, null, null, null);
INSERT INTO `t_metas` VALUES ('54', '234', null, 'tag', null, null, null, null);
INSERT INTO `t_metas` VALUES ('55', '88667', null, 'tag', null, null, null, null);
INSERT INTO `t_metas` VALUES ('56', '333', '333', 'tag', null, null, null, null);
INSERT INTO `t_metas` VALUES ('57', '666', '666', 'tag', null, null, null, null);

-- ----------------------------
-- Table structure for `t_options`
-- ----------------------------
DROP TABLE IF EXISTS `t_options`;
CREATE TABLE `t_options` (
  `name` varchar(32) NOT NULL DEFAULT '',
  `value` varchar(1000) DEFAULT '',
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_options
-- ----------------------------
INSERT INTO `t_options` VALUES ('123', '345', null);
INSERT INTO `t_options` VALUES ('site_description', '', null);
INSERT INTO `t_options` VALUES ('site_record', '无', null);
INSERT INTO `t_options` VALUES ('site_title', 'Seiryo', 'Seiryo');
INSERT INTO `t_options` VALUES ('social_csdn', '', null);
INSERT INTO `t_options` VALUES ('social_github', '', null);
INSERT INTO `t_options` VALUES ('social_jianshu', 'https://www.jianshu.com/', null);
INSERT INTO `t_options` VALUES ('social_resume', '', null);
INSERT INTO `t_options` VALUES ('social_twitter', '', null);
INSERT INTO `t_options` VALUES ('social_weibo', 'https://weibo.com/', null);
INSERT INTO `t_options` VALUES ('social_zhihu', 'https://www.zhihu.com/', null);

-- ----------------------------
-- Table structure for `t_relationships`
-- ----------------------------
DROP TABLE IF EXISTS `t_relationships`;
CREATE TABLE `t_relationships` (
  `cid` int(10) unsigned NOT NULL,
  `mid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`cid`,`mid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_relationships
-- ----------------------------
INSERT INTO `t_relationships` VALUES ('27', '41');
INSERT INTO `t_relationships` VALUES ('27', '42');
INSERT INTO `t_relationships` VALUES ('27', '43');
INSERT INTO `t_relationships` VALUES ('27', '46');
INSERT INTO `t_relationships` VALUES ('28', '41');
INSERT INTO `t_relationships` VALUES ('28', '43');
INSERT INTO `t_relationships` VALUES ('29', '41');
INSERT INTO `t_relationships` VALUES ('29', '42');
INSERT INTO `t_relationships` VALUES ('29', '43');
INSERT INTO `t_relationships` VALUES ('30', '48');
INSERT INTO `t_relationships` VALUES ('31', '48');
INSERT INTO `t_relationships` VALUES ('32', '41');
INSERT INTO `t_relationships` VALUES ('32', '43');
INSERT INTO `t_relationships` VALUES ('33', '48');
INSERT INTO `t_relationships` VALUES ('34', '49');
INSERT INTO `t_relationships` VALUES ('34', '50');
INSERT INTO `t_relationships` VALUES ('37', '50');

-- ----------------------------
-- Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `uid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `homeUrl` varchar(200) DEFAULT NULL,
  `screenName` varchar(32) DEFAULT NULL,
  `created` int(10) unsigned DEFAULT '0',
  `activated` int(10) unsigned DEFAULT '0',
  `logged` int(10) unsigned DEFAULT '0',
  `groupName` varchar(16) DEFAULT 'visitor',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE KEY `name` (`username`) USING BTREE,
  UNIQUE KEY `mail` (`email`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of t_users
-- ----------------------------
INSERT INTO `t_users` VALUES ('1', 'admin', 'a66abb5684c45962d887564f08346e8d', '864655735@qq.com', null, 'admin', '1490756162', '0', '0', 'visitor');
INSERT INTO `t_users` VALUES ('2', '123', '456', '123@qq.com', null, null, '0', '0', '0', 'visitor');
