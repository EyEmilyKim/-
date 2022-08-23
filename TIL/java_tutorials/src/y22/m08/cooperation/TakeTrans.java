package y22.m08.cooperation;

public class TakeTrans {

	public static void main(String[] args) {
		//학생 두 명 생성
		Student studentJames = new Student("James", 5000);
		Student studentSelly = new Student("Selly", 10000);
		studentJames.showInfo();
		studentSelly.showInfo();
		
		//James의 버스 탑승 과정
		Bus bus100 = new Bus(100);
		studentJames.takeBus(bus100);
		System.out.println("---James 버스 탑승");
		studentJames.showInfo();
		bus100.showInfo();
		
		//Selly의 지하철 탑승 과정
		Subway subwayGreen = new Subway("2호선");
		studentSelly.takeSubway(subwayGreen);
		System.out.println("---Selly 지하철 탑승");
		studentSelly.showInfo();
		subwayGreen.showInfo();
	}

}
