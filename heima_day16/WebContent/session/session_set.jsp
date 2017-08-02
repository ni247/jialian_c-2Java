<%@page import="com.itheima.domain.Person2"%>
<%@page import="com.itheima.domain.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	将person和person2对象绑定到session中
	<%
	/* session.setAttribute("p", new Person(1, "tom")); */
	session.setAttribute("p", new Person2(2, "tom"));
%>
</body>
</html>