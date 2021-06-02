/*
 Navicat Premium Data Transfer

 Source Server         : mysql-local
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : data_exchanger

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 02/06/2021 11:01:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task_execution_log
-- ----------------------------
DROP TABLE IF EXISTS `task_execution_log`;
CREATE TABLE `task_execution_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `task_state` enum('not_start','start','running','failed','completed') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `broker_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
