package y22.m08.array;

import java.util.Arrays;

public class ArrayCopyDemo {

	public static void main(String[] args) {
		int[] arr0 = new int[] { 1,2,3,4,5 };
		int newLen = 10;
		
		/* 1. System 클래스의 arraycopy() 메소드 */
		int[] arr1 = new int[newLen];
		System.arraycopy(arr0, 0, arr1, 0, arr0.length);
		//결과: { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 }
		
		/* 2. Arrays 클래스의 copyOf() 메소드 */ 
		int[] arr2 = Arrays.copyOf(arr0, 10);
		//결과: { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 }
		
		/* 3. Object 클래스의 clone() 메소드 */
		int[] arr3 = (int[])arr0.clone();
		//결과: { 1, 2, 3, 4, 5 } *clone()은 길이증가 없이 복사만 가능!
		
		/* 4. for 문과 인덱스를 이용한 복사 */
		int[] arr4 = new int[newLen];
		for(int i=0; i<arr0.length; i++) arr4[i] = arr0[i];
		//결과: { 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 }
		
		
		int[][] arrs = { arr0, arr1, arr2, arr3, arr4 }; 
		for(int i=0; i<arrs.length; i++) {
			System.out.println("--- arr"+(i)+" -------");
			for(int j=0; j<arrs[i].length; j++) {
				System.out.print(arrs[i][j]+" ");
			}
			System.out.println();
		}
	}

}
