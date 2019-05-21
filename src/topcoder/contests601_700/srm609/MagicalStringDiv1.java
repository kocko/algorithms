package topcoder.contests601_700.srm609;

import static java.lang.Integer.min;

public class MagicalStringDiv1 {

  public int getLongest(String S) {
    char[] x = S.toCharArray();
    int n = x.length;
    int[] open = new int[n], close = new int[n];
    for (int i = 0; i < n; i++) {
      if (x[i] == '<') {
        open[i] = 1;
      } else {
        close[i] = 1;
      }
    }
    for (int i = 1; i < n; i++) {
      open[i] += open[i - 1];
      close[i] += close[i - 1];
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (x[i] == '>') {
        int o = close[i], c = open[n - 1] - open[i], length = min(o, c);
        if (length > result) {
          result = length;
        }
      }
    }
    return 2 * result;
  }

}
