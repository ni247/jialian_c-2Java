<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$("input[name='kw']").keyup(function() {
			var value = $(this).val();
			var params = {
				"key" : value
			};
			var fn = function(data) {
				if (data != "") {
					$("#did").html("");
					var arr = data.split(",");
					$(arr).each(function() {
						//将每一个只中放入id为did.将每一个值放入一个div,将这个div内部插入到id为did的div中
						$("#did").append($("<div>" + this + "</div>"));
					});
					$("#did").css("display", "block");
				}
			};
			var url = "${pageContext.request.contextPath}/serarchKw";
			if (value)
				$.post(url, params, fn);
		})
	})
</script>
</head>
<body>
	<center>
		<div>
			<h1>黑马搜索</h1>
			<div>
				<input name="kw"> <input type="submit" value="黑马一下">
			</div>
			<div id="did"
				style="border: 1px solid red; width: 171px; display: none; position: relative; left: -37px;"></div>
		</div>
	</center>
</body>
</html>