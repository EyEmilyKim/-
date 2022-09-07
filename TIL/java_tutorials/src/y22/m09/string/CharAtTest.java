package y22.m09.string;

public class CharAtTest {
	public static void main(String[] args) {
		String str = new String("JavaCoffeeBean");
		System.out.println("원본 문자열 : "+str);
		
		for(int i=0; i<str.length(); i++) {
			System.out.print(str.charAt(i)+" ");
		}
		System.out.println("\ncharAt() 후 원본 문자열 : "+str);
	}
}
