package topcoder.contests601_700.srm696;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ropestring {
	
	public String makerope(String s) {
		char[] x = s.toCharArray();
		int n = x.length;
		List<Integer> even = new ArrayList<>(), odd = new ArrayList<>();
		int current = 0;
		for (char ch : x) {
			if (ch == '-') {
				current++;
			} else {
				if (current % 2 == 0 && current > 0) {
					even.add(current);
				} else if (current % 2 == 1) {
					odd.add(current);
				}
				current = 0;
			}
		}
		if (current % 2 == 0 && current > 0) {
			even.add(current);
		} else if (current % 2 == 1) {
			odd.add(current);
		}
 		String result = "";
		int count = 0;
		Collections.sort(even, Collections.reverseOrder()); 
		Collections.sort(odd, Collections.reverseOrder());
		for (Integer a : even) {
			for (int i = 0; i < a; i++) {
				result += '-';
				count++;
			}
			result += '.';
			count++;
		}
		for (Integer a : odd) {
			for (int i = 0; i < a; i++) {
				result += '-';
				count++;
			}
			result += '.';
			count++;
		}
		if (count >= n) {
			result = result.substring(0, n);
		}
		while (count <= n - 1) {
			result += '.';
			count++;
		}
		return result;
	}
}
