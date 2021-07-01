package topcoder.contests501_600.srm502;

public class TheCowDivTwo {

  public int find(int N, int K) {
    final Long MOD = (long) 1e9 + 7;
    long[][] dp = new long[K + 1][N];
    dp[0][0] = 1;
    for (int i = 0; i < N; i++) {
      for (int j = K - 1; j >= 0; j--) {
        for (int rem = N - 1; rem >= 0; rem--) {
          int next = (rem + i) % N;
          dp[j + 1][next] += dp[j][rem];
          dp[j + 1][next] %= MOD;
        }
      }
    }
    return (int) dp[K][0];
  }

}
