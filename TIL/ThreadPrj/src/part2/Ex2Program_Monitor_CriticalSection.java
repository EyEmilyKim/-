package part2;

public class Ex2Program_Monitor_CriticalSection {

	public static void main(String[] args) {
		
		Runnable subMain = new Runnable() {
			public void run() {
				print();
			}
		};
		
		
		Thread th1 = new Thread(subMain);
		th1.setName("sub1");
		Thread th2 = new Thread(subMain);
		th2.setName("sub2");
		Thread th3 = new Thread(subMain);
		th3.setName("sub3");

		th1.start();
		th2.start();
		th3.start();
		
		Thread th = Thread.currentThread();
		th.setName("Main");
//		print();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		System.out.println("====== Exit ======");
		
	}

	static Object lockIndex = new Object();
	static int gIndex = 0; // 데이터/정적 영역에 마련됨
	
	private static void print() {
		
		int index = 0; // 스택 영역에 마련됨
		
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
			
			// lock 으로 잠금을 해야하는 상황
			// 임계영역 : {} 
			// 락으로 쓰기 위한 객체 : lockIndex  
			synchronized (lockIndex) {
				index++;
				gIndex++;
				
				System.out.printf("%s[%d] : %d, index : %d, gIndex : %d\n", th.getName(), th.getId(), i+1, index, gIndex);
			}
			
		}
	}

}
