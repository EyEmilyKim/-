package y22.m08.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
 
public class SetDemo {

	public static void main(String[] args) {
		HashSet<Integer> A = new HashSet<Integer>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(2);
		A.add(3);
		System.out.println("--HashSet");
		Iterator hi = (Iterator) A.iterator();
		while(hi.hasNext()) {
			System.out.println(hi.next());
		}
		
		ArrayList<Integer> Aal = new ArrayList<Integer>();
		Aal.add(1);
		Aal.add(2);
		Aal.add(2);
		Aal.add(2);
		Aal.add(2);
		Aal.add(3);
		
		System.out.println("\n--ArrayList");
		Iterator ai =  Aal.iterator();
		while(ai.hasNext()) {
			System.out.println(ai.next());
		}
	}

}
