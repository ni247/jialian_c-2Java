<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>条件:假如值栈中已经存入值了,从jsp页面获取值</h3>


	<h6>从值栈中获取值,value值就是ognl表达式</h6>
	<s:property value="username" />
	<h6>常量</h6>
	<s:property value="'username'" />
	<h6>调用字符串的方法</h6>
	<s:property value="'username'.length()" />
</body>
</html>