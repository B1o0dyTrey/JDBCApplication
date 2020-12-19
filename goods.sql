/*
 Navicat Premium Data Transfer

 Source Server         : connect1
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : goods

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 09/12/2020 00:53:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_mau
-- ----------------------------
DROP TABLE IF EXISTS `tb_mau`;
CREATE TABLE `tb_mau`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mauname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` decimal(10, 0) NOT NULL,
  `postcode` decimal(10, 0) NULL DEFAULT NULL,
  `createtime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `status` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_mau
-- ----------------------------
INSERT INTO `tb_mau` VALUES (1, 'hzc', '111', 111, 1111, '2020-12-08 23:16:27', NULL);

-- ----------------------------
-- Table structure for tb_product
-- ----------------------------
DROP TABLE IF EXISTS `tb_product`;
CREATE TABLE `tb_product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mid` int(32) NOT NULL,
  `producecount` decimal(10, 0) NOT NULL,
  `productprice` decimal(10, 0) NOT NULL,
  `createtime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `status` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_product
-- ----------------------------
INSERT INTO `tb_product` VALUES (4, 'cola', 111, 64, 4, '2020-12-08 20:56:13', 1);
INSERT INTO `tb_product` VALUES (5, 'coco', 111, 93, 10, '2020-12-08 21:23:36', 1);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `usertype` int(255) NOT NULL,
  `userpwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userphone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1, 'trey', 1, '123456', '123', '2020-12-08 16:35:51', 1);
INSERT INTO `tb_user` VALUES (9, 'ttt', 2, '111', '111', '2020-12-08 18:05:22', 1);
INSERT INTO `tb_user` VALUES (10, '0', 0, '0', '0', '2020-12-08 18:06:23', NULL);
INSERT INTO `tb_user` VALUES (11, '0', 0, '0', '0', '2020-12-08 18:10:15', NULL);
INSERT INTO `tb_user` VALUES (12, 'haozicheng', 1, '123', '123456', '2020-12-08 18:12:21', 1);

SET FOREIGN_KEY_CHECKS = 1;
