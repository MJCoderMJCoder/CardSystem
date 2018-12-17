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
<link rel="stylesheet" href="/CardSystem/css/style.css" type="text/css">
</head>
<body style="background-image: url(/CardSystem/images/bg.jpg)">
	<div class="content" style="padding-left: 30%">
		<h3>您确定要挂失校园卡么?</h3>
		<a href="student/studentLockCardConfirm.action"><button class="buttoncss">确定</button></a>
		<a href="/CardSystem/student/blank.jsp"><button class="buttoncss">取消</button></a>
	</div>
</body>
</html>