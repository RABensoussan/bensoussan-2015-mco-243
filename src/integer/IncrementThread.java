package integer;

import java.util.concurrent.CountDownLatch;

public class IncrementThread extends Thread {

	private CountDownLatch latch;
	static Object lock = new Object();

	public IncrementThread(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		for (int i = 0; i < 1000000; i++) {
			synchronized (lock) {
				IncrementMain.number++;
			}
		}
		latch.countDown();
	}
}
