package projectX;

public class MathLeagueQ10A {
	public static double increment = 0.0001;
	public static double x = 0.08;
	public static double y = 0;

	public static double smallest = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (; x < 0.11; x = x + increment) {
			y(x);
			System.out.println("X value " + x + "\tSUM: " + sum(x, y));
		}
		x = 0.08;
		y = 0;
		loopMethod();
	}

	private static void loopMethod() {

		double sum = 0;
		double i = increment;
		y(i);
		double smallest = sum(i, y);

		for (i = 0.08; i < 0.11; i = increment + i) {
			y(i);
			sum = sum(i, y);
			if (sum < smallest) {
				smallest = sum;
			} else {
				break;
			}
		}
		System.out.println("X value " + i + "\tSUM: " + sum);
	}

	public static void y(double x) {
		y = (1 - 4 * x) / 9;
	}

	public static double sum(double x2, double y2) {
		return 1 / x2 + 1 / y2;
	}

}
