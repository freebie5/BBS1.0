jsp知识点总结：


1.jsp生命周期：
	1） 编译阶段：servlet容器编译servlet源文件，生成servlet类
	2）初始化阶段：加载与JSP对应的servlet类，创建其实例，并调用它的初始化方法
	3）执行阶段：调用与JSP对应的servlet实例的服务方法
	4）销毁阶段：调用与JSP对应的servlet实例的销毁方法，然后销毁servlet实例

2.jsp脚本
	<%
		out.println("Your IP address is " + request.getRemoteAddr());
	%>
3.jsp声明：一个声明语句可以声明一个或多个变量、方法，供后面的Java代码使用。在JSP文件中，
	您必须先声明这些变量和方法然后才能使用它们。

	<%! int i = 0; %> 
	<%! int a, b, c; %> 
	<%! Circle a = new Circle(2.0); %> 
	
4.JSP表达式： 一个JSP表达式中包含的脚本语言表达式，先被转化成String，然后插入到表达式出现的地方。
由于表达式的值会被转化成String，所以可以在一个文本行中使用表达式而不用去管它是否是HTML标签。
表达式元素中可以包含任何符合Java语言规范的表达式，但是不能使用分号来结束表达式。

	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html>
	<html>
		<head>
			<meta charset="utf-8">
			<title>菜鸟教程(runoob.com)</title>
		</head>
		<body>
			<p>
				今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
			</p>
		</body> 
	</html>

5.JSP注释：<%-- 该部分注释在网页中不会被显示--%> 

6.JSP指令：JSP指令用来设置与整个JSP页面相关的属性

	1）<%@ page ... %> 		定义页面的依赖属性，比如脚本语言、error页面、缓存需求等等
		buffer 				指定out对象使用缓冲区的大小
		autoFlush 			控制out对象的 缓存区
		contentType 		指定当前JSP页面的MIME类型和字符编码
		errorPage 			指定当JSP页面发生异常时需要转向的错误处理页面
		isErrorPage 		指定当前页面是否可以作为另一个JSP页面的错误处理页面
		extends 			指定servlet从哪一个类继承
		import 				导入要使用的Java类
		info 				定义JSP页面的描述信息
		isThreadSafe 		指定对JSP页面的访问是否为线程安全
		language 			定义JSP页面所用的脚本语言，默认是Java
		session 			指定JSP页面是否使用session
		isELIgnored 		指定是否执行EL表达式
		isScriptingEnabled 	确定脚本元素能否被使用
		
	2）<%@ include ... %> 	包含其他文件
	3）<%@ taglib ... %> 	引入标签库的定义，可以是自定义标签
	
7.JSP行为：与JSP指令元素不同的是，JSP动作元素在请求处理阶段起作用。
JSP行为标签使用XML语法结构来控制servlet引擎。它能够动态插入一个文件，重用JavaBean组件，
引导用户去另一个页面，为Java插件产生相关的HTML等等。

	jsp:include 		用于在当前页面中包含静态或动态资源
	jsp:useBean 		寻找和初始化一个JavaBean组件
	jsp:setProperty 	设置 JavaBean组件的值
	jsp:getProperty 	将 JavaBean组件的值插入到 output中
	jsp:forward 		从一个JSP文件向另一个文件传递一个包含用户请求的request对象
	jsp:plugin 			用于在生成的HTML页面中包含Applet和JavaBean对象
	jsp:element 		动态创建一个XML元素
	jsp:attribute 		定义动态创建的XML元素的属性
	jsp:body 			定义动态创建的XML元素的主体
	jsp:text 			用于封装模板数据

8. JSP隐含对象：JSP支持九个自动定义的变量，江湖人称隐含对象。这九个隐含对象的简介见下表：

	request 		HttpServletRequest类的实例
	response 		HttpServletResponse类的实例
	out 			PrintWriter类的实例，用于把结果输出至网页上
	session 		HttpSession类的实例
	application 	ServletContext类的实例，与应用上下文有关
	config 			ServletConfig类的实例
	pageContext 	PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问
	page 			类似于Java类中的this关键字
	Exception 		Exception类的对象，代表发生错误的JSP页面中对应的异常对象

9.







