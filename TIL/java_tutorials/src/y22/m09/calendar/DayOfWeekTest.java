package y22.m09.calendar;

import java.util.Calendar;

public class DayOfWeekTest {
	public static void main(String[] args) {
		int dayOfMonth ;
		Calendar cal = Calendar.getInstance();
		// 1~7:일~토요일 이 기본설정 
		for(int i=0; i<60; i++) {
			dayOfMonth = cal.get(Calendar.DAY_OF_WEEK);
			cal.add(Calendar.DATE, 1); //1일씩 더함
			System.out.println("dayOfMonth = "+dayOfMonth);
		} //5목 6금 7토 1일 2 3 4 5 6 7 1 2 3 4 5 6 7 ....
		
	}

}
