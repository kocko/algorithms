package topcoder.contests601_700.srm601;

public class WinterAndPresents {

  public long getNumber(int[] apple, int[] orange) {
    long result = 0;
    int max = Integer.MAX_VALUE, n = apple.length;
    for (int i = 0; i < n; i++) {
      max = Math.min(max, apple[i] + orange[i]);
    }
    for (int X = 1; X <= max; X++) {
      int maxApple = 0, maxOrange = 0;
      for (int i = 0; i < n; i++) {
        maxApple += Math.min(X, apple[i]);
        maxOrange += Math.min(X, orange[i]);
      }
      int total = X * n;
      int minApple = total - maxOrange;
      result += maxApple - minApple + 1;
    }
    return result;
  }

}
