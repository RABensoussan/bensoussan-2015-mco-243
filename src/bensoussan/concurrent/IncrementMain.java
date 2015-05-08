package bensoussan.concurrent;

import java.util.concurrent.CountDownLatch;

public class IncrementMain {

	static int number;

	public static void main(String args[]) throws InterruptedException {

		number = 0;
		
		CountDownLatch latch = new CountDownLatch(10);

		for (int i = 0; i < 10; i++) {
			new IncrementThread(latch).start();;
		}
			
		latch.await();
		System.out.println(number);
	}
}
