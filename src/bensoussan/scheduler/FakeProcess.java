package bensoussan.scheduler;

public class FakeProcess {
	private int timeToCompletion;
	private int priority;
	private int timeSinceExecution;

	public FakeProcess(int timeToCompletion, int priority) {
		this.timeToCompletion = timeToCompletion;
		this.priority = priority;
		timeSinceExecution = 0;
	}

	public void run(int time) {
		timeToCompletion -= time;
	}

	public int getTimeToCompletion() {
		return timeToCompletion;
	}

	public int getPriority() {
		return priority;
	}

	public boolean isStillRunning() {
		if (timeToCompletion > 0) {
			return true;
		}
		return false;
	}

	public void tick() {
		timeSinceExecution++;
		if (timeSinceExecution > 10) {
			if (priority != 1) { // highest priority is 1
				priority--; // to up a priority, SUBTRACT one number.
			}
			timeSinceExecution = 0;
		}
	}

	public void execute() {
		timeSinceExecution = 0;
	}
}
