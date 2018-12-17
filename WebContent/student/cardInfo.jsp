<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/CardManagerSystem/css/style.css" type="text/css">
<style type="text/css"> 
.ss { 
    border-right: 3px inset #E3E3E3; 
    border-bottom: 3px inset #E3E3E3; 
} 
</style>
<title>校园卡管理系统</title>
</head>
<body>
	<div class="content" style="padding-left: 30%">
		<table width="400" height="300" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" class="ss" style="font-size: 16px;text-align: center"> 

			<tr>
				<td width="150" bgcolor="#F7F7F7">姓名</td>
				<td bgcolor="#F7F7F7">${requestScope.card.name }</td>
			</tr>
			<tr>
				<td width="150" bgcolor="#F7F7F7">性别</td>
				<td bgcolor="#F7F7F7">${requestScope.card.sex }</td>
			</tr>
			<tr>
				<td width="150" bgcolor="#F7F7F7">身份证</td>
				<td bgcolor="#F7F7F7">${requestScope.card.identity }</td>
			</tr>
			<tr>
				<td width="150" bgcolor="#F7F7F7">手机</td>
				<td bgcolor="#F7F7F7">${requestScope.card.phone }</td>
			</tr>
			<tr>
				<td width="150" bgcolor="#F7F7F7">学院</td>
				<td bgcolor="#F7F7F7">${requestScope.card.college }</td>
			</tr>
			<tr>
				<td width="150" bgcolor="#F7F7F7">余额</td>
				<td bgcolor="#F7F7F7">${requestScope.card.money }</td>
			</tr>
			<tr>
				<td width="150" bgcolor="#F7F7F7">挂失</td>
				<td bgcolor="#F7F7F7">${request.card.islock }</td>
			</tr>
		</table>
	</div>
</body>
</html>