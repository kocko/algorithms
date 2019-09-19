package topcoder.contests701_800.srm767;

public class ArpaKonkoori {

  public long getA(long d, long s) {
    final long MAX_N = (long) 1e6;
    long result = -1;
    for (long minus = 1; minus <= MAX_N; minus++) {
      if (s % minus == 0) {
        long plus = s / minus;
        long a = (minus + plus) / 2L, b = plus - a;
        if (gcd(a, b) == d && a * a - b * b == s) {
          result = Math.max(result, a);
        }
      }
    }
    return result;
  }

  private long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

}
