package bensoussan.concurrent;

public class Elevator {

	private int currentFloor;
	private int requestedFloor;

	public boolean isInUse() {
		return requestedFloor > 0;
	}

	public void setRequestedFloor(int requestedFloor) {
		synchronized (this) {
			while (!isInUse());
			this.requestedFloor = requestedFloor;
		}
	} // problem if two threads call this method at the same time because one
		// will write over the other

}
