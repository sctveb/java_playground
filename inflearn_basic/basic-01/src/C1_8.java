import java.util.Scanner;

public class C1_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num1 = 10;
//		int num2 = 20;
//		
//		if(num1 < num2) {
//			System.out.println("num1 < num2");
//		}
//		
//		if(num1 < num2) {
//			System.out.println("num1 < num2");
//		} else {
//			System.out.println("not");
//		}
//		
//		if(num1 < num2) {
//			System.out.println("num1 < num2");
//		} else if(num1 > num2) {
//			System.out.println("num1 > num2");			
//		} else {
//			System.out.println("num1 == num2 or num1 != num2" );
//		}
		
		System.out.println("점수입력");
		Scanner inputNum = new Scanner(System.in);
		int score = inputNum.nextInt();
		
		switch (score) {
		case 90:
			System.out.println("90");
			break;
		case 80:
			System.out.println("90");
			break;
		case 70:
			System.out.println("90");
			break;
		case 60:
			System.out.println("90");
			break;
		case 50:
			System.out.println("50");
			break;
		default:
			break;
		}
		
		
		inputNum.close();
	}

}
