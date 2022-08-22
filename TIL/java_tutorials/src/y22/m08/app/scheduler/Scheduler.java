package y22.m08.app.scheduler;

import java.util.Scanner;

public class Scheduler {
	private int capacity = 3;
	public Event [] events = new Event [capacity];
	public int n = 0;
	private Scanner kb;
	public void processCommand() {
		kb = new Scanner(System.in);
		while(true) {
			System.out.print("$ ");
			String command = kb.next();
			if(command.equals("addevent")) {
				String type = kb.next();
				if(type.equalsIgnoreCase("oneday")) 
					handleAddOneDayEvent();
				else if(type.equalsIgnoreCase("duration"))
					handleAddDurationEvent();
				else if(type.equalsIgnoreCase("deadline"))
					handleAddDeadlinedEvent();
			}else if (command.equals("list")) {
				handleList();
			}else if (command.equals("show")) {
				
			}else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}

	private void handleList() {
		for(int i=0; i<n; i++)
			System.out.println(" "+ events[i].toString()); //dynamic binding
		
	}

	private void handleAddDeadlinedEvent() {
		// TODO Auto-generated method stub
		
	}

	private void handleAddDurationEvent() {
		// TODO Auto-generated method stub
		
	}

	private void handleAddOneDayEvent() {
		System.out.print(" when : ");
		String dateString = kb.next(); //dateString = "2022/8/22"
		System.out.print(" title : ");
		String title = kb.next();
		
		MyDate date = parseDateString(dateString);
		OneDayEvent ev = new OneDayEvent(title, date);
		
//		System.out.println(ev.toString());
		addEvent(ev);
		
	}

	private void addEvent(OneDayEvent ev) {
		if(n>=capacity) 
			reallocate();
		events[n++] = ev; 
	}

	private void reallocate() {
		Event[] tmp = new Event[capacity*2];
		for(int i=0; i<n; i++)
			tmp[i] = events[i];
		events = tmp;
		capacity *=2;
		//버려진 헌 배열은 자바 런타임에서 자동 garbage collecting 해줌.
	}

	private MyDate parseDateString(String dateString) {//dateString = "2022/8/22"
		String[] tokens = dateString.split("/");
		// tokens[0]="2017";
		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);
		
		MyDate md = new MyDate(year, month, day);
		return md;
	}

	public static void main(String[] args) {
		Scheduler app = new Scheduler();
		app.processCommand();

	}

}
