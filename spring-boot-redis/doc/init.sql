##create database
CREATE DATABASE IF NOT EXISTS `byteExpress` DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

##create table
CREATE TABLE IF NOT EXISTS `byteExpress`.`student`  (
    `id` bigint NOT NULL COMMENT '主键',
    `name` varchar(255) NULL COMMENT '姓名',
    `gender` varchar(3) NULL COMMENT '性别',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

##insert data
insert into byteExpress.student (id, name, gender)
values  (1, '阿三', '男'),
        (2, '阿四', '女');