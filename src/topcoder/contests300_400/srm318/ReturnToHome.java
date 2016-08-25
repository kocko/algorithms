package topcoder.contests300_400.srm318;

public class ReturnToHome {
	
	public double goHome(int x, int y, int d, int t) {
		double dist = Math.sqrt(x * x + y * y);
		double res = Math.min(dist, Math.floor(dist / d) * t + dist - Math.floor(dist / d) * d);
		if (d > dist) {
			res = Math.min(res, 2 * t);
		} else {
			res = Math.min(res, Math.ceil(dist / d) * t);
		}
		return Math.min(res, Math.ceil(dist / d) * t - dist + Math.ceil(dist /d) * d); 
	}
	
}
