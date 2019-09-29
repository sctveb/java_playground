
public class Grandeur {
	public String color;
    public String gear;
    public int price;
    // 생성자
    public Grandeur() {
        System.out.println("Grandeur constructor");
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
