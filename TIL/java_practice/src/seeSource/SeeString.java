package seeSource;

public class SeeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "choco";
		String str2 = "choco";
		String str3 = new String("choco");
		String str4 = new String("choco");

		int hash1 = str1.hashCode();
		int hash2 = str2.hashCode();
		int hash3 = str3.hashCode();
		int hash4 = str4.hashCode();
		
		System.out.println(str1 == str2); // true
		System.out.println(str1.equals(str2)); // true
		
		System.out.println(str1 == str3); // false
		System.out.println(str1.equals(str3)); // true
		
		System.out.println(str3 == str4); // false
		System.out.println(str3.equals(str4)); // true
		
		System.out.println(hash1); // 94636694
		System.out.println(hash2); // 94636694
		System.out.println(hash3); // 94636694
		System.out.println(hash4); // 94636694
		
		System.out.println(str1.getClass()); // class java.lang.String
		System.out.println(str2.getClass()); // class java.lang.String
		System.out.println(str3.getClass()); // class java.lang.String
		System.out.println(str4.getClass()); // class java.lang.String
		
		System.out.println(str1.getBytes()); // [B@58ceff1

		System.out.println(str1.charAt(0)); // c
		System.out.println(str1.charAt(1)); // h
		System.out.println(str1.charAt(2)); // o
		System.out.println(str1.charAt(3)); // c
		System.out.println(str1.charAt(4)); // o
		
		System.out.println(str1.startsWith("c")); // true
		System.out.println(str1.startsWith("C")); // false
		System.out.println(str1.startsWith("a")); // false
	}

}
