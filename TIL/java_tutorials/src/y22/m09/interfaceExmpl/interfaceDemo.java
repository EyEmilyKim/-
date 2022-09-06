package y22.m09.interfaceExmpl;

interface Animal {
	public abstract void cry();
}

class Cat implements Animal {
	public void cry() { System.out.println("냐옹"); }
}
class Dog implements Animal {
	public void cry() { System.out.println("멍멍"); }
}

public class interfaceDemo {
	public static void main(String[] args) {
//		Animal a = new Animal();//인터페이스는 인스턴스화 할 수 없다.
		Cat c = new Cat();
		Dog d = new Dog();

		c.cry();
		d.cry();
	}
}


/*
 * 자바에서 추상 클래스는 추상 메소드뿐만 아니라 생성자, 필드, 일반 메소드도 포함할 수 있다. 
 * 하지만 인터페이스(interface)는 오로지 추상 메소드와 상수만을 포함할 수 있다.
 * 
 * 클래스와 달리 인터페이스의 모든 필드는 public static final이어야 하며, 
 * 모든 메소드는 public abstract이어야 한다. 
 * 이것은 모든 인터페이스에 공통으로 적용되므로 이 제어자는 생략할 수 있다. 
 * 이렇게 생략된 제어자는 컴파일 시 자바 컴파일러가 자동으로 추가해 준다.
 */
