<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
font-family: Arial, Helvetica, sans-serif;
font-size:12px;
color:#666666;
background:#fff;
text-align:center;
}
* {
margin:0;
padding:0;
}
a {
color:#1E7ACE;
text-decoration:none;
}
a:hover {
color:#000;
text-decoration:underline;
}
h3 {
font-size:14px;
font-weight:bold;
}
pre,p {
color:#1E7ACE;
margin:4px;
}
input, select,textarea {
padding:1px;
margin:2px;
font-size:11px;
}
.buttom{
padding:1px 10px;
font-size:12px;
border:1px #1E7ACE solid;
background:#D0F0FF;
}
#formwrapper {
width:450px;
margin:15px auto;
padding:20px;
text-align:left;
border:1px solid #A4CDF2;
}
fieldset {
padding:10px;
margin-top:5px;
border:1px solid #A4CDF2;
background:#fff;
}
fieldset legend {
color:#1E7ACE;
font-weight:bold;
padding:3px 20px 3px 20px;
border:1px solid #A4CDF2;
background:#fff;
}
fieldset label {
float:left;
width:120px;
text-align:right;
padding:4px;
margin:1px;
}
fieldset div {
clear:left;
margin-bottom:2px;
}
.enter{ text-align:center;}
.clear {
clear:both;
}
</style>
<script type="text/javascript">
function admin()
{
	var targetForm = document.forms[0];
	var div1 = document.getElementById("div1");
	var div2 = document.getElementById("div2");
	var code = document.getElementById("code");
	var img = document.getElementById("img");
	img.style.visibility = "visible";
	code.style.visibility = "visible";
	div1.style.visibility = "visible";
	div2.style.visibility = "visible";
	targetForm.action = "adminLogin";
}
function student()
{
	var targetForm = document.forms[0];
	var div1 = document.getElementById("div1");
	var div2 = document.getElementById("div2");
	var code = document.getElementById("code");
	var img = document.getElementById("img");
	img.style.visibility = "visible";
	code.style.visibility = "visible";
	div1.style.visibility = "visible";
	div2.style.visibility = "visible";
	targetForm.action = "studentLogin";
}
function machine()
{
	var targetForm = document.forms[0];
	var div1 = document.getElementById("div1");
	var div2 = document.getElementById("div2");
	var code = document.getElementById("code");
	var img = document.getElementById("img");
	img.style.visibility = "hidden";
	code.style.visibility = "hidden";
	div1.style.visibility = "hidden";
	div2.style.visibility = "hidden";
	targetForm.action = "/CardSystem/machine/machineIndex.jsp";
}
    
function changeValidateCode(obj) {       
/***  
  *   获取当前的时间作为参数，无具体意义     
  *   每次请求需要一个不同的参数，否则可能会返回同样的验证码      
  *   这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。    
  */  
var timenow = new Date().getTime();       
      
obj.src="randPic.action?d="+timenow;       
}       
</script>
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
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body style="background-image: url(/CardSystem/images/bg.jpg)" onload="tip()">
	<div id="header">
		<a href="index.jsp" class="logo"><img src="images/logo.png" alt=""></a>
	</div>
	<div id="formwrapper">
		<h3></h3>
		<form action="" method="post" name="apLogin" id="apLogin">
			<fieldset>
				<legend>用户登录</legend>
				<div id="div1">
					<label for="userame">用户名</label>
					<input type="text" name="username" id="userame" size="18" maxlength="30" />
					<br/>
				</div>
				<div id="div2">
					<label for="password">密码</label>
					<input type="password" name="password" id="password" size="18" maxlength="30" />
					<br/>
				</div>
				<div class="cookiechk" align="center">
				 	 验证码：<input type="text" name="code" id="code"><img id = "img" src="randPic.action"  onclick="changeValidateCode(this)" title="点击图片刷新验证码"/>
					<p><input type="radio" value="admin" name="redict" onclick="admin()">管理员
					<input type="radio" value="student" name="redict" onclick="student()">学生
					<input type="radio" value="machine" name="redict" onclick="machine()">刷卡
					
					<p><input type="submit" class="buttom" value="登录" />
					<input type="reset" class="buttom" value="重置" /></p>
				</div>
			</fieldset>
		</form>
	</div>
<br/>
	
</body>
</html>