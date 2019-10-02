# 실전 JSP - 02

### Servlet 맵핑

Servlet 맵핑 :  복잡하고 보안에 취약한 url을 단순하게 바꾸는 것

web.xml 파일을 이용한 방법

```xml
<servlet>
	<servlet-name>임시 명칭</servlet-name>
	<servlet-class>원래 이름</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>임시 명칭</servlet-name>
    <url-pattern>/사용하고자 하는 경로명</url-pattern>
</servlet-mapping>
```



Java Annotation을 이용한 맵핑

```java
@WebServlet("/사용하고자 하는 경로명")
```



### Servlet request, response

HttpServlet : 추상 클래스, 서블릿을 만들면 상속하는 상위 클래스

HttpServletRequest

- getCookies();
- getSession();
- getAttribute(null);
- setAttribute(null, null);
- getParameter(null);
- getParameterNames();
- getParameterValues(null);

HttpServletResponse

- addCookie(null);
- getStatus();
- sendRedirect(null);
- getWriter();
- getOutputStream();



### Servlet Life-Cycle

Servlet 생명주기 : `@PostConstruct` - `init() - service() - destory() `-  `@PreDestory`

init부터 destory까지가 Servlet 생성 및 종료 되는 부분



생명주기 관련 메서드

```java
@PostConstruct
public void postConstruct() {}
@Override
public void init() {}
@Override
public void destory() {}
@PreDestory
public void preDestory() {}
```


