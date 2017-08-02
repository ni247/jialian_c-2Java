
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取复杂数据</title>
</head>
<body>
	往request域中放入数组
	<%
	request.setAttribute("arr", new String[] { "aa", "bb" });
	//放入list
	// request.setAttribute("list", new List) 
	//放入map
%>

	获取域中的数组:
	<br> 老方式:<%=((String[]) request.getAttribute("arr"))[1]%>
	<br> el方式:${arr[1] }
	<br>
	<hr>
	往request域中放入list
	<%
		List list = new ArrayList();
		list.add(111);
		list.add(222);
		request.setAttribute("brr", list);
	%>

	获取域中的list:
	<br> 老方式:<%=((List) request.getAttribute("brr")).get(1)%>
	<br> el方式:${brr.get(1)}
	<br> el方式:${brr[1]}
	<br>
	<hr>
	往request域中放入map
	<%
		Map<String, String> map = new HashMap<String, String>();
		map.put("tomcat", "2222");
		map.put("11", "2222");
		request.setAttribute("crr", map);
	%>
	获取域中的map:
	<br> 老方式:<%=((Map<String, String>) request.getAttribute("crr")).get("tomcat")%>
	<br> el方式:${crr.tomcat } //这里注意,不能是数字
	<br> el方式:${crr["tomcat"] } //这里注意,不能是数字
	<br>
	<hr>
	获取特殊名字的数据
	<br> ${crr["11"] }
</body>
</html>