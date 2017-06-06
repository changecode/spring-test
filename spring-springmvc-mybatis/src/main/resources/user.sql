DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `headImg` varchar(255) DEFAULT NULL,
  `isDeleted` int(11) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneNum` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  `openId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
#以下插入两条测试数据
LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (12,'http://localhost:8090/dheadImg/1.jpg',0,'glcnk','$2a$10$EpmkvDhQU5AHkn3Mvq1oDuJbT83aZRooqF0ZxdawiQsTz/sWfpxJa','1234','normal',NULL),(13,'http://localhost:8090/dheadImg/1.jpg',0,'psnys','$2a$10$dv4EQjbMwmUpbNB.kFySNe9RRJ1jwAXliK4FotoRLDrdfSAyWkk7C','3412','normal',NULL);
UNLOCK TABLES;