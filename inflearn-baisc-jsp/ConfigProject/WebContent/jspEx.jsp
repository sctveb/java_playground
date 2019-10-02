<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert Title Here</title>
	</head>
	<body>
	<%!
	String adminId;
	String adminPw;
	
	String imgDir;
	String testServerIP;
	
	String str;
	%>
	<%
	adminId = config.getInitParameter("adminId");
	adminPw = config.getInitParameter("adminPw");	
	%>
		
	<p>adminId : <%= adminId %></p>
	<p>adminPw : <%= adminPw %></p>
	
	<%
	imgDir = application.getInitParameter("imgDir");
	testServerIP = application.getInitParameter("testServerIP");	
	%>
		
	<p>imgDir : <%= imgDir %></p>
	<p>testServerIP : <%= testServerIP %></p>
	
	<%
	application.setAttribute("connectedIP", "165.65.25.42");
	application.setAttribute("connectedUser", "hong");
	%>
		
	<%
	out.print("<h1>java</h1>");
	%>
	
	<%
	out.print(str.toString());
	%>
	
	</body>
</html>