package bensoussan.compiler;

import java.util.Scanner;

public class Compiler {

	private Scanner keyboard;
	private char[] output;
	private int counter;

	public Compiler() {
		keyboard = new Scanner(System.in);
		output = new char[256];
		counter = 0;
	}

	public String compile() {
		while (keyboard.hasNext()) {
			String instruction = keyboard.next();
			switch (instruction) {
			case "LD":
				output[counter++] = '0';
				int temp = Integer.parseInt(keyboard.next());
				String info = Integer.toHexString(temp).toUpperCase();
				if (info.length() > 1) {
					output[counter++] = info.charAt(0);
					output[counter++] = info.charAt(1);
				} else {
					output[counter++] = '0';
					output[counter++] = info.charAt(0);
				}
				keyboard.nextLine();
				break;
			case "ST":
				output[counter++] = '1';
				temp = Integer.parseInt(keyboard.next());
				info = Integer.toHexString(temp).toUpperCase();
				if (info.length() > 1) {
					output[counter++] = info.charAt(0);
					output[counter++] = info.charAt(1);
				} else {
					output[counter++] = '0';
					output[counter++] = info.charAt(0);
				}
				keyboard.nextLine();
				break;
			case "SWP":
				output[counter++] = '2';
				keyboard.nextLine();
				break;
			case "ADD":
				output[counter++] = '3';
				keyboard.nextLine();
				break;
			case "INC":
				output[counter++] = '4';
				keyboard.nextLine();
				break;
			case "DEC":
				output[counter++] = '5';
				keyboard.nextLine();
				break;
			case "BZ":
				output[counter++] = '6';
				temp = Integer.parseInt(keyboard.next());
				info = Integer.toHexString(temp).toUpperCase();
				if (info.length() > 1) {
					output[counter++] = info.charAt(0);
					output[counter++] = info.charAt(1);
				} else {
					output[counter++] = '0';
					output[counter++] = info.charAt(0);
				}
				keyboard.nextLine();
				break;
			case "BR":
				output[counter++] = '7';
				temp = Integer.parseInt(keyboard.next());
				info = Integer.toHexString(temp).toUpperCase();
				if (info.length() > 1) {
					output[counter++] = info.charAt(0);
					output[counter++] = info.charAt(1);
				} else {
					output[counter++] = '0';
					output[counter++] = info.charAt(0);
				}
				keyboard.nextLine();
				break;
			case "STP":
				output[counter++] = '8';
				keyboard.nextLine();
				fill256();
				return output.toString();
			case "DATA":
				int location = Integer.parseInt(keyboard.next(), 16);
				info = keyboard.next();
				if (info.length() > 1) {
					output[location] = info.charAt(0);
					output[++location] = info.charAt(1);
				} else {
					output[location] = '0';
					output[++location] = info.charAt(0);
				}
				break;
			default:
				keyboard.nextLine();
			}
		}
		return output.toString();
	}

	private void fill256() {
		for (int i = 0; i < 256; i++) {
			if (output[i] == 0) {
				output[i] = '0';
			}
		}

	}

	public static void main(String args[]) {
		Compiler compiler = new Compiler();
		String machinecode = compiler.compile();
		System.out.println(machinecode);
	}
}
