package y22.m08.app.polynomial;

import y22.m08.linkedlist.MySingleLinkedList;

public class Polynomial {

	public char name;
	public MySingleLinkedList<Term> terms; 
	
	public Polynomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<Term>();
	}
	
	public void addTerm(int coef, int expo) {
		
	}
	
	public static void main(String[] args) {

	}

}
