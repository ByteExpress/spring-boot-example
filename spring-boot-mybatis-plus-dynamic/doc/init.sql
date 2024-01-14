##create database
CREATE DATABASE IF NOT EXISTS `byteExpress` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

##create table
CREATE TABLE `byteexpress`.`cus_student`  (
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
   `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
   `gender` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
   `major` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '专业',
   `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
   `update_by` datetime NULL DEFAULT NULL COMMENT '更新人',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

CREATE TABLE `byteexpress`.`cus_teacher`  (
   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
   `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
   `gender` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '性别',
   `position` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '职位',
   `create_by` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
   `update_by` datetime NULL DEFAULT NULL COMMENT '更新人',
   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;
