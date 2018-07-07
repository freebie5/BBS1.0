<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>用户详细信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<script src="../js/bbs.js" type="text/javascript"></script>
</head>
<body onload="centerSelectSex()">
	<div>
		<a href="Admin-listUser">返回用户列表</a>
	</div>
	<div>
		<div>
			<h4>用户详细资料</h4>
		</div>
		
		<div>
			<table border="1" bgcolor="#C0C0C0" width="400">
				<tr>
					<td>用户名</td>
					<td><s:property value="queryUserInfoResponse.name" /></td>
				</tr>
				<tr>
					<td>论坛积分</td>
					<td><s:property value="queryUserInfoResponse.integral" /></td>
				</tr>
				<tr>
					<td>加入时间</td>
					<td><s:property value="queryUserInfoResponse.createtime" /></td>
				</tr>
				<tr>
					<td>自我介绍</td>
					<td><s:property value="queryUserInfoResponse.introduction" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><s:property value="queryUserInfoResponse.sex" /></td>
				</tr>
				<tr>
					<td>年龄</td>
					<td><s:property value='queryUserInfoResponse.age' /></td>
				</tr>
				<tr>
					<td>职业</td>
					<td><s:property value='queryUserInfoResponse.occupation' /></td>
				</tr>
				
				<tr>
					<td>工作年限</td>
					<td><s:property value='queryUserInfoResponse.workyear' /></td>
				</tr>
				<tr>
					<td>爱好</td>
					<td><s:property value='queryUserInfoResponse.hobby' /></td>
				</tr>
				<tr>
					<td>QQ号码</td>
					<td><s:property value='queryUserInfoResponse.qq' /></td>
				</tr>
				<tr>
					<td>个人主页</td>
					<td><s:property value='queryUserInfoResponse.homepage' /></td>
				</tr>
				
			</table>
		</div>
		<br/>
		<div>
			<a onclick="javascript:return deleteConfirm()" href="Admin-deleteUser?deleteUserInfoRequest.userid=<s:property value='queryUserInfoResponse.id' />">
				删除
			</a>
		</div>
	</div>
</body>
</html>