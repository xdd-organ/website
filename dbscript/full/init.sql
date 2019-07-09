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
