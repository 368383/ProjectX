package comboSplit;

import java.util.ArrayList;

public class Pairs {
	private ArrayList<Integer> first;
	private ArrayList<Integer> second;
	private ArrayList<Integer> officialOne;
	private ArrayList<Integer> officialTwo;

	public Pairs(ArrayList<Integer> first, ArrayList<Integer> second) {
		this.first = (ArrayList<Integer>) first.clone();
		this.second = (ArrayList<Integer>) second.clone();
	}

	public Pairs(ArrayList<Integer> first, ArrayList<Integer> second, boolean alpha) {
		this.officialOne = (ArrayList<Integer>) first.clone();
		this.officialTwo = (ArrayList<Integer>) second.clone();
	}

	public String toString() {
		return first.toString() + second.toString();
	}
	
	public String toStringActual() {
		return officialOne.toString() + officialTwo.toString();
	}

	public void print() {
		System.out.println();
		System.out.print("FIRST PAIR");
		for (Integer currentValue : first) {
			System.out.print(" " + currentValue);
		}
		System.out.print("SECOND PAIR");
		for (Integer currentValue : second) {
			System.out.print(" " + currentValue);
		}
	}
}
