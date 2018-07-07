<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录java交流论坛</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon"> -->
<link href="css/forum.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/passport.css" media="screen" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="page">
		<div id="header">
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
				<div id="wrap">
					<div class="passport">
						<h1 class="tit_1">
							<img src="images/tit_login.gif" title="用户登录" alt="用户登录" />用户登录
						</h1>
						<!-- login -->
						<div class="login">
							<ul id="tags" class="tab">
								<li class="selectTag"></li>
							</ul>
							<div id="tagContent">
								<div class="tagContent selectTag" id="tagContent0">
									<!--form tab-->
									<div align="center" style="color:#F00">
										<s:property value="registerResponse.result"/>
										<s:property value="fieldErrors.loginError[0]"/>
									</div>
									<%-- <s:debug></s:debug> --%>
									<form action="User-login" id="login_form" method="post">
										<table border="0" cellspacing="0" cellpadding="0"
											class="table_1">
											<colgroup>
												<col width="60" />
												<col />
											</colgroup>
											<tbody>
												<tr>
													<th>用户名</th>
													<td><input class="input_1 required" id="user_name"
														name="loginRequest.name" placeholder="用户名" tabindex="1" type="text"
														value="" /></td>
												</tr>
												<tr>
													<th>密码</th>
													<td><input class="input_1 required" id="password"
														name="loginRequest.password" tabindex="2" type="password" value="" /></td>
												</tr>
												<tr>
													<th>&nbsp;</th>
													<td>
														<input id="auto" name="remember_me" tabindex="3"type="checkbox" value="1" />
														<label for="auto">下次自动登录</label>
														<a href="">忘记密码？</a>
													</td>
												</tr>
												<tr>
													<th>&nbsp;</th>
													<td><input type="submit" name="button" id="button"
														value="登　录" class="btn_1 submit" tabindex="4" /></td>
												</tr>
											</tbody>
										</table>
									</form>
								</div>
							</div>
						</div>
						<div class="login_info">
							<dl>
								<dt>java交流论坛是软件开发深度交流社区，加入我们</dt>
								<dd>你能够：</dd>
								<dd>
									<ul>
										<li>加入优质的深度技术论坛</li>
										<li>马上拥有新颖的技术博客</li>
										<li>获得技术群组的人际交往</li>
										<li>获得职业发展方面的建议</li>
									</ul>
								</dd>
								<dd>
									想使用全部功能？<a href="register.jsp" tabindex="5">立即注册</a>
								</dd>
							</dl>
						</div>
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