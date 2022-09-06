package y22.m09.innerclass;

public class GameCharacterDemo {
	public static void main(String[] args) {
		GameCharacter hero = new GameCharacter();
		hero.add("Sword", 1, 100);
		hero.add("Gun", 2, 50);
		hero.print();
	}

}
