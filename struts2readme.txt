struts2学习笔记：

	struts2版本2.2.1ga
	
	常用struts2标签：使用struts2标签，jsp页面必须先导入标签库：<%@taglib uri="/struts-tags" prefix="s" %>
	1）<s:fielderror fieldName="name" theme="simple"/>获取字段错误信息
	2）<s:debug></s:debug>用于调试
	3）<s:property value="fieldErrors"/>  访问Value Stack Contents的值
	4）<s:property value="#session.username"/>  访问Stack Context的值

Action知识点：

1.实现一个action最常用方式：从ActionSupport继承

2.DMI动态方法调用：

3.通配符：
	<package name="actions" extends="struts-default" namespace="/actions">
        <action name="Student*" class="com.bjsxt.struts2.action.StudentAction" method="{1}">
            <result>/Student{1}_success.jsp</result>
        </action>
        
        <action name="*_*" class="com.bjsxt.struts2.action.{1}Action" method="{2}">
            <result>/{1}_{2}_success.jsp</result>
            <!-- {0}_success.jsp -->
        </action>
    </package>

4.接收参数的方法：一般用 属性 或者 DomainModel 接收
	
	1）属性接收
	
	2）DomainModel接收
		使用DomainModel接收jsp传过来的参数步骤：
		a）action类添加数据对象的字段和getter、setter，且数据对象类由spring注入
			private User user;
			
			public User getUser() {
				return user;
			}
			
			public void setUser(User user) {
				this.user = user;
			}
		b）jsp页面传递参数
			<a href="user/user!add?user.name=a&user.age=8">添加用户</a>

5.简单参数验证addFieldError（ognl）
	1）一般不使用struts2的ui标签
	
	2）任何一个action他的属性的值都会放在Value Stack Contents：
		<s:property value="fieldErrors"/>  访问Value Stack Contents的值
		
	3）<s:property value="#session.username"/>  访问Stack Context的值
	
6.访问web元素：
	1）自己手动获得，Map类型request、session、application
		request = (Map)ActionContext.getContext().get("request");
		session = ActionContext.getContext().getSession();
		application = ActionContext.getContext().getApplication();
	
		request.put("r1", "r1");
		session.put("s1", "s1");
		application.put("a1", "a1");
		
	*2）实现接口RequestAware、SessionAware、ApplicationAware获得，Map类型request、session、application
	这种方法最常用，而且request基本不用，因为action成员变量已经能够传值了，而且application基本不用

	3）自己手动获得，HttpServletRequest类型request、session、application
		request = ServletActionContext.getRequest();
		session = request.getSession();
		application = session.getServletContext();
		
		request.setAttribute("r1", "r1");
		session.setAttribute("s1", "s1");
		application.setAttribute("a1", "a1");
	
	4）实现接口ServletRequestAware获得，HttpServletRequest类型request、session、application
	
7.包含struts.xml文件配置：
	在主struts.xml文件添加如下片段，把login.xml配置文件包含进来
	<include file="login.xml" />

8.默认action处理：

	在struts.xml文件添加如下片段
	<package name="default" namespace="/" extends="struts-default">
    	<default-action-ref name="index"></default-action-ref>
    	<action name="index">
    		<result>/default.jsp</result>
    	</action>
    </package>
    

Result知识点：

1.result类型：

	1）dispatcher默认类型
	2）redirect客户端重定向
	3）chain（其实就是action的dispatcher）
	4）redirectAction（action的redirect）
	
2.全局result：同一个package下的action都可以共用global-results的result
	<package name="user" namespace="/user" extends="struts-default">
    	
    	<global-results>
    		<result name="mainpage">/main.jsp</result>
    	</global-results>
    	
    	<action name="index">
    		<result>/index.jsp</result>
    	</action>
    	
	    <action name="user" class="com.bjsxt.struts2.user.action.UserAction">
	    	<result>/user_success.jsp</result>
	    	<result name="error">/user_error.jsp</result>
	    </action>	    
    </package>
	
3.动态result：（用得不多，了解），用${r}这个表达式，struts.xml文件去Value Stack Contents取action的属性值r（ognl表达式的一种）

	<package name="user" namespace="/user" extends="struts-default">
    	
	    <action name="user" class="com.bjsxt.struts2.user.action.UserAction">
	    	<result>${r}</result>
	    </action>	    
    </package>
	
4.传递参数：

	1）客户端跳转才需要传递
	2）jsp页面参数?t=1，这种参数只有在Stack Context里才能拿到值



OGNL（Object Graph Navigation Language）知识点：

1.想初始化domainmodel，可以自己new，也可以传参数值，如果传参数值，需要有空的构造方法public User() {...}

2.





标签知识点：

1.通用标签
a）property
	
b）set
	
c）bean
	
d）include
	
e）param
	
f）debug

2.控制标签
a）if，else，else if
	<li>if elseif else: 
		<s:set var="age" value="#parameters.age[0]" />
		<s:if test="#age < 0">wrong age!</s:if>
		<s:elseif test="#parameters.age[0] < 20">too young!</s:elseif>
		<s:else>yeah!</s:else><br />
	</li>
b）iterator
	<li>遍历集合：<br />
		<s:iterator value="{1, 2, 3}" >
			<s:property/> |
		</s:iterator>
	</li>	
c）subset
	
3.UI标签（用得不多）
a）theme
	

4.AJAX标签

5.$，%{}，#区别：
	$用于 i18n 和 struts.xml配置文件
	%{}将原本的文本属性解析为ognl，对于本来就是ognl的属性不起作用
	#取得stack context的值









	