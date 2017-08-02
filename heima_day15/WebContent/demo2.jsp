<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	/* .html()用为读取和修改元素的HTML标签    对应js中的innerHTML
	 .html()是用来读取元素的HTML内容（包括其Html标签）,.html()方法使用在多个元素上时，只读取第一个元素
	 .text()用来读取或修改元素的纯文本内容  对应js中的innerText
	 text()用来读取元素的纯文本内容，包括其后代元素;.text()方法不能使用在表单元素上
	 .val()用来读取或修改表单元素的value值
	 .val()是用来读取表单元素的"value"值,.val()只能使用在表单元素上 */
	$(function() {
		$("input[name='username']")
				.blur(
						function() {
							//获取输入的值
							var val = $(this).val();
							var url = "${pageContext.request.contextPath}/checkUsername4AjaxServlet";
							var type = "get";
							var dataType = "json";
							var params = {
								"username" : val
							};
							var fn = function(data) {
								if (data != "0")
									$("#username_msg").text("已被占用").css(
											"color", "red");
								else
									$("#username_msg").text("未被占用").css(
											"color", "green")
							}
							$.get(url, params, fn);
						})
	})
</script>
<body>
	<form method="post" enctype="application/x-www-form-urlencoded">
		<table>
			<tr>
				<td>用户名</td>
				<td><input id="username" name="username"></td>
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