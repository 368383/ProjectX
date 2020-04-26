package projectX;

public class Recursion {
	public static int modValue = 0;

	public static void main(String[] args) {
		modValue = 3;
		System.out.println("MOD VALUE " + mod(11));
	}

	public static double mod(int input) {
		if (input < modValue) {
			return input;
		}
		input = input - modValue;
		return mod(input);
	}
}
