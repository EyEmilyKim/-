package y22.m08.app.scheduler;

public class DeadlinedEvent extends Event {
	public String title;
	public MyDate deadline;
	
	public DeadlinedEvent(String title, MyDate date){
		super(title);
		this.deadline = date;
	}
	
	public String toStiring() {
		return title + ", " + deadline.toString();
	}
}
