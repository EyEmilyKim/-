package y22.m08.downcasting;

public class Animal {
	public void move() {
		System.out.println("동물이 움직인다");
	}
}

class Human extends Animal {
	@Override
	public void move() {
		System.out.println("사람이 두 발로 걷는다");
	}
	public void readBook() {
		System.out.println("사람이 책을 읽는다");
	}
}

class Tiger extends Animal {
	@Override
	public void move() {
		System.out.println("호랑이가 네 발로 뛴다");
	}
	public void hunting() {
		System.out.println("호랑이가 사냥을 한다");
	}
}

class Eagle extends Animal {
	@Override
	public void move() {
		System.out.println("독수리가 하늘을 난다");
	}
	public void flying() {
		System.out.println("독수리가 날개를 펴고 멀리 날아간다");
	}
}