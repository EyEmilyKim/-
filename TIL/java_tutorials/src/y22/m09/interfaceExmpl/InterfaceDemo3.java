package y22.m09.interfaceExmpl;

/* 인터페이스도 상속이 가능하다. */
interface MyPet extends Pet {
	public void fawnsUpon();
}

class MyBunny implements MyPet {
	public void play() { System.out.println("우다다다다♪");	}
	//인터페이스 MyPet이 상속한 인터페이스 Pet의 abstract 메서드 구현
	public void fawnsUpon() { System.out.println("쓰담해죠욤♡"); }
	//인터페이스 MyPet의 abstract 메서드 구현
}

public class InterfaceDemo3 {
	public static void main(String[] args) {
		MyBunny choco = new MyBunny();
		choco.play();
		choco.fawnsUpon();
	}
}
