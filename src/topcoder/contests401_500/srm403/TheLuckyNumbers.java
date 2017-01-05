package topcoder.contests401_500.srm403;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheLuckyNumbers {
	
	private List<Integer> set = new ArrayList<>();
	
	public int count(int a, int b) {
		recurse("");
		Collections.sort(set);
		int count = 0;
		for (int i = 0; i < set.size(); i++) {
			int next = set.get(i);
			if (next >= a && next <= b) {
				count++;
			}
		}
		return count;
	}
	
	private void recurse(String s) {
		if (s.length() < 9) {
			set.add(Integer.parseInt(s + "4"));
			recurse(s + "4");
			set.add(Integer.parseInt(s + "7"));
			recurse(s + "7");
		}
	}
}
