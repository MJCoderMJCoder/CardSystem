<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园卡管理系统</title>
<link rel="stylesheet" href="/CardSystem/css/style.css" type="text/css">
<%
	String str = (String)request.getAttribute("tip");
%>
<script type="text/javascript">
function tip()
{
	var s = "<%=str%>";
	if(s != "null")
	{
		alert(s);
	}
}
</script>
</head>
<body onload="tip()">
	<div id="header">
		<a href="/CardSystem/index.jsp" class="logo"><img src="/CardSystem/images/logo.png" alt=""></a>
	</div>
	<div align="center" style="margin-top: 100px">
		<h3>请输入卡号和要消费的金额</h3>
		<form action="consume" style="font-size: 16px">
			卡号：<input type="text" name="number" style="background: url(/CardSystem/images/form-textfield-234.gif);border:0px"><br><br>
			金额：<input type="text" name="money" style="background: url(/CardSystem/images/form-textfield-234.gif);border:0px"><br><br>
			<input type="submit" value="消费" style="font-size: 16px"><a href="/CardSystem/index.jsp"><input type="button" value="退出" style="font-size: 16px"></a>
		</form>
	</div>
</body>
</html>