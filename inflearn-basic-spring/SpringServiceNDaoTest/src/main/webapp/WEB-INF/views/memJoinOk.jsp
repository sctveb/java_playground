<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- <h1> memJoinOk </h1>
	ID : ${memId} <br />
	PW : ${memPw} <br />
	Mail : ${memMail} <br />
	Phone : ${memPhone} <br /> -->
	ID : ${mem.memId} <br />
	PW : ${mem.emPw} <br />
	Mail : ${mem.memMail} <br />
	Phone : ${mem.memPhone1} - ${mem.memPhone2} - ${mem.memPhone3} <br />
	<a href="/lec17/resources/html/memJoin.html">Go MemberJoin</a>
</body>
</html>