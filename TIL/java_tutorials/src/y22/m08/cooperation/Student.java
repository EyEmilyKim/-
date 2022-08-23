package y22.m08.cooperation;

public class Student {
	public String studentName;
	public int grade;
	public int money;
	
	//학생 이름과 가진 돈을 매개변수로 받는 생성자
	public Student(String n, int m) {
		this.studentName = n;
		this.money = m;
	}
	
	//학생이 버스를 타면 1,000원 지불하는 method
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}
	
	//학생이 지하철을 타면 1,000원 지불하는 method
	public void takeSubway(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}
	
	//학생의 현재 정보를 출력하는 method
	public void showInfo() {
		System.out.println(studentName+"학생의 남은 돈:"+money);
	}
}
