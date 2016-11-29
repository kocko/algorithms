package codeforces.contests501_600.problemset584;

import java.math.BigInteger;
import java.util.Scanner;

public class OlesyaAndRodion {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		sc.close();
		BigInteger good = findSatisfactoryNumber(n, t);
		System.out.println(good.toString());
	}

	static BigInteger findSatisfactoryNumber(int n, int t) {
		char[] digits = new char[n];
		if (n > 1) {
			digits[0] = '1';
			for (int i = 1; i < n; i++) {
				digits[i] = '0';
			}
		} else {
			if (t == 10)
				return BigInteger.valueOf(-1);
			return BigInteger.valueOf(t);
		}
		BigInteger result = new BigInteger(new String(digits));
		int rem = result.mod(BigInteger.valueOf(t)).intValue();
		int diff = t - rem;
		result = result.add(BigInteger.valueOf(diff));
		return result;
	}
}
