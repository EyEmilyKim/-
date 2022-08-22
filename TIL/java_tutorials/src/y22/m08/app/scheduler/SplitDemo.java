package y22.m08.app.scheduler;

public class SplitDemo {
	public static void main(String[] args) {
		String str = "012-3456-78-9-abc-defghj";
		String[] tokens = str.split("-");
		for(int i=0; i<tokens.length; i++)
			System.out.println(tokens[i]);
		System.out.println();
		
		String str1 = "012.3456.78.9.abc.defghj";
//		String[] tokens1 = str1.split(".");
		//↑실행안됨. 왜냐하면 regular expression(정규 표현식)이 들어가야하는데 "."이 다른 의미로 해석되기 때문.
		//이럴 때는 이렇게↓ escape character "\" 사용.
		String[] tokens1 = str1.split("\\.");
		for(int i=0; i<tokens1.length; i++)
			System.out.println(tokens1[i]);
		System.out.println();
		
		String str2 = "This is    a pen.";
//		String[] tokens2 = str2.split("[]+");
		//↑와 ↓는 비슷한 표현이지만 ↓가 더 바람직함(여러개의 공백(white space, tab, 개행)도 커버 가능).
		String[] tokens2 = str2.split("\\s+");
		for(int i=0; i<tokens2.length; i++)
			System.out.println(tokens2[i]);
	}
}
