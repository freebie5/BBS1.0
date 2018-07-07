1.启动和关闭mysql（windows环境），进入cmd，输入
net start mysql
netstop mysql

2.mysql修改编码为utf-8，进入mysql
	1）此种方式只在当前状态下有效，当重启数据库服务后失效
		SET character_set_client = utf8; 
		SET character_set_connection = utf8; 
		SET character_set_database = utf8; 
		SET character_set_results = utf8; 
		SET character_set_server = utf8;
		
		SHOW VARIABLES LIKE 'character%';
		
	2）从my.ini下手（标签下没有的添加，有的修改） 
		[client] 
		default-character-set=utf8 
		[mysql] 
		default-character-set=utf8 
		[mysqld] 
		default-character-set=utf8 
		以上3个section都要加default-character-set=utf8，平时我们可能只加了mysqld一项
		然后重启mysql，执行 
		mysql> SHOW VARIABLES LIKE 'character%'; 
		确保所有的Value项都是utf8即可
	
	3）该配置| character_set_server | latin1 无法设置成UTF8 交互时候仍然会出现乱码
		
	
3.另外注意事项： 

	1）建表时加utf8，表字段的Collation可加可不加，不加时默认是utf8_general_ci了。 
	
		CREATE TABLE `tablename4` ( 
			`id` int(11) NOT NULL AUTO_INCREMENT, 
			`varchar1` varchar(255) DEFAULT NULL, 
			`varbinary1` varbinary(255) DEFAULT NULL, 
			PRIMARY KEY (`id`) 
		) ENGINE=MyISAM DEFAULT CHARSET=utf8 
	
	2）网页xxx.php/jsp保存时选择utf8编码，页头最好加上 
		header('conten-type:text/html;charset=utf-8'); 
		在执行CRUD操作前先执行一下 
		mysql_query("set names utf8"); 
	
	
	3）连接数据库设置编码 jdbc:mysql://地址:3306/数据库名?characterEncoding=utf8
	
	4）java中的常用编码UTF-8;GBK;GB2312;ISO-8859-1; 
	       对应mysql数据库中的编码utf8;gbk;gb2312;latin1