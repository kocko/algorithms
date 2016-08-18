package topcoder.contests501_600.srm596;

import static java.lang.Math.min;

public class ColorfulRoad {
	
	private char[] road;
	private int min = Integer.MAX_VALUE;
	private int n;
	private boolean ok;
	
	public int getMin(String road) {
		this.n = road.length();
		this.road = road.toCharArray();
		recurse(0, 0, 'G');
		return ok ? min : -1;
	}
	
	private void recurse(int index, int score, char aim) {
		if (index == n - 1) {
			ok = true;
			min = min(min, score);
		} else {
			for (int i = index + 1; i < n; i++) {
				if (road[i] == aim) {
					int dist = (i - index) * (i - index);
					if (aim == 'R') {
						recurse(i, score + dist, 'G');
					} else if (aim == 'G') {
						recurse(i, score + dist, 'B');
					} else if (aim == 'B') {
						recurse(i, score + dist, 'R');
					}
				}
			}
		}
	}
}
