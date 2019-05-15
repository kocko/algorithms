package topcoder.contests601_700.srm602;

import static java.lang.Integer.max;

public class TypoCoderDiv1 {

  public int getmax(int[] D, int X) {
    this.d = D;
    this.n = d.length;
    dp = new Integer[n][2500];
    return recurse(0, X);
  }

  private int n;
  private int[] d;

  private Integer[][] dp;

  private Integer recurse(int idx, int rating) {
    if (idx >= n) return 0;

    if (dp[idx][rating] != null) return dp[idx][rating];

    int ans = recurse(idx + 1, max(0, rating - d[idx]));
    if (rating + d[idx] >= 2200) {
      if (idx + 1 < n) {
        if (rating + d[idx] - d[idx + 1] < 2200) {
          ans = max(ans, 2 + recurse(idx + 2, max(0, rating + d[idx] - d[idx + 1])));
        }
      } else {
        ans = max(ans, 1 + recurse(idx + 1, rating + d[idx]));
      }
    } else {
      ans = max(ans, recurse(idx + 1, rating + d[idx]));
    }
    return dp[idx][rating] = ans;
  }

}
