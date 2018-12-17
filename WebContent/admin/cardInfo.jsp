<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/CardManagerSystem/css/style.css" type="text/css">
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
<title>校园卡管理系统</title>
</head>
<body onload="tip()">
	<div class="content" style="padding-left: 30%">
		<h3>请输入要查询的卡号</h3>
		<form action="adminCardInfo">
			<table style="font-size: 16px">
				<tr>
					<td>卡号:</td>
					<td><input type="text" name="number" style="background: url(/CardSystem/images/form-textfield-234.gif);border:0px"></td>
					<td><input type="submit" value="查询" style="font-size: 16px">
				</tr>
			</table>
		</form>
	</div>
</body>
</html>