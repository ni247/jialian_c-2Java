<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<a href="${pageContext.request.contextPath }/live/request.jsp">演示request创建和销毁</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/live/session_des.jsp">演示session创建和销毁</a>
	</h2>
	<hr>
	<h2>
		<a href="${pageContext.request.contextPath }/attr/attr_set.jsp">添加属性</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/attr/attr_replace.jsp">替换|添加属性</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/attr/attr_remove.jsp">删除属性</a>
	</h2>
	<hr>
	<h2>
		<a href="${pageContext.request.contextPath }/session/session_set.jsp">javabean绑定到session</a>
	</h2>
	<h2>
		<a
			href="${pageContext.request.contextPath }/session/session_remove.jsp">javabean解绑到session</a>
	</h2>
	<hr>
	<h2>
		<a href="${pageContext.request.contextPath }/session/session_set.jsp">钝化到磁盘</a>
	</h2>
	<h2>
		<a
			href="${pageContext.request.contextPath }/session/session_getJavaBean.jsp">活化到session</a>
	</h2>
	<hr>
	<h2>
		<a href="${pageContext.request.contextPath }/demo1">过滤器入门</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/demo2">过滤器生命周期</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath }/a/b/demo3">chain执行顺序</a>
	</h2>
</body>
</html>