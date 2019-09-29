# 자바 프로그래밍 입문 - 02

## 객체 지향 프로그래밍

객체 :  프로그래밍에서 속성과 기능을 가지는 프로그램 단위

클래스 : 

- 객체를 생성하기 위한 틀로 모든 객체는 클래스로부터 생성
- 속성(맴버 변수)와 기능(메서드)로 구성



#### 클래스 제작과 객체 생성

클래스 제작

```java
public class Car {
    // 맴버 변수
    public String color;
    public String gear;
    public int price;
    // 생성자 : 객체를 생성할 때 가장 먼저 호출
    public Car() {
        System.out.println("constructor");
    }
    // 메서드
    public void run() {
        System.out.println("--run--");
    }
    public void stop() {
        System.out.println("--stop--");
    }
    public void info() {
    	System.out.println("--info--");
        System.out.println(color);
        System.out.println(gear);
        System.out.println(price);
    }
}
```

객체 생성

```java
Car myCar1 = new Car();
myCar1.color = "red";
myCar1.gear = "auto";
myCar1.price = 3000000;

myCar1.run();
myCar1.stop();
myCar1.info();
```







#### 메서드

#### 객체와 메모리

#### 생성자와 소멸자 그리고 this 키워드

#### 패키지와 static

#### 데이터 은닉