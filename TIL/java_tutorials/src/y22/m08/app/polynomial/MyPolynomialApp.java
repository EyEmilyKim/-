package y22.m08.app.polynomial;

import java.util.Scanner;

public class MyPolynomialApp {
	private Polynomial[] polys = new Polynomial[100];
	int n = 0;
	private Scanner kb = new Scanner(System.in);
	
	public MyPolynomialApp() {}
	
	private void processCommand() {
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("create"))//새로운 다항식 추가 > 다항식명 입력
				handleCreate();
			else if(command.equals("add"))//항 추가 > 다항식명, 계수, 차수 입력 
				handleAdd();
			else if(command.equals("calc"))//다항식 계산 > 다항식명, 밑수 입력
				handleCalc();
			else if(command.equals("print"))//다항식 출력 > 다항식명 입력
				handlePrint();
			else if(command.equals("exit"))//프로그램 종료
				break;
		}
		kb.close();
	}

	private void handlePrint() {
		char name = kb.next().charAt(0);

		int index = find(name);
		if(index < 0) {
			System.out.printf("No such Polynomial.");
			return;
		}
		System.out.println(polys[index].toString());
	}

	private void handleCalc() {
		char name = kb.next().charAt(0);
		int x = kb.nextInt();
		
		int index = find(name);
		if(index < 0) {
			System.out.printf("No such Polynomial.");
			return;
		}
		System.out.println(polys[index].calc(x));
	}

	private void handleAdd() {
		char name = kb.next().charAt(0);
		int coef = kb.nextInt();
		int expo = kb.nextInt();
		
		int index = find(name);
		if(index < 0) {
			System.out.printf("No such Polynomial.");
			return;
		}
		polys[index].addTerm(coef,expo);
	}
	
	//여러개의 다항식을 가진 polys에서 이름으로 다항식을 찾는 기능
	private int find(char name) {
		for(int i=0; i<n; i++)
			if(polys[i].name == name)
				return i;
		return -1;
	}

	private void handleCreate() {
		char name = kb.next().charAt(0);//charAt(0)→2장에서 설명
		Polynomial p = new Polynomial(name);
		polys[n++] = p;
//		//--상위호환(대략의 로직만 기술..)-- around 53:00
//		insert(p);
//	}
//	
//	//내가 입력한 이름으로 이미 정의된 다항식이 존재하는 경우를 고려한 코드
//	private void insert(Polynomial polynomial) {
//		int index = find(Polynomial.getName());//getName()정의 필요
//		if(index > -1)
//			polys[index] = polynomial;
//		else {
//			if(polys.length <= n)//배열이 꽉차면 reallocate
//				reallocate();
//			polys[n++] = Polynomial;
//		}
	}

	public static void main(String[] args) {
		MyPolynomialApp app = new MyPolynomialApp();
		app.processCommand();
	}
	
}
