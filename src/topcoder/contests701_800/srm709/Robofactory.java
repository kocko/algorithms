package topcoder.contests701_800.srm709;

import java.util.ArrayList;
import java.util.List;

public class Robofactory {
	
	public int reveal(int[] query, String[] answer) {
		int prev = 0, n = query.length;
		if (n == 1) return 0;
		List<Integer> possible = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (prev % 2 == 1) {
				if ((query[i] % 2 == 1 && "Even".equals(answer[i])) || (query[i] % 2 == 0 && "Odd".equals(answer[i]))) {
					return i;
				}
			} else {
				possible.add(i);
			}
			prev = query[i];
		}
		return possible.size() == 1 ? possible.get(0) : -1;
	}
	
}
