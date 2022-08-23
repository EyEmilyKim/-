package y22.m08.cooperation;

public class Subway {
	String lineNumber;
	int passengerCount;
	int money;
	
	//지하철 노선 번호를 매개변수로 받는 생성자
	public Subway(String lineNum) {
		this.lineNumber = lineNum;
	}
	
	//승객이 지하철에 탄 경우를 구현하는 method
	public void take(int m) {
		this.money += m;
		passengerCount++;
	}
	
	//지하철 정보 출력
	public void showInfo() {
		System.out.println("지하철 "+lineNumber+"호선의 승객:"+passengerCount+"명, 수입:"+money);
	}
}
