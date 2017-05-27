DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', '方舟子');
INSERT INTO `user` VALUES ('002', '小红');
INSERT INTO `user` VALUES ('003', '樱木滑到');
INSERT INTO `user` VALUES ('005', '桃木');
INSERT INTO `user` VALUES ('1', '张三');
INSERT INTO `user` VALUES ('2', '李四');