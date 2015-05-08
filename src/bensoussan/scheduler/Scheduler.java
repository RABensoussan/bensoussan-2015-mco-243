package bensoussan.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Scheduler extends Thread{
	private static final int QUANTUM = 10;
	private static final Random rand = new Random();
	private List<FakeProcess> list;
	private SchedulerAlgorithm algorithm;

	public Scheduler(SchedulerAlgorithm algorithm) {
		// can make a bunch of instances of an algorithm and scheduler can take
		// different algorithms at different times.
		// the logic behind the scheduling can be in the instances' class
		list = new ArrayList<FakeProcess>();
		for(int i=0; i<100; i++){
			list.add(new FakeProcess(rand.nextInt(100), rand.nextInt(10)));
		}
		this.algorithm = algorithm;

	}

	@Override
	public void run() {
		while (!list.isEmpty()) {
			FakeProcess process = algorithm.getNextProcess(list);
			list.remove(process);

			process.run(QUANTUM);

			if (process.isStillRunning()) {
				list.add(process);
			}
		}
		System.out.println(algorithm.getName() + " is finished!");
	}

}
