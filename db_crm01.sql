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

 Date: 21/12/2020 14:39:57
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
                             `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
                             `custom_name` varchar(50) NOT NULL,
                             `custom_phone` varchar(50) DEFAULT NULL,
                             `custom_address` varchar(255) DEFAULT NULL,
                             `custom_credit` int(11) NOT NULL COMMENT '信用度',
                             `custom_password` varchar(255) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_custom
-- ----------------------------
BEGIN;
INSERT INTO `tb_custom` VALUES (1, '王彭', '2234324234', '南京市', 101, '123456');
INSERT INTO `tb_custom` VALUES (2, '睡觉', '43243242', '南京市', 1001, '123456');
INSERT INTO `tb_custom` VALUES (3, '深深的', '42421321', '南京', 23, '123456');
INSERT INTO `tb_custom` VALUES (4, '宋得', '23234424', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (5, '速度速度', '23234424', '南京市', 100, '123213123');
INSERT INTO `tb_custom` VALUES (6, '说的是', '123456', '23443243', 110, '南京市');
INSERT INTO `tb_custom` VALUES (7, '说的是', '123456', '23443243', 110, '南京市');
INSERT INTO `tb_custom` VALUES (8, '短发短发', '3432532', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (9, '高宇', '13838383338', '常州市', 100, '12345678');
INSERT INTO `tb_custom` VALUES (10, '撒大', '13813883388', '南京市', 100, '12345678');
INSERT INTO `tb_custom` VALUES (11, '而且往往企鹅', '13833883388', '南京市', 100, '12345qwer');
INSERT INTO `tb_custom` VALUES (12, '王彭2', '15996313311', '安徽省', 100, '12345678');
INSERT INTO `tb_custom` VALUES (13, '阿斯顿', '13833883388', '南京', 100, '12332321');
INSERT INTO `tb_custom` VALUES (14, 'sdas', '13833883388', '南京', 100, '2312');
INSERT INTO `tb_custom` VALUES (15, '我明明', '13813338338', 'nn', 100, '23412323');
INSERT INTO `tb_custom` VALUES (16, '徐峥', '15996313311', '南京市', 100, '1234qwer');
INSERT INTO `tb_custom` VALUES (17, '徐正', '17761712345', '南京市', 100, '1234qwer');
INSERT INTO `tb_custom` VALUES (18, '徐正', '17761716837', '南京市', 100, '1234qwer');
INSERT INTO `tb_custom` VALUES (19, '徐正', '15996313311', '南京市', 100, '1234qwer');
COMMIT;

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
-- Records of tb_feedfack
-- ----------------------------
BEGIN;
COMMIT;

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
-- Records of tb_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES (1, 1, 1, 1, '2020-12-13 21:30:54');
INSERT INTO `tb_order` VALUES (2, 5, 2, 2, '2020-12-17 20:42:31');
INSERT INTO `tb_order` VALUES (3, 2, 2, 1, '2020-12-19 01:00:56');
COMMIT;

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
-- Records of tb_plan
-- ----------------------------
BEGIN;
COMMIT;

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
-- Records of tb_shop
-- ----------------------------
BEGIN;
INSERT INTO `tb_shop` VALUES (1, 'MacBook Pro13', '2020-12-03 22:16:07', 13, 13000.00);
INSERT INTO `tb_shop` VALUES (2, 'MacBook Pro13 M1', '2020-12-17 20:41:20', 13, 12000.00);
COMMIT;

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
-- Records of tb_shoptype
-- ----------------------------
BEGIN;
INSERT INTO `tb_shoptype` VALUES (2, 0, '数码', '1');
INSERT INTO `tb_shoptype` VALUES (3, 0, '食品', '1');
INSERT INTO `tb_shoptype` VALUES (4, 0, '服装', '1');
INSERT INTO `tb_shoptype` VALUES (5, 2, '手机', '2');
INSERT INTO `tb_shoptype` VALUES (6, 2, '平板', '2');
INSERT INTO `tb_shoptype` VALUES (7, 2, '电脑', '2');
INSERT INTO `tb_shoptype` VALUES (8, 2, '音响', '2');
INSERT INTO `tb_shoptype` VALUES (9, 8, '入耳式耳机', '3');
INSERT INTO `tb_shoptype` VALUES (10, 8, '头戴式耳机', '3');
INSERT INTO `tb_shoptype` VALUES (11, 8, '有源音箱', '3');
INSERT INTO `tb_shoptype` VALUES (12, 8, '蓝牙音箱', '3');
INSERT INTO `tb_shoptype` VALUES (13, 7, '笔记本电脑', '3');
INSERT INTO `tb_shoptype` VALUES (14, 7, '台式电脑', '3');
INSERT INTO `tb_shoptype` VALUES (15, 5, '智能手机', '3');
INSERT INTO `tb_shoptype` VALUES (16, 2, '游戏机', '2');
INSERT INTO `tb_shoptype` VALUES (17, 16, '主机游戏', '3');
INSERT INTO `tb_shoptype` VALUES (18, 16, '掌上游戏机', '3');
INSERT INTO `tb_shoptype` VALUES (19, 3, '方便食品', '2');
INSERT INTO `tb_shoptype` VALUES (20, 4, '上装', '2');
INSERT INTO `tb_shoptype` VALUES (21, 20, '卫衣', '3');
INSERT INTO `tb_shoptype` VALUES (22, 20, '外套', '3');
INSERT INTO `tb_shoptype` VALUES (23, 3, '零食', '2');
INSERT INTO `tb_shoptype` VALUES (24, 3, '酒品', '2');
INSERT INTO `tb_shoptype` VALUES (25, 3, '茶', '2');
INSERT INTO `tb_shoptype` VALUES (26, 3, '海鲜', '2');
COMMIT;

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

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
BEGIN;
INSERT INTO `tb_staff` VALUES (1, '王二', '销售部', 7, 24000);
INSERT INTO `tb_staff` VALUES (2, '代行开', '销售部', 7, 100000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
