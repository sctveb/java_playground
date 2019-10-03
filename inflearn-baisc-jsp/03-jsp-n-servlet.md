# 실전 JSP - 03

### form 데이터 처리

doGet :  데이터가 웹 브라우저 URL에 노출되어 웹 서버에 전송(보안에 취약)

doPost : 데이터가 HTTP Request에 포함되어 웹 서버로 전송



### JSP 스크립트

Servlet vs JSP : JSP는 jsp파일로 생성하고 컴파일시 java -> class 순으로 변환되고 Servlet은 java파일로 생성하고 class로 변환됨

JSP 주요 스크립트

```jsp
<%-- 선언 태그 --%>
<%!
    int num = 10;
	String str = "jsp";
	ArrayList<String> list = new ArrayList<String>();
	
	public void jspWorld() {
        System.out.println("jspWorld");
    }
%>

<%-- JSP 주석 태그: Servlet 파일로 변환시 제외 --%>
<!-- HTML 주석 태그 -->

<%-- 스크립트릿 태그: JSP 페이지에서 Java 코드를 넣기 위한 코드 --%>
<% if(num > 0) { %>
<p> num > 0 </p>
<% } else{ %>
<p> num <= 0 </p>
<% } %>

<%-- 표현식 태그: Java의 변수 및 메서드의 반환값을 출력하는 코드 --%>
num is <%= num %>
    
<%-- 지시어: 서버에서 jsp페이지를 처리하는 방법에 대한 정의 --%>
<%-- page: 페이지 기본 설정 -> <%@ page 속성="속성 값"%> --%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%> 
<%-- include: include file 설정 -> <%@ include file="파일 명"%> --%>
<%@ include file="header.jsp"%>
<%-- taglib: 외부라이브러리 태그 설정 -> <%@ taglib uri="uri" prefix="네임스페이스명" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/util/core" prefix="c" %>
```



### JSP request, response

request 객체로 form 입력값을 받고 response 객체로 요청에 대한 반응을 설정



### JSP 내장객체

config 객체 : init param으로 구동시 하나의 JSP에 전달할 값을 설정

application 객체 : context param으로 모든 JSP에 전달할 값을 설정

out 객체 : 출력처리

exception 객체 : 예외처리



### Servlet 데이터 공유

servlet parameter : getServletConfig().getInitParameter()

context parameter : getServletContext().getInitParameter()

context attribute : getServletContext().setAttribute(), getServletContext().getAttribute()



### Cookie

cookie :  서버와 클라이언트가 연결을 시도한 흔적(기존 연결정보 저장)

-> Why? HTTP 프로토콜은 request, response가 이뤄진 이후, 바로 연결이 끊어지기 때문

1. 쿠키 유무 확인
2. 없을 경우 쿠키 생성
3. 있으면 쿠키 재활용

```java
Cookie[] cookies = request.getCookies();
Cookie cookie = null;

for (Cookie c : cookies) {
    System.out.println(c.getName() + " : " + c.getValue());

    if (c.getName().equals("memberId")) {
        cookie = c;
    }
}

if (cookie == null) {
    System.out.println("cookie is null");
    cookie = new Cookie("memberId", mId);
}

response.addCookie(cookie);
cookie.setMaxAge(60*60);
response.sendRedirect("loginOk.jsp");
```



### Session

세션 : 쿠키를 통해 사용자를 식별하기 위해 서버에 저장하는 정보

```java
HttpSession session = request.getSession();
session.setAttribute("memberId", mID);

response.sendRedirect("loginOk.jsp");
```




