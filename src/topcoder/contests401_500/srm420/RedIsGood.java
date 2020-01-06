package topcoder.contests401_500.srm420;

public class RedIsGood {

  public double getProfit(int red, int black) {
    dp = new Double[red + 1][black + 1];
    return recurse(red, black);
  }

  private Double[][] dp;

  private Double recurse(int red, int black) {
    if (red == 0) return 0d;
    if (black == 0) return (double) red;

    if (dp[red][black] != null) return dp[red][black];

    double prob = (double) red / (red + black);
    double ans = prob * (1 + recurse(red - 1, black));

    ans += (1 - prob) * (-1 + recurse(red, black - 1));

    if (ans < 0) {
      ans = 0;
    }
    return dp[red][black] = ans;
  }

}
