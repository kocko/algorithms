package topcoder.contests701_800.srm796;

public class ChristmasLightsFixing {

  public int[] fixingTime(int n, long step) {
    init();
    long has = 0;
    int take = 1;
    while (true) {
      if (has + binom[n][take] < step) {
        has += binom[n][take];
        take++;
      } else break;
    }
    int start = 0;
    int[] result = new int[take];
    for (int i = 0; i < take; i++) {
      for (int pos = start; pos < n; pos++) {
        int positions = n - pos - 1, bits = take - i - 1;
        long ways = binom[positions][bits];
        if (has + ways < step) {
          has += ways;
        } else {
          result[i] = pos;
          start = pos + 1;
          break;
        }
      }
    }
    return result;
  }

  private long[][] binom;

  private void init() {
    int MAX_N = 50;
    binom = new long[MAX_N + 1][MAX_N + 1];
    for (int i = 0; i <= MAX_N; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          binom[i][j] = 1L;
        } else {
          binom[i][j] = binom[i - 1][j] + binom[i - 1][j - 1];
        }
      }
    }
  }

}
