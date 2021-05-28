/*
 Navicat Premium Data Transfer

 Source Server         : mysql-local
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 28/05/2021 21:07:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mysql_alltype_test
-- ----------------------------
DROP TABLE IF EXISTS `mysql_alltype_test`;
CREATE TABLE `mysql_alltype_test`  (
  `bigint_test` bigint(64) NOT NULL AUTO_INCREMENT,
  `binary_test` binary(64) NULL DEFAULT NULL,
  `bit_test` bit(64) NULL DEFAULT NULL,
  `blob_test` blob NULL,
  `char_test` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date_test` date NULL DEFAULT NULL,
  `datetime_test` datetime(6) NULL DEFAULT NULL,
  `decimal_test` decimal(65, 0) NULL DEFAULT NULL,
  `double_test` double NULL DEFAULT NULL,
  `enum_test` enum('this','that','those') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `float_test` float NULL DEFAULT NULL,
  `geometry_test` geometry NULL,
  `geometrycollection_test` geometrycollection NULL,
  `int_test` int(255) NULL DEFAULT NULL,
  `integer_test` int(255) NULL DEFAULT NULL,
  `json_test` json NULL,
  `linestring_test` linestring NULL,
  `longblob_test` longblob NULL,
  `longtext_test` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `mediumblob_test` mediumblob NULL,
  `mediumint_test` mediumint(255) NULL DEFAULT NULL,
  `mediumtext_test` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `multilinestring_test` multilinestring NULL,
  `multipoint_test` multipoint NULL,
  `multipolygon_test` multipolygon NULL,
  `numeric_test` decimal(65, 0) NULL DEFAULT NULL,
  `point_test` point NULL,
  `polygon_test` polygon NULL,
  `real_test` double NULL DEFAULT NULL,
  `set_test` set('c','b','f','s','u','p','e','r') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `smallint_test` smallint(6) NULL DEFAULT NULL,
  `text_test` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `time_test` time(6) NULL DEFAULT NULL,
  `timestamp_test` timestamp(6) NULL DEFAULT NULL,
  `tinyblob_test` tinyblob NULL,
  `tinyint_test` tinyint(255) NULL DEFAULT NULL,
  `tinytext_test` tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `varbinary_test` varbinary(255) NULL DEFAULT NULL,
  `varchar_test` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bigint_test`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mysql_alltype_test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
