package projectX;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class HashMapInputDemo {
	public static void main(String args[]) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("a", new Integer(100));
		hm.put("b", new Integer(200));
		hm.put("c", new Integer(300));
		hm.put("d", new Integer(400));
		Set<Map.Entry<String, Integer>> st = hm.entrySet();

		if (hm.containsKey("a")) {
			for (Map.Entry<String, Integer> alpha : st) {
				if (alpha.getValue() == 200) {
					System.out.println(alpha.getKey());
					break;
				}
			}
			System.out.println("COMPLETION SUCCESSFUL");
		} else {
			System.out.println("VALUE NOT FOUND");
		}
	}
}