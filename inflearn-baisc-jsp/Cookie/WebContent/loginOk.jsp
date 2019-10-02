<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert Title Here</title>
	</head>
	<body>
	<%
	Cookie[] cookies = request.getCookies();
	for (Cookie c: cookies) {
		out.print(c.getName() + "<br>");
		out.print(c.getValue() + "<br>");
		out.print("-----------------------------" + "<br>");
	}
	%>
	
	</body>
</html>