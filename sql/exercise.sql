/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : exercise

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 14/04/2020 12:43:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for exercise_appointment
-- ----------------------------
DROP TABLE IF EXISTS `exercise_appointment`;
CREATE TABLE `exercise_appointment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约表id',
  `request_user_id` int(11) NOT NULL COMMENT '发起预约请求的人的id',
  `requested_user_id` int(11) NOT NULL COMMENT '被预约的人的id',
  `appointment_time` datetime(0) NULL DEFAULT NULL COMMENT '预定的时间',
  `request_time` datetime(0) NULL DEFAULT NULL COMMENT '发起请求的时间',
  `accept` int(2) NULL DEFAULT NULL COMMENT '接受预约标志, 1接受，0未接受',
  `del_flag` int(2) NULL DEFAULT NULL COMMENT '删除标志, 1已删，0未删',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_appointment
-- ----------------------------
INSERT INTO `exercise_appointment` VALUES (1, 4, 3, '2020-02-25 00:00:00', '2020-03-24 20:33:57', 1, 0);
INSERT INTO `exercise_appointment` VALUES (5, 4, 5, '2020-03-27 00:00:00', '2020-03-25 13:25:30', 0, 0);
INSERT INTO `exercise_appointment` VALUES (6, 4, 6, '2020-03-30 00:00:00', '2020-03-25 13:25:42', 0, 0);
INSERT INTO `exercise_appointment` VALUES (7, 4, 3, '2020-03-25 00:00:00', '2020-03-25 15:19:18', 1, 0);

-- ----------------------------
-- Table structure for exercise_comment
-- ----------------------------
DROP TABLE IF EXISTS `exercise_comment`;
CREATE TABLE `exercise_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论表id',
  `user_id` int(11) NOT NULL COMMENT '评论人id',
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '评论',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `course_id` int(11) NOT NULL COMMENT '课程id',
  `del_flag` int(2) NULL DEFAULT NULL COMMENT '删除标志，1：删除，0没删',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_comment
-- ----------------------------
INSERT INTO `exercise_comment` VALUES (1, 4, '测试', '2020-03-23 16:25:53', 1, 0);
INSERT INTO `exercise_comment` VALUES (2, 4, '这个课不错哟。', '2020-03-23 17:33:18', 1, NULL);
INSERT INTO `exercise_comment` VALUES (3, 4, '这个课程适合老年人吧？', '2020-03-23 17:41:58', 3, NULL);

-- ----------------------------
-- Table structure for exercise_course
-- ----------------------------
DROP TABLE IF EXISTS `exercise_course`;
CREATE TABLE `exercise_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程描述',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `start_time` datetime(0) NOT NULL COMMENT '开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '截止时间',
  `place_id` int(11) NULL DEFAULT NULL COMMENT '场地id',
  `course_time` int(4) NOT NULL COMMENT '课时',
  `user_id` int(11) NOT NULL COMMENT '教练id',
  `money` decimal(12, 2) NULL DEFAULT NULL COMMENT '费用',
  `img` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `del_flag` int(2) NULL DEFAULT 0 COMMENT '删除标志位：0：存在，1：删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `project_id`(`project_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_course
-- ----------------------------
INSERT INTO `exercise_course` VALUES (1, '瑜伽教学', '美女老师教你最标准的瑜伽身法。', 3, '2020-03-04 14:12:20', '2021-02-01 14:12:20', 1, 200, 3, 2000.00, '/images/index_Carousel_1.jpg', 0, '2020-03-10 15:49:44', '2020-03-10 15:49:44');
INSERT INTO `exercise_course` VALUES (3, '大众健身操', '欢迎中老年人', 5, '2020-03-04 14:12:20', '2021-01-01 14:12:20', 2, 200, 5, 1998.00, '/images/index_Carousel_2.jpg', 0, '2020-03-10 15:49:44', '2020-03-10 15:49:44');
INSERT INTO `exercise_course` VALUES (4, '健身球课程', '欢迎大家来体验', 8, '2020-03-05 14:12:20', '2021-01-01 14:12:20', 3, 200, 6, 2998.00, '/images/index_Carousel_3.jpg', 0, '2020-03-10 15:49:44', '2020-03-10 15:49:44');
INSERT INTO `exercise_course` VALUES (5, '有氧舞蹈开始啦', '游戏不如跳舞~', 4, '2020-03-13 16:33:31', '2020-07-30 00:00:00', NULL, 100, 7, 1222.00, '/images/yoga-1842292_640.jpg', 0, '2020-03-13 16:33:31', '2020-03-13 16:33:31');

