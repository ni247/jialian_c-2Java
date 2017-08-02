<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<title>省市联动</title>
</head>
<script type="text/javascript">
	$(function() {
		//页面加载成功需要查询所有的省
		$.get("${pageContext.request.contextPath}/getAllPro", function(data) {
			var pro = $("#proID");
			$(data).each(
					function() {
						pro.append($("<option value='"+this.provinceID+"'>"
								+ this.name + "</option>"))
					});
		}, "json");
		$("#proID").change(function() {
			var proIDValue=$("#proID").val();
		/* 	alert(proIDValue); */
			var cityID = $("#cityID");
			cityID.html("");
			$.get("${pageContext.request.contextPath}/selectPro",{"proID":proIDValue}, function(data) {
				$(data).each(
						function() {
							cityID.append($("<option value='"+this.provinceID+"'>"
									+ this.name + "</option>"))
						});
			}, "json");
		});
	})
</script>
<body>
	<select id="proID" name="province">
		<option>--省份---</option>

	</select>
	<select id="cityID" name="city">
		<option>--城市---</option>
	</select>
</body>
</html>