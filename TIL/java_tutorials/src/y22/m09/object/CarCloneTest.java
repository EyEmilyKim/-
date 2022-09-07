package y22.m09.object;

import java.util.ArrayList;

class Car implements Cloneable {
	private String modelName;
	private ArrayList<String> owners = new ArrayList();
	
	public String getModelName() {return this.modelName;}
	public void setModelName(String modelName) {this.modelName = modelName;}
	
	public ArrayList getOwners() {return this.owners;}
	public void setOwners(String ownerName) {this.owners.add(ownerName);}
	
	public Object clone() {//Object 클래스의 clone()메소드 오버라이드
		try {
			Car clonedCar = (Car)super.clone();

//			clonedCar.owners = (ArrayList)owners.clone();
			//↑ 이 메소드가 필요한 이유:
			//object 클래스의 기본 clone()메소드는 단지 필드의 값만을 복사하므로, 
			//필드의 값이 배열이나 인스턴스인 경우, 제대로 독립된 복제본을 생성할 수 없다.
			
			return clonedCar;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}

public class CarCloneTest {
	public static void main(String[] args) {
		Car car01 = new Car();
		car01.setModelName("아반떼");
		car01.setOwners("홍길동");
		System.out.println("Car01 : "+car01.getModelName()+", "+car01.getOwners()+"\n");

		Car car02 = (Car)car01.clone();
		car02.setOwners("황진이");
		System.out.println("Car01 : "+car01.getModelName()+", "+car01.getOwners());
		System.out.println("Car02 : "+car02.getModelName()+", "+car02.getOwners());
	}
}
