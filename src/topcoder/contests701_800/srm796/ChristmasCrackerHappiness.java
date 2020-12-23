package topcoder.contests701_800.srm796;

public class ChristmasCrackerHappiness {

  public int solve(int n, int[] winner, int[] loser) {
    boolean[] happy = new boolean[n];
    for (int w : winner) {
      happy[w] = true;
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      if (happy[i]) {
        cnt++;
      }
    }
    return (cnt >= n - 1) ? 0 : (n - 1 - cnt);
  }

}
