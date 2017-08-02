<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var deleteClike = function(pid) {
		var r = confirm("是否确定删除该商品");
		if (r)
			location.href = "${pageContext.request.contextPath }/delete?id="
					+ pid;
	}
	var changeCheck = function(b) {
		var objs = document.getElementsByName("id");
		for (var i = 0; i < objs.length; i++) {
			objs[i].checked = b;
		}
	}
	var deleteDuo = function() {
		document.getElementById("formId").submit();
		//方法提交
	}
</script>
<body>
	<form method="post"
		action="${pageContext.request.contextPath }/findAll">
		<table border="1">
			<tr>
				<td width="95%" colspan="8">商品名称: <input name="productName">
					&nbsp; 关键字: <input name="key"> <input type="submit"
					value="提交">
				</td>
				<td><input type="button" onclick="deleteDuo()" value="删除已选中的商品"></td>
			</tr>
		</table>
	</form>
	<form id="formId" method="post"
		action="${pageContext.request.contextPath }/delete">
		<table border="1">
			<tr>
				<td width="5%"><a href="javascript:void(0)"
					onclick="changeCheck(true)">全选</a> <a href="javascript:void(0)"
					onclick="changeCheck(false)">全不选</a></td>
				<td width="5%">id</td>
				<td width="5%">名字</td>
				<td width="5%">市场价</td>
				<td width="5%">到店价</td>
				<td width="20%">图片</td>
				<td width="7%">时间</td>
				<td width="43%">详情</td>
				<td width="5%">操作</td>
			</tr>

			<c:forEach items="${allData }" var="p">
				<tr>
					<td><input type="checkbox" name="id" value="${p.pid }"></td>
					<td>${p.pid }</td>
					<td>${p.pname }</td>
					<td>${p.market_price }</td>
					<td>${p.shop_price }</td>
					<td><img src="${p.pimage }"></td>
					<td>${p.pdate }</td>
					<td>${p.pdesc }</td>
					<td><a
						href="${pageContext.request.contextPath }/getProduct?id=${ p.pid }">修改</a>
						<%-- <button onclick="deleteClike('${p.pid}')">删除</button> --%> <a
						href="javascript:void(0)" onclick="deleteClike('${p.pid}')">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>