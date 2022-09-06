package y22.m09.innerclass;

class OuterClass{
	private int value = 10;
	
	class InnerClass{
		public void myMethod() {
			System.out.println("외부 클래스의 private 변수 값 : "+value);
		}
	}
	
	OuterClass(){
		InnerClass obj = new InnerClass();
		obj.myMethod();
	}
}

public class InnerClassTest {
	public static void main(String[] args) {
		System.out.println("Outer 생성 = Inner 생성 & Inner 메서드 실행");
		OuterClass outer = new OuterClass();
		
		System.out.println("\nInner 생성 -> Inner 메서드 실행");
		OuterClass.InnerClass inner = outer.new InnerClass();
		inner.myMethod();
	}

}
