package topcoder.contests201_300.srm233;

import java.util.Arrays;

public class PipeCuts {

  public double probability(int[] x, int L) {
    Arrays.sort(x);
    int n = x.length, good = 0;
    double cuts = 0d;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (x[i] > L || (x[j] - x[i]) > L || (100 - x[j]) > L) {
          good++;
        }
        cuts++;
      }
    }
    return good / cuts;
  }

}
