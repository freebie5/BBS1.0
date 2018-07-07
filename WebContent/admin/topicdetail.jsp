<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>主题内容</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script src="../js/bbs.js" type="text/javascript"></script>
</head>

<body>
	<div>
		<a href="Admin-listTopic">返回主题列表</a>
	</div>
	<div>
		<h4>主题：<s:property value="topic.name"/></h4>
	</div>
	<div>
		<table border="1" width="600" bgcolor="#C0C0C0">
			<tr>
				<th>作者</th>
				<th>内容</th>
				<th>发表时间</th>
				<th>浏览次数</th>
			</tr>
			<tr>
				<td><s:property value="topic.user.name"/></td>
				<td><s:property value="topic.content"/></td>
				<td><s:property value="topic.createtime"/></td>
				<td><s:property value="count"/></td>
			</tr>
			
		</table>
		<br/>
		<table border="1" width="600" bgcolor="#C0C0C0">
			<tr>
				<th>回复</th>
				<th>内容</th>
				<th>回复时间</th>
			</tr>
			<s:iterator value="answers" id="sts">
				<tr>
					<td><s:property value="#sts.user.name"/></td>
					<td><s:property value="#sts.content"/></td>
					<td><s:property value="#sts.createtime"/></td>
				</tr>
			</s:iterator>
		</table>
		<br/>
		<a onclick="javascript:return deleteConfirm()" href="Admin-deleteTopic?deleteTopicInfoRequest.topicid=<s:property value='topic.id' />">
			删除
		</a>
	</div>
</body>
</html>
