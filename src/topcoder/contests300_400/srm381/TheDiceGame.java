package topcoder.contests300_400.srm381;

public class TheDiceGame {

  public double expectedThrows(int candies) {
    double[] dp = new double[candies + 1];
    dp[0] = 0d;
    for (int i = 1; i <= candies; i++) {
      dp[i] = 6;
      for (int j = i - 1; j >= Math.max(0, i - 6); j--) {
        dp[i] += dp[j];
      }
      dp[i] /= 6.0;
    }
    return dp[candies];
  }

}
