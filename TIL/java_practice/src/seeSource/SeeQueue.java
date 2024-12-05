package seeSource;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Item {
	String name;
	int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

public class SeeQueue {

	public static void main(String[] args) {
		Item i1 = new Item("pen", 500);
		Item i2 = new Item("eraser", 300);
		Item i3 = new Item("notebook", 1000);
		
		Queue<Item> queue = new LinkedList<>();
			
		queue.add(i1);
		queue.add(i2);
		queue.add(i3);

		System.out.println(queue.size()); //3
		System.out.println(queue.poll().name); //pen
		System.out.println(queue.poll().name); //eraser
		System.out.println(queue.peek().name); //notebook
		queue.add(i1);
		System.out.println(queue.size()); //2
		System.out.println(queue.poll().name); //notebook
		System.out.println(queue.poll().name); //pen
	}

}
