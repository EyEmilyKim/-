package y22.m09.object;

public class ToStringTest {
	public static void main(String[] args) {
		Car car01 = new Car();
		Car car02 = new Car();
		
		System.out.println(car01.toString());
		System.out.println(car02.toString());
	}
}
//toString()메소드는 해당 인스턴스에 대한 정보를 문자열로 반환한다.
//반환되는 문자열 : 클래스 이름/ 구분자 '@'/ 16진수 해쉬코드(hash code)
//16진수 해쉬코드는 인스턴스의 주소를 가리키는 값으로, 인스턴스마다 모두 다르게 반환된다.
//JAVA에서 toString()메소드는 각 API 클래스마다 자체적으로 오버라이딩을 통해 재정의되어 있다.