package y22.m08.array;

public class EnhancedforDemo {

	public static void main(String[] args) {
		int[] arr = new int[] { 1,2,3,4,5 };
	
	//JDK 1.5부터 배열과 컬렉션의 요소 참조를 위한 EnhancedFor문이 추가되었다.
	//EnhancedFor문은 명시한 배열이나 컬렉션의 길이만큼 반복되어 실행됨.	
		for(int e : arr) {
			System.out.print(e+" ");
		}//결과: 1 2 3 4 5
		System.out.println();
	
	//EnhancedFor으로 요소 값의 변경은 불가. (배열요소 원본이 아닌 사본을 조회에 사용한다)
		int[] arr1 = new int[] {1,2,3,4,5};
		int[] arr2 = new int[] {1,2,3,4,5};
		
		for(int i=0; i<arr1.length; i++) { arr1[i] += 10; }
		//결과: 11 12 13 14 15
		for(int e : arr2) { e += 10; }
		//결과: 1 2 3 4 5
		
		for(int e : arr1) System.out.print(e+" ");
		System.out.println();
		for(int e : arr2) System.out.print(e+" ");
	}

}
