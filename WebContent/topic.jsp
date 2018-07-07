<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>java交流论坛</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"> -->
<link href="css/forum.css" media="screen" rel="stylesheet"
	type="text/css" />
<link href="css/passport.css" media="screen" rel="stylesheet"
	type="text/css" />
<script src="js/bbs.js" type="text/javascript"></script>
</head>
<body onload="isLogin()">
	<div id="page">
		<div id="header">
			<input type="hidden" id="userid"  value="${sessionScope.loginUserInfo.id}"/>
			<input type="hidden" id="username"  value="${sessionScope.loginUserInfo.name}"/>
			<div class="clearfix">
				<div id="user_nav">
					<a href="index.jsp">首页</a> <a href="login.jsp" class="welcome"
						title="登录">您还未登录！</a> <a href="login.jsp">登录</a> <a
						href="register.jsp" class="nobg">注册</a>
				</div>
			</div>
		</div>

		<div id="content" class="clearfix">

			<div id="main">
				
				<div class="actions">
					<div><a href="index.jsp">返回首页</a></div>
					<div class="wrapper">
						<div class="info">浏览<s:property value="count"/>次</div>
					</div>
				</div>

				<table id="forum_main" cellspacing="1">
					<thead>
						<tr>
							<th colspan="2" class="topic_title">
								<div class="wrapper">
									主题：<s:property value="topic.name"/>
								</div>
							</th>
						</tr>
						<tr>
							<td class="first_col">作者</td>
							<td class="last_col">正文</td>
						</tr>
					</thead>
					<tbody id="posts">
						<tr id="2428364">
							<td class="postauthor">
								<ul>
									<li class="name"><s:property value="topic.user.name"/></li>									
									<li>性别: <s:property value="topic.user.sex"/></li>									
									<li>积分: <s:property value="topic.user.integral"/></li>
									<li>职业: <s:property value="topic.user.occupation"/></li>									
								</ul>
							</td>
							<td class="postcontent">
								<div class="postactions">
									<div class="description">&nbsp;&nbsp;发表时间：<s:property value="topic.createtime"/>&nbsp;&nbsp;</div>
								</div>
								<div class="postbody clearfix">								
									<br/>
									<s:property value="topic.content"/>
								</div>
							</td>
						</tr>
						
						<tr class="sep2">
							<td colspan="2"></td>
						</tr>

						<s:iterator value="answers" id="sts">
							<tr id="2428458">
								<td class="postauthor">
									<ul>
										<li class="name"><s:property value="#sts.user.name"/><br /></li>									
										<li>性别: <s:property value="#sts.user.sex"/></li>
										<li>积分: <s:property value="#sts.user.integral"/></li>
										<li>职业: <s:property value="#sts.user.occupation"/></li>
									</ul>
								</td>
								<td class="postcontent">
									<div class="postactions">
										<div class="description">&nbsp;&nbsp;发表时间：<s:property value="#sts.createtime"/>&nbsp;&nbsp;</div>
									</div>
									<div class="postbody clearfix"><s:property value="#sts.content"/></div>
								</td>
							</tr>
							
							<tr class="sep2">
								<td colspan="2"></td>
							</tr>
						</s:iterator>
						
					</tbody>
				</table>
				<div>
					<div class="quick_reply">
						<form action="User-reply" id="quick_reply_form" method="post">
						<input type="hidden" id="topicid" name="answer.topic.id" value="<s:property value='topic.id'/>"/>
						<input type="hidden" id="userid" name="answer.user.id" value="${sessionScope.loginUserInfo.id}"/>
							<span><strong>快速回复（登录后即可回复）</strong></span>
							
								<div align="center" style="color:#F00">
									<s:property value="fieldErrors.replyError[0]"/>
								</div>
																				
							<textarea class="required bad-words min-length-5 validation-passed" cols="40" id="post_body" name="answer.content" rows="20"></textarea>
							<input class="submit validation-passed" id="quick_reply_button" name="commit" type="submit" value="提交" />
							<br />
						</form>
					</div>
				</div>
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