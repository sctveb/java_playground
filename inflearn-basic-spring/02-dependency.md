# 자바 스프링 프레임워크 - 02

### DI(Dependency injection)

DI : 의존성(클래스 내에 필요로 하는 클래스를 변수로 생성) 주입(외부에서 객체를 생성해서 넣어주기)

DI 설정 방법

1. 공통적으로 적용할 객체 생성
2. 필요로 하는 class(객체)에 해당 객체 주입

```xml
<bean id="injection" class="com.injectionClass"></bean>

<bean id="dependency" class="com.dependencyClass">
    <constructor-arg ref="injection"></constructor-arg>
</bean>
```



### 다양한 의존 객체 주입

생성자를 이용한 의존 객체 주입

```java
public StudentRegisterService(StudentDao studentDao) {
    this.studentDao = studentDao;
}
```

```xml
<bean id="studentDao" class="ems.member.dao.StudentDao"></bean>

<bean id="StudentRegisterService" class="ems.member.service.StudentRegisterService">
    <constructor-arg ref="studentDao"></constructor-arg>
</bean> 
```



setter를 이용한 의존 객체 주입

```java
public void setJdbcUrl(String jdbcUrl){
    this.jdbcUrl = jdbcUrl;
}
public void setUserId(String userId){
    this.userId = userId;
}
public void setUserPw(String userPw){
    this.userPw = userPw;
}
```

```xml
<bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
    <property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
    <property name="userId" value="scott" />
    <property name="userPw" value="tiger" />
</bean>
```



List타입 의존 객체 주입

```java
public void setDevelopers(List<String> developers) {
    this.developers = developers;
}
```

```xml
<property name="developers">
    <list>
        <value>A</value>
        <value>B</value>
        <value>C</value>
        <value>D</value>
    </list>
</property>
```



Map타입 의존 객체 주입

```java
public void setAdministrators(Map<String,String> administrators) {
    this.administrators = administrators;
}
```

```xml
<property name="administrators">
    <map>
        <entry>
            <key>
            	<value>Chevoy</value>
        	</key>
            <value>Griffin</value>
        </entry>
        
    </map>
</property>
```



### 스프링 설정 파일 분리

스프링 설정 파일 분리 : 길어질 수 있는 설정 파일을 분리 작업

1. xml 코드 분할 작성
2. 배열 형태로 불러오기

```java
GenericXmlApplicationContent ctx = new GenericXmlApplicationContent({"xml1","xml2","xml3"})
```



빈(Bean)의 범위 :

1. 싱글톤(Singleton) : 스프링 컨테이너에서 생성된 빈(bean) 객체의 경우, 동일한 타입에 대해서는 기본적으로 한 개만 생성이 되며, getBean() 메소드로 호출될 떄 동일한 객체가 반환 된다
2. 프로토타입 : 싱글톤과 반대로 개발자가 별도로 설정해줘야 하는데, 스프링 설정 파일에서 빈(Bean) 객체를 정의할 때 scope 속성을 명시해 주면 된다.

```java
<bean id="injection" class="com.injectionClass"></bean>

<bean id="dependency" class="com.dependencyClass" scope="prototype">
    <constructor-arg ref="injection"></constructor-arg>
</bean>
```



### 의존객체 자동 주입

의존객체 자동 주입 : 스프링 설정 파일에서 의존 객체를 주입할 때 `<constructor-org>`, `<property>` 태그로 의존 대상 객체를 명시하지 않아도 스프링 컨테이너가 자동으로 필요한 의존 대상 객체를 찾아서 의존 대상 객체가 필요한 객체에 주입해 주는 기능



@Autowired : 주입하려고 하는 객체의 `타입`이 일치하는 객체를 자동으로 주입

1. injection class 생성자에 @Autowired 어노테이션 추가

2. xml 파일 필요한 값 추가

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    
    <context:annotation-config />
    
    <bean id="injection" class="com.injectionClass"></bean>
    <bean id="dependency" class="com.dependencyClass">
    	<!-- <constructor-arg ref="injection"></constructor-arg> -->
	</bean>
</beans>
```

cf) 생성자가 아닌 프로퍼티나 메소드에 @Autowired를 사용할 경우, default 생성자를 작성해놔야 함



@Resource : 주입하려고 하는 객체의 `이름`이 일치하는 객체를 자동으로 주입



### 의존객체 선택

의존객체 선택 : 동일한 객체가 2개 이상인 경우 스프링 컨테이너는 자동 주입 객체를 판단하지 못해서 Exception 발생

1. 자동주입이 되는 class에 @Qualifier('somethingusedDao')  입력
2. 자동주입하고자 하는 bean 안에 `<qualifier value='somethingusedDao'>` 입력

의존객체 자동 주입 체크 : `@Autowired(required = false)` : 의존객체가 있으면 자동주입, 없으면 무시

@Inject : @Autowired와 유사, 하지만 required 지원안함