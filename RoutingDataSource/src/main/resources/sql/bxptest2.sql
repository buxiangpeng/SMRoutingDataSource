CREATE DATABASE `bxptest2`;

USE `bxptest2`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `info` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `number` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert  into `user`(`id`,`info`,`name`,`number`) values (2,'8','8','8');

