<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var btnClick = function() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
				alert(xmlhttp.responseText)
			}
		};
		xmlhttp.open("post", "${pageContext.request.contextPath}/ajax2");
		//必须设置一个请求头
		xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("userName=张三")
	}
</script>
<body>
	<input type="button" value="发送ajax" onclick="btnClick()">

</body>
</html>