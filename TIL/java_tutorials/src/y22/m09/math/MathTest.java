package y22.m09.math;

import java.util.Random;

public class MathTest {
	public static void main(String[] args) {
		System.out.println( (Math.random()*100) );//0~99(xx.xx)
		System.out.println( (int)(Math.random()*100) );//0~99(xx)
		
		Random ran = new Random();
		System.out.println(ran.nextInt(100) +"\n");//0~99(xx)
		
		System.out.println( (int)(Math.random()*6) );//0~5
		System.out.println( (int)(Math.random()*6)+1 );//1~6
		System.out.println( (int)(Math.random()*6)+3 +"\n");//3~8
		
		
		System.out.println(Math.abs(10));    //10
		System.out.println(Math.abs(-10));   //10
		System.out.println(Math.abs(-3.14) +"\n"); //3.14
		
		
		System.out.println(Math.E); //오일러의 수: 자연로그의 밑값, 약 2.718...
		System.out.println(Math.PI +"\n"); //원주율: 원의 원주를 지름으로 나눈 비율, 약 3.14159...
		
		//ceil(): 반대로 인수로 전달받은 값과 같거나 큰 수 중에서 가장 작은 정수 반환
		System.out.println(Math.ceil(10.0));      // 10.0
		System.out.println(Math.ceil(10.1));      // 11.0
		System.out.println(Math.ceil(10.000001) +"\n"); // 11.0

		//floor(): 인수로 전달받은 값과 같거나 작은 수 중에서 가장 큰 정수 반환
		System.out.println(Math.floor(10.0));     // 10.0
		System.out.println(Math.floor(10.9) +"\n");     // 10.0

		//round(): 전달받은 실수를 소수점 첫째 자리에서 반올림한 정수 반환
		System.out.println(Math.round(10.0));     // 10
		System.out.println(Math.round(10.4));     // 10
		System.out.println(Math.round(10.5) +"\n");     // 11
		
		System.out.println(Math.max(3.14, 3.14159)); // 3.14159
		System.out.println(Math.min(3.14, 3.14159)); // 3.14
		System.out.println(Math.max(-10, -11));      // -10
		System.out.println(Math.min(-10, -11) +"\n");      // -11

		//pow(): 제곱. sqrt(): 제곱근.
		System.out.println(Math.pow(5, 2)); // 25.0 = 5의 2승
		System.out.println(Math.sqrt(25));  // 5.0 = 25의 제곱근
		
	}

}
