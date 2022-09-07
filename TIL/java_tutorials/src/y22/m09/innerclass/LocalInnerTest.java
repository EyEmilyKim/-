package y22.m09.innerclass;

class LocalInner {
	private int data = 30;
	
	void display() {
		final String msg = "현재의 데이터 값은 ";
		
		class Local {
			void printMsg() {
				System.out.println(msg+data);
			}
		}
		Local obj = new Local();
		obj.printMsg();
	}
}
//지역 클래스는 메소드의 지역변수에도 접근할 수 있다. 단 지역변수는 반드시 final이어야 한다.

public class LocalInnerTest {
	public static void main(String[] args) {
		LocalInner obj = new LocalInner();
		obj.display();
	}
}
/*
 * 중첩 클래스를 사용하는 이유 
 * 1.내장 클래스는 외부 클래스의 멤버가 private이더라도 접근할 수 있다 
 * 2.내장 클래스는 외부에서 보이지 않는다. 즉 철저하게 감춰진다. 
 * 3.무명 클래스는 콜백 메소드를 작성할 때 아주 편리하다.
 */