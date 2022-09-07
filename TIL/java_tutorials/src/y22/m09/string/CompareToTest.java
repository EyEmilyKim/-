package y22.m09.string;

public class CompareToTest {
	public static void main(String[] args) {
		String str = new String("banana");
		System.out.println("원본 문자열 : "+str);
		System.out.println(str.compareTo("cat"));
		System.out.println(str.compareTo("banana"));
		System.out.println(str.compareTo("apple")+"\n");
		
		System.out.println(str.compareTo("Banana"));
		System.out.println(str.compareToIgnoreCase("Banana"));
		System.out.println("compareTo() 후 원본 문자열 : "+str);
	}
}
//compareTo() 메소드는 해당 문자열을 인수로 전달된 문자열과 사전 편찬 순으로 비교한다.
//두 문자열이 같다면 0, 해당 문자열이 인수 문자열보다 작으면(먼저) 음수, 크면(나중) 양수를 반환.
//이 메소드는 문자열을 비교할 때 대소문자를 구분하여 비교한다.
//compareToIgnoreCase() 메소드를 사용하면 대소문자를 구분하지 않고 비교한다.