package topcoder.contests300_400.srm314;

public class MooingCows {
	
	public int dissatisfaction(String[] farmland) {
		int max = Integer.MAX_VALUE;
		for (int i = 0; i < farmland.length; i++) {
			for (int j = 0; j < farmland[0].length(); j++) {
				if (farmland[i].charAt(j) == 'C') {
					int d = 0;
					for (int k = 0; k < farmland.length; k++) {
						for (int m = 0; m < farmland[0].length(); m++) {
							if (farmland[k].charAt(m) == 'C') {
								d += (i - k) * (i - k) + (j - m) * (j - m);
							}
						}
					}
					max = Math.min(d, max);
				}
			}
		}
		return max;
	}
	
}
