log4j知识点总结：

1.项目添加log4j
	1）新建一个Java工程，导入包log4j-1.2.17.jar
	
	2）src同级创建并设置log4j.properties
	
		log4j.rootCategory=INFO, stdout

		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%d{ABSOLUTE} %5p %t %c{2}:%L - %m%n
		
		log4j.category.org.springframework.beans.factory=DEBUG
	
	其中，rootLogger是rootCategory的子类
	
	3）类文件添加记录日志语句
		public class Test {
		
			private static Logger logger = Logger.getLogger(Test.class);
			
		    public static void main(String[] args) {
		     	
		        // System.out.println("This is println message.");  
		        // 记录debug级别的信息  
		        logger.debug("This is debug message.");
		        // 记录info级别的信息 
		        logger.info("This is info message.");  
		        // 记录error级别的信息 
		        logger.error("This is error message.");  
		     }
		
		 }
		 
2.基本使用方法
	1）Log4j由三个重要的组件构成：日志信息的优先级，日志信息的输出目的地，日志信息的输出格式。
		日志信息的优先级从高到低有ERROR、WARN、 INFO、DEBUG，分别用来指定这条日志信息的重要程度；
		日志信息的输出目的地指定了日志将打印到控制台还是文件中；
		日志信息的输出格式则控制了日志信息的显示内容。
	
	2）定义log4j.properties文件
	
		1.配置根Logger，其语法为：
		
			log4j.rootLogger = [ level ] , appenderName, appenderName, ...
		
		level 是日志记录的优先级，比如在这里定 义了INFO级别，则应用程序中所有DEBUG级别的日志信息将不被打印出来
		appenderName就是指日志信息输出到哪个地方，可以同时指定多个输出目的地
	
		2.配置日志信息输出目的地Appender：
			
			log4j.appender.stdout = org.apache.log4j.ConsoleAppender
			
		Log4j提供的appender有以下几种：
		org.apache.log4j.ConsoleAppender（控制台），
		org.apache.log4j.FileAppender（文件），  
		org.apache.log4j.DailyRollingFileAppender（每天产生一个日志文件），
		org.apache.log4j.RollingFileAppender（文件大小到达指定尺寸的时候产生一个新的文件），
		org.apache.log4j.WriterAppender（将日志信息以流格式发送到任意指定的地方）
		
		3.配置日志信息的格式（布局）：
			
			log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
		
		org.apache.log4j.HTMLLayout（以HTML表格形式布局），  
		org.apache.log4j.PatternLayout（可以灵活地指定布局模式），  
		org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串），  
		org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等等信息）
		
		4.配置输出格式：
		
			log4j.appender.stdout.layout.ConversionPattern = 
					%d{ABSOLUTE} %5p %t %c{2}:%L - %m%n
					
		%p 输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL  
		%r 输出自应用启动到输出该log信息耗费的毫秒数  
		%c 输出所属的类目，通常就是所在类的全名  
		%t 输出产生该日志事件的线程名  
		%n 输出一个回车换行符，Windows平台为“rn”，Unix平台为“n”  
		%d 输出日志时间点的日期或时间，默认格式为ISO8601，也可以在其后指定格式，比如：
			%d{yyy MMM dd HH:mm:ss,SSS}，输出类似：2002年10月18日 22：10：28，921  
		%l 输出日志事件的发生位置，包括类目名、发生的线程，以及在代码中的行数。举例：
			Testlog4.main(TestLog4.java:10)
	
		5.设置package输出级别
			
			可以设置不同package的日志输出级别，语法为：
			
				log4j.logger.packageName=level
			
			其中，packageName为实际的包名，level为日志级别
			
		
	
	
	
	