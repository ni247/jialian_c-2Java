<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<!-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js">
	
</script> -->
</head>
<script type="text/javascript">
	$(function() {
		$("[type='button']").click(function() {
			var url = "${pageContext.request.contextPath}/jqueryAjax";
			var params = {
				"username" : "张三"
			};
			var fn = function(data) {
				alert(data.result);
				alert(data.msg);
			};
			var type = "json";
			/* 	//load方式
						$(this).load(url, params, function(data) {
							alert(data);
						}) */
			//get方式
			/* $.get(url, params, fn); */

			//post方式
			//$.post(url, params, fn, type);
			//ajax方式
			$.ajax({
				url : url,
				type : "post",
				data : params,
				success : fn,
				dataType : "json"
			})
		})
	})
</script>
<body>
	<input id="btn1" type="button" value="继续点我吧">
</body>
</html>