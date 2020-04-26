package projectX;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import utility.Util;

class HashMapDemo {
	public static void main(String args[]) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		String alpha;
		while (true) {
			alpha = Util.getUserStringInput("input string");
			if (alpha.contains("STOP")) {
				Util.programCompletion();
				break;
			}
			int beta = Util.getUserIntInput("input int");
			hm.put(alpha, new Integer(beta));

		}

		Set<Map.Entry<String, Integer>> st = hm.entrySet();

		for (Map.Entry<String, Integer> beta : st) {
			System.out.println(beta.toString());
		}

		System.out.println("COMPLETION SUCCESSFUL");

	}
}