package bensoussan.scheduler;

public class Main {

	public static void main(String args[]) {

		Scheduler fifo = new Scheduler(new FIFOAlgorithm());

		Scheduler spf = new Scheduler(new SPFAlgorithm());

		Scheduler priority = new Scheduler(new PriorityAlgorithm());

		priority.start();
		spf.start();
		fifo.start();

	}
}
