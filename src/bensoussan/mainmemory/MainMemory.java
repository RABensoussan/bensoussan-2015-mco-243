package bensoussan.mainmemory;

public class MainMemory {

	private char[][] memory;
	private int availBytes;

	// must be able to handle the case in which there is no space of memory that
	// is large enough to store what you want in one contiguous block.
	public MainMemory(int numRows) {
		memory = new char[numRows][128];
		availBytes = numRows * 128;
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				memory[i][j] = '-';
			}
		}
	}

	public boolean allocate(int pid, int numBytes) {
		if (availBytes < numBytes) {
			return false;
		}
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (numBytes > 0) {
					if (memory[i][j] == '-') {
						memory[i][j] = Integer.toString(pid).charAt(0);
						availBytes--;
						numBytes--;
					}
				}
			}
		}
		return true;
	}

	public void free(int pid) {
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].length; j++) {
				if (memory[i][j] == Integer.toString(pid).charAt(0)) {
					memory[i][j] = '-';
					availBytes++;
				}
			}
		}
	}

	public void print() {
		for (char[] a : memory) {
			for (char b : a) {
				System.out.print(b);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MainMemory memory = new MainMemory(10);
		memory.print();
		memory.allocate(4, 356);
		memory.allocate(3, 167);
		memory.allocate(6, 212);
		memory.allocate(1, 321);
		memory.print();
		memory.free(3);
		memory.print();
		memory.allocate(8, 224);
		memory.print();
	}

}
