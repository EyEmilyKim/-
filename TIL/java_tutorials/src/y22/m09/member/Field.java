package y22.m09.member;

public class Field {
	static int classVar = 10; //클래스 변수 선언
	int instanceVar = 20; //인스턴스 변수 선언

	public static void main(String[] args) {
		int var = 30; //지역 변수 선언
		/* 지역 변수 참조 */
		System.out.println(var + "\n"); //30
		
		/* 클래스 멤버 변수 */		
		Field f1 = new Field(); //인스턴스 생성
		Field f2 = new Field(); //인스턴스 생성
		
		/* 클래스 변수 참조 */
		System.out.println(Field.classVar); //10
		System.out.println(f1.classVar); //10
		System.out.println(f2.classVar+"\n"); //10
		
		f1.classVar = 100; //클래스 변수의 값 변경
		
		System.out.println(Field.classVar); //100 
		System.out.println(f1.classVar); //100
		System.out.println(f2.classVar+"\n"); //100
		/* →클래스 변수의 값은 모든 인스턴스가 공유한다 */
		
		/* 인스턴스 변수 참조 */
		System.out.println(f1.instanceVar); //20
		System.out.println(f1.instanceVar+"\n"); //20
		
		f1.instanceVar = 200; //인스턴스 변수의 값 변경
		
		System.out.println(f1.instanceVar); //200
		System.out.println(f2.instanceVar+"\n"); //20
		/* →인스턴스 변수의 값은 인스턴스별로 값이 유지된다 */
		
	}

}
