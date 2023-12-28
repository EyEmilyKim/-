package part2;

import java.util.concurrent.locks.ReentrantLock;

public class CharList3 {
	private char[] list;
	private int index;
	private ReentrantLock indexLock;
	
	public CharList3() {
		indexLock = new ReentrantLock();
		list = new char[240];
		
		index = 0;
	}
	
	public void load() {
		for(int i=0; i<26; i++) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			list[i] = (char)('A'+i);
			
		}
	}
	
	public void printAll(int count) {
		Thread th = Thread.currentThread();
		
		for(int i=0; i<count; i++) {
			StringBuilder builder = new StringBuilder();
			builder.append(list);
			
			System.out.printf("%s[%d-%d] - %s\n",
						th.getName(), th.getId(), ++index, builder.toString());
			
		}
	}

//	public synchronized void printNext() {
	public void printNext() {
		
		Thread th = Thread.currentThread();

		char ch = list[index];
		
		try{
			Thread.sleep(20);
		} catch (InterruptedException e) {
			return;
		}

		boolean aquired = indexLock.tryLock();
		
//		synchronized (indexLock) {
//		indexLock.lock();
		if(aquired) {
			System.out.printf("%s[%d] - index : %d, char : %s\n",
					th.getName(), th.getId(), index, ch);
			index++;
			indexLock.unlock();
		}
//		}
		else {
			System.out.printf("%s[%d] : alternate ... \n",
					th.getName(), th.getId());
		}
	}
	
}
