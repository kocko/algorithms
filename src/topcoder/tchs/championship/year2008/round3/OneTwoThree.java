package topcoder.tchs.championship.year2008.round3;

public class OneTwoThree {

    public int minimalNumber(int n) {
        boolean[] sieve = new boolean[n + 1];
        long result = 1, MOD = 987654321;
        for (long i = 2; i <= n; i++) {
            if (!sieve[(int) i]) {
                long p = i;
                while (p * i <= n) {
                    p *= i;
                }
                result *= p;
                result %= MOD;
                for (long j = i * i; j <= n; j += i) {
                    sieve[(int) j] = true;
                }
            }
        }
        return (int) (result % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new OneTwoThree().minimalNumber(10));
    }
}
