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
<title>个人中心</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"> -->
<link href="css/app_admin.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/blue.css" media="screen" rel="stylesheet" type="text/css" />
<script src="js/bbs.js" type="text/javascript"></script>
</head>
<body onload="centerSelectSex()">
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
						<li class="activetab">
							个人资料
						</li>
						<!-- <li><a href="password.jsp">修改密码</a></li> -->
					</ul>
				</div>
				<div align="center" style="color:#F00">
					<s:property value="queryUserInfoResponse.result"/>
				</div>
				<br/>
<input id="selectsex" type="hidden" value="<s:property value='queryUserInfoResponse.sex'/>" />
				<form action="User-changeUserInfo" id="setting_form" method="post">
					<fieldset>
					<input name="changeUserInfoRequest.id" type="hidden" value="${sessionScope.loginUserInfo.id}" />
						<ul>
							<li><label>用户名</label> <s:property value="queryUserInfoResponse.name"/> </li>
							<!-- <li><label>论坛等级</label> 新手上路</li> -->
							<li><label>论坛积分</label> <s:property value="queryUserInfoResponse.integral"/> </li>
							<li><label>加入时间</label> <s:property value="queryUserInfoResponse.createtime"/> </li>
						</ul>
						<br />
						<ul>
							<li>
								<label for="user_description">自我介绍</label>
								<textarea cols="50" id="user_description" name="changeUserInfoRequest.introduction" rows="5"><s:property value="queryUserInfoResponse.introduction"/></textarea>
							</li>
							<li>
								<label for="user_gender">性别</label> 
								<select id="user_gender" name="changeUserInfoRequest.sex">
									<option value="" ></option>
									<option value="1" >男</option>
									<option value="2" >女</option>
								</select>
							</li>
							<li>
								<label for="user_age">年龄</label>
								<input class="text" id="user_age" name="changeUserInfoRequest.age" size="30" type="text" value="<s:property value='queryUserInfoResponse.age'/>" />
							</li>
							<li>
								<label for="user_occ">职业</label>
								<input class="text" id="user_occ" name="changeUserInfoRequest.occupation" size="30" type="text" value="<s:property value='queryUserInfoResponse.occupation'/>"/>
							</li>
							<li>
								<label for="user_workyear">工作年限</label>
								<input class="text" id="user_workyear" name="changeUserInfoRequest.workyear" size="30" type="text" value="<s:property value='queryUserInfoResponse.workyear'/>" />
							</li>
							<li>
								<label for="user_hobby">爱好</label>
								<input class="text" id="user_hobby" name="changeUserInfoRequest.hobby" size="30" type="text" value="<s:property value='queryUserInfoResponse.hobby'/>" />
							</li>
							<li>
								<label for="user_qq">QQ号码</label>
								<input class="text" id="user_qq" name="changeUserInfoRequest.qq" size="30" type="text" value="<s:property value='queryUserInfoResponse.qq'/>" />
							</li>
							<li>
								<label for="user_website">个人主页</label>
								<input class="text" id="user_website" name="changeUserInfoRequest.homepage" size="30" type="text" value="<s:property value='queryUserInfoResponse.homepage'/>" />
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