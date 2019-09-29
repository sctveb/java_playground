
public class C1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 특수문자 */
		System.out.println("Good\t\tMorning~");
		System.out.println("Good\n\nMorning~");
		System.out.println("\'GoodMorning~\'");
		System.out.println("\"GoodMorning~\"");
		
		/* 서식문자 */
		System.out.printf("오늘의 날씨는 %d도 입니다.\n", 8);
		
		char a1 = 'a';
		char a2 = 'A';
		System.out.printf("소문자 \'%c\'의 대문자는 \'%c\'입니다\n", a1, a2);
		
		double d = 1.123456d;
		System.out.printf("d=%f\n", d);
		
		System.out.printf("%5d\n", 123);
		System.out.printf("%.1f\n", 1.23);

	}

}
