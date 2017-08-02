<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	hello jsp
	<%
	int i = 3;
	System.out.println(i);
%>
	<%=i%>

	<%
		out.print(i);
	%>
	<%
		out.print(k);
	%>
	<%!int k = 555;%>
</body>
</html>