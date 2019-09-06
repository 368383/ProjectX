
public class numberTest {
	public static void main(String[] args) {
		System.out.println(function(1, 2, 3) == 6);
	}

	public static double function(int a, int b, int c) {
		double value = (double) (a * b * c);
		return value;
	}
}
