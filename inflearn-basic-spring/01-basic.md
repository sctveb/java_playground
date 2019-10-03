# 자바 스프링 프레임워크 - 01

### 스프링 개요

스프링 프레임워크 : DI 디펜던시 인적션, AOP 관점 지향 프로그래밍, MVC, JDBC 등을 제공
스프링 프레임워크 모듈 :

- spring-core : DI, IoC
- spring-aop : AOP
- spring-jdbc : DB 관리 용이
- spring-tx : 트렌젝션
- spring-webmvc : 컨트롤러, 뷰 MVC모델

스프링 컨테이너 : 객체를 생성하고 조립하는 컨테이너, 컨테이너로 생성된 객체는 빈(Bean)이라 함
1. 객체생성 및 속성 데이터 작성
2. 스프링 컨테이너에서 객체 생성 및 조립
3. 애플리케이션 구현



### 스프링 프로젝트 생성

프로젝트 생성 : 

1. Maven Project를 생성 (Create a Simple project 선택)
2. Group Id, Artifact Id 설정 및 완료 (전역 명칭, 지역 명칭)

pom.xml 작성 : 필요한 모듈을 가져오기 위한 파일

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>4.1.0.RELEASE</version>
    </dependency>
</dependencies>    
<build>
    <plugins>
        <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.1</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <encoding>utf-8</encoding>
            </configuration>
        </plugin>
    </plugins>
</build>
```



폴더 및 pom.xml 파일의 이해 : 

- 프로젝트 폴더 : 스프링 프로젝트 root
- 프로젝트 폴더/src/main/java : java파일 관리 
- 프로젝트 폴더/src/main/resources : 자원파일 관리(xml, 프로퍼티 파일 등)

pom.xml 파일은 메이븐 설정파일, 메이븐은 라이브러리를 연결해주고 빌드를 위한 플랫폼



### 처음해 보는 스프링 프로젝트

1. resources 폴더에 컨테이너 역할의 xml 생성
2. 컨테이너 생성
3. 정의해둔 class 사용

```java
//		TranspotationWalk transpotationWalk = new TranspotationWalk();
//		transpotationWalk.move();
		
GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
TranspotationWalk transpotationWalk = ctx.getBean("tWalk", TranspotationWalk.class);
transpotationWalk.move();
		
ctx.close();
```



### 또 다른 프로젝트 생성 방법

폴더(java, resources)와 파일(pom.xml) 만들기

이클립스에서 import하기