package y22.m09.calendar;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		
//		Calendar time = new Calendar(); 
		//Calendar는 추상클래스이므로 인스턴스 생성 불가
		Calendar time = Calendar.getInstance(); 
		//Calendar 클래스의 static 메서드로 객체 리턴받음(시스템으로부터 생성된 날짜 정보) 
		System.out.println(time);
		//java.util.GregorianCalendar[time=1663205209365,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=15,DAY_OF_YEAR=258,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=0,HOUR=10,HOUR_OF_DAY=10,MINUTE=26,SECOND=49,MILLISECOND=365,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		System.out.println("---MONTH 상수 JANUARY~DECEMBER---");
		int jan = Calendar.JANUARY; System.out.println(jan); //0
		int feb = Calendar.FEBRUARY; System.out.println(feb); //1
		int mar = Calendar.MARCH; System.out.println(mar); //2
		int apr = Calendar.APRIL; System.out.println(apr); //3
		int may = Calendar.MAY; System.out.println(may); //4
		int jun = Calendar.JUNE; System.out.println(jun); //5
		int jul = Calendar.JULY; System.out.println(jul); //6
		int aug = Calendar.AUGUST; System.out.println(aug); //7
		int sep = Calendar.SEPTEMBER; System.out.println(sep); //8
		int oct = Calendar.OCTOBER; System.out.println(oct); //9
		int nov = Calendar.NOVEMBER; System.out.println(nov); //10
		int dec = Calendar.DECEMBER; System.out.println(dec); //11
		
		System.out.println("---get() test---");
		//get(int field)메서드로 특정 항목에 대한 값 추출. 항목 지정 파라미터는 Calendar.XXX 상수
		System.out.println(time.getTime()); //Thu Sep 15 10:04:05 KST 2022
		System.out.println(time.get(Calendar.MONTH)+1); //9 (1월:0~ 12월:11)
		System.out.println(time.get(Calendar.DATE)); //DATE=DAY_OF_MONTH
		System.out.println(time.get(Calendar.DAY_OF_MONTH)); //15 (월의 첫 value는 1)
		System.out.println(time.get(Calendar.HOUR)); //10 (12시간제)
		System.out.println(time.get(Calendar.HOUR_OF_DAY)); //10 (24시간제)
		System.out.println(time.get(Calendar.MINUTE)); //04
		System.out.println(time.get(Calendar.SECOND)); //05
		System.out.println(time.get(Calendar.YEAR)); //2022
		System.out.println("---요일 test---"); 
		System.out.println(time.get(Calendar.DAY_OF_WEEK)); //5:목요일 (1~7:일~토요일)
		
		int dayOfWeek = time.get(Calendar.DAY_OF_WEEK);
		switch(dayOfWeek) { //목요일
		case 1: System.out.println("일요일"); break;
		case 2: System.out.println("월요일"); break;
		case 3: System.out.println("화요일"); break;
		case 4: System.out.println("수요일"); break;
		case 5: System.out.println("목요일"); break;
		case 6: System.out.println("금요일"); break;
		case 7: System.out.println("토요일"); break;
		}
		switch(dayOfWeek) { //목요일
		case Calendar.SUNDAY: System.out.println("일요일"); break;
		case Calendar.MONDAY: System.out.println("월요일"); break;
		case Calendar.TUESDAY: System.out.println("화요일"); break;
		case Calendar.WEDNESDAY: System.out.println("수요일"); break;
		case Calendar.THURSDAY: System.out.println("목요일"); break;
		case Calendar.FRIDAY: System.out.println("금요일"); break;
		case Calendar.SATURDAY: System.out.println("토요일"); break;
		}
		
		System.out.println("---add() test---");
		System.out.println(time.getTime()); //Thu Sep 15 09:48:44 KST 2022
		time.add(Calendar.SECOND, 120); //120초(Second)추가
		System.out.println(time.getTime());//Thu Sep 15 09:51:49 KST 2022
		time.add(Calendar.DATE, 2); //2일(date)추가
		System.out.println(time.getTime());//Sat Sep 17 09:52:54 KST 2022
		time.add(Calendar.HOUR, 2); //2시간(hour)추가
		System.out.println(time.getTime());//Sat Sep 17 11:54:53 KST 2022
		time.add(Calendar.MONTH, 2); //2달(month)추가
		System.out.println(time.getTime());//Thu Nov 17 11:55:48 KST 2022
		
		System.out.println("---set() test---");
		System.out.println(time.getTime()); //Thu Nov 17 13:43:42 KST 2022
		time.set(Calendar.YEAR,	2030);
		System.out.println(time.getTime()); //Sun Nov 17 13:43:42 KST 2030
		time.set(1982, 1, 19);
		System.out.println(time.getTime()); //Fri Feb 19 13:43:42 KST 1982
		time.set(1982, 1, 19, 12, 34, 56);
		System.out.println(time.getTime()); //Fri Feb 19 12:34:56 KST 1982
		System.out.println(time.get((Calendar.MONTH))+"월"); //1월! (+1을 안해서.. 근데 +1하면 8월로 나오는건 왜?)
		System.out.println(time.get(Calendar.DAY_OF_WEEK)); //6:금요일
	
		System.out.println("---before()/after() test---");
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		Calendar time3 = Calendar.getInstance();
		time1.set(1982, 1, 19);
		time2.set(1989, 2, 19);
		time3.set(2020, 3, 19);
		System.out.println("time1:"+time1.get(Calendar.MONTH)+"월"); //1월!
		System.out.println("time2:"+time2.get(Calendar.MONTH)+"월"); //2월!
		System.out.println("time3:"+time3.get(Calendar.MONTH)+"월"); //3월!
				
		System.out.println(time2.before(time1)); //false
		System.out.println(time1.before(time3)); //true
		System.out.println(time2.after(time1)); //true
		System.out.println(time1.after(time3)); //false
		
		System.out.println("---roll() test---");
		Calendar time4 = Calendar.getInstance();
		Calendar time5 = Calendar.getInstance();
		System.out.println(time4.getTime()); //Thu Sep 15 12:01:26 KST 2022
		
		time4.add(Calendar.SECOND, 30);
		System.out.println(time4.getTime()); //Thu Sep 15 12:01:56 KST 2022
		
		time5.roll(Calendar.SECOND, 30);
		System.out.println(time5.getTime()); //Thu Sep 15 12:01:56 KST 2022
		
		System.out.println("---clear() test---");
		Calendar time6 = Calendar.getInstance();
		System.out.println(time6.getTime());//Thu Sep 15 12:25:24 KST 2022
		System.out.println(time6);
		//java.util.GregorianCalendar[time=1663212324939,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=15,DAY_OF_YEAR=258,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=25,SECOND=24,MILLISECOND=939,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		time6.clear(Calendar.YEAR);
		System.out.println(time6.get(Calendar.YEAR)); //1970
		System.out.println(time6.get(Calendar.MONTH)); //8
		System.out.println(time6.get(Calendar.DAY_OF_MONTH)); //15
		System.out.println(time6); //YEAR=1970*, MONTH=8(9월), DAY_OF_MONTH=15, ...
		//java.util.GregorianCalendar[time=22217124939,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=15,DAY_OF_YEAR=258,DAY_OF_WEEK=3,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=25,SECOND=24,MILLISECOND=939,ZONE_OFFSET=32400000,DST_OFFSET=0]
		time6.clear(Calendar.MONTH);
		System.out.println(time6.get(Calendar.YEAR)); //1970
		System.out.println(time6.get(Calendar.MONTH)); //0
		System.out.println(time6.get(Calendar.DAY_OF_MONTH)); //15
		System.out.println(time6); //YEAR=?, MONTH=?, DAY_OF_MONTH=15, ...
		//java.util.GregorianCalendar[time=1221924939,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=3,WEEK_OF_MONTH=3,DAY_OF_MONTH=15,DAY_OF_YEAR=15,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=25,SECOND=24,MILLISECOND=939,ZONE_OFFSET=32400000,DST_OFFSET=0]
		time6.clear(Calendar.DAY_OF_MONTH);
		System.out.println(time6.get(Calendar.YEAR)); //1970
		System.out.println(time6.get(Calendar.MONTH)); //0
		System.out.println(time6.get(Calendar.DAY_OF_MONTH)); //15
		System.out.println(time6); //YEAR=?, MONTH=?, DAY_OF_MONTH=?, ...
		//java.util.GregorianCalendar[time=1221924939,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=3,WEEK_OF_MONTH=3,DAY_OF_MONTH=15,DAY_OF_YEAR=15,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=3,AM_PM=1,HOUR=0,HOUR_OF_DAY=12,MINUTE=25,SECOND=24,MILLISECOND=939,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		time6.clear();
		System.out.println(time6.get(Calendar.YEAR)); //1970
		System.out.println(time6.get(Calendar.MONTH)); //0
		System.out.println(time6.get(Calendar.DAY_OF_MONTH)); //1
		System.out.println(time6);
		//java.util.GregorianCalendar[time=-32400000,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=1970,MONTH=0,WEEK_OF_YEAR=1,WEEK_OF_MONTH=1,DAY_OF_MONTH=1,DAY_OF_YEAR=1,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=1,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=0,ZONE_OFFSET=32400000,DST_OFFSET=0]

	}

}
