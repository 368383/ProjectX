import java.util.ArrayList;
import java.util.Collections;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = new int[99];
		for (int number = 0; number < list.length; number++) {
			list[number] = number * 0;
		}
		//list = generateRandomNumbers(100, 50, 70);
		print(list);
		search(list, 0);
	}

	public static void search(int[] source, int target) {
		int counter = 0;
		int roof = source.length - 1;
		int floor = 0;
		while (true) {
			if (target < source[0] || target > source[source.length - 1]) {
				System.out.println("OUT OF BOUNDS");
				break;
			}
			int difference = (roof - floor) / 2;
//			System.out.println("FLOOR NUMBER: "+floor+"\tROOF NUMBER: "+roof+"\tDIFFERENCE: "+difference);
//			System.out.println("FLOOR VALUE: "+source[floor]+"\tROOF VALUE: "+source[roof]);

			if (target < source[floor + difference]) {
				roof = floor + difference;
			}
			if (target >= source[floor + difference]) {
				floor = floor + difference;

				if (target < source[roof] && target > source[roof - 1]) {
					System.out.println("CANNOT BE FOUND");
					break;
				}
				if (source[roof] == target || source[floor] == target) {
					// System.out.println("ROOF VALUE: " + source[roof] + "\tFLOOR VALUE: " +
					// source[floor]);
					System.out.println("FOUND AT INDEX " + floor + " | ACTUAL VALUE " + source[floor]);
					break;
				}
			}
			counter++;

		}
		System.out.println("SEARCH CYLES: " + counter);
	}

	public static void print(int[] source) {
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i] + "\t");
			if (i != 0 && i % 12 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static int[] generateRandomNumbers(int size, int base, int max) {
		ArrayList<Integer> random = new ArrayList<Integer>();
		for (int round = 0; round < size; round++) {
			random.add((int) (Math.random() * (max - base) + base));
		}
		Collections.sort(random);
		Integer[] randomList = random.toArray(new Integer[random.size()]);
		return convert(randomList);
	}

	public static int[] convert(Integer[] bigI) {
		int[] value = new int[bigI.length];
		for (int i = 0; i < bigI.length; i++) {
			value[i] = bigI[i];
		}
		return value;
	}

}
