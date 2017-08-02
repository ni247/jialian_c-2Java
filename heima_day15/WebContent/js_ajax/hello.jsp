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
		//第一步,创建xmlhttprequest
		var xmlhttp = null;
		//普通浏览器
		if (window.XMLHttpRequest)
			xmlhttp = new XMLHttpRequest();
		//老浏览器
		else if (window.ActiveXObject())
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		//第二部,编写回调函数
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
				alert(xmlhttp.responseText)

				/* 	alert(123); */
		}
		//第三部,设置请求的方式,路径
		xmlhttp.open("get", "${pageContext.request.contextPath}/ajax1", true)
		//第四部 发送请求
		xmlhttp.send();
	}
</script>
<body>
	<input type="button" value="发送ajax" onclick="btnClick()">
</body>
</html>