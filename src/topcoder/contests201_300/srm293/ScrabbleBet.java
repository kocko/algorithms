package topcoder.contests201_300.srm293;

public class ScrabbleBet {

  public double estimate(int trials, int games, int winsNeeded, int winChance) {
    this.games = games;
    this.winsNeeded = winsNeeded;
    this.winChance = winChance;
    this.dp = new Double[games][games];

    double opponentWins = recurse(0, 0);
    double overall = 1.;
    for (int i = 0; i < trials; i++) {
      overall *= opponentWins;
    }
    return 1 - overall;
  }

  private int games, winsNeeded, winChance;
  private Double[][] dp;

  private Double recurse(int idx, int wins) {
    if (idx == games) return wins < winsNeeded ? 1. : 0;

    if (dp[idx][wins] != null) return dp[idx][wins];

    double ans = winChance * recurse(idx + 1, wins + 1) + (100 - winChance) * recurse(idx + 1, wins);
    ans /= 100.;
    return dp[idx][wins] = ans;
  }

}
