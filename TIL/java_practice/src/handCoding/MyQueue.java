package handCoding;

class Node <T> {
	T data;
	Node <T> next;
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
}

public class MyQueue <T> {
	private Node <T> first; // 큐의 시작점
	private Node <T> last; // 큐의 끝점
	private int size; // 큐의 크기

	public MyQueue() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
		
	// 큐가 비어있는지 확인
	public boolean isEmpty() {
		return this.first == null;
	}
	
	// 큐의 사이즈 확인
	public int size() {
		return this.size;
	}
	
	// 큐에 데이터 삽입
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if(this.last == null) { // 큐가 비어있는 경우
			this.first = newNode;
			this.last = newNode;
		} else {
			this.last.next = newNode;
			this.last = newNode;
		}
		size++;
	}
	
	// 큐에서 데이터 삭제 및 반환
	public T poll() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		
		T data = this.first.data;
		this.first = this.first.next;
		
		if (this.first == null) {
			// 큐가 비게 되면 last 도 null 로 변경
			this.last = null;
		}
		size--;
		return data;
	} 
	
	// 큐의 맨 앞 요소 확인
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		return this.first.data;
	}
	
}

//public class Main {
//	public static void main(String[] args) {
//		MyQueue<Integer> queue = new MyQueue<>();
//			
//			queue.add(10);
//			queue.add(20);
//			queue.add(30);
//			
//			System.out.println("Peek: " + queue.peek()); //Peek: 10
//			System.out.println("Poll: " + queue.poll()); //Poll: 10
//			System.out.println("Poll: " + queue.poll()); //Poll: 20
//			
//			queue.add(40);
//			System.out.println("Queue size: " + queue.size()); //Queue size: 2
//			System.out.println("Peek: " + queue.peek()); //Peek: 30
//			
//			while (!queue.isEmpty()) {
//				System.out.println("Poll: " + queue.poll()); 
//				//Poll: 30
//				//Poll: 40
//			}
//			
//			queue.poll(); //java.lang.IllegalStateException: Queue is empty
//	}
//}
