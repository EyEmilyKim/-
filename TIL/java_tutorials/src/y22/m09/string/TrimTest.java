package y22.m09.string;

public class TrimTest {
	public static void main(String[] args) {
		String str = new String(" Java Class     ");
		System.out.println("원본 문자열 : [" + str+"]");

		System.out.println(str + '|');
		System.out.println(str.trim() + '|');
		System.out.println("trim() 후 원본 문자열 : [" + str+"]");
	}
}
//trim() 메소드는 해당 문자열의 맨 앞과 맨 뒤에 포함된 모든 공백 문자를 제거해준다.