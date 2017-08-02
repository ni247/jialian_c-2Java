<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/day12/jsp/page.jsp">page指令</a>
	<a href="/day12/jsp/include/include.jsp">include指令</a>
	<a href="/day12/jsp/include/pageContext.jsp">pageContext作用</a>
	<a href="/day12/jsp/action/forward.jsp">jsp动作标签_forward</a>
	<a href="/day12/jsp/action/include.jsp">jsp动作标签_include</a>
	<hr>
	<hr>
	<a href="/day12/jsp/el/demo1.jsp">el_获取简单数据</a>
	<a href="/day12/jsp/el/demo2.jsp">el_获取复杂数据</a>
	<a href="/day12/jsp/el/demo3.jsp">el_获取bean导航</a>
	<a href="/day12/jsp/el/demo4.jsp">el_执行运算</a>
	<a
		href="/day12/jsp/el/demo5.jsp?username=tom&password=123&hobby=drink&hobby=sleep">和参数有关的内置对象</a>
	<a
		href="/day12/jsp/el/demo6.jsp?username=tom&password=123&hobby=drink&hobby=sleep">和请求头相关的内置对象(了解)</a>
	<a
		href="/day12/jsp/el/demo7.jsp?username=tom&password=123&hobby=drink&hobby=sleep">和全局初始化参数有关的el内置对象(了解)</a>
	<hr>
	<hr>
	<a href="/day12/jsp/el/demo8.jsp">el内置对象cookie</a>
	<a href="/day12/jsp/el/demo9.jsp">elcontext</a>

	<hr>
	<hr>
	<a href="${pageContext.request.contextPath}/jstl/if.jsp">jstl_if标签</a>
	<a href="${pageContext.request.contextPath}/jstl/for1.jsp">jstl_for标签基础用法</a>
	<a href="${pageContext.request.contextPath}/jstl/for2.jsp">jstl_for标签高级用法</a>
	<a href="${pageContext.request.contextPath}/jstl/set.jsp">jstl_set标签</a>
	<a href="${pageContext.request.contextPath}/jstl/choose.jsp">jstl_choose标签</a>
	<a href="${pageContext.request.contextPath}/jstl/fn.jsp">函数库</a>
</body>
</html>