package topcoder.contests701_800.srm756;

public class CinderellaGirls {
	
	public int count(int[] talent, int[] skill) {
		int result = 0, n = talent.length;
		for (int girl = 0; girl < n; girl++) {
			boolean better = false;
			for (int i = 0; i < n; i++) {
				if (i != girl) {
					better |= talent[i] > talent[girl] && skill[i] > skill[girl];
				}
			}
			if (!better) result++;
		}
		return result;
	}
	
}
