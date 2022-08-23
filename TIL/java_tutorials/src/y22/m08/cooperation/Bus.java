package y22.m08.cooperation;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	
	//버스 번호를 매개변수로 받는 생성자
	public Bus(int busNum) {
		this.busNumber = busNum;
	}
	
	//승객이 버스에 탄 경우를 구현하는 method
	public void take(int m) {
		this.money += m;
		passengerCount++;
	}
	
	//버스 정보 출력
	public void showInfo() {
		System.out.println("버스 "+busNumber+"번의 승객:"+passengerCount+", 수입:"+money);
	}
	
}
