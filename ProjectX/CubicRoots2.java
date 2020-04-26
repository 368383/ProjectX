package projectX;

import java.util.Scanner;

public class CubicRoots2 {
	public static double precision = 0;
	public static int threeCo = 1;
	public static double twoCo = 3 * Math.PI;
	public static double oneCo = 3 * Math.pow(Math.PI, 2);
	public static double constant = Math.pow(Math.PI, 3);
	public static int Maxlayers = 25;
	public static int currentLayer = 0;;
	public static boolean solved = false;

	public static void main(String[] args) {
		double lowerVal = -100000;
		double upperVal = 100000;
		double result = calculation(lowerVal, upperVal);
		if (solved) {
			System.out.println("Answer is:" + result);
		} else {
			System.out.println("Cannot solve.");
		}
		System.out.println("Pi is:"+Math.PI);
	}

	public static double evaluate(double input) {
		return threeCo * Math.pow(input, 3) + twoCo * Math.pow(input, 2) + oneCo * input + constant;
	}

	public static double calculation(double lowerVal, double upperVal) {
		currentLayer++;
		if (currentLayer >= Maxlayers) {
			solved = false;
			return 0;
		}

		System.out.println("low:" + lowerVal + "\tup:" + upperVal);
		double lowerResult = evaluate(lowerVal);
		double upperResult = evaluate(upperVal);
		if (Math.abs(lowerResult) <= precision) {
			solved = true;
			return lowerVal;
		}
		if (Math.abs(upperResult) <= precision) {
			solved = true;
			return upperVal;
		}

		if (lowerResult * upperResult > 0) {
			solved = false;
			return 0;
		}

		double pace = (upperVal - lowerVal) / 10;

		for (int i = 0; i < 10; i++) {

			lowerResult = evaluate(lowerVal + i * pace);
			upperResult = evaluate(lowerVal + (i + 1) * pace);

			if (Math.abs(lowerResult) <= precision) {
				solved = true;
				return lowerVal + i * pace;
			}
			if (Math.abs(upperResult) <= precision) {
				solved = true;
				return lowerVal + (i + 1) * pace;
			}
			if (lowerResult * upperResult < 0) {
				return calculation(lowerVal + i * pace, lowerVal + (i + 1) * pace);
			}
		}
		solved = false;
		return 0;
	}

	public static int input() {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt();
		return value;
	}

	public static void assignCo() {
		System.out.println("X^3");
		threeCo = input();
		System.out.println("X^2");
		twoCo = input();
		System.out.println("X");
		oneCo = input();
		System.out.println("Constant");
		constant = input();
	}
}
