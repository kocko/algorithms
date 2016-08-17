package topcoder.contests300_400.srm316;

import java.util.ArrayList;
import java.util.List;

public class InboxCleanup {
	
	public int fewestClicks(String messages, int low, int high) {
		int result = Integer.MAX_VALUE, n = messages.length();
		for (int i = low; i <= high; i++) {
			int start = 0, end = start + i;
			List<String> pages = new ArrayList<>();
			while (true) {
				if (start > n) break;
				String add;
				if (end < n) {
					add = messages.substring(start, end);
				} else {
					add = messages.substring(start);
				}
				if (!"".equals(add)) {
					pages.add(add);
				}
				start = end;
				end = start + i;
			}
			int total = 0;
			for (String page : pages) {
				total += getMinProcessingClicks(page);
			}
			total += pages.size() - 1;
			result = Math.min(total, result);
		}
		return result;
	}
	
	private int getMinProcessingClicks(String x) {
		int n = x.length(), d = 0;
		for (char c : x.toCharArray()) {
			if (c == 'D') d++;
		}
		if (d == 0) return 0;
		return Math.min(2 + n - d, d + 1);
	}
	
}
