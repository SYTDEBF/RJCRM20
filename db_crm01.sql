/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : db_crm

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 17/11/2020 11:12:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin_password` varchar(255) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
BEGIN;
INSERT INTO `tb_admin` VALUES (1, '123456', 'mz');
COMMIT;

-- ----------------------------
-- Table structure for tb_custom
-- ----------------------------
DROP TABLE IF EXISTS `tb_custom`;
CREATE TABLE `tb_custom` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `custom_name` varchar(50) NOT NULL,
  `custom_phone` varchar(50) DEFAULT NULL,
  `custom_address` varchar(255) DEFAULT NULL,
  `custom_credit` int NOT NULL COMMENT '信用度',
  `custom_password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_custom
-- ----------------------------
BEGIN;
INSERT INTO `tb_custom` VALUES (1, '王彭', '2234324234', '南京市', 101, '123456');
INSERT INTO `tb_custom` VALUES (2, '睡觉', '43243242343', '南京市', 1001, '123456');
INSERT INTO `tb_custom` VALUES (3, '深深的', '42421321', '南京', 23, '123456');
INSERT INTO `tb_custom` VALUES (4, '宋得', '23234424', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (5, '速度速度', '23234424', '南京市', 100, '123213123');
INSERT INTO `tb_custom` VALUES (6, '说的是', '123456', '23443243', 110, '南京市');
INSERT INTO `tb_custom` VALUES (7, '说的是', '123456', '23443243', 110, '南京市');
INSERT INTO `tb_custom` VALUES (8, '短发短发', '3432532', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (9, '高宇', '13838383338', '常州市', 100, '12345678');
INSERT INTO `tb_custom` VALUES (10, '撒大', '13813883388', '南京市', 100, '12345678');
COMMIT;

-- ----------------------------
-- Table structure for tb_feedfack
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedfack`;
CREATE TABLE `tb_feedfack` (
  `id` int NOT NULL AUTO_INCREMENT,
  `feedfack_name` varchar(255) NOT NULL,
  `feedfack_time` datetime NOT NULL,
  `feedback_content` varchar(600) NOT NULL,
  `feedback_shopid` int NOT NULL,
  `feedback_isslove` varchar(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `feed_shop-id` (`feedback_shopid`),
  CONSTRAINT `feed_shop-id` FOREIGN KEY (`feedback_shopid`) REFERENCES `tb_shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_feedfack
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `custom_id` int NOT NULL,
  `shop_id` int NOT NULL,
  `staff_id` int NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `custom_for` (`custom_id`),
  KEY `shop_for` (`shop_id`),
  KEY `staff_for` (`staff_id`),
  CONSTRAINT `custom_for` FOREIGN KEY (`custom_id`) REFERENCES `tb_custom` (`id`),
  CONSTRAINT `shop_for` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`id`),
  CONSTRAINT `staff_for` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES (1, 1, 1, 1, '2020-10-01 13:39:23');
COMMIT;

-- ----------------------------
-- Table structure for tb_plan
-- ----------------------------
DROP TABLE IF EXISTS `tb_plan`;
CREATE TABLE `tb_plan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_id` int DEFAULT NULL,
  `plan_user_num` int DEFAULT NULL COMMENT '计划客户数量',
  `plan_profit` int DEFAULT NULL COMMENT '利润',
  `plan_time` datetime DEFAULT NULL,
  `plan_stand` varchar(255) DEFAULT NULL COMMENT '情况',
  `plan_mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `staff_id` (`staff_id`),
  CONSTRAINT `staff_id` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_plan
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) NOT NULL,
  `shop_date` datetime NOT NULL,
  `shop_type` varchar(255) NOT NULL,
  `shop_price` float(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
BEGIN;
INSERT INTO `tb_shop` VALUES (1, 'MacBOOK Pro', '2020-09-16 22:13:05', '电脑', 16000.00);
COMMIT;

-- ----------------------------
-- Table structure for tb_staff
-- ----------------------------
DROP TABLE IF EXISTS `tb_staff`;
CREATE TABLE `tb_staff` (
  `id` int NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) NOT NULL,
  `staff_depart` varchar(255) NOT NULL,
  `staff_shop_type` varchar(255) NOT NULL,
  `staff_salary` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
BEGIN;
INSERT INTO `tb_staff` VALUES (1, '马云', '销售部', '电脑', 40000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
