# 실전 JSP - 04

### 한글처리

post : 서블릿에 request.setCharacterEncoding("UTF-8");

get : server.xml에 `<Connector URIEncoding="UTF-8"/>` 추가

filter : request, response 간에 중복되는 부분을 filter로 전체적용가능



### 오라클 설치

Oracle Database Express Edition 11g Release 2

```sql
sqlplus
system
password
create user c##username identified by password;
grant connect, resource to c##username;
show user;
```

SQL developer 설치



### SQL

테이블 생성 및 삭제

```sql
-- 테이블 생성
CREATE TABLE book (
    book_id NUMBER(4),
    book_name VARCHAR2(20),
    book_loc VARCHAR2(20)
);

-- 테이블 검색
SELECT * FROM tab;

-- 테이블 삭제
DROP TABLE book;

-- table 생성 - 제약 조건
CREATE TABLE book (
    book_id NUMBER(4) CONSTRAINT book_id_pk PRIMARY KEY,
    book_name VARCHAR2(20),
    book_loc VARCHAR2(20)
);

-- 작업 내용 반영
COMMIT;
```



테이블 추가, 수정, 삭제

```sql
-- 시퀀스 생성
CREATE SEQUENCE book_seq;

-- 데이터 추가
INSERT INTO
	book(book_id, book_name, book_loc)
VALUES
	(BOOK_SEQ,NEXTVAL, 'book5', '001-00005');

INSERT INTO
	book(book_id, book_name, book_loc)
VALUES
	(BOOK_SEQ,NEXTVAL, 'book6', '001-00006');
	
-- 수정
UPDATE book SET book_loc = '001-00006123'
WHERE book_name = 'book6';

-- 삭제
DELETE FROM book
WHERE book_id = 6;
```



데이터 검색

```sql
-- 데이터 검색
SELECT * FROM book;
SELECT book_name AS 책이름, book_loc FROM book;

-- 조건 - WHERE
SELECT * FROM book WHERE book_id > 3;
SELECT book_name, book_loc FROM book WHERE book_id > 3 AND book_id <= 5;

-- 조건 - BETWEEN AND
SELECT * FROM book WHERE book_id BETWEEN 2 AND 4;

-- 조건 - LIKE
SELECT * FROM book WHERE book_id LIKE 3;
SELECT * FROM book WHERE book_loc LIKE '%3';
SELECT * FROM book WHERE book_name LIKE 'book%';
SELECT * FROM book WHERE book_name LIKE  '%ok%';

-- 정렬
SELECT * FROM book ORDER BY book_id ASC;
SELECT * FROM book ORDER BY book_id DESC;
```



### JDBC

JDBC : Java가 DB와 통신할 수 있게 해주는 API

1. oracle jdbc 파일 찾기 - ojdbc8_g.jar
2. jre/lib/ext 폴더에 추가



JDBC를 이용한 데이터 관리

```java
// OracleDriver 로딩
Class.forName(driver);
// Java와 Oracle 연결
con = DriverManager.getConnection(url, id, pw);
// query 객체 전송
stmt = con.createStatement();
// query 작성
String sql = "SELECT * FROM book"
// 탐색 query 전송
res = stmt.executeQuery(sql);
// 수정 query 전송
// res = stmt.executeUpdate(sql);
```

PreparedStatement : query 작성간에 빈칸채우기 형식으로 작동할 수 있도록 도와줌

```java
String sql = "UPDATE book SET book_loc = ? WHERE book_name = ?";
pstmt = con.prepareStatement(sql);
pstmt.setString(1, "001-0001732");
pstmt.setString(2, "book7");
int n = pstmt.executeUpdate();
```



### DAO와 DTO

DAO : Data Access Object, Java의 데이터를 DB의 것으로 바꾸는 객체

DTO : Data Transfer Object, DB의 데이터를 Java의 것으로 바꾸는 객체

ex) 브라우저 - BookServlet - BookDAO - DTO - DB



### Connection Pool

커넥션 풀 :  잦은 커넥션에 대한 명령을 풀로 만들어 관리

커넥션 풀 설정 :

1. web.xml에 정의

```xml
<Resource 
          auth="Container"
          driverClassName="oracle.jdbc.driver.OracleDriver"
          url="jdbc:oracle:thin:@localhost:1521:xe"
          username="c##scott"
          password="tiger"
          name="jdbc/Oracle18g"
          type="javax.sql.DataSource"
          maxActive="4"
          maxWait="10000"
          />
```

2. 정의한 내용을 이용해 기존 코드 교체

```java
/*
String Driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "c##scott";
String pw = "tiger";
*/
// Class.forName(driver) 
Context context = new InitialContext();
dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
```

```java
// con = DriverManager.getConnection();
con = DataSource.getConnection();
```



