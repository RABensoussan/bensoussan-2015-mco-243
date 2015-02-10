package bensoussan.microprocesser;

import java.util.Scanner;

public class MicroprocesserSimulation {

	private String[] input;
	private int inputPointer;
	private String A;
	private String B;

	public MicroprocesserSimulation(String input) {
		this.input = input.split("");
		inputPointer = 0;
	}

	public void generateOutput() {
		while (!input[inputPointer].equals("8")) {
			followInstructions(input[inputPointer]);
		}
	}

	public String getOutput() {
		StringBuilder info = new StringBuilder();
		for (String str : input) {
			info.append(str);
		}
		info.append("\n");
		return info.toString();
	}

	private void followInstructions(String string) {
		switch (string) {
		case "0":
			String temp = input[++inputPointer] + input[++inputPointer];
			int memory = Integer.parseInt(temp, 16);
			A = input[memory];
			inputPointer++;
			break;
		case "1":
			temp = input[++inputPointer] + input[++inputPointer];
			memory = Integer.parseInt(temp, 16);
			input[memory] = A.toUpperCase();
			inputPointer++;
			break;
		case "2":
			temp = A;
			A = B;
			B = temp;
			inputPointer++;
			break;
		case "3":
			int a = Integer.parseInt(A, 16);
			int b = Integer.parseInt(B, 16);
			int sum = a + b;
			String hex = Integer.toHexString(sum);
			if (hex.length() > 1) {
				A = String.valueOf(hex.charAt(1));
				B = String.valueOf(hex.charAt(0));
			}
			else{
				A = String.valueOf(hex.charAt(0));
				B = "0";
			}
			inputPointer++;
			break;
		case "4":
			a = Integer.parseInt(A, 16);
			if (a == 15) {
				a = 0;
			} else {
				a++;
			}
			A = Integer.toHexString(a);
			inputPointer++;
			break;
		case "5":
			a = Integer.parseInt(A, 16);
			if (a == 0) {
				a = 15;
			} else {
				a--;
			}
			A = Integer.toHexString(a);
			inputPointer++;
			break;
		case "6":
			a = Integer.parseInt(A, 16);
			if (a == 0) {
				temp = input[++inputPointer] + input[++inputPointer];
				memory = Integer.parseInt(temp, 16);
				inputPointer = memory;
			} else {
				inputPointer += 3;
			}
			break;
		case "7":
			temp = input[++inputPointer] + input[++inputPointer];
			memory = Integer.parseInt(temp, 16);
			inputPointer = memory;
			break;
		}
	}

	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		MicroprocesserSimulation simulator = new MicroprocesserSimulation(input);
		simulator.generateOutput();
		String output = simulator.getOutput();
		System.out.println(output);
		keyboard.close();
	}
}
