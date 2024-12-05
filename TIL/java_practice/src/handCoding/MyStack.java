package handCoding;

public class MyStack {
	int[] array;
	private int size;
	private int top;
	
	public MyStack(int length) {
		this.array = new int[length];
		this.size = length;
		this.top = -1;
	}
	
	public boolean isEmpty() {
		return this.top == -1;
	}
	
	public boolean isFull() {
		return this.top == this.size - 1;
	}

	public void push(int value) {
		if(isFull()) {
			System.out.println("stack is full");
			return;
		}
		this.array[++this.top]= value; 
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return -1;
		}
		return this.array[this.top--];
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("stack is empty");
			return -1;			
		}
		return this.array[this.top];
	}
	
}

//public class Main {
//	public static void main(String[] args) {
//	MyStack stack = new MyStack(3);
//
//	stack.push(1);
//	stack.push(2);
//	stack.push(3);
//	stack.push(4); //stack is full
//
//	System.out.println(stack.pop()); // 3
//	System.out.println(stack.peek()); // 2
//	System.out.println(stack.pop()); // 2
//	System.out.println(stack.pop()); // 1		
//	System.out.println(stack.pop()); // stack is empty -1		
//	}
//}
