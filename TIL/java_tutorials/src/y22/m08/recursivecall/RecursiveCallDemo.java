package y22.m08.recursivecall;

public class RecursiveCallDemo {
	
	/* 1."1부터 n까지의 합계" 쌩 메소드 */
	static int sumUntil(int n) {
		int result = 0;
		for(int i=1; i<=n; i++) { result += i; }
			return result;
		}
	
	 /* 2. 1의 코드를 재귀호출로 바꿔보면 */
	static int recursiveSum(int n) {
		if(n == 1) {return 1;} 
		else {return n + recursiveSum(n-1);}
	}
//	예를 들어...1부터 4까지의 합을 구하는 알고리즘??
//	 _ 1. 1부터 4까지의 합은 1부터 3까지의 합에 4를 더하면 됨.
//	 _ 2. 1부터 3까지의 합은 1부터 2까지의 합에 3을 더하면 됨.
//	 _ 3. 1부터 2까지의 합은 1부터 1까지의 합에 2를 더하면 됨.
//	 _ 4. 1부터 1까지의 합은 그냥 1.
//	위 로직을 의사 코드(pseudo code)로 정리하면
//	 _ 시작
//	 _ 1. n이 1이 아니면, n과 [1부터 (n-1)까지의 합]을 더한 값을 반환함. *[]부분이 재귀반복됨!
//	 _ 2. n이 1이면, 그냥 1을 반환함. 
//			* 이렇게 재귀반복이 끝나는 조건문이 반드시 필요.
//			->만약 그게 없으면 stack overflow에 의해 이 프로그램은 실행하자 마자 종료됨.
//	 _ 끝
//	이처럼 재귀호출은 다양한 알고리즘을 표현한 의사 코드를 그대로 코드로 옮길 수 있게 해주므로,
//	직관적인 프로그래밍을 하는 데 많은 도움을 준다.
	
	public static void main(String[] args) {
		int sumUntil10 = sumUntil(10);
		System.out.println(sumUntil10);//55

		int recursiveSum10 = recursiveSum(10);
		System.out.println(recursiveSum10);//55
	}

}
