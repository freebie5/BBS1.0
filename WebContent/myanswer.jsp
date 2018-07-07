<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个人中心</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"> -->
<link href="css/app_admin.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/blue.css" media="screen" rel="stylesheet" type="text/css" />
<script src="js/bbs.js" type="text/javascript"></script>
</head>
<body>
	<div id="page">
		<div id="header">
			<div class="clearfix">
				<div id="user_nav">
					<a href="index.jsp">首页</a>
				</div>
			</div>
		</div>


		<div id="content" class="clearfix">
			<div id="main">
				<div>
					<ul id="main_nav">
						<li class="activetab">我的回复</li>
					</ul>
				</div>

				<div id="activities">
					<s:iterator value="answers" id="sts">
						<div class="activity clearfix Blog">
							回复主题：<a href="User-queryTopic?topic.id=<s:property value='#sts.topic.id' />"><s:property value="#sts.topic.name" /></a><br/>
							<s:property value="#sts.content" /><br/>
							<a onclick="javascript:return deleteConfirm()" href="Topic-deleteAnswerInfo?deleteAnswerInfoRequest.userid=${sessionScope.loginUserInfo.id}&deleteAnswerInfoRequest.answerid=<s:property value='#sts.id' />">
								删除
							</a>
							<div class="activity_time">
								<s:property value="#sts.createtime" />
							</div>
						</div>
					</s:iterator>
				</div>
			</div>

			<div id="local">
				<div class="local_top"></div>

				<div id="maintain_menu">
					<h5>我的设置</h5>
					<ul class="icons">
						<li class="my_feed"><a
							href="User-queryUserInfo?queryUserInfoRequest.userid=${sessionScope.loginUserInfo.id}">个人资料</a></li>
						<li class="my_notification"><a href="password.jsp">修改密码</a></li>
						<li class="my_message"><a href="Topic-queryTopicInfo?queryTopicInfoRequest.userid=${sessionScope.loginUserInfo.id}">我的主题</a></li>
						<li class="my_group"><a href="Topic-queryAnswerInfo?queryAnswerInfoRequest.userid=${sessionScope.loginUserInfo.id}">我的回复</a></li>
						<li class="my_resume"><a href="">我的简历</a></li>
					</ul>
					<h5>我的空间</h5>
					<ul class="icons">
						<li class="my_picture"><a href="">我的相册</a></li>
						<li class="my_favorite"><a href="">我的收藏</a></li>
						<li class="my_code"><a href="">我的代码</a></li>
						<li class="my_weibo"><a href="">我的微博</a></li>
					</ul>
				</div>

				<div class="local_bottom"></div>
			</div>
		</div>

		<div id="footer">
			<div id="copyright">
				© 2003-2017 sy.com. [ <a href="#">京ICP证XXXX号</a> 京公网安备XXXX ]<br />
				XXXX有限公司版权所有<br />
			</div>
		</div>
	</div>
</body>
</html>