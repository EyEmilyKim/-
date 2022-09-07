package y22.m09.string;

public class IndexOfTest {
	public static void main(String[] args) {
		String str = new String("Oracle Java");
		System.out.println("원본 문자열 : "+str);
		
		System.out.println(str.indexOf('o'));//-1
		System.out.println(str.indexOf('O'));//0
		System.out.println(str.indexOf('a'));//2
		System.out.println(str.indexOf("Java"));//7
		System.out.println("indexOf() 후 원본 문자열 : "+str);
	}
}
//indexOf() 메소드는 해당 문자열에서 특정 문자나 문자열이 처음으로 등장하는 위치의 인덱스를 반환한다.
//index는 0부터 시작. 결과가 0 => 첫번째 글자, 즉 n+1번째.
//만약 해당 문자열에 전달된 문자나 문자열이 포함되어 있지 않으면 -1을 반환한다.
//indexOf() 메소드는 문자나 문자열을 찾을 때 대소문자를 구분한다.

