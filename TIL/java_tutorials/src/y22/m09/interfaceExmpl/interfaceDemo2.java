package y22.m09.interfaceExmpl;

interface Pet {
	public abstract void play();
}

/* 인터페이스는 다중 상속(구현)이 가능하다 (클래스는 단일상속만 허용됨!) */
class Cat2 implements Animal, Pet{
	public void cry() { System.out.println("냐옹"); }
	public void play() { System.out.println("쥐잡기 놀이 하자~"); }
}
class Dog2 implements Animal, Pet{
	public void cry() { System.out.println("멍멍"); }
	public void play() { System.out.println("공던지기 놀이 하자~"); }
}

/* 인터페이스 상속(구현)과 클래스 상속(1개만), 동시에 가능 */
class Cat3 extends Cat implements Pet{
	public void play() { System.out.println("츄르먹자~"); }
}

public class interfaceDemo2 {
	public static void main(String[] args) {
		Cat2 c2 = new Cat2();
		Dog2 d2 = new Dog2();
		c2.cry();
		c2.play();
		d2.cry();
		d2.play();
		
		System.out.println();
		Cat3 c3 = new Cat3();
		c3.cry();
		c3.play();
	}
}

/*
 * 인터페이스를 사용하면 다중 상속이 가능할 뿐만 아니라, 다음과 같은 장점을 가질 수 있다.
 * 1. 대규모 프로젝트 개발 시 일관되고 정형화된 개발을 위한 표준화가 가능 
 * 2. 클래스 작성과 인터페이스 구현을 동시에 진행할 수 있으므로, 개발 시간을 단축할 수 있음
 * 3. 클래스와 클래스 간의 관계를 인터페이스로 연결하여 클래스마다 독립적인 프로그래밍 가능
 */

