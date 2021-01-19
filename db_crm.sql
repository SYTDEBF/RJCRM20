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

 Date: 19/01/2021 17:54:09
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_custom
-- ----------------------------
BEGIN;
INSERT INTO `tb_custom` VALUES (1, '王彭', '2234324234', '南京市', 101, '123456');
INSERT INTO `tb_custom` VALUES (2, '睡大觉', '15996313311', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (3, '深深的', '42421321', '南京', 23, '123456');
INSERT INTO `tb_custom` VALUES (4, '宋捷', '15996313311', '北京市', 100, '12345634');
INSERT INTO `tb_custom` VALUES (8, '短发短发', '3432532', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (9, '高宇', '13838383338', '常州市', 100, '12345678');
INSERT INTO `tb_custom` VALUES (10, '撒大', '13813883388', '南京市', 100, '12345678');
INSERT INTO `tb_custom` VALUES (11, '而且往往企鹅', '13833883388', '南京市', 100, '12345qwer');
INSERT INTO `tb_custom` VALUES (13, '阿斯顿', '13833883388', '南京', 100, '12332321');
INSERT INTO `tb_custom` VALUES (14, 'sdas', '13833883388', '南京', 100, '2312');
INSERT INTO `tb_custom` VALUES (15, '我明明', '13813338338', 'nn', 100, '23412323');
INSERT INTO `tb_custom` VALUES (16, '徐峥', '15996313311', '南京市', 100, '1234qwer');
INSERT INTO `tb_custom` VALUES (17, '徐正', '17761712345', '南京市', 100, '1234qwer');
INSERT INTO `tb_custom` VALUES (20, '首辅', '13899773456', '南京市', 100, '123456');
INSERT INTO `tb_custom` VALUES (21, '张三', '13625239606', '南京', 100, '123456');
COMMIT;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_id` int(11) NOT NULL,
  `shop_id` int(11) NOT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `custom_for` (`custom_id`),
  KEY `shop_for` (`shop_id`),
  KEY `staff_for` (`staff_id`),
  CONSTRAINT `custom_for` FOREIGN KEY (`custom_id`) REFERENCES `tb_custom` (`id`),
  CONSTRAINT `shop_for` FOREIGN KEY (`shop_id`) REFERENCES `tb_shop` (`id`),
  CONSTRAINT `staff_for` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
BEGIN;
INSERT INTO `tb_order` VALUES (4, 1, 2, 1, '2020-12-28 22:56:17');
INSERT INTO `tb_order` VALUES (7, 1, 1, 1, '2020-12-30 08:26:19');
INSERT INTO `tb_order` VALUES (8, 3, 4, 1, '2020-12-30 19:41:11');
INSERT INTO `tb_order` VALUES (9, 1, 2, 1, '2020-12-30 19:47:43');
INSERT INTO `tb_order` VALUES (10, 3, 3, 2, '2021-01-18 16:20:16');
INSERT INTO `tb_order` VALUES (11, 2, 5, 8, '2021-01-05 21:16:29');
INSERT INTO `tb_order` VALUES (12, 1, 1, 7, '2021-01-11 18:08:51');
INSERT INTO `tb_order` VALUES (13, 1, 5, 8, '2021-01-13 05:34:43');
COMMIT;

-- ----------------------------
-- Table structure for tb_plan
-- ----------------------------
DROP TABLE IF EXISTS `tb_plan`;
CREATE TABLE `tb_plan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staff_id` int(11) DEFAULT NULL,
  `plan_profit` int(11) DEFAULT NULL COMMENT '计划销量',
  `plan_time` datetime DEFAULT NULL COMMENT '计划时间',
  `plan_stand` text COMMENT '计划内容',
  `plan_mark` int(1) NOT NULL COMMENT '是否完成',
  PRIMARY KEY (`id`),
  KEY `staff_id` (`staff_id`),
  CONSTRAINT `staff_id` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_plan
-- ----------------------------
BEGIN;
INSERT INTO `tb_plan` VALUES (1, 1, 10, '2021-01-11 18:15:15', '是对方的思维额分为范德\n萨发生的发生都发多少发多\n少发多少粉丝多福多寿发多少\n发多少发多少发多少发多少粉丝的\n方法是对方方式的方式地方都是粉色\n的的实打实的撒打算打算大大', 1);
INSERT INTO `tb_plan` VALUES (2, 1, 122, '2021-01-11 18:16:11', '请问我去额外企鹅我去额外企鹅我去额外企\n鹅完全恶趣味我去额外企鹅我企鹅\ntwerewrew\n饿死人玩儿玩儿\n让她有人疼有人疼', 0);
INSERT INTO `tb_plan` VALUES (3, 1, 12, '2021-01-02 09:40:15', 'rwerewrewrewrewreeftw\nerewrw惹我惹我惹我惹我认为认为 u一幕茵\n额头热议我把他让给v52而5v435345vv天额外人v为v任务\n而v我去二·234324324时德文吃3年58 清热问题e', 1);
INSERT INTO `tb_plan` VALUES (6, 1, 10, '2021-01-11 18:15:59', '这是一个大计划', 0);
INSERT INTO `tb_plan` VALUES (7, 2, 12, '2021-01-03 03:32:41', '加油，奥利给', 1);
INSERT INTO `tb_plan` VALUES (8, 3, 11, '2021-01-13 20:06:55', 'deasdasd', 0);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_shop
-- ----------------------------
BEGIN;
INSERT INTO `tb_shop` VALUES (1, 'MacBook Pro13', '2020-12-03 22:16:07', 13, 13000.00);
INSERT INTO `tb_shop` VALUES (2, 'MacBook Pro13 M1', '2020-12-17 20:41:20', 13, 12000.00);
INSERT INTO `tb_shop` VALUES (3, '联想拯救者', '2020-12-17 00:00:00', 13, 12000.00);
INSERT INTO `tb_shop` VALUES (4, '联想小新', '2020-12-01 00:00:00', 13, 1200.00);
INSERT INTO `tb_shop` VALUES (5, '华为P40 Pro Plus', '2021-01-03 16:23:23', 15, 10000.00);
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

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
INSERT INTO `tb_shoptype` VALUES (19, 3, '方便食品', '2');
INSERT INTO `tb_shoptype` VALUES (20, 4, '上装', '2');
INSERT INTO `tb_shoptype` VALUES (24, 3, '酒品', '2');
INSERT INTO `tb_shoptype` VALUES (26, 3, '海鲜', '2');
INSERT INTO `tb_shoptype` VALUES (27, 5, '老年机', '3');
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
  `staff_password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_shop_id` (`staff_shop_type`),
  CONSTRAINT `fk_shop_id` FOREIGN KEY (`staff_shop_type`) REFERENCES `tb_shoptype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_staff
-- ----------------------------
BEGIN;
INSERT INTO `tb_staff` VALUES (1, '王二', '销售部', 13, 100000, '123456');
INSERT INTO `tb_staff` VALUES (2, '戴鑫凯', '销售部', 13, 10000, '123456');
INSERT INTO `tb_staff` VALUES (3, '里斯', '销售部', 13, 10000, '123456');
INSERT INTO `tb_staff` VALUES (6, '码字', '销售部', 13, 10000, '123456');
INSERT INTO `tb_staff` VALUES (7, '二者', '销售部', 13, 1000, '12345678');
INSERT INTO `tb_staff` VALUES (8, '李维', '销售部', 15, 10000, '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
