package projectX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CubicRoots {
	public static int threeCo = 1000;
	public static int twoCo = -50;
	public static int oneCo = 10;
	public static int constant = -2;

//
//	public static void calculation() {
//		double lowerVal = -1000;
//		double nearApprox = 0;
//		double upperVal = 1000;
//		double increment = 0.1;
//		while (true) {
//			nearApprox = threeCo * Math.pow(lowerVal, 3) + twoCo * Math.pow(lowerVal, 2) + oneCo * lowerVal + constant;
//			if ((int) Math.abs(nearApprox) <= increment * 20) {
//				increment = increment / 10;
//			}
//			if (lowerVal >= upperVal || increment == 0) {
//				System.out.println("________________________");
//				System.out.println("FINAL ANSWER " + lowerVal);
//				break;
//			}
//			lowerVal = lowerVal + increment;
//		}
//	}
	public static double lowerVal = -1000;
	public static double nearApprox = 0;
	public static double upperVal = 1000;
	public static double increment = 0.1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// assignCo();
		// calculation();
		recursionCalc(increment, lowerVal);
	}

	public static double recursionCalc(double increment, double lowerVal) {

		nearApprox = threeCo * Math.pow(lowerVal, 3) + twoCo * Math.pow(lowerVal, 2) + oneCo * lowerVal + constant;
		if ((int) Math.abs(nearApprox) <= increment * 20) {
			increment = increment / 10;
		}
		if (lowerVal >= upperVal || increment == 0) {
			System.out.println("________________________");
			System.out.println("FINAL ANSWER " + lowerVal);
			return increment;
		}
		lowerVal = lowerVal + increment;

		return recursionCalc(increment, lowerVal);

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
