 CREATE TABLE `dictionary` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `name` varchar(32) DEFAULT NULL COMMENT '字典名称',
   `key` varchar(32) DEFAULT NULL COMMENT '字典key',
   `value` varchar(1024) DEFAULT NULL COMMENT '字典value',
   `status` int(11) DEFAULT '0' COMMENT '0：有效，1删除',
   `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `insert_author` int(11) DEFAULT NULL,
   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_author` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='数据字典';
 
CREATE TABLE `file` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `key` varchar(32) DEFAULT NULL COMMENT '文件唯一标识',
   `name` varchar(128) DEFAULT NULL COMMENT '本地文件名',
   `file_name` varchar(128) DEFAULT NULL COMMENT '文件名',
   `url` varchar(1024) DEFAULT NULL COMMENT '文件地址',
   `size` int(11) DEFAULT NULL COMMENT '文件大小 KB',
   `status` int(11) DEFAULT '0' COMMENT '0：有效，1：删除',
   `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `insert_author` int(11) DEFAULT '0',
   `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `update_author` int(11) DEFAULT '0',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='文件';

CREATE TABLE `user` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `username` varchar(32) DEFAULT NULL COMMENT '用户名',
   `password` varchar(64) DEFAULT NULL COMMENT '密码',
   `telphone` varchar(16) DEFAULT NULL COMMENT '电话',
   `avatar` varchar(64) DEFAULT NULL COMMENT '头像',
   `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
   `is_disable` int(11) DEFAULT '0' COMMENT '1：禁用，0：启用',
   `status` int(11) DEFAULT '0' COMMENT '0:有效，1:删除',
   `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `insert_author` int(11) DEFAULT NULL,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   `update_author` int(11) DEFAULT NULL,
   `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
   `session_key` varchar(32) DEFAULT NULL COMMENT '微信session_key',
   `openid` varchar(64) DEFAULT NULL,
   `unionId` varchar(64) DEFAULT NULL,
   `gender` int(11) DEFAULT NULL COMMENT '值为1时是男性，值为2时是女性，值为0时是未知',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=100000001 DEFAULT CHARSET=utf8mb4 AVG_ROW_LENGTH=1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='用户';


CREATE TABLE `product` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `name` varchar(32) DEFAULT NULL COMMENT '产品名称',
   `price` int(11) DEFAULT 0 COMMENT '价格，单位：分',
   `imgs` varchar(1024) DEFAULT NULL COMMENT '产品图片，逗号分隔',
   `desc` varchar(1024) DEFAULT NULL COMMENT '产品描述',
   `type` int(11) DEFAULT '0' COMMENT '0：非洲鼓，1：吉他，2：钢琴',
   `status` int(11) DEFAULT '0' COMMENT '0:有效，1:删除',
   `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `insert_author` int(11) DEFAULT NULL,
   `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
   `update_author` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 AVG_ROW_LENGTH=1 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='产品表';






