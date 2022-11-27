package y22.m08.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayListToArray {
/*	
	https://codechacha.com/ko/java-convert-arraylist-to-array/
	Java - ArrayList를 배열로 변환
	ArrayList<String> 타입을 String[]으로 변환
*/		
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		String[] result = list.toArray(new String[list.size()]);	
		for(String s : result) {
			System.out.println(s);
		} // a b c
	}
	
}
