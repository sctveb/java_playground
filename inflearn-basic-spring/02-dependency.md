# 자바 스프링 프레임워크 - 02

### DI(Dependency injection)

DI : 의존성(클래스 내에 필요로 하는 클래스를 변수로 생성) 주입(외부에서 객체를 생성해서 넣어주기)

DI 설정 방법

1. 공통적으로 적용할 객체 생성
2. 필요로 하는 class(객체)에 해당 객체 주입

```xml
<bean id="common" class="com.commonClass"></bean>

<bean id="specific" class="com.specificClass">
    <constructor-arg ref="common"></constructor-arg>
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

스프링 설정 파일 분리

빈(Bean)의 범위



### 의존객체 자동 주입



### 의존객체 선택