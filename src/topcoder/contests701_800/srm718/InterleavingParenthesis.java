package topcoder.contests701_800.srm718;

public class InterleavingParenthesis {

  public int countWays(String s1, String s2) {
    x = s1.toCharArray();
    y = s2.toCharArray();
    n = x.length;
    m = y.length;
    prefix_x = new int[n];
    for (int i = 0; i < n; i++) {
      prefix_x[i] = x[i] == '(' ? 1 : -1;
      if (i > 0) {
        prefix_x[i] += prefix_x[i - 1];
      }
    }
    prefix_y = new int[m];
    for (int i = 0; i < m; i++) {
      prefix_y[i] = y[i] == '(' ? 1 : -1;
      if (i > 0) {
        prefix_y[i] += prefix_y[i - 1];
      }
    }
    if (prefix_x[n - 1] + prefix_y[m - 1] != 0) {
      return 0;
    }
    dp = new long[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        dp[i][j] = -1;
      }
    }
    return (int) recurse(0, 0);
  }

  private final long MOD = (int) 1e9 + 7;
  private int n, m;
  private char[] x, y;
  private int[] prefix_x, prefix_y;
  private long[][] dp;

  private long recurse(int i, int j) {
    if (i == n && j == m) return 1;

    if (dp[i][j] != -1) return dp[i][j];

    int balance = 0;
    balance += i >= 1 ? prefix_x[i - 1] : 0;
    balance += j >= 1 ? prefix_y[j - 1] : 0;

    long result = 0;
    if (i < n) {
      if (x[i] == '(') {
        result += recurse(i + 1, j);
        result %= MOD;
      } else if (balance >= 1) {
        result += recurse(i + 1, j);
        result %= MOD;
      }
    }
    if (j < m) {
      if (y[j] == '(') {
        result += recurse(i, j + 1);
        result %= MOD;
      } else if (balance >= 1) {
        result += recurse(i, j + 1);
        result %= MOD;
      }
    }

    return dp[i][j] = result;
  }

}
