package y22.m08.linkedlist;

public class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node(T item) {
		data = item;
		next = null;
	}
}
