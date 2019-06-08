package topcoder.contests601_700.srm613;

import java.util.Arrays;

public class TaroFriends {

  public int getNumber(int[] coordinates, int X) {
    Arrays.sort(coordinates);
    int n = coordinates.length;
    int result = coordinates[n - 1] - coordinates[0];
    int[] a = new int[n];
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j <= i; j++) {
        a[j] = coordinates[j] + X;
      }
      for (int j = i + 1; j < n; j++) {
        a[j] = coordinates[j] - X;
      }
      Arrays.sort(a);
      result = Math.min(result, a[n - 1] - a[0]);
    }
    return result;
  }

}
