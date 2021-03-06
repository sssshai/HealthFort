/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : besure

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 14/12/2020 21:57:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_cs
-- ----------------------------
DROP TABLE IF EXISTS `t_cs`;
CREATE TABLE `t_cs`
(
    `idP`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `auCS` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `cskP` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`idP`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_cs
-- ----------------------------

-- ----------------------------
-- Table structure for t_ehr
-- ----------------------------
DROP TABLE IF EXISTS `t_ehr`;
CREATE TABLE `t_ehr`
(
    `idP`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `stage`        int(0)                                                         NOT NULL,
    `c_rou_y_rou`  varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `ck_rou_y_rou` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `PB_l`         varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `Bl_l`         varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `sigma_PB_l`   varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`idP`, `stage`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ehr
-- ----------------------------

-- ----------------------------
-- Table structure for t_h
-- ----------------------------
DROP TABLE IF EXISTS `t_h`;
CREATE TABLE `t_h`
(
    `idP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `auH` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    PRIMARY KEY (`idP`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_h
-- ----------------------------

-- ----------------------------
-- Table structure for t_ks
-- ----------------------------
DROP TABLE IF EXISTS `t_ks`;
CREATE TABLE `t_ks`
(
    `idP`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   NOT NULL,
    `pwP_star` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL,
    `au`       varchar(10240) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
    `eP`       int(0)                                                          NULL DEFAULT NULL,
    PRIMARY KEY (`idP`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_ks
-- ----------------------------

-- ----------------------------
-- Table structure for t_params
-- ----------------------------
DROP TABLE IF EXISTS `t_params`;
CREATE TABLE `t_params`
(
    `P`     varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `P_pub` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `s`     varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `k`     varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_params
-- ----------------------------
INSERT INTO `t_params`
VALUES ('+??7??&x????m	??????????Un????2??}??A!=????{????????TGu????\"hS)??R2??;??????(	??,\r&g??o????X??j?????&??????????V??8??????????\Z??2????8??>g\\;????&??CoJ\\??????S~??????w??????',
        '01A????????????K????^??]AE????????????1????@>????????????2??;5??????r????@:??????-p????????????o???????????????!??????\r??/\n??1??Jy%g??????+????qL?? *1??????????bpj????ae??i??????QAy??',
        'GlD????\\????_=??	??`??%3????????H??????K;??jg????T??1	W??????%-??[2\"i????dI??j+??',
        'GlD????\\????_=??	??`??%3????????H??????K;??jg????T??1	W??????%-??[2\"i????dI??j+??');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`
(
    `uid`      int(0)                                                  NOT NULL AUTO_INCREMENT,
    `uname`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 156
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
