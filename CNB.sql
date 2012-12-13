/*
 Navicat Premium Data Transfer

 Source Server         : MySql_InMyMacBook
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost
 Source Database       : CNB

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : utf-8

 Date: 12/13/2012 10:09:40 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `T_ARTICLE`
-- ----------------------------
DROP TABLE IF EXISTS `T_ARTICLE`;
CREATE TABLE `T_ARTICLE` (
  `ArticleID` int(11) NOT NULL AUTO_INCREMENT,
  `TiTle` varchar(50) DEFAULT NULL,
  `SubTitle` varchar(100) DEFAULT NULL,
  `ThumbImageID` int(11) DEFAULT NULL,
  `UpdateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ArticleID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `T_ARTICLEBODY`
-- ----------------------------
DROP TABLE IF EXISTS `T_ARTICLEBODY`;
CREATE TABLE `T_ARTICLEBODY` (
  `ArticleID` int(11) DEFAULT NULL,
  `ContentID` int(11) DEFAULT NULL,
  `Sort` int(11) DEFAULT NULL,
  `Type` int(1) DEFAULT '0' COMMENT '0-图;1- 文'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `T_IMAGE`
-- ----------------------------
DROP TABLE IF EXISTS `T_IMAGE`;
CREATE TABLE `T_IMAGE` (
  `ImageID` int(11) NOT NULL AUTO_INCREMENT,
  `InsertDate` datetime DEFAULT NULL,
  `Thumbnail` blob COMMENT '略缩图',
  `FullSizeImage` mediumblob,
  `Note` varchar(200) DEFAULT NULL,
  `Module` char(1) DEFAULT '0' COMMENT '使用模块：0-相册;1-话题',
  PRIMARY KEY (`ImageID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `T_PARAMETER`
-- ----------------------------
DROP TABLE IF EXISTS `T_PARAMETER`;
CREATE TABLE `T_PARAMETER` (
  `PARANAME` varchar(10) NOT NULL DEFAULT '',
  `PARAVALUE` varchar(100) DEFAULT NULL,
  `NOTE` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PARANAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `T_TEXT`
-- ----------------------------
DROP TABLE IF EXISTS `T_TEXT`;
CREATE TABLE `T_TEXT` (
  `TextID` int(11) NOT NULL AUTO_INCREMENT,
  `InsertDate` datetime DEFAULT NULL,
  `Text` text,
  PRIMARY KEY (`TextID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `T_VIDEO`
-- ----------------------------
DROP TABLE IF EXISTS `T_VIDEO`;
CREATE TABLE `T_VIDEO` (
  `VideoID` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(50) DEFAULT NULL COMMENT '网站视频地址ID',
  `WebSite` varchar(10) DEFAULT NULL COMMENT '视频来源 优酷-YOUKU',
  `Title` varchar(100) DEFAULT NULL COMMENT '视频标题',
  `Introduction` varchar(100) DEFAULT NULL COMMENT '视频内容简介',
  `ThumbNailID` int(11) DEFAULT NULL COMMENT '略缩图',
  `UpdateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`VideoID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  View structure for `v_article`
-- ----------------------------
DROP VIEW IF EXISTS `v_article`;
CREATE ALGORITHM=UNDEFINED DEFINER=`developer`@`localhost` SQL SECURITY DEFINER VIEW `v_article` AS select `a`.`ArticleID` AS `ArticleID`,`a`.`SubTitle` AS `SubTitle`,concat((select `t_parameter`.`PARAVALUE` from `t_parameter` where (`t_parameter`.`PARANAME` = 'HOSTNAME')),'/image/thumbnail/',`a`.`ThumbImageID`) AS `ThumbImagePath`,`a`.`TiTle` AS `Title`,date_format(`a`.`UpdateTime`,'%M.%d %Y') AS `UpdateTime` from `t_article` `a`;

-- ----------------------------
--  View structure for `v_articlebody`
-- ----------------------------
DROP VIEW IF EXISTS `v_articlebody`;
CREATE ALGORITHM=UNDEFINED DEFINER=`developer`@`localhost` SQL SECURITY DEFINER VIEW `v_articlebody` AS select concat(`b`.`ArticleID`,`b`.`Sort`) AS `ID`,`b`.`ArticleID` AS `ArticleID`,`b`.`Type` AS `Type`,(case `b`.`Type` when '0' then concat((select `t_parameter`.`PARAVALUE` from `t_parameter` where (`t_parameter`.`PARANAME` = 'HOSTNAME')),'/image/fullsizeimage/',`b`.`ContentID`) when '1' then (select `t`.`Text` from `t_text` `t` where (`t`.`TextID` = `b`.`ContentID`)) else '' end) AS `Content`,`b`.`Sort` AS `Sort` from `t_articlebody` `b`;

-- ----------------------------
--  View structure for `v_photoalbum`
-- ----------------------------
DROP VIEW IF EXISTS `v_photoalbum`;
CREATE ALGORITHM=UNDEFINED DEFINER=`developer`@`localhost` SQL SECURITY DEFINER VIEW `v_photoalbum` AS select `t`.`ImageID` AS `ImageID`,`t`.`InsertDate` AS `InsertDate`,concat((select `t_parameter`.`PARAVALUE` from `t_parameter` where (`t_parameter`.`PARANAME` = 'HOSTNAME')),'/image/fullsizeimage/',`t`.`ImageID`) AS `FullSizeImagePath`,concat((select `t_parameter`.`PARAVALUE` from `t_parameter` where (`t_parameter`.`PARANAME` = 'HOSTNAME')),'/image/thumbnail/',`t`.`ImageID`) AS `ThumbnailPath` from `t_image` `t` where (`t`.`ImageID` > 1);

-- ----------------------------
--  View structure for `v_video`
-- ----------------------------
DROP VIEW IF EXISTS `v_video`;
CREATE ALGORITHM=UNDEFINED DEFINER=`developer`@`localhost` SQL SECURITY DEFINER VIEW `v_video` AS select `v`.`VideoID` AS `VideoID`,`v`.`Title` AS `Title`,`v`.`Introduction` AS `Introduction`,`v`.`UpdateTime` AS `UpdateTime`,(case `v`.`WebSite` when 'YOUKU' then concat('http://v.youku.com/player/getRealM3U8/vid/',`v`.`URL`,'/type/video.m3u8') else '' end) AS `URL` from `t_video` `v`;

SET FOREIGN_KEY_CHECKS = 1;
