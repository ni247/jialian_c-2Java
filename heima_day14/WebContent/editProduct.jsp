<%@page import="utils.UUIDUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${data ==null?'添加':'修改'}</title>
</head>
<body>
	<%
		String code = UUIDUtils.getCode();
		session.setAttribute("stoke", code);
		/* String action = request.getContextPath() + getServletContext().getAttribute("data") == null ? "/add"
				: "/edit"; */
		String path = request.getContextPath();
		String serString = getServletContext().getAttribute("data") == null ? "/add" : "/edit";
		String servlet = path + "/" + serString;
		/* 	out.print(path);
			out.print(serString);
		
			out.print(servlet); */
		session.setAttribute("action", servlet);
	%>
	<form method="post" action="${action}">
		<input type="hidden" name="stoke" value="${stoke }"> <input
			type="hidden" name="pid" value="${data.pid }">
		<table>
			<tr>
				<td>名称</td>
				<td><input name="pname" value="${data.pname }"></td>
			</tr>
			<tr>
				<td>市场价</td>
				<td><input name="market_price" value="${data.market_price }"></td>
			</tr>
			<tr>
				<td>到店价</td>
				<td><input name="shop_price" value="${data.shop_price }"></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input name="pimage" value="${data.pimage }"></td>
			</tr>
			<tr>
				<td>时间</td>
				<td><input name="pdate" value="${data.pdate }"></td>
			</tr>
			<tr>
				<td>详情</td>
				<td><input name="pdesc" value="${data.pdesc }"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>