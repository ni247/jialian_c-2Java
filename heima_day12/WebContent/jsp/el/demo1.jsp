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
		request.setAttribute("rkey", "rvalue");
		session.setAttribute("rkey", "svalue");
		session.setAttribute("skey", "svalue");
		application.setAttribute("akey", "avale");
	%>
	获取request中的数据:
	<br> 老方式:
	<%=request.getAttribute("rkey")%>
	<br>
	<%=session.getAttribute("skey")%>
	<br>
	<%=application.getAttribute("akey")%>
	<hr>
	el新方式: ${requestScope.rkey }
	<br> ${sessionScope.skey }
	<br> ${applicationScope.akey }
	<hr>
	获取失败老方式:
	<%=request.getAttribute("rkeyd")%><br> 获取失败el方式:
	${requestScope.rkeyd }
	<hr>
	便捷获取: ${rkey},${skey},${aakey},${akey}
	<hr>
	 值相同:${rkey}
</body>
</html>