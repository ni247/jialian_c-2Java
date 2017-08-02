<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>从值栈中取值</h3>
	[数值] 从root栈中从上往下打印 [数值].top 获取指定位置的值

	<hr />
	获取栈顶的字符串:
	<br />
	<s:property value="[1].top" />
	<hr />
	获取栈顶的map的值 通过直接.key:
	<br />
	<s:property value="[0].msg" />
	<hr />
	获取栈顶的对象
	<br />
	<s:property value="[0].top.username" />
	<s:property value="[0].top.pwd" />
	<hr />
	注意:[数值].top 是可以不写的.会一直找下去.找到低为止
	<br />
	<s:property value="username" />
	<hr />
	获取list的值 [数值].top[数值].属性 push进去的
	<br />
	<s:property value="[0].top[0].username" />
	<hr />
	获取list的值 [数值].top[数值].属性 set进去的
	<br />
	<s:property value="list[0].username" />

	<hr />
	迭代的标签
	<br /> 属性:
	<br /> value 要迭代的集合,需要从值栈中获取
	<br /> var 编写上,迭代产生的对象会压入context栈 取值需要#
	<br /> var 不便携,迭代产生的对象会压入root栈
	<br />

	<br /> #压入context栈中.var 写
	<br />
	<s:iterator value="list" var="u">
		<s:property value="#u.username" />
		<s:property value="#u.pwd" />
	</s:iterator>
	<hr>
	压入root栈中,不写var
	<br />
	<s:iterator value="list">
		<s:property value="username" />
		<s:property value="pwd" />
	</s:iterator>

	<hr>
	取出request域中的数据
	<br />
	<s:property value="#request.msg" />

	<hr>
	取出链接中的数据
	<br />
	<s:property value="#parameters.id" />

	<hr>
	依次从栈中查找属性
	<br />
	<s:property value="#attr.msg" />

	<hr>
	使用el表达式和jstl标签库来取值
	因为底层使用装饰者模式
	<br />
	<c:forEach items="${list }" var="user">
	${user.username }---${username.pwd} 
	</c:forEach>

	<!-- debug 在jsp页面上,查看值栈的内部结构 -->
	<s:debug></s:debug>
</body>
</html>