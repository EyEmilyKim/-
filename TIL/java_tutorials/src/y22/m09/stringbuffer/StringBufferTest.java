package y22.m09.stringbuffer;

public class StringBufferTest {
	public static void main(String[] args) {
		StringBuffer str0 = new StringBuffer();
		StringBuffer str = new StringBuffer("Java");
		System.out.println(str0.capacity());
		System.out.println(str.capacity()+"\n");
		//capacity():StringBuffer 인스턴스의 현재 버퍼 크기 반환
		
		System.out.println("원본 문자열 : "+str);
		System.out.println(str.append("수업"));
		System.out.println("append() 후 원본 문자열 : "+str+"\n");
		//append(): 문자열 추가해서 보여줌
		
		StringBuffer str1 = new StringBuffer("Java Oracle");
		System.out.println("원본 문자열 : " + str1);
		System.out.println(str1.delete(4, 8));
		System.out.println(str1.deleteCharAt(1));
		System.out.println("메소드 호출 후 원본 문자열 : " + str1+"\n");
		//delete(): 문자열에서 삭제
	
		StringBuffer str2 = new StringBuffer("Java 만세!!");
		System.out.println("원본 문자열 : " + str2);
		System.out.println(str2.insert(4, "Script"));
		System.out.println("insert() 메소드 호출 후 원본 문자열 : " + str2+"\n");
		//insert(): 문자열에 삽입
		
		System.out.println(str2.reverse());
		//reverse(): 문자열 역순으로 출력
	}

}
