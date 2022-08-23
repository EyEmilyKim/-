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
		/* 특수case 확인 */
		//기존의 연결리스트의 크기가 0인 경우, 즉 head가 null인 경우도 문제 없음을 확인.
	}
	public void addAfter(Node<T> before, T item) {
		Node<T> temp = new Node<T>(item);
		temp.next = before.next;
		before.next = temp;
		size++;
		/* 특수case 확인 */
		//before가 하필 마지막 node인 경우, 즉 before.next가 null인 경우도 문제 없음을 확인.
	}
	
	public void add(int index, T item) {//insert - index-1번째 노드에 item 삽입
		if(index<0 || index> size)
			return; //원래는 exception처리를 해줘야 맞지만 여기선 pass
		if(index == 0)
			addFirst(item);
		else {
			Node<T> q = getNode(index-1);
			addAfter(q, item);
		}
	}
	
	public T removeFirst() {
		if(head == null) { return null;
		}else {
			T temp = head.data;
			head = head.next;
			return temp;
			/* 특수case 확인 */
			//단 하나 있던 node를 삭제하는 경우, head가 null이 되어 문제가 없음을 확인.
		}
	}
	public T removeAfter(Node<T> before) {
		if(before.next == null) { return null;
		}else {
			T temp = before.next.data;
			before.next = before.next.next;
			return temp;
			/* 특수case 확인 */
			//삭제한 node가 마지막 것이었을 경우, before 의 next가 null이 되어 문제가 없음을 확인.
		}
	}
	
	public T remove(int index) {//delete
		if(index < 0 || index >= size)
			return null;
		if(index==0)
			return removeFirst();
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}
	public T remove(T item) {
		Node<T> p = head, q = null;
		while(p!=null && !p.data.equals(item)) {
			q = p;
			p = p.next;
		}
		if(p==null)//삭제할 node가 존재하지 않음
			return null;		
		if(q==null)//찾던 node가 첫번째였던 경우
			return removeFirst();
		else
			return removeAfter(q);
	/* 특수case 확인 */
	//empty list였을 때, null이 반환되어 문제가 없음을 확인.
	}
	
	public Node<T> getNode(int index) {//show - index번째 노드 반환
		if(index<0 || index>=size)
			return null;
		Node<T> p = head;
		for (int i=0; i<index; i++) 
			p= p.next;
		return p;
	}
	
	public T get(int index) {//show - index번째 노드에 저장된 data를 반환
		if(index<0 || index>=size)
			return null;
//		Node<T> p = head;
//		for (int i=0; i<index; i++) 
//			p= p.next;
//		return p.data;
		return getNode(index).data;
	}
	
	//연결리스트 순회(traverse): 연결리스트의 노드들을 처음부터 순서대로 방문하는 것
	public int indexOf(T item) {//search
		Node<T> p = head;
		int index = 0;
		while(p != null) {
			if(p.data.equals(item)) { 
				return index;
			}else {
				p = p.next;
				index++;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<String>();
		list.add(0, "Saturday");	//F
		list.add(1, "Friday");	//S,F
		list.add(0, "Monday");	// M,S,F
		list.add(2,	"Tuesday");	//M,S,T,F
		
		String str = list.get(2);	//str = "Tuesday"
		System.out.println(str);	//ㅇㅇ
		list.remove(2);	//M,S,F
		int pos = list.indexOf("Friday");	//pos = 2
		System.out.println(pos);	//ㅇㅇ
		System.out.println();
		
		list.addFirst("garota");	//garota,M,S,F
		list.addFirst("moon");	//moon,garota,M,S,F
		list.add(pos, str);	// moon,garota,T,M,S,F
		list.remove("Friday");	//moon,garota,T,M,S
		int index = list.indexOf("Saturday");	//4
		System.out.println(index); //ㅇㅇ
		
		System.out.println();
		for(int i=0; i<list.size; i++)
			System.out.println(list.get(i));
		
	}

}
