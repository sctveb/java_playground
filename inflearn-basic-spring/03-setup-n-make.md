# 자바 스프링 프레임워크 - 03

### 생명주기

스프링 컨테이너 생명주기 :

1. GenericXmlApplicationContext를 이용한 스프링 컨테이너 초기화(생성)
2. getBean()을 이용한 빈(Bean)객체 이용
3. close()를 이용한 스프링 컨테이너 종료

빈(Bean) 객체 생명주기 : 스프링 컨테이너의 생명주기와 같음

구현방법 :

1. InitializingBean, DisposableBean 인터페이스 사용

2. init-method, destroy-method 속성

- 1.xml 파일의 bean에 init-method, destroy-method 정의
- 2.bean에 해당하는 class 내부에 init-method, destrory-method에 정의한 이름을 사용한 메서드 생성



### 어노테이션을 이용한 스프링 설정

xml파일을 Java파일로 변경하기

```java
// 스프링 컨테이너로 사용
@Configuration
public class MemberConfig {
    // Bean 설정
    /* <bean id="studentDao" class="ems.member.dao.StudentDao" /> */
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }
    /* <bean id="registerService" class="ems.member.service.StudentRegisterService">
    <constructor-arg ref="studentDao"></constructor-arg>
    </bean> */
    @Bean
    public StudentRegisterService registerService() {
        return new StudentRegisterService(studentDao());
    }
    /* <bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
    <property name="jdbcUrl" value="jdbc:oracle:thin:@192.168.0.1:1521:xe" />
    <property name="userId" value="c##scott" />
    <property name="userPw" value="tiger" />
    </bean> */
    @Bean
    public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
        DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
        infoDev.setjdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
        infoDev.setuserId("c##scott");
        infoDev.setuserPw("tiger");
        
        return infoDev;
    }
    /* <bean id="informationService" class="ems.member.service.EMSInfomationService">
    <property name="Info">
    	<value>info's value</value>
    </property>
    <property name="CopyRight">
    	<value>copyright's value</value>
    </property>
    <property name="developers">
    	<list>
    		<value>Nuguri</value>
    		<value>Showmaker</value>
    		<value>Nuclear</value>
    	</list>
    </property>
    <property name="administrators">
    	<map>
    		<entry>
    			<key>
    				<value>Cheney</value>
    			</key>
    			<value>cheney@springPjt.org</value>
    		</entry>
    	</map>
    </property>
    <property name="dbInfos">
    	<map>
    		<entry>
    			<key>
    				<value>dev</value>
    			</key>
    			<ref bean="dataBaseConnectionInfoDev" />
    		</entry>
    	</map>
    </property>
    </bean>
    */
    @Bean
    public EMSInfomationService informationService() {
        EMSInfomationService info = new EMSInfomationService();
        
        info.setInfo("info's value");
        info.setCopyRight("copyright's value");
        
        ArrayList<String> developers = new ArrayList<String>();
        developers.add("Nuguri");
        developers.add("Showmaker");
        developers.add("Nuclear");
        info.setDevelopers(developers);
        
        Map<String, dataBaseConnectionInfo> dbInfos = new HashMap<String, dataBaseConnectionInfo>();
        // 사전에 정의된 객체 불러오기
        dbInfos.put("dev", dataBaseConnectionInfoDev());
        info.setDbInfos(dbInfos);               
        
        return info;
    }    
}

/* GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml") */
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig.class);
```

java 파일 분리 : 분리되어 있더라도 자동주입이 가능

1. Bean 객체 정의
2. return 되는 값을 받기 위해 필요로 하는 부분에서 빈 객체 정의
3. @Autowired로 의존성 주입
4. 통합절차를 수행하는 java 파일에서 복수의 프로퍼티를 그냥 삽입

@import 어노테이션

```java
// 통합을 위한 java 파일에서 1,2,3번 java파일 불러오기
// 통합 파일
AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MemberConfig1.class,MemberConfig2.class,MemberConfig3.class);

// 1번 파일에서 2,3번 파일을 불러오고 통합을 위한 java 파일에선 1번만 실행
// 1번 파일
@Configuration
@Import({MemberConfig2.class,MemberConfig3.class})
```



### 웹 프로그래밍 설계 모델

웹 프로그래밍을 구축하기 위한 설계 모델 :

브라우저 - WAS(웹 어플리케이션 서버) - DB

- Model1 - WAS 구조를 JSP <-> Service&DAO 통신할 수 있도록 통째로 개발
  - 장점 : 개발 속도 빠름
  - 단점 : 유지보수 어려움, 스파게티 코딩의 가능성 높음
- Model2 - WAS 구조가 Controller - Service - DAO - Model의 형태로 연결되고 얻은 결과를 Controller가 View 객체(JSP)를 만들어서 reponse
  - 장점 : 각 기능을 모듈로 나눠놓기 떄문에 유지보수가 수월해짐
  - 단점 : 처음 만들 때 시간이 더 소요됨 



스프링 MVC프레임워크 설계 구조 :

<img src="./spring-structure.jpg">

1. 클라이언트가 요청
2. DispatcherServlet이 받고 HandlerMapping으로 전달
3. HandlerMapping이 알맞은 Controller를 선택하고 DispatcherServlet에 전달
4. DispatcherServlet이 HandlerAdapter로 전달
5. HandlerAdapter가 해당 Controller 내 요청을 처리하기 알맞은 메소드를 찾아서 작업한 결과를 DispatcherServlet에 전달
6. DispatcherServlet이 ViewResolver에 전달하고 가장 적합한 JSP파일을 찾도록 함
7. 찾은 결과를 DispatcherServlet이 받고 View 작성
8. 클라이어트에 응답



DispatcherServlet 설정 : web.xml에 서블릿 등록

```xml
<servlet>
    <servlet-name>appServlet</servlet-name>
    <servlet-class>org.spring.framework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>appServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```



Controller 객체 

- @Controller

1. servlet-context.xml에 `<annotation-driven />` 작성해 초기값 정의
2. Controller로 사용하고자 하는 class에 @Controller 어노테이션 사용



- @RequestMapping : Controller 내 method에 @RequestMapping("/routename") 설정



- Model 타입의 파라미터

```java
@RequestMapping("/success")
public String success(Model model) {
    model.setAtrribute("tempData", "model has data!");
}
```



View 객체

```xml
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <beans:property name="prefix" value="/WEB-INF/views" />
    <beans:property name="suffix" value=".jsp" />
</beans:bean>
```



전체적인 웹프로그래밍 구조

1. 클라이언트 요청
2. Controller
3. 사용자 요청에 해당하는 메서드 실행
4. View 검색
5. View로 응답



### 스프링 MVC 웹서비스

웹 서버(Tomcat) 다운로드

웹 서버(Tomcat) 와 이클립스 연동

STS(Spring Tool Suit) 설치

STS를 이용한 웹 프로젝트 생성

스프링 MVC 프레임워크를 이용한 웹 프로젝트 분석

프로젝트 전체 구조

web.xml

DispatchServlet

servlet-context.xml

Controller

View



### STS를 이용하지 않은 웹 프로젝트



### Service & Dao 객체 구현



### Controller 객체 구현

