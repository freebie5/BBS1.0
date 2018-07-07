maven的版本：apache-maven-3.3.9
	
maven的功能：
	构建工具
	依赖管理工具
	项目信息管理工具

1.安装配置：
	1）新建一个环境变量：M2_HOME，变量值：D:\apache-maven-3.3.9
	2）环境变量Path添加：%M2_HOME%\bin
	3）测试是否安装成功
		打开cmd，输入echo %M2_HOME%，显示环境变量值
		输入mvn -v，显示maven版本信息和jdk信息
		
	4）配置用户范围settings.xml，复制M2_HOME\conf\settings.xml文件 到 ~\.m2\settings.xml

	5）配置代理，打开 ~\.m2\settings.xml，添加如下片段
	<settings>
	...
		<proxies>
		   <proxy>    
		     <id>myProxy</id>    
		     <active>true</active>    
		     <protocol>http</protocol>    
		     <host>123.123.123.123</host>    
		     <port>8080</port>    
		     <username>XXXXX</username>    
		     <password>XXXXX</password>
		     <!-- 不需要代理的网址 -->
		     <nonProxyHosts>*.XXX.com|XXX.org</nonProxyHosts>    
		   </proxy>    
		 </proxies> 
	 ...
	 </settings>
	 
2.理解pom.xml文件
	
	<project xmlns="http://maven.apache.org/POM/4.0.0"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
			http://maven.apache.org/maven-v4_0_0.xsd">
		<!-- maven2和maven3固定配置4.0.0 -->
		<modelVersion>4.0.0</modelVersion>
		<!-- maven坐标 -->
		<groupId>com.sy</groupId>
		<artifactId>bbs</artifactId>
		<packaging>war</packaging>
		<version>0.0.1-SNAPSHOT</version>
		<!--  -->
		<name>bbs Maven Webapp</name>
		<url>http://maven.apache.org</url>
		
		<!-- 依赖 -->
		<dependencies>
			<dependency>
				<groupId>junit</groupId>
				<artifactId>junit</artifactId>
				<version>3.8.1</version>
				<scope>test</scope>
			</dependency>
		</dependencies>
		
		<!-- 插件的配置放这里 -->
		<build>
			<finalName>bbs</finalName>
			
			<!-- 配置maven-compiler-plugin插件使其支持java1.6 -->
			<plugins>
		  	  <plugin>
		  	    <groupId>org.apache.maven.plugins</groupId>
		  	    <artifactId>maven-compiler-plugin</artifactId>
		  	    <configuration>
		  	      <source>1.6</source>
		  	      <target>1.6</target>
		  	    </configuration>
		  	  </plugin>
		</build>
	</project>

3.maven坐标 和 maven依赖：
	1）坐标五个基本属性：groupId， artifactId， version， packaging， classifier
	<groupId>com.sy</groupId>
	<artifactId>bbs</artifactId>
	<packaging>war</packaging>
	<version>0.0.1-SNAPSHOT</version>
	
	2）依赖基本属性：groupId， artifactId， version， type（一般不用配置）， scope（依赖范围）， 
		exclusions（用来排除传递性依赖）， optional（标记依赖是否可选）
	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	
	3）依赖范围（compile，test，provided（编译测试，例如servlet-api），runtime，system）
	三种classpath（编译classpath，测试classpath，运行classpath）
	
	4）传递性依赖
		A -> B
		B -> C
	则，A -> C
	
	5）依赖解调（两个原则），主要用于相同依赖的不同版本号
	
		1.路径最近者优先
			A -> B -> C -> Y1.0
			A -> D -> Y1.1
		Y1.1会被解析使用
		
		2.第一声明者优先
			当传递性依赖路径一样长时，pom.xml文件依赖声明的顺序，先声明的会被解析使用
			
	6）可选依赖
		
		A -> B
		B -> X（可选）
		B -> Y（可选）
	则，A没有传递性依赖
	
	当A依赖于B，实际需要使用X依赖，则必须声明X依赖
		
	7）排除依赖
	
		A -> B ->（排除） C
		A -> C
	配置pom.xml文件
		<project>
			<modelVersion>4.0.0</modelVersion>
			<groupId>com.juven.mvnbook</groupId>
			<artifactId>a</artifactId>
			<version>1.0</version>
			<dependencies>
				<dependency>
					<groupId>com.juven.mvnbook</groupId>
					<artifactId>b</artifactId>
					<version>1.0</version>
					<exclutions>
						<exclution>
							<groupId>com.juven.mvnbook</groupId>
							<artifactId>c</artifactId>
							<!-- 不需要声明版本号，因为依赖调节的原因，不存在同一个依赖，两个版本号的情况 -->
						</exclution>
					</exclutions>
				</dependency>
				
				<dependency>
					<groupId>com.juven.mvnbook</groupId>
					<artifactId>my-c</artifactId>
					<version>1.0</version>
				</dependency>
			</dependencies>
		</project>
		
	8）归类依赖，配置一个properties片段，声明一个全局变量，version标签就可以引用
	
		<project>
			<modelVersion>4.0.0</modelVersion>
			<groupId>com.juven.mvnbook</groupId>
			<artifactId>bbs</artifactId>
			<version>1.0</version>
			
			<properties>
				<springframework>2.5.6</springframework>
			</properties>
			
			<dependencies>
				<!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
				<dependency>
				    <groupId>org.springframework</groupId>
				    <artifactId>spring-core</artifactId>
				    <version>springframework</version>
				</dependency>
				
				<!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
				<dependency>
				    <groupId>org.springframework</groupId>
				    <artifactId>spring-context</artifactId>
				    <version>springframework</version>
				</dependency>
				
				<!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
				<dependency>
				    <groupId>org.springframework</groupId>
				    <artifactId>spring-beans</artifactId>
				    <version>springframework</version>
				</dependency>
				
			</dependencies>
		</project>
	
	
	
	
	
