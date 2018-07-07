20170319
开始搭建ssh框架开发环境，步骤：

spring2.5.6  hibernate3.3.2  struts2.2.1ga

版本规划：
bbs1.0搭建ssh框架
bbs1.1添加注册功能
bbs1.2添加登录功能
。。。

1.了解spring基本知识点，包括：ioc和aop
	1)ioc知识点包括：
		*1.ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		2.setter注入
		3.简单属性注入，配置数据源datasource
			<bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
				<property name="driverClassName" value="${jdbc.driverClassName}" />
				<property name="url" value="${jdbc.url}" />
				<property name="username" value="${jdbc.username}" />
				<property name="password" value="${jdbc.password}" />
			</bean>
		4.scope
			singleton prototype
		5.自动装配（autowire） byName byType
			<bean id="userService" class="com.bjsxt.service.UserService" scope="prototype" autowire="byType">
			</bean>
		6.生命周期，数据源用到destroy-method="close"
			lazy-init="true"
			<bean id="userService" class="" init-method="init" destroy-method="destroy" scope="prototype">
			
		7.Annotation配置ioc
			配置beans.xml文件
			<beans xmlns="http://www.springframework.org/schema/beans"
	       		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	       		xmlns:context="http://www.springframework.org/schema/context"
	       		xsi:schemaLocation="http://www.springframework.org/schema/beans
	           		http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	           		http://www.springframework.org/schema/context
	           		http://www.springframework.org/schema/context/spring-context-2.5.xsd">
			<context:annotation-config />
			<context:component-scan base-package="com.sy.bbs" />
			
			类文件添加：
				用得不多：@AutoWire @Qualifier("u")
				
				常用：@Component @Resource
				@Component 的key为类名第一个字母小写，例如RegisterDaoImpl类的key为registerDaoImpl
				@Resource 默认按属性名称，找不到才按类型
				@Scope("prototype")
				@PostConstruct
				@PreDestroy
		
		
	2)aop知识点包括：
		*1.jdk动态代理 Proxy类，InvocationHandler类
			Business bus = new BusinessImpl();
			BusinessInvocationHandler handler = new BusinessInvocationHandler(bus);
			Business busProxy = (Business)Proxy.newProxyInstance(bus.getClass().getClassLoader(), 
					bus.getClass().getInterfaces(), handler);
			busProxy.sell();
			
		2.Annotation方式配置aop：
			配置bean.xml文件：
			<beans xmlns="http://www.springframework.org/schema/beans"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xmlns:context="http://www.springframework.org/schema/context"
				xmlns:aop="http://www.springframework.org/schema/aop"
				xsi:schemaLocation="http://www.springframework.org/schema/beans
	           		http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
	           		http://www.springframework.org/schema/context
	           		http://www.springframework.org/schema/context/spring-context-2.5.xsd
	           		http://www.springframework.org/schema/aop
	           		http://www.springframework.org/schema/aop/spring-aop-2.5.xsd">
			<context:annotation-config />
			<context:component-scan base-package="com.sy.bbs" />
			<aop:aspectj-autoproxy />
		
			切面类文件添加：
			@Aspect
			
			@Pointcut("execution(public * com.sy.bbs.dao..*.*(..))")
			public void myMethod(){};
			
			@Before("myMethod()")
			@After("myMethod()")
			@Around("myMethod()")
		
		3.几个概念：
			JoinPoint PointCut Aspect（切面） Advice（声明式事务管理xml配置方式用到） Target Weave
			
		4.xml方式配置aop：（好处：切面类如果不是自己写的，也可以把切面类添加到业务逻辑）
			<bean id="logInterceptor" class="com.sy.bbs.aop.LogInterceptor"></bean>
			<aop:config>
				<aop:pointcut expression="execution(public * com.sy.bbs.service.impl..*.*(..))" id="servicePointcut" />
				<aop:aspect id="logAspect" ref="logInterceptor" >
					<aop:pointcut expression="execution(public * com.sy.bbs.service.impl..*.*(..))" id="subServicePointcut" />
					<aop:before method="before" pointcut-ref="servicePointcut" />
					<aop:after method="after" pointcut="execution(public * com.sy.bbs.service.impl..*.*(..))"/>
				</aop:aspect>
			</aop:config>		
		
	3)spring指定datasource知识点：
		1.dbcp配置（dbcp属于datasource一种）
		<bean id="dataSource" destroy-method="close" class="org.apache.commons.dbcp.BasicDataSource">
			<property name="driverClassName" value="${jdbc.driverClassName}" />
			<property name="url" value="${jdbc.url}" />
			<property name="username" value="${jdbc.username}" />
			<property name="password" value="${jdbc.password}" />
		</bean>
		2.占位符配置
		<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
			<property name="locations">
				<value>classpath:jdbc.properties</value>
			</property>
		</bean>
		
	4)spring整合hibernate知识点：
		1.beans.xml整合hibernate基本配置，这里就用到ioc集合注入了
			配置beans.xml文件：
				<bean id="sessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
					<property name="dataSource" ref="dataSource" />
					<property name="hibernateProperties">
						<props>
							<prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
							<prop key="hibernate.show_sql">true</prop>
						</props>
					</property>
					<!-- <property name="annotatedClasses">
						<list>
							<value>com.sy.bbs.model.User</value>
						</list>
					</property> -->
					<property name="packagesToScan">
						<list>
							<value>com.sy.bbs.model</value>
						</list>
					</property>
				</bean>
				
			model类添加hibernate相关注解：
				@Entity @Id @GeneratedValue
		
		*2.声明式的事务管理Annotation方式（最好在service层添加事务管理）
			配置beans.xml文件：
			<tx:annotation-driven transaction-manager="txManager"/>这一段是基于Annotation方式配置才要添加
			
			<bean id="txManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
				<property name="sessionFactory" ref="sessionFactory" />
			</bean>
		
			服务类相关方法添加注解：（如果是runtime异常，会自动回滚）
			@Transactional
			public void register(User user) {
				Log log = new Log();
				log.setContent("test log");
				logDao.add(log);
				registerDao.add(user);
			}
		
			propagation事务的传播特性：（5个取值）
				require 默认值
				@Transactional(propagation=Propagation.REQUIRED)
			
			readOnly只读属性
				默认取值false
				@Transactional(readOnly=true)
			
		3.声明式的事务管理xml方式（最好在service层添加事务管理），推荐使用xml方式配置，因为如果service有很多个，那么就得每一service写一次@Transactional
			<tx:advice id="txAdvice" transaction-manager="txManager">
				<tx:attributes>
					<tx:method name="getUser" read-only="true" />
					<tx:method name="register" propagation="REQUIRED" />
				</tx:attributes>
			</tx:advice>
			
			<aop:config>
				<aop:pointcut id="registerService" expression="execution(public * com.sy.bbs.service..*.*(..))" />
				<aop:advisor pointcut-ref="registerService" advice-ref="txAdvice" />
			</aop:config>
			
		4.HibernateTemplate知识点：（简化了sessionFactory代码）
			配置beans.xml文件：
			<bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">
				<property name="sessionFactory" ref="sessionFactory"></property>
			</bean>
			
			dao类add方法直接调用HibernateTemplate：
			public void add(User user) {
				//hibernatetemplate方式
				hibernateTemplate.save(user);
			}
			
