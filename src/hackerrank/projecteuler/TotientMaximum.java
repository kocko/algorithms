package hackerrank.projecteuler;

public class TotientMaximum {

	public static void main(String[] args) {
		double score = 0.0;
		int n = 1;
		for (int i = 1; i <= 100000; i++) {
			int totient = phi(i);
			double candidate = (double) i / totient;
			if (candidate >= score) {
				score = candidate;
				n = i;
			}
		}
		System.out.println(n);
	}

	static int phi(int n) {
		if (n == 1) return 1;
		
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (gcd(n, i) == 1) {
				count++;
			}
		}
		return count;
	}
	
	static int gcd(int n, int k) {
		if (k == 0) {
			return n;
		} else return gcd(k, n % k);
	}

}
