package y22.m09.innerclass;

import java.util.ArrayList;

public class GameCharacter {
	ArrayList<GameItem> list = new ArrayList<GameItem>();
	
	class GameItem{
		String name;
		int type;
		int price;
		public int getPrice() { return price; }
		public String toString() {
			return (String)("GameItem [name="+name+", type="+type+", price="+price+"]");
		}
	}
	
	public void add(String name, int type, int price) {
		GameItem item = new GameItem();
		item.name = name;
		item.type = type;
		item.price = price;
		list.add(item);
	}
	
	public void print() {
		int total = 0;
		for(GameItem item : list) {
			System.out.println(item);
			total += item.getPrice();
		}
		System.out.println("아이템 총 가격 : "+total);
	}
}
