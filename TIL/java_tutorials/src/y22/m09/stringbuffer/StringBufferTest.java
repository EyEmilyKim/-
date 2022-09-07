package y22.m09.stringbuffer;

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer str0 = new StringBuffer();
		StringBuffer str = new StringBuffer("Java");

		System.out.println(str0.capacity());
		System.out.println(str.capacity()+"\n");
		//capacity():StringBuffer 인스턴스의 현재 버퍼 크기 반환.
		
		System.out.println("원본 문자열 : "+str+"\n");
		
		System.out.println(str.append("수업"));
		System.out.println("append() 후 원본 문자열 : "+str);
		//append(): 문자열 추가.
		
	}

}
