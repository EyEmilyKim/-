package part2;

public class CharList {
	private char[] list;
	private int index;
	
	public CharList() {
		list = new char[240];
		for(int i=0; i<240; i++)
			list[i] = (char)i;
		index = 0;
	}

	public synchronized void printNext() {
		
		Thread th = Thread.currentThread();

		char ch = list[index];
		
		try{
			Thread.sleep(20);
		} catch (InterruptedException e) {
			return;
		}

//		synchronized (this) {
			System.out.printf("%s[%d] - index : %d, char : %s\n",
					th.getName(), th.getId(), index, ch);
			index++;
//		}
	}
	
}
