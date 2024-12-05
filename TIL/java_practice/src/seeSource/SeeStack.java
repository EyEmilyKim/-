package seeSource;

import java.util.Stack;

class Human {
	int age;
	String name;
	
	public Human(int age, String name) {
		this.age = age;
		this.name = name;
	}
}
	
public class SeeStack {
	
	public static void main(String[] args) {
	
		Human emily = new Human(20, "Emily");
		Human irene = new Human(23, "Irene");
		Human cedric = new Human(12, "Cedric");
		Human john = new Human(30, "John");
		
		Stack<Human> stack = new Stack<Human>();
		stack.push(emily);
		stack.add(irene);
		stack.add(cedric);
		stack.push(emily);
		stack.push(john);
		
		System.out.println("---------");
		stack.forEach(h -> {
			System.out.println(h.name + " " + h.age); 
			// Emily 20, Irene 23, Cedric 12, Emily 20, John 30
		});
		
		System.out.println("---------");
		System.out.println(stack.pop().name); // Joan
		System.out.println(stack.pop().name); // Emily
		System.out.println(stack.pop().name); // Cedric
		
		System.out.println("---------");
		stack.forEach(h -> {
			System.out.println(h.name + " " + h.age); 
			// Emily 20, Irene 23
		});
		
		System.out.println("---------");
		System.out.println(stack.size()); // 2
		
		System.out.println("---------");
		stack.clear();
		System.out.println(stack.isEmpty()); // true
		System.out.println(stack.size()); // 0
		
	}

}