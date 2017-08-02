<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center" width="88%">
		<tr>
			<th>pid</th>
			<th>商品图片</th>
			<th>商品名称</th>
			<th>市场价</th>
			<th>商城价</th>
			<th>商品描述</th>

		</tr>
		<c:forEach items="${pageData.list }" var="p">
			<tr>
				<td width='8%'>${p.pid }</td>
				<td width='8%'><img alt=""
					src="${pageContext.request.contextPath }/${p.pimage}" width="80"></td>
				<td width='8%'>${p.pname }</td>
				<td width='8%'>${p.market_price }</td>
				<td width='8%'>${p.shop_price }</td>
				<td>${p.pdesc }</td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<c:if test="${pageData.currPage!=1 }">
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currPage=1">[首页]</a>
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currPage=${pageData.currPage=='1'?'1':pageData.currPage-1}">[上一页]</a>
		</c:if>
		<c:forEach begin="${pageData.currPage-5>0?pageData.currPage:1 }"
			end="${pageData.currPage+4>pageData.totalPage?pageData.totalPage:pageData.currPage+4 }"
			step="1" var="i">
			<!-- 如果是当前页,不可点 -->
			<c:if test="${pageData.currPage==i }">	
		${i }
		</c:if>
			<c:if test="${pageData.currPage!=i}">
				<a
					href="${pageContext.request.contextPath }/showProductsByPage?currPage=${i}">${i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${pageData.currPage!=pageData.totalPage}">
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currPage=${pageData.currPage==pageData.totalPage?'pageData.totalPage':pageData.currPage+1}">[下一页]</a>
			<a
				href="${pageContext.request.contextPath }/showProductsByPage?currPage=${pageData.totalPage}">[尾页]</a>
		</c:if>
	</center>
</body>
</html>