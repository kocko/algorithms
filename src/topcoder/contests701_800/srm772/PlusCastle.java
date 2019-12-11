package topcoder.contests701_800.srm772;

public class PlusCastle {
	
	public int maximiseClosedFigures(int k) {
		if (k < 4) return 0;
		int sqrt = (int) Math.sqrt(k);
		int rem = k - sqrt * sqrt;
		int result = (sqrt - 1) * (sqrt - 1);
		for (int i = 0; i < 2; i++) {
			if (rem < 0) break;
			int side = 0;
			while (side < sqrt) {
				if (side == 0) {
					if (rem >= 2) {
						rem -= 2;
						result++;
						side += 2;
					} else break;
				} else {
					if (rem > 0) {
						rem--;
						result++;
						side++;
					} else break;
				}
			}
		}
		return result;
	}
}
