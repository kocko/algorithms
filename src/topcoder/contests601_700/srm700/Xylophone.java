package topcoder.contests601_700.srm700;

public class Xylophone {
	
	public int countKeys(int[] keys) {
		boolean[] used = new boolean[7];
		for (int i : keys) {
			used[i % 7] = true;
		}
		int count = 0;
		for (boolean b : used) {
			if (b) count++;
		}
		return count;
	}
}
