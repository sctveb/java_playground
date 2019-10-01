# 실전 JSP - 01

## 오리엔테이션

웹 프로그램 : 인터넷 서비스를 이용해서 서로 다른 구성요소들이 통신할 수 있는 프로그램

프로토콜 :  통신을 하기 위한 규약 (ex) HTTP, FTP, SMTP, POP 등)

웹페이지 주소 = Protocol + 인터넷 서비스 + 도메인(or IP) + Port 번호 + 경로

웹 페이지 동작 원리 : 

- User <-> Web Server : Request, Response
- Web Server <-> DB : query, result

1. 정적 데이터? HTML
2. 동적 데이터? Container

웹 컨테이너 구조 :

1. JSP 파일로 request
2. 웹 컨테이너(Tomcat)에서 jsp -> java -> class -> obj 순으로 변화
3. html로 request

WAS : Web Application Server