<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>传统的配置文件的方式</h3>
	<a href="${pageContext.request.contextPath }/saveCust">保存客户</a>
	<a href="${pageContext.request.contextPath }/deleteCust">删除客户</a>
	<h3>通配符的方式(应用比较多)使用* {1}对应参数</h3>
	<a href="${pageContext.request.contextPath }/linkman_save">保存客户</a>
	<a href="${pageContext.request.contextPath }/linkman_delete">删除客户</a>
	<h3>动态方法访问的方式 !!!</h3>
	<a href="${pageContext.request.contextPath }/user!save">保存用户</a>
	<a href="${pageContext.request.contextPath }/user!delete">删除用户</a>
</body>
</html>