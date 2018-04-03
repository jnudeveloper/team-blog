/*
Navicat MySQL Data Transfer

Source Server         : db1
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : team_blog_article

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-04-03 23:32:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('1');
INSERT INTO `hibernate_sequence` VALUES ('1');

-- ----------------------------
-- Table structure for `tb_article_tag`
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_tag`;
CREATE TABLE `tb_article_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtnsyb8an3cxm08mm1v7xt7bjx` (`tag_id`),
  KEY `FKq1n0b8cf83uy048159jj7yry` (`article_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_article_tag
-- ----------------------------
INSERT INTO `tb_article_tag` VALUES ('1', '1', '1');
INSERT INTO `tb_article_tag` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for `t_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `summary` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `like_num` int(11) NOT NULL DEFAULT '0',
  `read_num` int(11) NOT NULL DEFAULT '0',
  `status` int(11) NOT NULL DEFAULT '0',
  `order` smallint(4) NOT NULL DEFAULT '0',
  `post_time` datetime DEFAULT NULL,
  `createt_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '1', 'article1', 'a1', 'article111', '0', '0', '0', '0', '0', null, '2018-04-01 16:28:38', '2018-04-01 16:28:38', '0');
INSERT INTO `t_article` VALUES ('2', '1', 'article2', 'a2', 'article222', '0', '0', '0', '0', '0', null, '2018-04-01 16:31:35', '2018-04-01 16:31:35', '0');
INSERT INTO `t_article` VALUES ('3', '1', 'article3', 'a3', 'article333', '0', '0', '0', '0', '0', null, '2018-04-01 17:21:57', '2018-04-01 17:21:57', '0');

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `commenter_id` bigint(20) NOT NULL,
  `article_id` bigint(20) NOT NULL,
  `commenter_name` varchar(40) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `text` text NOT NULL,
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0',
  `createt_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `author_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '1', '1', 'user01', null, '1', '0', '2018-04-03 21:57:32', '2018-04-03 21:57:32', null);

-- ----------------------------
-- Table structure for `t_tag`
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES ('1', 'tag1');
INSERT INTO `t_tag` VALUES ('2', 'tag2');
