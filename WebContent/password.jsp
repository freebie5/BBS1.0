<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
						<%-- <li>
							<a href="User-queryUserInfo?queryUserInfoRequest.userid=${sessionScope.loginUserInfo.id}">个人资料</a>
						</li> --%>
						<li class="activetab">修改密码</li>
					</ul>
				</div>

				<div align="center" style="color:#F00">
					<s:property value="fieldErrors.changepasswordError[0]"/>
				</div>
				<div align="center" style="color:#F00">
					<s:property value="changePasswordResponse.result"/>
				</div>
				<br/>

				<form action="User-changePassword" id="setting_form" method="post">					
					<fieldset>
					<input name="changePasswordRequest.id" type="hidden" value="${sessionScope.loginUserInfo.id}" />
						<ul>
							<li>
								<label for="old_password">旧密码</label>
								<input type="password" name="changePasswordRequest.oldpassword" id="old_password" class="text required" />
							</li>
							<li>
								<label for="new_password">新密码</label>
								<input type="password" name="changePasswordRequest.newpassword" id="new_password" class="text required min-length-6 max-length-20 validate-ajax-/users/validate_password" />
								&nbsp;&nbsp;密码不允许纯数字或字母，长度大于5
							</li>
							<li>
								<label for="new_password_confirmation">新密码确认</label>
								<input type="password" name="changePasswordRequest.newpassword2" id="new_password_confirmation" class="text required equals-new_password" />
							</li>
						</ul>
					</fieldset>
					<div style="text-align: center;">
						<input class="submit" id="submit_button" name="commit" type="submit" value="提交" />
					</div>
				</form>
			</div>

			<div id="local">
				<div class="local_top"></div>

				<div id="maintain_menu">
					<h5>我的设置</h5>
					<ul class="icons">
						<li class="my_feed"><a href="User-queryUserInfo?queryUserInfoRequest.userid=${sessionScope.loginUserInfo.id}">个人资料</a></li>
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
				© 2003-2017 sy.com. [ <a href="#">京ICP证XXXX号</a> 京公网安备XXXX ]<br/>
				XXXX有限公司版权所有<br/>
			</div>
		</div>
	</div>
</body>
</html>