2.了解n层架构划分
	1)2层架构，jsp+DB
	2)2层架构，jsp+DB+User类
	3)3层架构，jsp+DB+User类+Service（User类是贫血模型，业务逻辑交给Service）
	4)n层架构，jsp+DB+User类+Service+Dao
	5)n层架构，jsp+DB+User类+Service+ServiceImpl+UserDao+UserDaoImpl
	
	
	6)n层架构，jsp+DB+User类+Service+ServiceImpl+UserDao+UserDaoImpl+Struts+Spring+Dto+Hibernate
	struts2整合spring知识点：
		1.struts基本配置，引入jar包，配置web.xml
			<filter>
				<filter-name>struts2</filter-name>
				<filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
			</filter>
		
			<filter-mapping>
				<filter-name>struts2</filter-name>
				<url-pattern>/*</url-pattern>
			</filter-mapping>
			
			配置struts.xml
			<?xml version="1.0" encoding="UTF-8" ?>
			<!DOCTYPE struts PUBLIC
				"-//Apache Software Foundation//DTD Struts Configuration 2.1//EN"
				"http://struts.apache.org/dtds/struts-2.1.dtd">
			
			<struts>
				<package name="registration" extends="struts-default">
					<action name="user" class="com.bjsxt.registration.action.UserAction">
						<result name="success">/registerSuccess.jsp</result>
						<result name="fail">/registerFail.jsp</result>
					</action>
				</package>
			</struts>
			
			新建Action类
		
		2.Struts2整合spring知识点：
			配置web.xml
			<!-- 整合spring -->
			<listener>
				<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
				<!-- beans.xml默认路径: /WEB-INF/beans.xml -->
			</listener>
			<context-param>
				<param-name>contextConfigLocation</param-name>
				<param-value>classpath:beans.xml</param-value>
			</context-param>
			
			Action类service属性添加@Resource注解
			
		3.struts读取配置文件顺序：
			struts-default.xml -> struts-plugin.xml -> struts.xml -> web.xml
			
		4.dto概念：data transfer object
		  vo概念：value object
		
			
3.常见问题
	1）中文乱码问题
		web.xml配置一个encodingfilter，该filter必须配置在struts2核心filter之前
		
		<!-- 设置页面编码 -->
		<filter>
			<filter-name>encodingFilter</filter-name>
			<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
			<init-param>
				<param-name>encoding</param-name>
				<param-value>GBK</param-value>
			</init-param>
		</filter>
		<filter-mapping>
			<filter-name>encodingFilter</filter-name>
			<url-pattern>/*</url-pattern>
		</filter-mapping>	
			
	2）struts Action由spring产生，配置方法：
		1.struts.xml配置action标签class属性为userAction
			<package name="registration" extends="struts-default">
				<action name="register" class="userAction">
					<result name="success">/registerSuccess.jsp</result>
					<result name="error">/registerFail.jsp</result>
				</action>
			</package>
 		
 		2.Action类添加注解@Component("userAction") @Scope("prototype")
			
4.spring3.0新特性
	1）SpEL语言，用在配置文件里，灵活初始化属性
		<bean id="my" class="com.bjsxt.spring30.spel.MyBean">
			<property name="randomNumber" value="#{T(java.lang.Math).random() * 100}"></property>
			<property name="userRegion" value="#{systemProperties['user.country']}"></property>
		</bean>
			
			
5.spring testing用法
	1）加入依赖jar包，包括：
	
		/LIB/Spring2.5.6/spring-test-2.5.6.jar
		/LIB/JUnit4.4/junit-4.4.jar
		
	2）创建测试类：

		@RunWith(SpringJUnit4ClassRunner.class)
		@ContextConfiguration("classpath:beans.xml")
		public class SpELTest extends AbstractJUnit4SpringContextTests{
			
			@Resource
			private MyBean my;
			
			@Test
			public void test01() {
				System.out.println(my.getRandomNumber());
				System.out.println(my.getUserRegion());
			}
		
		}	
		
		创建一个测试用的类，推荐名称为 “被测试类名称 + Test”。
		测试类应该继承：
			AbstractJUnit4SpringContextTests 或 
			AbstractTransactionalJUnit4SpringContextTests
		如果在你的测试类中，需要用到事务管理（比如要在测试结果出来之后回滚测试内容），就可以使用
		AbstractTransactionalJUnit4SpringTests类。事务管理的使用方法和正常使用Spring事务管理
		是一样的。在此需要注意的是，如果想要使用声明式事务管理，即使用
		AbstractTransactionalJUnitSpringContextTests类，请在beans.xml文件中加入片段：
		
			<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
			    <property name="dataSource" ref="dataSource" />
			</bean>
			
		如果没有添加上述bean，将会抛出NoSuchBeanDefinitionException，
		指明 No bean named 'transactionManager' is definded.	
			
			
6.MD5和验证码：

	1）MD5：用户登录，用户名和密码以明文出现，存在安全隐患			
	
7.了解acegi，现在叫spring security
			