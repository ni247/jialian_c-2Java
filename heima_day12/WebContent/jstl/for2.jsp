<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//往域中放入一个list
		List l = new ArrayList();
		l.add(111);
		l.add(2);
		request.setAttribute("list", l);
	%>
	<c:forEach items="${list}" var="n">
	${n }<br>
	</c:forEach>
	<hr>
	<%
		Set s = new HashSet();
		s.add("1");
		s.add("2");
		request.setAttribute("set", s);
	%>
	<c:forEach items="${set}" var="n">
	${n }<br>
	</c:forEach>
	<hr>
	<%
		Map m = new HashMap();
		m.put("user", "tom");
		m.put("age", "18");
		request.setAttribute("map", m);
	%>
	<c:forEach items="${map}" var="en">
	${en.key }--${en.value }<br>
	</c:forEach>
	<hr>
</body>
</html>