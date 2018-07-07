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


<title>回复列表</title>

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
			<b>回复</b>
		</dt>
		<dd>
			<ul>
				<s:iterator value="answers" id="sts">
					<li>
						<span>
							<a onclick="javascript:return deleteConfirm()" href="Admin-deleteAnswer?deleteAnswerInfoRequest.answerid=<s:property value='#sts.id' />">
								删除
							</a>
						</span>
						<span>用户：<s:property value="#sts.user.name"/></span>
						<span>回复时间：<s:property value="#sts.createtime"/></span>
						[回复主题]
						<s:property value="#sts.topic.name"/>
						<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[回复内容]
						<s:property value="#sts.content"/>
					</li>
				</s:iterator>
			</ul>
		</dd>
	</dl>
</body>
</html>