-- ----------------------------
-- Table structure for exercise_order
-- ----------------------------
DROP TABLE IF EXISTS `exercise_order`;
CREATE TABLE `exercise_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` bigint(20) NULL DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `payment` decimal(20, 2) NULL DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` int(4) NULL DEFAULT NULL COMMENT '支付类型,1-在线支付,2-现金，3-刷卡',
  `status` int(10) NULL DEFAULT NULL COMMENT '订单状态:0-已取消-10-未付款，20-已付款，50-交易成功，60-交易关闭',
  `remark` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '订单备注',
  `payment_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '交易完成时间',
  `close_time` datetime(0) NULL DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `order_no_index`(`order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exercise_order_item
-- ----------------------------
DROP TABLE IF EXISTS `exercise_order_item`;
CREATE TABLE `exercise_order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) NULL DEFAULT NULL,
  `order_no` bigint(20) NULL DEFAULT NULL,
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `project_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `course_id` int(11) NULL DEFAULT NULL COMMENT '，课程id',
  `current_unit_price` decimal(12, 2) NULL DEFAULT NULL COMMENT '生成订单时的课程单价，单位是元,保留两位小数',
  `total_price` decimal(20, 2) NULL DEFAULT NULL COMMENT '总价,单位是元,保留两位小数',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_no_index`(`order_no`) USING BTREE,
  INDEX `order_no_user_id_index`(`user_id`, `order_no`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exercise_place
-- ----------------------------
DROP TABLE IF EXISTS `exercise_place`;
CREATE TABLE `exercise_place`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '场地表id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '场地名称',
  `text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '场地描述',
  `user_id` int(11) NOT NULL COMMENT '教练id',
  `use_status` int(2) NULL DEFAULT 0 COMMENT ' 是否可用：0：可用-闲暇，1：不可用-繁忙',
  `del_flag` int(2) NULL DEFAULT 0 COMMENT '删除标志位：0：存在，1：删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exercise_place_reserve
-- ----------------------------
DROP TABLE IF EXISTS `exercise_place_reserve`;
CREATE TABLE `exercise_place_reserve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'placeId',
  `place_id` int(11) NOT NULL COMMENT '场地表id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `start_time` datetime(0) NOT NULL COMMENT '使用开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '结束时间',
  `use_status` int(2) NULL DEFAULT 0 COMMENT ' 是否可用：0：可用-闲暇，1：不可用-繁忙',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exercise_project
-- ----------------------------
DROP TABLE IF EXISTS `exercise_project`;
CREATE TABLE `exercise_project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目表id',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目名称',
  `text` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目描述',
  `del_flag` int(2) NULL DEFAULT 0 COMMENT '删除标志位：0：存在，1：删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_project
-- ----------------------------
INSERT INTO `exercise_project` VALUES (1, '举重', '举重训练', 0, '2020-03-04 14:12:20', '2020-03-04 14:12:20');
INSERT INTO `exercise_project` VALUES (2, '游泳', '是的，我们专门开设了教授游泳的课程', 0, '2020-03-10 15:27:54', '2020-03-10 15:27:54');
INSERT INTO `exercise_project` VALUES (3, '瑜伽', '瑜伽姿势运用古老而易于掌握的技巧，改善人们生理、心理、情感和精神方面的能力，是一种达到身体、心灵与精神和谐统一的运动方式，包括调身的体位法、调息的呼吸法、调心的冥想法等，以达至身心的合一。', 0, '2020-03-10 15:32:50', '2020-03-10 15:32:50');
INSERT INTO `exercise_project` VALUES (4, '有氧舞蹈', '有氧舞蹈(AEROBICDANCE)一方面能消耗较多热量，一方面能把许多舞蹈动作健美操化，不像健美操动作比较操化，它有许多风格，根据动作、音乐的不同特点分：AEROBICDANCE，HIP-HOP，FUNK，SALSA等有氧舞蹈。', 0, '2020-03-10 15:33:46', '2020-03-10 15:33:46');
INSERT INTO `exercise_project` VALUES (5, '大众健身操', '运动活动范围涉及全身每个关节，在一节为五十分钟左右的课程中，健身者在音乐、灯光、教练的口令、参与伙伴的鼓励与带动下进行有节奏的、循序渐进的有氧运动。可燃烧大量的脂肪，提高参与者的心肺功能。不失为减肥、保持体能、体型的首选。', 0, '2020-03-10 15:34:29', '2020-03-10 15:34:29');
INSERT INTO `exercise_project` VALUES (6, '跑步', '跑步也是适合男士健身的项目之一，对于减肥和锻炼身体都有很好的益出。我们有专业的老师开设课程手把手教您如何正确的跑步！', 0, '2020-03-10 15:34:54', '2020-03-10 15:34:54');
INSERT INTO `exercise_project` VALUES (7, '时速单骑(spinnig)', '它是目前欧美最流行的有氧健身项目之一，有人把这项运动称做“自行车上的舞蹈”，通过运动使车轮不停地旋转、还可自行调节运动负荷，运动量可大可小、易学、易练又动感十足，从而达到减少腰腹部的赘肉、健美下肢和提高心肺功能的效果，', 0, '2020-03-10 15:35:26', '2020-03-10 15:35:26');
INSERT INTO `exercise_project` VALUES (8, '健身球', '健身球现在不再仅作为一种理疗，它也成为新兴的健身运动。', 0, '2020-03-10 15:36:23', '2020-03-10 15:36:23');
INSERT INTO `exercise_project` VALUES (9, '搏击健美操', '这个项目是结合音乐、舞蹈、拳击、搏击等特点而形成的健美操。搏击健美操与拳击boxing不同的是前者的目标是健身，后者目标是打赢比赛，更易受伤，不适合大众。它是对搏击或健美操的补充。它可以提高自信心，肌肉的协调性和必要的技巧与柔韧性。', 0, '2020-03-10 15:36:53', '2020-03-10 15:36:53');
INSERT INTO `exercise_project` VALUES (10, '杠铃操', '杠铃操是最能减脂的健身项目，也是能快速瘦身的办法，很多男性朋友也比较钟爱', 0, '2020-03-10 15:40:19', '2020-03-10 15:40:19');

-- ----------------------------
-- Table structure for exercise_qd
-- ----------------------------
DROP TABLE IF EXISTS `exercise_qd`;
CREATE TABLE `exercise_qd`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '签到表id',
  `user_id` int(11) NOT NULL COMMENT '签到人id',
  `qd_time` datetime(0) NOT NULL COMMENT '签到时间',
  `del_flag` int(2) NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_qd
-- ----------------------------
INSERT INTO `exercise_qd` VALUES (1, 4, '2020-03-13 17:50:16', 0);
INSERT INTO `exercise_qd` VALUES (5, 4, '2020-03-14 14:07:03', 0);
INSERT INTO `exercise_qd` VALUES (6, 4, '2020-03-16 15:09:07', 0);
INSERT INTO `exercise_qd` VALUES (7, 14, '2020-03-17 13:10:50', 0);
INSERT INTO `exercise_qd` VALUES (8, 15, '2020-03-17 13:17:30', 0);
INSERT INTO `exercise_qd` VALUES (9, 4, '2020-03-20 17:50:19', 0);
INSERT INTO `exercise_qd` VALUES (10, 4, '2020-03-23 18:06:43', 0);
INSERT INTO `exercise_qd` VALUES (11, 4, '2020-03-24 16:58:05', 0);
INSERT INTO `exercise_qd` VALUES (12, 4, '2020-03-25 17:43:31', 0);

-- ----------------------------
-- Table structure for exercise_time
-- ----------------------------
DROP TABLE IF EXISTS `exercise_time`;
CREATE TABLE `exercise_time`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '时间段id',
  `text` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '时间段：1:8:00-10:00，2:10:00-12:00，3:12:00-14:00，4:14:00-16:00，5:16:00-18:00，6:18:00-20:00，7:20:00-22:00',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exercise_user
-- ----------------------------
DROP TABLE IF EXISTS `exercise_user`;
CREATE TABLE `exercise_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码，MD5加密',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真名',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重置密码验证码',
  `role` int(4) NOT NULL COMMENT '角色： 0-管理员,1-会员,2-教练',
  `vip_status` int(4) NOT NULL COMMENT '会员是否办卡标志位：1：办理，0：未办理',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_name_unique`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_user
-- ----------------------------
INSERT INTO `exercise_user` VALUES (1, 'wonder', '123456', 'wonder', 'xanwidtf@foxmail.com', '13481926610', NULL, 0, 1, '2020-03-03 15:40:21', '2020-03-10 14:52:31');
INSERT INTO `exercise_user` VALUES (2, 'admin', '123456', '管理员', 'xanwidtf@foxmail.com', '123456789', NULL, 0, 0, '2020-03-09 10:56:07', '2020-03-14 17:27:48');
INSERT INTO `exercise_user` VALUES (3, 'yujia', '123456', '瑜伽老师', '233@qq.com', '123456', '/images/girl.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (4, 'test', '123456', '测试gggg', 't@test.com', '123456', NULL, 1, 0, '2020-03-09 13:23:54', '2020-03-09 13:23:54');
INSERT INTO `exercise_user` VALUES (5, 'dzjsc', '123456', '大众健身操老师', '233@qq.com', '123456', '/images/pig.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (6, 'jsq', '123456', '健身球老师', '233@qq.com', '123456', '/images/pig2.jpeg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (7, 'yywd', '123456', '有氧舞蹈老师', 'yywd@qq.com', '123456', '/images/xx.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (8, 'run', '123456', '跑步老师', 'run@qq.com', '123456', '/images/wstx.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (9, 'bjjmc', '123456', '搏击健美操老师', 'bjjmc@qq.com', '123456', '/images/wstx.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (10, 'youyong', '123456', '游泳老师', 'youyong@qq.com', '123456', '/images/wstx.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (11, 'ssdj', '123456', '时速单骑老师', 'ssdj@qq.com', '123456', '/images/wstx.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (12, 'glc', '123456', '杠铃操老师', 'glc@qq.com', '123456', '/images/wstx.jpg', 2, 0, '2020-03-09 11:01:08', '2020-03-09 11:01:08');
INSERT INTO `exercise_user` VALUES (14, 'ttt', '123456', 'hhh', '233@qq.com', '111111', NULL, 1, 0, '2020-03-17 13:10:14', '2020-03-17 13:10:14');
INSERT INTO `exercise_user` VALUES (15, 'vvv', '1123456', 'vvv', '233@qq.com', '111111', NULL, 1, 0, '2020-03-17 13:16:56', '2020-03-17 13:16:56');

-- ----------------------------
-- Table structure for exercise_user_card
-- ----------------------------
DROP TABLE IF EXISTS `exercise_user_card`;
CREATE TABLE `exercise_user_card`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户表id',
  `start_time` datetime(0) NOT NULL COMMENT '有效期开始时间',
  `end_time` datetime(0) NOT NULL COMMENT '有效期截止时间',
  `lost_status` int(2) NULL DEFAULT 0 COMMENT ' 是否挂失：0：没有挂失，1：挂失',
  `use_status` int(2) NULL DEFAULT 0 COMMENT ' 是否可用：0：可用，1：不可用',
  `del_flag` int(2) NULL DEFAULT 0 COMMENT '是否退卡：0：存在，1：退卡，即删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exercise_user_course
-- ----------------------------
DROP TABLE IF EXISTS `exercise_user_course`;
CREATE TABLE `exercise_user_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课表主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `course_id` int(11) NOT NULL COMMENT '课程id',
  `del_flag` int(2) NULL DEFAULT NULL COMMENT '删除标志位：0：存在，1：删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_user_course
-- ----------------------------
INSERT INTO `exercise_user_course` VALUES (1, 4, 1, 0, '2020-03-12 16:34:59');
INSERT INTO `exercise_user_course` VALUES (5, 1, 1, 0, '2020-03-12 16:34:59');
INSERT INTO `exercise_user_course` VALUES (6, 4, 3, 0, '2020-03-16 15:08:57');
INSERT INTO `exercise_user_course` VALUES (7, 14, 4, 0, '2020-03-17 13:10:43');
INSERT INTO `exercise_user_course` VALUES (8, 14, 1, 0, '2020-03-17 13:10:56');
INSERT INTO `exercise_user_course` VALUES (9, 15, 1, 0, '2020-03-17 13:17:51');
INSERT INTO `exercise_user_course` VALUES (10, 4, 5, 0, '2020-03-23 18:06:33');

-- ----------------------------
-- Table structure for exercise_user_wallet
-- ----------------------------
DROP TABLE IF EXISTS `exercise_user_wallet`;
CREATE TABLE `exercise_user_wallet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '钱包id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `money` decimal(12, 2) UNSIGNED NOT NULL DEFAULT 0.00 COMMENT 'money',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exercise_user_wallet
-- ----------------------------
INSERT INTO `exercise_user_wallet` VALUES (1, 2, 100000.00);
INSERT INTO `exercise_user_wallet` VALUES (2, 9, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (3, 5, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (4, 12, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (5, 6, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (6, 8, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (7, 11, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (8, 4, 19994985.00);
INSERT INTO `exercise_user_wallet` VALUES (9, 1, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (10, 10, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (11, 3, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (12, 7, 0.00);
INSERT INTO `exercise_user_wallet` VALUES (13, 14, 4002.00);
INSERT INTO `exercise_user_wallet` VALUES (14, 15, 19998000.00);

SET FOREIGN_KEY_CHECKS = 1;
