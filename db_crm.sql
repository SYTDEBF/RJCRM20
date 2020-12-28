/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : db_crm

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 28/12/2020 23:14:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_password` varchar(255) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_custom
-- ----------------------------
DROP TABLE IF EXISTS `tb_custom`;
CREATE TABLE `tb_custom` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `custom_name` varchar(50) NOT NULL,
  `custom_phone` varchar(50) DEFAULT NULL,
  `custom_address` varchar(255) DEFAULT NULL,
  `custom_credit` int(11) NOT NULL COMMENT '信用度',
  `custom_password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_feedfack
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedfack`;
CREATE TABLE `tb_feedfack` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `feedfack_name` varchar(255) NOT NULL,
  `feedfack_time` datetime NOT NULL,
  `feedback_content` varchar(600) NOT NULL,
  `feedback_shopid` int(11) NOT NULL,
  `feedback_isslove` varchar(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `feed_shop-id` (`feedback_shopid`),
  CONSTRAINT `feed_shop-id` FOREIGN KEY (`feedback_shopid`) REFERENCES `tb_shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `custom_for` (`custom_id`),
  KEY `shop_for` (`shop_id`),
  KEY `staff_for` (`staff_id`),
  CONSTRAINT `custom_for` FOREIGN KEY (`custom_id`) REFERENCES `tb_custom` (`id`),
  CONSTRAINT `shop_for` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`id`),
  CONSTRAINT `staff_for` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_plan
-- ----------------------------
DROP TABLE IF EXISTS `tb_plan`;
CREATE TABLE `tb_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `plan_user_num` int(11) DEFAULT NULL COMMENT '计划客户数量',
  `plan_profit` int(11) DEFAULT NULL COMMENT '利润',
  `plan_time` datetime DEFAULT NULL,
  `plan_stand` varchar(255) DEFAULT NULL COMMENT '情况',
  `plan_mark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `staff_id` (`staff_id`),
  CONSTRAINT `staff_id` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_shop
-- ----------------------------
DROP TABLE IF EXISTS `tb_shop`;
CREATE TABLE `tb_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) NOT NULL,
  `shop_date` datetime NOT NULL,
  `shop_type` int(11) NOT NULL,
  `shop_price` float(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shop_type` (`shop_type`),
  CONSTRAINT `fk_shop_type` FOREIGN KEY (`shop_type`) REFERENCES `tb_shoptype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_shoptype
-- ----------------------------
DROP TABLE IF EXISTS `tb_shoptype`;
CREATE TABLE `tb_shoptype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parentid` int(11) NOT NULL COMMENT '父id',
  `typename` varchar(255) NOT NULL COMMENT '商品类型名称',
  `stype` varchar(10) NOT NULL COMMENT '商品类型名称层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tb_staff
-- ----------------------------
DROP TABLE IF EXISTS `tb_staff`;
CREATE TABLE `tb_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_name` varchar(255) NOT NULL,
  `staff_depart` varchar(255) NOT NULL,
  `staff_shop_type` int(11) NOT NULL,
  `staff_salary` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shop_id` (`staff_shop_type`),
  CONSTRAINT `fk_shop_id` FOREIGN KEY (`staff_shop_type`) REFERENCES `tb_shoptype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
