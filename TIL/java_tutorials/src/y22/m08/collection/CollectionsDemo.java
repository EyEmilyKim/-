package y22.m08.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Computer implements Comparable {
	int serial;
	String owner;
	Computer(int serial, String owner){
		this.serial = serial;
		this.owner = owner;
	}
	public int compareTo(Object o) {
		return this.serial - ((Computer)o).serial;
	}
	public String toString() {
		return serial + " " + owner;
	}
}

public class CollectionsDemo {
	public static void main(String[] args) {
		List<Computer> computers = new ArrayList<Computer>();
		computers.add(new Computer(220501, "kosea1"));
		computers.add(new Computer(220603, "kosea3"));
		computers.add(new Computer(1308, "lenovo"));
		computers.add(new Computer(1912, "surface6"));
		Iterator i = computers.iterator();
		System.out.println("before");
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		Collections.sort(computers);
		System.out.println("\nafter");
		i = computers.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
