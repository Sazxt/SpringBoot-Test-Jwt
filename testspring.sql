/*
 Navicat Premium Data Transfer

 Source Server         : MYSQLI Docker Localhost
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : testspring

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 02/06/2024 21:49:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for testdata
-- ----------------------------
DROP TABLE IF EXISTS `testdata`;
CREATE TABLE `testdata`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `wallet` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of testdata
-- ----------------------------
INSERT INTO `testdata` VALUES (1, 'Aldi', 'Tanggerang banten kecamatan sukamulya', '0x27c2973865e729c242', 'karuma1363@gmail.com', NULL, NULL);
INSERT INTO `testdata` VALUES (5, 'saz', 'di ubah', NULL, 'Done ga bang ?', '2024-05-23 03:58:25', '2024-05-23 18:05:04');
INSERT INTO `testdata` VALUES (8, 'ok', 'ok', NULL, 'ok', '2024-06-02 20:01:05', '2024-06-02 20:01:05');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `nik` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tingkat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'aldi', 'karuma1363@gmail.com', NULL, 'jl.sudirman', '1290480234235', 'sparka', '2024-05-26 01:00:37', '2024-05-26 01:00:37');
INSERT INTO `users` VALUES (9, 'alxdi', 'karuma136x3@gmail.com', '$2a$10$hZisbYGckUmqBOZzLY/6ietCuNYrQNZh9BOZPK8X/DQqm.u/CeBki', 'jl.sudirman', '1290480234235', 'sparkla', '2024-05-26 02:23:23', '2024-05-26 02:23:23');
INSERT INTO `users` VALUES (10, 'admin', 'admin@gmail.com', '$2a$10$iYPHp4zzVH/UTiJ1a7W/xeMbdyRYcFCM.yIOZ/4hhuc9AjAg4PSpm', 'jl.sudirman', '1290480234235', 'sparkla', '2024-06-01 00:25:58', '2024-06-01 00:25:58');

SET FOREIGN_KEY_CHECKS = 1;
