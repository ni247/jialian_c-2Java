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
	<c:set var="day" value="5"></c:set>
	<c:choose>
		<c:when test="${day==1 }">
周一
</c:when>
		<c:when test="${day==2 }">
周二</c:when>
		<c:when test="${day==3 }">
周三</c:when>
		<c:otherwise>
没有了
</c:otherwise>
	</c:choose>
</body>
</html>