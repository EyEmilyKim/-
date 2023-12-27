package part1;

import java.util.ArrayList;
import java.util.List;

public class my_Ex8Program_ThreadGroup_Loop {

	public static void main(String[] args) {
		
		Runnable subMain = new Runnable() {
			public void run() {
				print();
			}
		};
		
		List<Thread> threads = new ArrayList<Thread>();
		
		ThreadGroup thGroup = new ThreadGroup("print main group");
		ThreadGroup thGroup1 = new ThreadGroup(thGroup, "print sub1 group");
		ThreadGroup thGroup2 = new ThreadGroup(thGroup, "print sub2 group");
		
		ThreadGroup[] thGroups = new ThreadGroup[] {thGroup1,thGroup1,thGroup1,thGroup2,thGroup2,thGroup2};
		
		String[] names = new String[] {"sub1","sub2","sub3","sub4","sub5","sub6"};
		
		for(int i=0; i<6; i++) {
			Thread thread = new Thread(thGroups[i], subMain);
			thread.setName(names[i]);
			threads.add(thread);
		}		
//		Thread th1 = new Thread(thGroup1, subMain);
//		th1.setName("sub1");
//		Thread th2 = new Thread(thGroup1, subMain);
//		th2.setName("sub2");
//		Thread th3 = new Thread(thGroup1, subMain);
//		th3.setName("sub3");
//		Thread th4 = new Thread(thGroup2, subMain);
//		th4.setName("sub4");
//		Thread th5 = new Thread(thGroup2, subMain);
//		th5.setName("sub5");
//		Thread th6 = new Thread(thGroup2, subMain);
//		th6.setName("sub6");

		for(Thread thread : threads) {
			thread.start();
		}		
//		th1.start();
//		th2.start();
//		th3.start();
//		th4.start();
//		th5.start();
//		th6.start();
		
		Thread th = Thread.currentThread();
		th.setName("Main");
//		print();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thGroup.list();
		thGroup1.interrupt();
//		thGroup2.interrupt();
		
//		if(th1.isAlive())
//			th1.interrupt();
//		if(th2.isAlive())
//			th2.interrupt();
//		if(th3.isAlive())
//			th3.interrupt();
//		if(th4.isAlive())
//			th4.interrupt();
//		if(th5.isAlive())
//			th5.interrupt();
//		if(th6.isAlive())
//			th6.interrupt();
		
		System.out.println("====== Exit ======");
		
	}

	private static void print() {
		
		Thread th = Thread.currentThread();
		
		for(int i=0; i<100; i++) {
			
			if(th.isInterrupted()) {
				System.err.println("요청이 들어와서 종료함.");
				return;
			}
			
			try{
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.err.println("자다가 깨서 스레드를 종료함.");
				return;
			}
		
			if(th.getName().equals("Main"))
				System.out.printf("%s[%d] : %d>\n", th.getName(), th.getId(), i+1);
			else
				System.out.printf("%s[%d] : %d\n", th.getName(), th.getId(), i+1);
		}
	}

}
