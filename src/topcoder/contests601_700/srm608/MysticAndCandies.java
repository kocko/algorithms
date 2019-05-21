package topcoder.contests601_700.srm608;

import static java.util.Arrays.sort;

public class MysticAndCandies {

  public int minBoxes(int c, int x, int[] low, int[] high) {
    int n = low.length;
    sort(low);
    int need = x, taken = 0;
    for (int i = n - 1; i >= 0; i--) {
      need -= low[i];
      taken++;
      if (need <= 0) {
        break;
      }
    }
    int result = taken;
    sort(high);
    need = c - x;
    taken = n;
    for (int i = 0; i < n; i++) {
      need -= high[i];
      taken--;
      if (need < 0) {
        ++taken;
        break;
      }
    }
    return Math.min(result, taken);
  }
  
}
