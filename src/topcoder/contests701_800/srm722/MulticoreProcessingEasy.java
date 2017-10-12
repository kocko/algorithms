package topcoder.contests701_800.srm722;

public class MulticoreProcessingEasy {
	
	public int fastestTime(int job, int penalty, int[] s, int[] c) {
		int min = Integer.MAX_VALUE, n = s.length;
		for (int i = 0; i < n; i++) {
			int speed = s[i];
			for (int cores = 1; cores <= c[i]; cores++) {
				int partition = (int) Math.ceil(((double) job / cores));
				int time = (partition / speed) + (partition % speed != 0 ? 1 : 0);
				int total = time + (cores - 1) * penalty;
				min = Math.min(total, min);
			}
		}
		return min;
	}
}
