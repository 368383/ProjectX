package projectX;

public class UtilitySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] given = { 65, 3, 14, 9, 2, 25, 12, 3, 4, 4, 3 };
		for (int testValue = 0; testValue < given.length; testValue++) {
			for (int i = 0; i < given.length; i++) {
				if (given[testValue] >= given[i]) {
				} else {
					int holder = given[i];
					given[i] = given[testValue];
					given[testValue] = holder;
				}
			}
		}

		printIndex(given);

	}

	private static void printIndex(int[] given) {
		for (int currentIndex : given) {
			System.out.println(currentIndex);
		}
	}

}
