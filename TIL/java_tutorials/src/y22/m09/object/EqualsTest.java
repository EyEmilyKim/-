package y22.m09.object;

public class EqualsTest {
	public static void main(String[] args) {
		Car car01 = new Car();
		Car car02 = new Car();
		
		System.out.println(car01.equals(car02));//false
		System.out.println(car01.toString()+"\n"+car02.toString()+"\n");
		
		car01 = car02;
		System.out.println(car01.equals(car02));//true
		System.out.println(car01.toString()+"\n"+car02.toString());
	}
}
//equals() 메소드는 해당 인스턴스를 매개변수로 전달받는 참조변수와 비교하여 그 결과를 반환한다.
//이 때 참조변수가 가리키는 값을 비교하므로, 서로 다른 두 객체는 언제나 false를 반환한다.
//JAVA에서 equals()메소드는 API 클래스마다 자체적으로 오버라이딩을 통해 재정의되어 있다.