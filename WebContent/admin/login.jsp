<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title>后台登录</title>
<link href="css/style_log.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/userpanel.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.ui.all.css" />

</head>

<body class="login" mycollectionplug="bind">
	<div class="login_m">
		<div class="login_logo">
			<!-- <img src="" width="196" height="46" /> -->
			<br />
			<br />
		</div>
		<div class="login_boder">
			
			<form action="Admin-login" id="login_form" method="post">
			<div align="center" style="color:#F00">
			<br />
				<s:property value="registerResponse.result"/>
				<s:property value="fieldErrors.loginError[0]"/>
			</div>
				<div class="login_padding" id="login_model">
	
					<h2>用户名</h2>
					<label>
						<input type="text" name="adminLoginRequest.name" id="username" class="txt_input" value="" />
					</label>
					<h2>密码</h2>
					<label>
						<input type="password" name="adminLoginRequest.password" id="userpwd" class="txt_input" value="" />
					</label>
					<div class="rem_sub">
						<!-- <div class="rem_sub_l">
							<input type="checkbox" name="checkbox" id="save_me" /> <label
								for="checkbox">Remember me</label>
						</div> -->
						<label>
							<input type="submit" class="sub_button"
							name="button" id="button" value="登录" style="opacity: 0.7;" />
						</label>
					</div>
				</div>
				<!--login_padding  Sign up end-->
			</form>
		</div>
		<!--login_boder end-->
	</div>
	<!--login_m end-->
	<br/>
	<br/>
	<p align="center">
		© 2003-2017 sy.com. [ <a href="#">京ICP证XXXX号</a>京公网安备XXXX ]<br/>
				XXXX有限公司 版权所有<br/>
	</p>
</body>
</html>