4.maven仓库
	1）本地仓库 和 远程仓库（中央仓库，私服）
		自定义本地仓库路径，settings.xml文件添加片段
		<settings>
		...
			<localRepository>D:\.m2\repository</localRepository>
		...
		</settings>
		
	2）配置远程仓库，pom.xml配置如下片段
	
	<project>
		...
		<repositories>
	        <!--<repository>-->
	            <!--<id>spring-snapshots</id>-->
	            <!--<url>http://maven.oschina.net/content/groups/public/</url>-->
	            <!--<snapshots>-->
	                <!--<enabled>true</enabled>-->
	            <!--</snapshots>-->
	        <!--</repository>-->
	        <repository>
	            <id>springsource-repos</id>
	            <name>SpringSource Repository</name>
	            <url>http://repo.spring.io/release/</url>
	        </repository>
	        <repository>
	            <id>central-repos</id>
	            <name>Central Repository</name>
	            <url>http://repo.maven.apache.org/maven2</url>
	        </repository>
	        <repository>
	            <id>central-repos2</id>
	            <name>Central Repository 2</name>
	            <url>http://repo1.maven.org/maven2/</url>
	        </repository>
	    </repositories>
	    ...
	</project>
5.仓库搜索服务：
	1）MVNrepository：http://www.mvnrepository.com/
	
6.maven版本管理
	1）版本管理  区别  版本控制
		
		版本管理：项目整体版本的演化过程管理，如从1.0SNAPSHOT到1.0，再到1.1SNAPSHOT
		
		版本控制：指借助版本控制工具（git，svn）追踪代码的每一个变更
	

7.maven生命周期 和 插件：生命周期是抽象的，实际行为由插件完成

	1）三套生命周期：每套生命周期包含一些阶段（phase），例如clean生命周期包含的阶段有：pre-clean、clean、post-clean
		clean：清理项目
		default：构建项目
		site：建立项目站点
	
	2）插件：每个 插件 包含多个 插件目标，例如：maven-dependency-plugin包含：dependency：analyze、dependency：tree、dependency：list
	
	3）每个生命周期阶段（phase） 绑定 一个 插件目标，例如：default生命周期compile阶段绑定maven-compiler-plugin插件的compile目标
	
	
8.继承（注意：配置继承后，执行安装命令是要先安装父工程）
	1）需求：统一管理各个模块项目中对junit依赖的版本号
	
	2）解决思路：将junit依赖统一提取到“父”工程中，在子工程中声明junit依赖是不指定版本号，以父工程中统一设定为准，同时也便于修改
	
	3）操作步骤：
	
		a）创建一个maven工程做为父工程，注意：打包方式：pom
		
			<groupId>com.yuanls</groupId>
			<artifactId>ylsframework</artifactId>
			<version>1.0.0-SNAPSHOT</version>
			<packaging>pom</packaging>
		
		b）在子工程中声明对父工程的引用
		
			<parent>
				<groupId>com.yuanls</groupId>
				<artifactId>ylsframework</artifactId>
				<version>1.0.0-SNAPSHOT</version>
				<!-- 以当前pom.xml文件为基准的父工程的pom.xml文件的相对路径 -->
				<!-- 先找该路径下的父pom.xml，如果找不到就去本地仓库找 -->
				<relativePath>../ylsframework/pom.xml</relativePath>
			</parent>
		
		c）将子工程的坐标中与父工程坐标中重复的内容删除
		
			<groupId>com.yuanls</groupId>
			<version>1.0.0-SNAPSHOT</version>
			
		d）在父工程中统一  管理   junit的依赖
		
			<dependencyManagement>
				<dependencies>
					<groupId>junit</groupId>
				    <artifactId>junit</artifactId>
				    <version>4.12</version>
				    <scope>test</scope>
				</dependencies>
			</dependencyManagement>
		
		e）在子工程中删除junit依赖的版本号部分	
			
			<version>4.12</version>
	
9.聚合
	1）作用：一键安装各个模块工程
	
	2）配置方式：在一个“总的聚合工程”中配置各个参与聚合的模块
		
		<!-- 配置聚合 -->
		<modules>
			<!-- 指定各个子工程的相对路径 -->
			<module>../ylsframework-comm</module>
			<module>../ylsframework-commweb</module>
			<module>../ylsframework-frameweb</module>
			<module>../ylsframework-limit</module>
			<module>../ylsframework-util</module>
			<module>../ylsframework-web</module>
			<module>../ylsframework-web-dist</module>		
		</modules>

	3）使用方式：在聚合工程的pom.xml上右击 ->run as ->maven install
	
10.常用命令
	1）引入自己的jar包
	mvn install:install-file -Dfile=D:\hanlp-1.5.4.jar -DgroupId=com.hankcs -DartifactId=hanlp -Dversion=1.5.4 -Dpackaging=jar