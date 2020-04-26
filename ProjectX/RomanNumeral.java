package projectX;

import java.util.Scanner;

public class RomanNumeral {

	private static int I = 1;
	private static int V = 5;
	private static int X = 10;
	private static int L = 50;
	private static int C = 100;
	private static int D = 500;
	private static int M = 1000;
	private static int[] symbols = { I, V, X, L, C, D, M };
	private static String output = "";

	public static void main(String args[]) {
		boolean tracker = true;
		while (tracker) {
			int input = input();
			if (input == 0) {
				System.out.println("Program Stopped");
				break;
			}
			if (input > 3999) {
				System.out.println("Not a possible value. Range must be from 0 to 3999");
			}
			while (tracker && input <= 3999) {
				int prev = remainderBig(input);
				// System.out.println("Largest Value " + prev);
				input = input - prev;
				// System.out.println("input " + input);
				output += lookUp(prev);
				String output1 = output;
				if (input <= 0) {
					// System.out.println("before print " + output1);
					System.out.println("Result " + formatter(output1));
					output = "";
					break;
				}
			}
		}
	}

	public static String formatter(String input) {

		if (input.contains("VIIII")) {
			input = input.replace("VIIII", "IX");
		}
		if (input.contains("IIII")) {
			input = input.replace("IIII", "IV");
			// System.out.println("hit");
		}

		if (input.contains("LXXXX")) {
			input = input.replace("LXXXX", "XC");
		}
		if (input.contains("XXXX")) {
			input = input.replace("XXXX", "XL");
		}
		if (input.contains("DCCCC")) {
			input = input.replace("DCCCC", "CM");
		}
		if (input.contains("CCCC")) {
			input = input.replace("CCCC", "CD");
		}

		return input;

	}

	public static int input() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static int remainderBig(int input) {
		int prevRemainder = 0;
		int counter = 0;
		for (int currentSymbol : symbols) {
			int remainder = Math.floorDiv(input, currentSymbol);
//			System.out.println("--------------------------------------");
//			System.out.println("Current value to test " + currentSymbol);
//			System.out.println("Previous Remainder value " + prevRemainder);
//			System.out.println("Remainder value " + remainder);
			if (remainder == 0) {
				// System.out.println("Returning biggest possible " + symbols[counter - 1]);
				return symbols[counter - 1];
			}
			counter++;
			prevRemainder = remainder;
		}
		return M;
	}

	public static String lookUp(int input) {
		switch (input) {
		case 1:
			return "I";
		case 5:
			return "V";
		case 10:
			return "X";
		case 50:
			return "L";
		case 100:
			return "C";
		case 500:
			return "D";
		case 1000:
			return "M";
		}
		return "error";
	}

}
