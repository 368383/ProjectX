package comboSplit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ComboSplit {
	private static ArrayList<Integer> dataList = new ArrayList<>();
	private static ArrayList<Integer> first = new ArrayList<Integer>();
	private static ArrayList<Integer> second = new ArrayList<Integer>();
	private static ArrayList<Integer> firstRandomSet = new ArrayList<Integer>();
	private static ArrayList<Integer> secondRandomSet = new ArrayList<Integer>();
	private static ArrayList<Pairs> all = new ArrayList<Pairs>();
	private static ArrayList<Pairs> work = new ArrayList<Pairs>();

	private static long cycles = 0;
	private static int iterations = 1;

	public static void main(String args[]) {

		int[] dataSet = { 0, 1, 3, 5, 5, 4 };
		cycles = initializeTotal(dataSet);
		long cycleTotalCycleCount = cycles;
		System.out.println(cycles);
		int count = -1;
		long startTime = System.nanoTime();

		while (cycles > 0) {
			firstRandomSet.clear();
			secondRandomSet.clear();
			first.clear();
			second.clear();

			System.out.println(" TOTAL CYCLE COUNT " + cycleTotalCycleCount + "| CYCLE COUNT " + cycles);
			toArrayList(dataSet);
			if (!split()) {
				continue;
			}
			cycles--;
		}
		long endTime = System.nanoTime();
		long durationInNano = (endTime - startTime);
		System.out.println("Completion Time " + (durationInNano / (1000000000)) + " Elements Found: " + work.size());
		System.out.println("SYSTEM IS READY TO PRINT OUT THOSE THAT WORKED. PRESS Y TO CONTINUE");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		int i = 0;
		if (userInput.toUpperCase().equals("Y")) {
			for (Pairs currentPair : work) {
				if (i == 3) {
					System.out.println();
				}
				System.out.print(currentPair.toStringActual() + " ");
				i++;
			}
		}
		System.out.println();
		System.out.println("PROGRAM FINISHED");

	}

	private static void toArrayList(int[] array) {
		dataList.clear();
		for (Integer currentValue : array) {
			dataList.add(currentValue);
		}
	}

	private static long initializeTotal(int[] array) {
		System.out.println("ArrayLength " + array.length);
		long totalPossibilities = 0;
		for (int index = 1; index <= array.length / 2; index++) {
			totalPossibilities = totalPossibilities + factorial(array.length);
			System.out.println("total possibilties " + totalPossibilities);
		}
		return totalPossibilities;
	}

	private static int factorial(int value) {
		int total = 1;
		for (int index = 1; index <= value; index++) {
			total = total * index;
		}
		return total;
	}

	private static int placeFactorial(int base, int cycles) {
		int total = 1;
		for (int index = 0; index < cycles; index++) {
			total = total * base;
			base--;
		}
		return total;
	}

	private static boolean split() {
		// System.out.println("CYCLE______________________________________");
		int sumFirst = 0;
		int sumSecond = 0;
		if (iterations == 4) {
			iterations = 1;
		}
		for (int cycleCount = 0; cycleCount < iterations; cycleCount++) {
			int firstRandom = getFirstRandom();
			sumFirst = sumFirst + addToArrayList(first, firstRandom);
		}
		// System.out.println("DATALIST SIZE " + dataList.size() + " Iteration Count " +
		// iterations);

		iterations++;
		while (dataList.size() > 0) {
			int secondRandom = getSecondRandom();
			sumSecond = sumSecond + addToArrayList(second, secondRandom);
		}

		Pairs currentSet = new Pairs(firstRandomSet, secondRandomSet);

		for (Pairs currentPair : all) {
			if (currentPair.toString().equals(currentSet.toString())) {
//				System.out.println("SET REPEAT DETECTED");
//				System.out.println(currentPair.toString());
//				System.out.println(currentSet.toString());
				return false;
			}
		}
		all.add(currentSet);

		if (checkSum(sumFirst, sumSecond)) {
//			System.out.println("SUM " + sumFirst + " " + sumSecond);
//			System.out.println("THE FOLLOWING SET WORKS");
//			System.out.println(first.toString());
//			System.out.println(second.toString());
			Pairs workingSet = new Pairs(first, second, true);
			work.add(workingSet);
		} else {
//			System.out.println("SUM " + sumFirst + " " + sumSecond);
//			System.out.println("THE FOLLOWING DOES NOT WORK");
//			System.out.println(first.toString());
//			System.out.println(second.toString());
		}
		return true;
	}

	private static int addToArrayList(ArrayList<Integer> set, int randomValue) {
		int valueToBeAdded = dataList.remove(randomValue);
		set.add(valueToBeAdded);
		return valueToBeAdded;
	}

	private static int getSecondRandom() {
		int secondRandom = (int) (Math.random() * dataList.size());
		secondRandomSet.add(secondRandom);
		return secondRandom;
	}

	private static int getFirstRandom() {
		int firstRandom = (int) (Math.random() * dataList.size());
		firstRandomSet.add(firstRandom);
		return firstRandom;
	}

	private static boolean checkSum(int first, int second) {
		if (first == second) {
			return true;
		}
		return false;
	}

}
