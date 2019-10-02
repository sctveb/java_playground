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
create user username identified by password;
grant connect, resource to username;
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

JDBC 설정

JDBC를 이용한 데이터 관리

PreparedStatement



### DAO와 DTO



### Connection Pool