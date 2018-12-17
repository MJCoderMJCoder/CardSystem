<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园卡管理系统</title>
<link rel="stylesheet" href="/CardSystem/css/style.css" type="text/css">
<script type="text/javascript">
function clickChangePasswordButton()
{
	document.getElementById("page").src = "/CardSystem/student/changePassword.jsp";
}
function clickCardInfoButton()
{
	document.getElementById("page").src = "cardInfo.action";
}
function clickHistoryButton()
{
	document.getElementById("page").src = "history.action";
}
function clickChangeInfoButton()
{
	document.getElementById("page").src = "/CardSystem/student/changeInfo.jsp";
}
function clickLockCardButton()
{
	document.getElementById("page").src = "/CardSystem/student/lockCardConfirm.jsp";
}
</script>
</head>
<body style="background-image: url(/CardSystem/images/bg.jpg)">
	<div id="header">
		<a href="/CardSystem/index.jsp" class="logo"><img src="/CardSystem/images/logo.png" alt=""></a>
	</div>
	<div style="float:left;width:15%;height:850px; border-right: #123 solid 1px;">
		<ul>
			<li>
				<button id="changePassword" onclick="clickChangePasswordButton()" style="width:150px;font-size: 16px">修改密码</button>
			</li>
			<li>
				<button id="cardInfo" onclick="clickCardInfoButton()" style="width: 150px;font-size: 16px">查询卡信息</button>
			</li>
			<li>
				<button id="history" onclick="clickHistoryButton()" style="width: 150px;font-size: 16px">查询交易记录</button>
			</li>
			<li>
				<button id="changeInfo" onclick="clickChangeInfoButton()" style="width: 150px;font-size: 16px">修改卡信息</button>
			</li>
			<li>
				<button id="lockCard" onclick="clickLockCardButton()" style="width: 150px;font-size: 16px">挂失</button>
			</li>
			<li>
				<a href="/CardSystem/index.jsp"><button style="width: 150px;font-size: 16px">退出</button></a>
			</li>
		</ul>
	</div>
	<div style="float:left;width:83%;height:850px;">
	<div>
		<iframe id="page" src="" frameborder="0" width="100%" height="799px"></iframe>
	</div>
</div>
</body>
</html>