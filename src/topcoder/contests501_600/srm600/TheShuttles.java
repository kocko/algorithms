package topcoder.contests501_600.srm600;

public class TheShuttles {
	
	public int getLeastCost(int[] cnt, int baseCost, int seatCost) {
		int n = cnt.length;
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= 100; i++) {
			int temp = 0;
			for (int a : cnt) {
				int x = (a + i - 1) / i;
				temp += x * (baseCost + i * seatCost);
			}
			result = Math.min(temp, result);
		}
		return result;
	}
	
}
