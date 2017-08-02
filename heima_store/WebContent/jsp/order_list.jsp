<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>
</head>

<body>

	<jsp:include page="/jsp/head.jsp"></jsp:include>
	<div class="container">
		<div class="row">

			<div style="margin: 0 auto; margin-top: 10px; width: 950px;">
				<strong>我的订单</strong>

				<table class="table table-bordered">
					<c:forEach items="${orderPage.list }" var="order">
						<tbody>
							<tr class="success">
								<th colspan="5">订单编号:${order.oid } <c:if
										test="${ order.state==0}">
										<a
											href="${pageContext.request.contextPath}/order?method=getById&oid=${ order.oid}">未支付</a>
									</c:if> <c:if test="${ order.state==1}">
										<a href="javascript:void(0)">已支付</a>
									</c:if> <c:if test="${ order.state==2}">
										<a href="javascript:void(0)">确认收货</a>
									</c:if>
								</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${order.list }" var="orderItem">
								<tr class="active">
									<td width="60" width="40%"><input type="hidden" name="id"
										value="22"> <img
										src="${pageContext.request.contextPath}/${orderItem.product.pimage}"
										width="70" height="60"></td>
									<td width="30%"><a target="_blank"
										href="${pageContext.request.contextPath}/product?method=getById&pid=${ orderItem.product.pid}">
											${orderItem.product.pname }...</a></td>
									<td width="20%">￥${orderItem.product.shop_price }</td>
									<td width="10%">${orderItem.count }</td>
									<td width="15%"><span class="subtotal">￥${orderItem.subtotal }</span></td>
								</tr>
							</c:forEach>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<div style="text-align: center;">
			<ul class="pagination">
				<c:if test="${ orderPage.currPage==1}">
					<li class="disabled"><a href="javascript:void(0)"
						aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<li class="disabled"><a href="javascript:void(0)"
						aria-label="Previous"><span aria-hidden="true">上一页</span></a>
				</c:if>
				<c:if test="${ orderPage.currPage!=1}">
					<li><a
						href="${pageContext.request.contextPath}/order?method=getPageOrder&currPage=1"
						"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<li><a
						href="${pageContext.request.contextPath}/order?method=getPageOrder&currPage=${ orderPage.currPage-1}"
						aria-label="Previous"><span aria-hidden="true">上一页</span></a></li>
				</c:if>
				<c:forEach var="page"
					begin="${orderPage.currPage-5>0?orderPage.currPage-5:1 }"
					end="${orderPage.currPage+4>orderPage.totalPage?orderPage.totalPage:orderPage.currPage+4  }">
					<c:if test="${page==orderPage.currPage }">
						<li class="active"><a href="javascript:void(0)">${page }</a></li>
					</c:if>
					<c:if test="${page!=orderPage.currPage }">
						<li><a
							href="${pageContext.request.contextPath}/order?method=getPageOrder&currPage=${page }">${page }</a></li>
					</c:if>
				</c:forEach>
				<c:if test="${ orderPage.currPage==orderPage.totalPage}">
					<li class="disabled"><a href="javascript:void(0)"
						aria-label="Next"> <span aria-hidden="true">下一页</span>
					</a></li>
					<li class="disabled"><a href="javascript:void(0)"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				<c:if test="${ orderPage.currPage!=orderPage.totalPage}">
					<li><a
						href="${pageContext.request.contextPath}/order?method=getPageOrder&currPage=${orderPage.currPage+1}"
						aria-label="Next"> <span aria-hidden="true">下一页</span>
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/order?method=getPageOrder&currPage=${orderPage.totalPage}"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
			</ul>
		</div>
	</div>

	<jsp:include page="/jsp/foot.jsp"></jsp:include>
</body>

</html>