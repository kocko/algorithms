package topcoder.contests201_300.srm286;

public class ExtraBall {

  public double expectedPayout(int[] card, int[] balls, String[] patterns, int[] prizes) {
    double result = 0d;
    boolean[] drawn = new boolean[76];
    for (int ball : balls) {
      drawn[ball] = true;
    }
    final double possibility = (75. - balls.length);
    int n = patterns.length;
    for (int i = 0; i < n; i++) {
      String pattern = patterns[i];
      int misses = 0;
      for (int j = 0; j < pattern.length(); j++) {
        if (pattern.charAt(j) == 'X') {
          if (!drawn[card[j]]) {
            misses++;
          }
        }
      }
      if (misses == 1) {
        result += prizes[i];
      }
    }
    return result / (75. - balls.length);
  }

}