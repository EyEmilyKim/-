package y22.m09.enumExmpl;

enum Rainbow { //특정 int값을 변수로 갖는 enum(열거체) 상수 정의 
	//(특정값 부여하지 않고 상수명만 정의하면 0부터 차례대로 값을 갖게 됨)
	RED(3), ORANGE(10), YELLOW(21), GREEN(5), BLUE(1), INDIGO(-1), VIOLET(-11);
	private final int value; //enum 상수의 인스턴스 변수
	Rainbow(int value){this.value = value;} //생성자
	public int getValue() {return value;} //메소드
}

enum Colors {
	RED(3), PINK(30), ORANGE(100);
	private final int value; //enum 상수의 인스턴스 변수
	Colors(int value){this.value = value;} //생성자
	public int getValue() {return value;} //메소드
}

public class EnumTest {
	public static void main(String[] args) {
		
		/* values() : 해당 열거체의 모든 상수를 저장한 배열을 생성하여 반환 */
		for(Rainbow rb : Rainbow.values()) {
			System.out.println(rb);
		} //RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET

		/* valueOf() : 전달된 문자열과 일치하는 해당 열거체의 상수"요소"를 반환 */
		Rainbow rb_g = Rainbow.valueOf("GREEN");
		System.out.println("\n"+ rb_g); //GREEN
		System.out.println(rb_g.getValue()); //5
		
		/* ordinal() : 해당 열거체 상수가 열거체 정의에서 정의된 순서(0부터 시작)를 반환 */
		int idx_y = Rainbow.YELLOW.ordinal();
		System.out.println("\n"+idx_y); //2
		Rainbow rb_y = Rainbow.YELLOW.valueOf("YELLOW");
		System.out.println(rb_y.getValue()); //21
		
		/* name() : 해당 열거체 상수의 "이름"을 반환 */
		String rb_red = Rainbow.RED.name();
		System.out.println("\n"+ rb_red); //RED
		
		/* getClass() : Object class 로부터 상속된 메소드. 열거체가 아닌 상수에 대해 사용가능 */
		System.out.println("\n"+ Rainbow.ORANGE.getClass()+"\n"); //class y22.m08.constant2.Rainbow
		
		
	/* equals(Object other) : 
	 * Returns true if the specified object is equal to this enum constant */
//		boolean test1 = (Rainbow.RED == Colors.RED); 
		//↑서로 다른 enum 요소는 '==' 로는 비교 자체가 불가, 컴파일 에러.
		boolean test2 = (Rainbow.RED.equals(Colors.RED));
		System.out.println(test2); //false
		
		Rainbow rb_r = Rainbow.valueOf("RED");
		boolean test3 = (Rainbow.RED.equals(rb_r));
		System.out.println(test3); //true

		boolean test4 = (Rainbow.RED.equals(rb_red));
		System.out.println(test4 +"\n"); //false
		
//		System.out.println(Rainbow.RED.getValue());//3
//		System.out.println(Colors.RED.getValue());//3
//		boolean test0 = (3 == 3);
//		System.out.println(test0); //true
		//↓이 경우, 상수의 변수 값 끼리는 타입이 int형이므로 '=='로 비교 가능.
		boolean test5 = (Rainbow.RED.getValue() == Colors.RED.getValue());
		System.out.println(test5); //true
	}

}
