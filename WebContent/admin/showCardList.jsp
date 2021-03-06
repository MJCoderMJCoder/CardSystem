<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/CardManagerSystem/css/style.css" type="text/css">
<title>校园卡管理系统</title>
</head>
<body>
<s:set name="page" value="currentPage"></s:set>
<s:set name="last" value="pageCount"></s:set>
	<div id="body">
		<div class="content" align="center">
			<table width="600" border="0" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" class="ss" style="font-size: 16px;text-align: center"> 
				<tr height="30px">
					<th bgcolor="#F7F7F7">卡号</th>
					<th bgcolor="#F7F7F7">姓名</th>
				</tr>
			<s:iterator value="cardList" status="m">
				<tr height="30px">		
					<td align="center" bgcolor="#F7F7F7"><s:property value="number"/></td>
					<td align="center" bgcolor="#F7F7F7"><s:property value="name"/></td>
				</tr>
			</s:iterator>
			</table>
			<br>
			<div align="center" style="font-size: 18px">
				当前页码 <s:property value="currentPage"/>&nbsp&nbsp;
				总页数 ${requestScope.pageCount}&nbsp;&nbsp;
				<a href="showCardList.action?pageNumber=1">第一页</a>&nbsp;&nbsp;
				<s:if test="#page>1">
				<a href="showCardList.action?pageNumber=${requestScope.currentPage - 1}">上一页</a>&nbsp;&nbsp;
				</s:if>
				<s:if test="#page<#last">
				<a href="showCardList.action?pageNumber=${requestScope.currentPage + 1}">下一页</a>&nbsp;&nbsp;
				</s:if>
				<a href="showCardList.action?pageNumber=${requestScope.pageCount}">最后页</a>&nbsp;&nbsp;
			</div>
		</div>
	</div>
</body>
</html>