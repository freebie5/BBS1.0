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
<title>java交流论坛</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<!-- <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon"> -->
<link href="css/forum.css" media="screen" rel="stylesheet" type="text/css" />
<link href="css/passport.css" media="screen" rel="stylesheet" type="text/css" />
<script src="js/bbs.js" type="text/javascript"></script>
</head>
<body onload="isLogin()">
	<div id="page">
		<div id="header">
			<input type="hidden" id="userid"  value="${sessionScope.loginUserInfo.id}"/>
			<input type="hidden" id="username"  value="${sessionScope.loginUserInfo.name}"/>
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
				<div class="actions">
					<div><a href="index.jsp">返回首页</a></div>
					<div class="wrapper">
						
					</div>
				</div>
				<div style="padding-top: 20px">
		          <form action="User-publish" id="editor_form" method="post">
		            <input name="topic.user.id" type="hidden" value="${sessionScope.loginUserInfo.id}" />
		            <table id="forum_main" cellspacing="1">
		              <thead>
		                <tr>
		                  <td colspan="2">发表主题</td>
		                </tr>
		              </thead>
		              <tbody>
		                <tr>
		                  <td class="row1">主题</td>
		                  <td class="row2">
		                  	<input class="text" id="topic_title" maxlength="80" name="topic.name" size="45" style="width: 450px;" title="" type="text" />
		                  </td>
		                </tr>

		                <tr>
		                  <td colspan="2" class="row3">
		                    <div id="editor_switch">
			                    <span id="editor_switch_spinner" style="padding-left: 5px; display: none;">
			                    	<img alt="Spinner" src="publish_files/spinner.gif" />
			                  	</span>
			                  	<span id="editor_auto_save_update" style="padding-left: 5px;"></span>
		                    </div>
		                    <!-- <input name="auto_save_id" id="editor_auto_save_id" type="hidden" /> -->
		                    <div id="editor_preview" style="display: none; background-color: white; border: 1px solid gray; padding: 20px 5px; width: 95%; overflow-x: auto;">
		                    </div>		            
		                    <div id="editor_main">
		                      <div id="editor_wrapper" class="clearfix">		                        
		                        <div id="bbcode_controllers">		                        
		                          <textarea
		                            class="validate-richeditor bad-words min-length-5"
		                            cols="40" id="editor_body" name="topic.content" rows="20"
		                            style="width: 925px; height: 350px;"></textarea>
		                        </div>
		                      </div>
		                    </div>
		                    <div class="note" align="center">提示：内容长度最大64KB，约2万多汉字，如果出现超长（比如从Word粘贴带格式文本）被截断的问题，请分开发布</div>
		                  </td>
		                </tr>
		                <tr>
		                  <td colspan="2" class="row4" align="center"><input
		                    class="submit" id="submit_button" name="commit" value="提交"
		                    type="submit" /></td>
		                </tr>
		              </tbody>
		            </table>
		          </form>
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