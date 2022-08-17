package y22.m08.collection;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		String[] arrayObj = new String[2];
		arrayObj[0] = "one";
		arrayObj[1] = "two";
//		arrayObj[2] = "three";//OutOfBoundsException
		for(int i=0; i<arrayObj.length; i++) {
			System.out.println(arrayObj[i]);
		}
			System.out.println();
		
		ArrayList al = new ArrayList();
		al.add("one");
		al.add("two");
		al.add("three");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		for(int i=0; i<al.size(); i++) {
			String value = (String)al.get(i);
			//ArrayList()의 매개변수로 들어간 요소들은 Type이 Object이므로
			//String 타입 변수에 담기 위해서 String 으로 형변환이 필요하다.
			System.out.println(value);
		}
			System.out.println();
		
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("one");
		al1.add("two");
		al1.add("three");
		for(int i=0; i<al1.size(); i++) {
			String value = al1.get(i);
			//여기서는 ArrayList<String>()으로 내용의 타입을 특정했으므로
			//al1 안의 요소를 꺼낼 때 별도 String 형변환 필요없음.
			System.out.println(value);
		}
		
			
	}

}
