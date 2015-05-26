package bensoussan.mainmemory;

public class MainMemory {

	// must be able to handle the case in which there is no space of memory that
	// is large enough to store what you want in one contiguous block.
	public MainMemory(int totalBytes) {
		
	}

	public boolean allocate(int processID, int numBytes) {
		// Boolean indicates if it works or not
		
	}

	public void free(int pid) {
		
	}

	public void print() {
		// print a graphical representation of the memory box - what is free '-'
		// , and what is not free - put number of which id it is allocated to.
		// Width should be 128.
		
	}

}
