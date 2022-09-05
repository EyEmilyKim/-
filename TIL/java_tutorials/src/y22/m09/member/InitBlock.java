package y22.m09.member;

class Car {
	private String modelName;
	private int modelYear;
	private String color;
	private int maxSpeed;
	private int currentSpeed;
	private char charTest;
	
	{//인스턴스 초기화 블럭
		this.currentSpeed = 10;
	}
	
	Car(){}
	Car(String mn, int my, String c, int ms){
		this.modelName = mn;
		this.modelYear = my;
		this.color = c;
		this.maxSpeed = ms;
	}
	
	public int getSpeed() {
		return currentSpeed;
	}
	public void setSpeed(int cs) {
		this.currentSpeed = cs;
	}
	
	public String getModelName() {
		return modelName;
	}
	public int getModelYear() {
		return modelYear;
	}
	public char getCharTest() {
		return charTest;
	}
}

public class InitBlock {
	public static void main(String[] args) {
		/* 초기화 블럭 Test */
		Car myCar1 = new Car("Ferrari",2022,"yellow",380);//인스턴스 생성&..
		Car myCar2 = new Car("Toyota",2020,"pink",250);//..&생성자를 통한 초기화
		System.out.println(myCar1.getModelName());//인스턴스 메소드의 호출
		System.out.println(myCar1.getSpeed());
		System.out.println(myCar2.getModelName());
		System.out.println(myCar2.getSpeed()+"\n");
		//결과 : Ferrari, 10, Toyota, 10
		//→ 모든 인스턴스가 공통값을 갖는 변수는 초기화 블럭을 통해 코드, 초기화의 중복을 피할 수 있다.
		
		/* 자동 초기값 Test */
		//클래스 변수와 인스턴스 변수는 초기화를 하지 않아도 변수의 타입에 맞게 자동으로 초기화된다.
		//하지만 지역변수는 사용하기 전에 초기화하지 않으면, 자바 컴파일러가 오류를 발생시키므로 주의.
		//클래스 변수와 인스턴스 변수도 적절한 값으로 초기화한 후에 사용하는 것이 좋다.
		Car myCar3 = new Car();
		System.out.println(myCar3.getModelName());
		System.out.println(myCar3.getModelYear());
		System.out.println(myCar3.getCharTest());
		System.out.println(myCar3.getSpeed()+"\n");
		//결과 : null, 0, '공백', 10 
		
//		myCar1.setSpeed(100);
//		System.out.println(myCar1.getSpeed());
		//결과 : 100
	}

}
