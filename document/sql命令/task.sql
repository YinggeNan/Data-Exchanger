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

 Date: 02/06/2021 11:01:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reader_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `reader_json_config` json NOT NULL,
  `sinker_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sinker_json_config` json NOT NULL,
  `intermediateProcessor_className` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `blocking_queue_size` double NOT NULL,
  `column_map_json_config` json NOT NULL,
  `concurrent_number` int(11) NULL DEFAULT NULL,
  `is_delete` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
