package bensoussan.scheduler;

import java.util.List;

public class PriorityAlgorithm implements SchedulerAlgorithm {

	private String name = "Priority Algorithm";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {

		int lowestPriorityIndex = 0;
		int lowestPriority = list.get(0).getPriority();
		for (int i = 1; i < list.size() - 1; i++) {
			list.get(i).tick(); // tell it another round went by and not
								// executed
			if (list.get(i).getPriority() < lowestPriority) {
				lowestPriorityIndex = i;
				lowestPriority = list.get(i).getPriority();
			}
		}

		list.get(lowestPriorityIndex).execute(); // set timesincexecution to be
													// 0

		return list.get(lowestPriorityIndex);
	}

}
