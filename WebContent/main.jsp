<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>java交流论坛</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"> -->
<link href="css/forum.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/passport.css" media="screen" rel="stylesheet" type="text/css" />
<script src="js/bbs.js" type="text/javascript"></script>
</head>
<body onload="isLogin()">
	
	<div id="page">
		<div id="header">
			<input type="hidden" id="userid"  value="${sessionScope.loginUserInfo.id}"/>
			<input type="hidden" id="username"  value="${sessionScope.loginUserInfo.name}"/>
			<%-- <s:debug></s:debug> --%>
			<div class="clearfix">
				<div id="user_nav">
					<a href="index.jsp">首页</a>
					<a href="login.jsp" class="welcome" title="登录">您还未登录！</a>
					<a href="login.jsp">登录</a>
					<a href="register.jsp" class="nobg">注册</a>
				</div>
			</div>
		</div>

		<div id="content" class="clearfix">
			<div id="main">

				<div class="actions" id="publish" style="visibility:hidden;">
		          	<div class="buttons">
		            	<a href="publish.jsp" class="new_topic" title="发表新帖">&nbsp;</a>
		          	</div>
		        </div>
				<table id="forum_main" cellspacing="1">
					<thead>
						<tr>
							<td colspan="2" class="first_col" style="width: 620px;">主题</td>
							<td class="first_col" style="width: 60px;">回复</td>
							<td class="first_col" style="width: 60px;">作者</td>
							<td class="first_col" style="width: 180px;">最新文章</td>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="topices" id="sts">
							<tr>
								<td class="read_forum"></td>
								<td class="forum_description">
									<a href="User-queryTopic?topic.id=<s:property value='#sts.id'/>" class="forumtitle"><s:property value="#sts.name"/></a><br/>
									<s:property value="#sts.name"/><br/>
								</td>
								<td class="forum_index"><s:property value="#sts.answers.size"/><br/></td>
								<td class="forum_index"><s:property value="#sts.user.name"/></td>
								<td class="forum_index">
									<s:property value="#sts.createtime"/><br/>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>

		<div id="footer">
			<div id="copyright">
				© 2003-2017 sy.com. [ <a href="#">京ICP证XXXX号</a>京公网安备XXXX ]<br/>
				XXXX有限公司 版权所有<br/>
			</div>
		</div>
	</div>
</body>
</html>