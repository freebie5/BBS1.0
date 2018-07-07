function initPage() {
	isLogin();
	// initIndex();
}

// 判断是否登录，如果已经登录，则状态栏显示 首页、用户名（工人中心）
function isLogin() {
	var username = document.getElementById("username").value;
	var userid = document.getElementById("userid").value;
	if (userid != "") {
		// alert(userid);
		// 清除原状态栏
		document.getElementById('user_nav').innerHTML = "";
		// 添加新的状态信息
		var index = document.createElement("a");
		index.href = "index.jsp";
		index.innerText = "首页";
		document.getElementById('user_nav').appendChild(index);

		var center = document.createElement("a");
		center.href = "User-queryUserInfo?queryUserInfoRequest.userid="
				+ /* encodeURI(userid,'UTF-8') */userid;
		center.className = "welcome";
		center.innerText = "欢迎，" + username;
		document.getElementById('user_nav').appendChild(center);

		var btn = document.getElementById('publish').style.visibility = "visible";

	}
}
// 初始化index.jsp首页
function initIndex() {
	window.location.href = "User-listTopic";
}

// 根据返回值选择性别
function centerSelectSex() {
	var flag = document.getElementById("selectsex").value;
	var options = document.getElementById("user_gender").options;
	if(flag==0) {
		options[0].selected=true;
	} else if(flag==1) {
		options[1].selected=true;
	} else {
		options[2].selected=true;
	}
}

// 删除确认
function deleteConfirm() {
	var msg = "您真的确定要删除吗？";
	if (confirm(msg) == true) {
		return true;
	} else {
		return false;
	}
}