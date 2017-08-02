<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>属性驱动的方式</h3>
	<form action="${ pageContext.request.contextPath }/regist1.action"
		method="post">
		姓名:<input type="text" name="username" /><br /> 密码:<input
			type="password" name="password" /><br /> 年龄:<input type="password"
			name="age"><br /> <input type="submit" value="注册" />
	</form>
	<br />
	<h3>属性驱动的方式(封装到javabean)</h3>
	<!-- 注意,页面的编写规则,发生变化,使用了ogel表达式的写法 -->
	<form action="${ pageContext.request.contextPath }/regist2.action"
		method="post">
		姓名:<input type="text" name="user.username" /><br /> 密码:<input
			type="password" name="user.password" /><br /> 年龄:<input
			type="password" name="user.age"><br /> <input type="submit"
			value="注册" />
	</form>
	<br />
	<h3>模型驱动的方式</h3>
	<form action="${ pageContext.request.contextPath }/regist3.action"
		method="post">
		姓名:<input type="text" name="username" /><br /> 密码:<input
			type="password" name="password" /><br /> 年龄:<input type="password"
			name="age"><br /> <input type="submit" value="注册" />
	</form>
	<br />
	<h3>向list集合封装数据</h3>
	<form action="${ pageContext.request.contextPath }/regist4.action"
		method="post">
		姓名:<input type="text" name="list[0].username" /><br /> 密码:<input
			type="password" name="list[0].password" /><br /> 年龄:<input
			type="password" name="list[0].age"><br /> 姓名:<input
			type="text" name="list[1].username" /><br /> 密码:<input
			type="password" name="list[1].password" /><br /> 年龄:<input
			type="password" name="list[1].age"><br /> <input
			type="submit" value="注册" />
	</form>
	<h3>向map集合封装数据</h3>
	<form action="${ pageContext.request.contextPath }/regist5.action"
		method="post">
		姓名:<input type="text" name="map['user1'].username" /><br /> 密码:<input
			type="password" name="map['user1'].password" /><br /> 年龄:<input
			type="password" name="map['user1'].age"><br /> 姓名:<input
			type="text" name="map['user2'].username" /><br /> 密码:<input
			type="password" name="map['user2'].password" /><br /> 年龄:<input
			type="password" name="map['user2'].age"><br /> <input
			type="submit" value="注册" />
	</form>
</body>
</html>