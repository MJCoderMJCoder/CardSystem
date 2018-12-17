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
function clickCreateCardButton()
{
	document.getElementById("page").src = "/CardSystem/admin/createCard.jsp";
}
function clickCardInfoButton()
{
	document.getElementById("page").src = "/CardSystem/admin/cardInfo.jsp";
}
function clickRechargeButton()
{
	document.getElementById("page").src = "/CardSystem/admin/recharge.jsp";
}
function clickHistoryButton()
{
	document.getElementById("page").src = "/CardSystem/admin/history.jsp";
}
function clickLockCardButton()
{
	document.getElementById("page").src = "/CardSystem/admin/lockCard.jsp";
}
function clickDeleteCardButton()
{
	document.getElementById("page").src = "/CardSystem/admin/deleteCard.jsp";
}
function clickShowCardListButton()
{
	document.getElementById("page").src = "showCardList.action";
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
				<button id="createCardButton" onclick="clickCreateCardButton()" style="width:150px;font-size: 16px">创建卡</button>
			</li>
			<li>
				<button id="showCardListButton" onclick="clickShowCardListButton()" style="width:150px;font-size: 16px">列出所有卡</button>
			</li>
			<li>
				<button id="recharge" onclick="clickRechargeButton()" style="width:150px;font-size: 16px">充值</button>
			</li>
			<li>
				<button id="cardInfo" onclick="clickCardInfoButton()" style="width:150px;font-size: 16px">查看卡信息</button>
			</li>
			<li>
				<button id="historyButton" onclick="clickHistoryButton()" style="width: 150px;font-size: 16px">查询交易记录</button>
			</li>
			<li>
				<button id="lockCardButton" onclick="clickLockCardButton()" style="width: 150px;font-size: 16px">挂失管理</button>
			</li>
			<li>
				<button id="deleteCardButton" onclick="clickDeleteCardButton()" style="width: 150px;font-size: 16px">注销卡</button>
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