package bensoussan.scheduler;

import java.util.List;

public interface SchedulerAlgorithm {
	
	String getName();
	FakeProcess getNextProcess(List<FakeProcess> list);

}
