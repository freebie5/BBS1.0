<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>主题列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/item.css" />
<script src="../js/bbs.js" type="text/javascript"></script>
</head>

<body>
	<!-- Category_list
	<a href="admin/Category-addInput">添加Category</a>
	<a href="admin/Category-updateInput">更新Category</a>
	<a href="admin/Category-delete">删除Category</a> -->
	<dl class="list_dl">
		<dt>
			<b>访客</b>
		</dt>
		<dd>
			<ul>
				<s:iterator value="visitors" id="sts">
					<li>
						<%-- <span>
							<a onclick="javascript:return deleteConfirm()" href="Admin-deleteTopic?deleteTopicInfoRequest.topicid=<s:property value='#sts.id' />">
								删除
							</a>
						</span> --%>
						<%-- <span>用户：<s:property value="#sts.user.name"/></span> --%>
						<span>访问时间：<s:property value="#sts.createtime"/></span>
						[访客ip]
						<s:property value="#sts.ip"/>
					</li>
				</s:iterator>
			</ul>
		</dd>
	</dl>
</body>
</html>
