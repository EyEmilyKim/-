package y22.m08.collection;

import java.util.HashSet;
import java.util.Iterator;

public class SetDemo1 {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		
		HashSet<Integer> B = new HashSet<Integer>();
		B.add(3);
		B.add(4);
		B.add(5);
		
		HashSet<Integer> C = new HashSet<Integer>();
		C.add(1);
		C.add(2);
		
		/* 포함 여부 */
		System.out.println(A.containsAll(B));//false
		System.out.println(A.containsAll(C));//true
		
		/* 집합 연산 */
//		A.addAll(B);//합집합(union) - 1,2,3,4,5
//		A.retainAll(B);//교집합(intersect) - 3
		A.removeAll(B);//차집합(difference) - 1,2
		
		Iterator hi = (Iterator)A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		
	}
}
