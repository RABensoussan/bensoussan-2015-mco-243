package bensoussan.scheduler;

import java.util.List;

public class SPFAlgorithm implements SchedulerAlgorithm {

	private String name = "SPF Algorithm";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		int shortestIndex = 0;
		int shortestTime = list.get(0).getTimeToCompletion();
		for (int i = 1; i < list.size() - 1; i++) {
			if (list.get(i).getTimeToCompletion() < shortestTime) {
				shortestIndex = i;
				shortestTime = list.get(i).getTimeToCompletion();
			}
		}
		return list.get(shortestIndex);
	}

}
