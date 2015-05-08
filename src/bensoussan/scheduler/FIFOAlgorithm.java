package bensoussan.scheduler;

import java.util.List;

public class FIFOAlgorithm implements SchedulerAlgorithm{
	
	private String name = "FIFO Algorithm";
	
	@Override
	public String getName(){
		return name;
	}

	@Override
	public FakeProcess getNextProcess(List<FakeProcess> list) {
		return list.get(0);
	}

}
