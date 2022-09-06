package y22.m09.innerclass;

class OuterClass{
	private int value = 10;
	
	class InnerClass{
		public void myMethod() {
			System.out.println("외부 클래스의 private 변수 값 : "+value);
		}
	}
	
	OuterClass(){
		/* 외부 클래스의 생성자에서 내부 클래스 객체 생성 */
		//이 때는 내부 클래스명을 그대로 사용하면 된다.
		InnerClass obj = new InnerClass();
		obj.myMethod();
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		System.out.println("Outer 생성 = Inner 생성 & Inner 메서드 실행");
		OuterClass outer = new OuterClass();

		/* 외부 클래스 바깥에서 내부 클래스 객체 생성하는 경우 */
		//내부 클래스 객체는 외부 클래스 객체가 먼저 생성되어 있어야 생성될 수 있다.
		System.out.println("\nInner 생성 -> Inner 메서드 실행");
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.myMethod();
		
	}

}

/*
 * 내부 클래스를 사용할 시 장점 
 * 1. 내부 클래스에서 외부 클래스의 멤버에 손쉽게 접근할 수 있음 (private 멤버도 접근 가능)
 * 2. 서로 관련 있는 클래스를 논리적으로 묶어서 표현함으로써, 코드의 캡슐화를 증가 
 * 3. 외부에서는 내부 클래스에 접근할 수 없으므로, 코드의 복잡성을 줄일 수 있음
 */
