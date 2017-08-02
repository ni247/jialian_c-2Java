<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var usernameBlur = function(obj) {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
				var msg = xmlhttp.responseText == "0" ? "可以使用" : "不可以使用";
				var boo = xmlhttp.responseText == "0" ? false : true;
				document.getElementById("username_msg").innerText = msg;
				document.getElementById("submit").disabled = boo;
			}
		};
		xmlhttp.open("post",
				"${pageContext.request.contextPath}/checkUsername4AjaxServlet");
		xmlhttp.setRequestHeader("content-type",
				"application/x-www-form-urlencoded");
		xmlhttp.send("username=" + obj.value);
	}
</script>
<body>
	<form method="post" enctype="application/x-www-form-urlencoded">
		<table>
			<tr>
				<td>用户名</td>
				<td><input onblur="usernameBlur(this)" name="username"></td>
				<td><span id="username_msg"></span></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password"></td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" id="submit"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>