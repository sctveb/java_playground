
public class C2_1 {
	public static void main(String[] args) {
		Grandeur myCar1 = new Grandeur();
		myCar1.color = "red";
		myCar1.gear = "auto";
		myCar1.price = 3000000;

		myCar1.run();
		myCar1.stop();
		myCar1.info();
		
		Grandeur myCar2 = new Grandeur();
		myCar2.color = "blue";
		myCar2.gear = "manual";
		myCar2.price = 2500000;

		myCar2.run();
		myCar2.stop();
		myCar2.info();
		
		Bicycle myBicycle = new Bicycle();
		myBicycle.color = "red";
		myBicycle.price = 100;
		
		myBicycle.info();
		
		Bicycle myBicycle2 = new Bicycle("blue", 50);
		
		myBicycle2.info();
	}
}
