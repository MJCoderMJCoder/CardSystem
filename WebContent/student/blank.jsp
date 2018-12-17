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
	</div>
</body>
</html>