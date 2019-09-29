
public class Bicycle {
	public String color;
    public int price;
    // 생성자
    public Bicycle() {
        System.out.println("Bicycle constructor");
    }
    
    public Bicycle(String c, int p) {
        System.out.println("Bicycle constructor2");
        this.color = c;
        this.price = p;
    }
    // 메서드
    public void info() {
    	System.out.println("--info--");
        System.out.println(color);
        System.out.println(price);
    }

}
