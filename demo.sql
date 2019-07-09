/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 09/07/2019 15:27:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 308 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'shenqikai666', '123aaaaa', 'qq.comaaaaa', 'suqianaaaaa', '13625250569');
INSERT INTO `user` VALUES (17, 'shenqikai', 'shenqikai666', 'hacker@aa.com', 'qusian', '13773990569');
INSERT INTO `user` VALUES (156, 'aaaaa11111', 'aaa', '14125@aa.com', '宿迁市', '12345');
INSERT INTO `user` VALUES (157, 'aaaaa11112', 'aaa', '14126@aa.com', '宿迁市', '12346');
INSERT INTO `user` VALUES (158, 'aaaaa11113', 'aaa', '14127@aa.com', '宿迁市', '12347');
INSERT INTO `user` VALUES (159, 'aaaaa11114', 'aaa', '14128@aa.com', '宿迁市', '12348');
INSERT INTO `user` VALUES (160, 'aaaaa11115', 'aaa', '14129@aa.com', '宿迁市', '12349');
INSERT INTO `user` VALUES (161, 'aaaaa11116', 'aaa', '14130@aa.com', '宿迁市', '12350');
INSERT INTO `user` VALUES (162, 'aaaaa11117', 'aaa', '14131@aa.com', '宿迁市', '12351');
INSERT INTO `user` VALUES (163, 'aaaaa11118', 'aaa', '14132@aa.com', '宿迁市', '12352');
INSERT INTO `user` VALUES (164, 'aaaaa11119', 'aaa', '14133@aa.com', '宿迁市', '12353');
INSERT INTO `user` VALUES (165, 'aaaaa11120', 'aaa', '14134@aa.com', '宿迁市', '12354');
INSERT INTO `user` VALUES (166, 'aaaaa11121', 'aaa', '14135@aa.com', '宿迁市', '12355');
INSERT INTO `user` VALUES (167, 'aaaaa11122', 'aaa', '14136@aa.com', '宿迁市', '12356');
INSERT INTO `user` VALUES (168, 'aaaaa11123', 'aaa', '14137@aa.com', '宿迁市', '12357');
INSERT INTO `user` VALUES (169, 'aaaaa11124', 'aaa', '14138@aa.com', '宿迁市', '12358');
INSERT INTO `user` VALUES (170, 'aaaaa11125', 'aaa', '14139@aa.com', '宿迁市', '12359');
INSERT INTO `user` VALUES (171, 'aaaaa11126', 'aaa', '14140@aa.com', '宿迁市', '12360');
INSERT INTO `user` VALUES (172, 'aaaaa11127', 'aaa', '14141@aa.com', '宿迁市', '12361');
INSERT INTO `user` VALUES (173, 'aaaaa11128', 'aaa', '14142@aa.com', '宿迁市', '12362');
INSERT INTO `user` VALUES (174, 'aaaaa11129', 'aaa', '14143@aa.com', '宿迁市', '12363');
INSERT INTO `user` VALUES (175, 'aaaaa11130', 'aaa', '14144@aa.com', '宿迁市', '12364');
INSERT INTO `user` VALUES (176, 'aaaaa11131', 'aaa', '14145@aa.com', '宿迁市', '12365');
INSERT INTO `user` VALUES (177, 'aaaaa11132', 'aaa', '14146@aa.com', '宿迁市', '12366');
INSERT INTO `user` VALUES (179, 'aaaaas', 'aasdec', 'aaa', 'aaa', NULL);
INSERT INTO `user` VALUES (180, 'aaaaa11111', 'aaa', '14125@aa.com', '宿迁市', '12345');
INSERT INTO `user` VALUES (181, 'aaaaa11112', 'aaa', '14126@aa.com', '宿迁市', '12346');
INSERT INTO `user` VALUES (182, 'aaaaa11113', 'aaa', '14127@aa.com', '宿迁市', '12347');
INSERT INTO `user` VALUES (183, 'aaaaa11114', 'aaa', '14128@aa.com', '宿迁市', '12348');
INSERT INTO `user` VALUES (184, 'aaaaa11115', 'aaa', '14129@aa.com', '宿迁市', '12349');
INSERT INTO `user` VALUES (185, 'aaaaa11116', 'aaa', '14130@aa.com', '宿迁市', '12350');
INSERT INTO `user` VALUES (186, 'aaaaa11117', 'aaa', '14131@aa.com', '宿迁市', '12351');
INSERT INTO `user` VALUES (187, 'aaaaa11118', 'aaa', '14132@aa.com', '宿迁市', '12352');
INSERT INTO `user` VALUES (188, 'aaaaa11119', 'aaa', '14133@aa.com', '宿迁市', '12353');
INSERT INTO `user` VALUES (189, 'aaaaa11120', 'aaa', '14134@aa.com', '宿迁市', '12354');
INSERT INTO `user` VALUES (190, 'aaaaa11121', 'aaa', '14135@aa.com', '宿迁市', '12355');
INSERT INTO `user` VALUES (191, 'aaaaa11122', 'aaa', '14136@aa.com', '宿迁市', '12356');
INSERT INTO `user` VALUES (192, 'aaaaa11123', 'aaa', '14137@aa.com', '宿迁市', '12357');
INSERT INTO `user` VALUES (193, 'aaaaa11124', 'aaa', '14138@aa.com', '宿迁市', '12358');
INSERT INTO `user` VALUES (194, 'aaaaa11125', 'aaa', '14139@aa.com', '宿迁市', '12359');
INSERT INTO `user` VALUES (195, 'aaaaa11126', 'aaa', '14140@aa.com', '宿迁市', '12360');
INSERT INTO `user` VALUES (196, 'aaaaa11127', 'aaa', '14141@aa.com', '宿迁市', '12361');
INSERT INTO `user` VALUES (197, 'aaaaa11128', 'aaa', '14142@aa.com', '宿迁市', '12362');
INSERT INTO `user` VALUES (198, 'aaaaa11129', 'aaa', '14143@aa.com', '宿迁市', '12363');
INSERT INTO `user` VALUES (199, 'aaaaa11130', 'aaa', '14144@aa.com', '宿迁市', '12364');
INSERT INTO `user` VALUES (200, 'aaaaa11131', 'aaa', '14145@aa.com', '宿迁市', '12365');
INSERT INTO `user` VALUES (201, 'aaaaa11132', 'aaa', '14146@aa.com', '宿迁市', '12366');
INSERT INTO `user` VALUES (202, 'aaaaa11133', 'aaa', '14147@aa.com', '宿迁市', '12367');
INSERT INTO `user` VALUES (203, 'aaaaa11111', 'aaa', '14125@aa.com', '宿迁市', '12345');
INSERT INTO `user` VALUES (204, 'aaaaa11112', 'aaa', '14126@aa.com', '宿迁市', '12346');
INSERT INTO `user` VALUES (205, 'aaaaa11113', 'aaa', '14127@aa.com', '宿迁市', '12347');
INSERT INTO `user` VALUES (206, 'aaaaa11114', 'aaa', '14128@aa.com', '宿迁市', '12348');
INSERT INTO `user` VALUES (207, 'aaaaa11115', 'aaa', '14129@aa.com', '宿迁市', '12349');
INSERT INTO `user` VALUES (208, 'aaaaa11116', 'aaa', '14130@aa.com', '宿迁市', '12350');
INSERT INTO `user` VALUES (209, 'aaaaa11117', 'aaa', '14131@aa.com', '宿迁市', '12351');
INSERT INTO `user` VALUES (210, 'aaaaa11118', 'aaa', '14132@aa.com', '宿迁市', '12352');
INSERT INTO `user` VALUES (211, 'aaaaa11119', 'aaa', '14133@aa.com', '宿迁市', '12353');
INSERT INTO `user` VALUES (212, 'aaaaa11120', 'aaa', '14134@aa.com', '宿迁市', '12354');
INSERT INTO `user` VALUES (213, 'aaaaa11121', 'aaa', '14135@aa.com', '宿迁市', '12355');
INSERT INTO `user` VALUES (214, 'aaaaa11122', 'aaa', '14136@aa.com', '宿迁市', '12356');
INSERT INTO `user` VALUES (215, 'aaaaa11123', 'aaa', '14137@aa.com', '宿迁市', '12357');
INSERT INTO `user` VALUES (216, 'aaaaa11124', 'aaa', '14138@aa.com', '宿迁市', '12358');
INSERT INTO `user` VALUES (217, 'aaaaa11125', 'aaa', '14139@aa.com', '宿迁市', '12359');
INSERT INTO `user` VALUES (218, 'aaaaa11126', 'aaa', '14140@aa.com', '宿迁市', '12360');
INSERT INTO `user` VALUES (219, 'aaaaa11127', 'aaa', '14141@aa.com', '宿迁市', '12361');
INSERT INTO `user` VALUES (220, 'aaaaa11128', 'aaa', '14142@aa.com', '宿迁市', '12362');
INSERT INTO `user` VALUES (221, 'aaaaa11129', 'aaa', '14143@aa.com', '宿迁市', '12363');
INSERT INTO `user` VALUES (222, 'aaaaa11130', 'aaa', '14144@aa.com', '宿迁市', '12364');
INSERT INTO `user` VALUES (223, 'aaaaa11131', 'aaa', '14145@aa.com', '宿迁市', '12365');
INSERT INTO `user` VALUES (224, 'aaaaa11132', 'aaa', '14146@aa.com', '宿迁市', '12366');
INSERT INTO `user` VALUES (225, 'aaaaa11133', 'aaa', '14147@aa.com', '宿迁市', '12367');
INSERT INTO `user` VALUES (226, 'aaaaa11111', 'aaa', '14125@aa.com', '宿迁市', '12345');
INSERT INTO `user` VALUES (227, 'aaaaa11112', 'aaa', '14126@aa.com', '宿迁市', '12346');
INSERT INTO `user` VALUES (228, 'aaaaa11113', 'aaa', '14127@aa.com', '宿迁市', '12347');
INSERT INTO `user` VALUES (229, 'aaaaa11114', 'aaa', '14128@aa.com', '宿迁市', '12348');
INSERT INTO `user` VALUES (230, 'aaaaa11115', 'aaa', '14129@aa.com', '宿迁市', '12349');
INSERT INTO `user` VALUES (231, 'aaaaa11116', 'aaa', '14130@aa.com', '宿迁市', '12350');
INSERT INTO `user` VALUES (232, 'aaaaa11117', 'aaa', '14131@aa.com', '宿迁市', '12351');
INSERT INTO `user` VALUES (233, 'aaaaa11118', 'aaa', '14132@aa.com', '宿迁市', '12352');
INSERT INTO `user` VALUES (234, 'aaaaa11119', 'aaa', '14133@aa.com', '宿迁市', '12353');
INSERT INTO `user` VALUES (235, 'aaaaa11120', 'aaa', '14134@aa.com', '宿迁市', '12354');
INSERT INTO `user` VALUES (236, 'aaaaa11121', 'aaa', '14135@aa.com', '宿迁市', '12355');
INSERT INTO `user` VALUES (237, 'aaaaa11122', 'aaa', '14136@aa.com', '宿迁市', '12356');
INSERT INTO `user` VALUES (238, 'aaaaa11123', 'aaa', '14137@aa.com', '宿迁市', '12357');
INSERT INTO `user` VALUES (239, 'aaaaa11124', 'aaa', '14138@aa.com', '宿迁市', '12358');
INSERT INTO `user` VALUES (240, 'aaaaa11125', 'aaa', '14139@aa.com', '宿迁市', '12359');
INSERT INTO `user` VALUES (241, 'aaaaa11126', 'aaa', '14140@aa.com', '宿迁市', '12360');
INSERT INTO `user` VALUES (242, 'aaaaa11127', 'aaa', '14141@aa.com', '宿迁市', '12361');
INSERT INTO `user` VALUES (243, 'aaaaa11128', 'aaa', '14142@aa.com', '宿迁市', '12362');
INSERT INTO `user` VALUES (244, 'aaaaa11129', 'aaa', '14143@aa.com', '宿迁市', '12363');
INSERT INTO `user` VALUES (245, 'aaaaa11130', 'aaa', '14144@aa.com', '宿迁市', '12364');
INSERT INTO `user` VALUES (246, 'aaaaa11131', 'aaa', '14145@aa.com', '宿迁市', '12365');
INSERT INTO `user` VALUES (247, 'aaaaa11132', 'aaa', '14146@aa.com', '宿迁市', '12366');
INSERT INTO `user` VALUES (248, 'aaaaa11133', 'aaa', '14147@aa.com', '宿迁市', '12367');
INSERT INTO `user` VALUES (249, 'aaaaa11111', 'aaa', '14125@aa.com', '宿迁市', '12345');
INSERT INTO `user` VALUES (250, 'aaaaa11112', 'aaa', '14126@aa.com', '宿迁市', '12346');
INSERT INTO `user` VALUES (251, 'aaaaa11113', 'aaa', '14127@aa.com', '宿迁市', '12347');
INSERT INTO `user` VALUES (252, 'aaaaa11114', 'aaa', '14128@aa.com', '宿迁市', '12348');
INSERT INTO `user` VALUES (253, 'aaaaa11115', 'aaa', '14129@aa.com', '宿迁市', '12349');
INSERT INTO `user` VALUES (254, 'aaaaa11116', 'aaa', '14130@aa.com', '宿迁市', '12350');
INSERT INTO `user` VALUES (255, 'aaaaa11117', 'aaa', '14131@aa.com', '宿迁市', '12351');
INSERT INTO `user` VALUES (256, 'aaaaa11118', 'aaa', '14132@aa.com', '宿迁市', '12352');
INSERT INTO `user` VALUES (257, 'aaaaa11119', 'aaa', '14133@aa.com', '宿迁市', '12353');
INSERT INTO `user` VALUES (258, 'aaaaa11120', 'aaa', '14134@aa.com', '宿迁市', '12354');
INSERT INTO `user` VALUES (259, 'aaaaa11121', 'aaa', '14135@aa.com', '宿迁市', '12355');
INSERT INTO `user` VALUES (260, 'aaaaa11122', 'aaa', '14136@aa.com', '宿迁市', '12356');
INSERT INTO `user` VALUES (261, 'aaaaa11123', 'aaa', '14137@aa.com', '宿迁市', '12357');
INSERT INTO `user` VALUES (262, 'aaaaa11124', 'aaa', '14138@aa.com', '宿迁市', '12358');
INSERT INTO `user` VALUES (263, 'aaaaa11125', 'aaa', '14139@aa.com', '宿迁市', '12359');
INSERT INTO `user` VALUES (264, 'aaaaa11126', 'aaa', '14140@aa.com', '宿迁市', '12360');
INSERT INTO `user` VALUES (265, 'aaaaa11127', 'aaa', '14141@aa.com', '宿迁市', '12361');
INSERT INTO `user` VALUES (266, 'aaaaa11128', 'aaa', '14142@aa.com', '宿迁市', '12362');
INSERT INTO `user` VALUES (267, 'aaaaa11129', 'aaa', '14143@aa.com', '宿迁市', '12363');
INSERT INTO `user` VALUES (268, 'aaaaa11130', 'aaa', '14144@aa.com', '宿迁市', '12364');
INSERT INTO `user` VALUES (269, 'aaaaa11131', 'aaa', '14145@aa.com', '宿迁市', '12365');
INSERT INTO `user` VALUES (270, 'aaaaa11132', 'aaa', '14146@aa.com', '宿迁市', '12366');
INSERT INTO `user` VALUES (271, 'aaaaa11133', 'aaa', '14147@aa.com', '宿迁市', '12367');
INSERT INTO `user` VALUES (272, 'aaaaa11111', 'aaa', '14125@aa.com', '宿迁市', '12345');
INSERT INTO `user` VALUES (273, 'aaaaa11112', 'aaa', '14126@aa.com', '宿迁市', '12346');
INSERT INTO `user` VALUES (274, 'aaaaa11113', 'aaa', '14127@aa.com', '宿迁市', '12347');
INSERT INTO `user` VALUES (275, 'aaaaa11114', 'aaa', '14128@aa.com', '宿迁市', '12348');
INSERT INTO `user` VALUES (276, 'aaaaa11115', 'aaa', '14129@aa.com', '宿迁市', '12349');
INSERT INTO `user` VALUES (277, 'aaaaa11116', 'aaa', '14130@aa.com', '宿迁市', '12350');
INSERT INTO `user` VALUES (278, 'aaaaa11117', 'aaa', '14131@aa.com', '宿迁市', '12351');
INSERT INTO `user` VALUES (279, 'aaaaa11118', 'aaa', '14132@aa.com', '宿迁市', '12352');
INSERT INTO `user` VALUES (280, 'aaaaa11119', 'aaa', '14133@aa.com', '宿迁市', '12353');
INSERT INTO `user` VALUES (281, 'aaaaa11120', 'aaa', '14134@aa.com', '宿迁市', '12354');
INSERT INTO `user` VALUES (282, 'aaaaa11121', 'aaa', '14135@aa.com', '宿迁市', '12355');
INSERT INTO `user` VALUES (283, 'aaaaa11122', 'aaa', '14136@aa.com', '宿迁市', '12356');
INSERT INTO `user` VALUES (284, 'aaaaa11123', 'aaa', '14137@aa.com', '宿迁市', '12357');
INSERT INTO `user` VALUES (285, 'aaaaa11124', 'aaa', '14138@aa.com', '宿迁市', '12358');
INSERT INTO `user` VALUES (286, 'aaaaa11125', 'aaa', '14139@aa.com', '宿迁市', '12359');
INSERT INTO `user` VALUES (287, 'aaaaa11126', 'aaa', '14140@aa.com', '宿迁市', '12360');
INSERT INTO `user` VALUES (288, 'aaaaa11127', 'aaa', '14141@aa.com', '宿迁市', '12361');
INSERT INTO `user` VALUES (289, 'aaaaa11128', 'aaa', '14142@aa.com', '宿迁市', '12362');
INSERT INTO `user` VALUES (290, 'aaaaa11129', 'aaa', '14143@aa.com', '宿迁市', '12363');
INSERT INTO `user` VALUES (291, 'aaaaa11130', 'aaa', '14144@aa.com', '宿迁市', '12364');
INSERT INTO `user` VALUES (292, 'aaaaa11131', 'aaa', '14145@aa.com', '宿迁市', '12365');
INSERT INTO `user` VALUES (293, 'aaaaa11132', 'aaa', '14146@aa.com', '宿迁市', '12366');
INSERT INTO `user` VALUES (294, 'aaaaa11133', 'aaa', '14147@aa.com', '宿迁市', '12367');
INSERT INTO `user` VALUES (295, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (296, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (297, '肾上腺素', '345tfdfv ', 'hacker@aa.com', 'sacsacd ', '875472284');
INSERT INTO `user` VALUES (298, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (299, '肾上腺素', '345tfdfv ', 'hacker@aa.com', 'sacsacd ', '875472284');
INSERT INTO `user` VALUES (300, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (301, '肾上腺素', '345tfdfv ', 'hacker@aa.com', 'sacsacd ', '875472284');
INSERT INTO `user` VALUES (302, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (303, '肾上腺素', '345tfdfv ', 'hacker@aa.com', 'sacsacd ', '875472284');
INSERT INTO `user` VALUES (304, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (305, '肾上腺素', '345tfdfv ', 'hacker@aa.com', 'sacsacd ', '875472284');
INSERT INTO `user` VALUES (306, 'sasec', 'scasca', 'hackery@aa.com', 'sadcascd', '6526161515641');
INSERT INTO `user` VALUES (307, '肾上腺素', '345tfdfv ', 'hacker@aa.com', 'sacsacd ', '875472284');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, '沈琪凯', '123456', 'hackershen@qq.com', '宿迁', '17606102809', '1');

SET FOREIGN_KEY_CHECKS = 1;
