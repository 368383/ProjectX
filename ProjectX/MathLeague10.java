package projectX;

public class MathLeague10 {
	public static double x = 2;
	public static double y = y(x);
	public static double increment = 0.00001;
	public static double smallest = recip(x, y);

	public static void main(String[] args) {
		x = x + increment;
		y = y + increment;

		double result = eval(x, y);
		System.out.println("result " + result);
	}

	public static double eval(double x, double y) {
		double recip = recip(x, y);

		if (smallest > recip) {
			smallest = recip;
			x = x + increment;
			if (x == 0) {
				return 0;
			}
			y = y(x);
			return eval(x, y);
		} else {
			x = x + increment;
			y = y(x);
			return eval(x, y);
		}

	}

	public static double y(double x) {

		double alpha = ((1 - 4 * x) / 9);
		if (alpha < 0) {
			System.out.println("ERROR");
		}
		return alpha;
	}

	public static double recip(double x2, double d) {
		double inverse = (1 / x2) + (1 / d);
		return inverse;
	}

}
