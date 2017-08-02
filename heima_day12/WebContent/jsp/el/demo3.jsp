<%@page import="com.itheima.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User u = new User();
		u.setId("001");
		u.setPassword("123");
		u.setName("tom");

		//将user放入域中
		request.setAttribute("user", u);
	%>
	获取域中javabean的id值:
	<br> 老方式:<%=((User) request.getAttribute("user")).getName()%>
	<br> el方式: ${user.name }
	<br> 错误el方式: ${user.name }
</body>
</html>