<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.buttoncss {
    font-family: "tahoma", "宋体"; /*www.52css.com*/
    font-size:18pt; color: #003399;
    border: 1px #003399 solid;
    color:#006699;
    border-bottom: #93bee2 1px solid;
    border-left: #93bee2 1px solid;
    border-right: #93bee2 1px solid;
    border-top: #93bee2 1px solid;
    background-color: #FFF0AC;
    cursor: hand;
    font-style: normal ;
	width: 200px;
}
</style>
<title>校园卡管理系统</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="header">
		<a href="index.jsp" class="logo"><img src="images/logo.png" alt=""></a>
	</div>
	<div align="center">
		<a href="admin/adminLogin.jsp"><button class="buttoncss">管理员登陆</button></a>
	</div>
	<br>
	<div align="center">
		<a href="student/studentLogin.jsp"><button class="buttoncss">学生登陆</button></a>
	</div>
	<br>
	<div align="center">
		<a href="machine/machineIndex.jsp"><button class="buttoncss">刷卡</button></a>
	</div>
</body>
</html>