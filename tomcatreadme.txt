1.Tomcat配置文件server.xml中host和context
	<Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true" xmlValidation="false" xmlNamespaceAware="false">
		<Context path="/auto" docBase="/home/V020B/autostation/web" reloadable="true" crossContext="true"></Context>
	</Host>

	1）<Host>元素用来创建主机，<Host>元素的name属性指定主机名（域名），appBase属性指定了tomcat下webapps的路径
	
	2）<Context>元素用来配置Web应用程序，path属性指定访问某个Web应用的的路径，docBase属性指定了某个Web应用的根目录



2.Tomcat在conf/Catalina/localhost目录下配置项目路径
	
	1）在tomcat服务器的conf\Catalina\localhost目录下创建一个xml文件(路径找不到就自己创建)，内容如下：
	
		<Context path="/autonew" reloadable="true" docBase="/home/V020B/autostationnew/web" workDir="/home/V020B/autostationnew/work" >
			
			<Loader className="org.apache.catalina.loader.DevLoader" 
					reloadable="true" 
					debug="1" 
					useSystemClassLoaderAsParent="false" />
		</Context>
		
	2）xml的文件名一定要和发布路径（path）一致！在本例中xml文件名必须为：autonew.xml
	