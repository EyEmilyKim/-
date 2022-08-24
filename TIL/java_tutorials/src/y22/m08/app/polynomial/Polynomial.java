package y22.m08.app.polynomial;

import y22.m08.linkedlist.MySingleLinkedList;
import y22.m08.linkedlist.Node;

public class Polynomial {
	public char name;
	public MySingleLinkedList<Term> terms; 
	
	public Polynomial(char name) {
		this.name = name;
		terms = new MySingleLinkedList<Term>();
	}
	
	//새로운 항을 추가하는 메서드
	public void addTerm(int coef, int expo) {	
		if(coef == 0)
		//*특수케이스: 계수가 0이라면 할 일 없음	
			return;
		Node<Term> p = terms.head, q = null;
		while(p != null && p.data.expo > expo ) {
		//낄 자리 찾기:(빈 리스트가 아니면서!)기존의 차수가 내 차수와 같거나 작지 않은 동안
			//그 앞 자리 정보(q)를 찾으면서 내가 낄 자리(p) 순회   	
			q = p;
			p = p.next;
		}
		if (p != null && p.data.expo == expo) {
		//(빈리스트가 아니면서!)내가 추가하려는 항과 같은 차수의 항이 존재하는 경우
			//항끼리의 계수를 더한다
			p.data.coef += coef;
			if(p.data.coef == 0) {
			//계수를 더해서 0이 된 경우 	
				//remove this node p
				if(q==null)
				//*특수케이스: 만약 지우려는 항이 첫번째 항이었다면 q==null	
					terms.removeFirst();
				else
					terms.removeAfter(q);
			}
		}else {
		//내가 추가하려는 항이 새로운 차수의 항인 경우
			//add after q
			Term t = new Term(coef, expo);
			if(q==null)
			//*특수케이스: 만약 빈 리스트였어서, 내가 모든 항보다 차수가 큰 첫번째 항이었다면 q==null	
				terms.addFirst(t);
			else
				terms.addAfter(q, t);
		}
	}
	
	//정수 x를 매개변수로 받아서 이 다항식의 결과값을 계산해주는 메서드
	//즉 다항식 모든 항의 값(각 밑수,계수,차수 조합)을 계산해서 더해주기
	public int calc(int x) {
		int result = 0;
		Node<Term> p = terms.head;
		while(p != null) {
			result += p.data.calc(x);
			p = p.next;
		}
		return result;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name+"(x)=");
		Node<Term> p = terms.head;
		while(p != null) {
			sb.append("+"+p.data.toString());
			p = p.next;
		}
		return sb.toString();
//		--하위호환 코딩--
//		String result = "";
//		Node<Term> p = terms.head;
//		while(p != null) {
//			result += ("+"+p.data.toString());
//			p = p.next;
//		}
//		return result
//		--------------
	}
}
