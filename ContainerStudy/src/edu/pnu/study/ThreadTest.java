package edu.pnu.study;

public class ThreadTest {

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread() {
			public void run() {
				for (int i = 0 ; i < 10 ; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("thread" + i);
				}
			}
		};

		// 스레드 시작
		t1.start();
		
		// 스레드가 끝날 때까지 대기
		//t1.join();
		
		System.out.println("End");
	}
}
