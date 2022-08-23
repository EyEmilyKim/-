package y22.m08.linkedlist;

public class MySingleLinkedList<T> {
	public Node<T> head;
	public int size;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	public void addFirst(T item) {
		Node<T> newNode = new Node<T>(item); //OK. T: type parameter
		/* 여기서 잠깐 제네릭 복습 */
		//T t = new T(); //not OK
		//T[] array = new T[100]; //not OK
		//Node<T> arr = new Node<T>[100];//not OK
		//T타입의 자체 객체 생성 불가.
		//T타입의 자체 배열 생성 불가.
		//T를 타입 파라미터로 갖는 다른 클래스 객체는 생성 OK.
		//하지만 T를 타입 파라미터로 갖는 어떤 클래스의 배열 생성은 또 불가.
		newNode.next = head; 
		head = newNode;
		size++;
		/* 예외 확인 */
		//기존의 연결리스트의 크기가 0인 경우, 즉 head가 null인 경우도 문제 없음을 확인.
	}
	public void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T>(item);
		temp.next = before.next;
		before.next = temp;
		size++;
		/* 예외 확인 */
		//before가 하필 마지막 node인 경우, before.next가 null인 경우도 문제 없음을 확인.
	}
	
	public void add(int index, T item) {//insert
		
	}
	
	public void remove(int index) {//delete
		
	}
	public T get(int index) {//show
		return null;
	}
	public int indexOf(T item) {//search
		return -1;
	}
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<String>();
		list.add(0, "Saturday");	//F
		list.add(1, "Friday");	//S,F
		list.add(0, "Monday");	// M,S,F
		list.add(2,	"Tuesday");	//M,S,T,F
		
		String str = list.get(2);	//str = "Tuesday"
		list.remove(2);	//M,S,F
		int pos = list.indexOf("Friday");	//pos = 2
	}

}
