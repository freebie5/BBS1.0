<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>java交流论坛后台管理系统</title>
<link rel="stylesheet" type="text/css" href="ext/resources/css/ext-all.css" />
<!-- GC -->
<!-- LIBS -->
<script type="text/javascript" src="ext/adapter/ext/ext-base.js">
	
</script>
<!-- ENDLIBS -->
<script type="text/javascript" src="ext/ext-all.js">
	
</script>

<script type="text/javascript" src="ext/ext-lang-zh_CN.js">
	
</script>
<style type="text/css">
html, body {
	font: normal 12px verdana;
	margin: 0;
	padding: 0;
	border: 0 none;
	overflow: hidden;
	height: 100%;
}

.empty .x-panel-body {
	padding-top: 0;
	text-align: center;
	font-style: italic;
	color: gray;
	font-size: 11px;
}

.x-btn button {
	font-size: 14px;
}

.x-panel-header {
	font-size: 14px;
}
</style>
<script type="text/javascript">
	Ext.onReady(function() {
		//Ext.Msg.alert('ext','welcome you!');
		var addPanel = function(btn, event) {
			var n;
			n = tabPanel.getComponent(btn.id);
			if (n) {
				tabPanel.setActiveTab(n);
				return;
			}
			n = tabPanel.add({
				id : btn.id,
				title : btn.text,
				html : '<iframe width=100% height=100% src=' + btn.id + ' />',
				//autoLoad : '',
				closable : 'true'
			});
			tabPanel.setActiveTab(n);
		}

		var item1 = new Ext.Panel({
			title : '主题管理',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [ new Ext.Button({
				id : 'Admin-listTopic',
				text : '主题列表',
				width : '100%',
				listeners : {
					click : addPanel
				}})
			
			]
		});

		var item2 = new Ext.Panel({
			title : '回复管理',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [ new Ext.Button({
				id : 'Admin-listAnswer',
				text : '回复列表',
				width : '100%',
				listeners : {
					click : addPanel
				}})
			
			]
		});

		var item3 = new Ext.Panel({
			title : '用户管理',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [ new Ext.Button({
				id : 'Admin-listUser',
				text : '用户列表',
				width : '100%',
				listeners : {
					click : addPanel
				}})
			
			]
		});
		
		var item4 = new Ext.Panel({
			title : '点击量管理',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [ new Ext.Button({
				id : 'Admin-listTopicRecorder',
				text : '点击量列表',
				width : '100%',
				listeners : {
					click : addPanel
				}})
			
			]
		});
		
		var item5 = new Ext.Panel({
			title : '最近访客',
			//html : '&lt;empty panel&gt;',
			cls : 'empty',
			items : [ new Ext.Button({
				id : 'Admin-listVisitor',
				text : '访客列表',
				width : '100%',
				listeners : {
					click : addPanel
				}})
			
			]
		});

		var accordion = new Ext.Panel({
			region : 'west',
			/* margins : '5 0 5 5', */
			split : true,
			width : 210,
			layout : 'accordion',
			items : [ item1, item2, item3, item5 ]
		});

		var tabPanel = new Ext.TabPanel({
			region : 'center',
			enableTabScroll : true,
			deferredRender : false,
			/* activeTab : 0, */
			items : [/*  {

				title : 'index',

				//html : 'aaaaaa'
				autoLoad : 'Category_add.jsp'
			} */ ]
		});

		var box = new Ext.BoxComponent({
            region:'north',
            el: 'header',
            height:32
        })
		
		var viewport = new Ext.Viewport({
			layout : 'border',
			items : [ accordion, tabPanel, box ]
		});

	});
</script>
</head>
<body>
<div id="header">
	<!-- <div style="float: left;margin:10px" class="x-small-editor">
		java交流论坛后台管理系统
	</div> -->
	<div style="float:right;margin:10px;" class="x-small-editor">	
		用户 ：${sessionScope.loginAdminInfo.name} 
	</div>
</div>
	<!-- EXAMPLES -->
</body>
</html>
