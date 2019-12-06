package topcoder.contests401_500.srm458;

import java.util.Arrays;

public class BouncingBalls {

  public double expectedBounces(int[] x, int T) {
    double result = 0;
    Arrays.sort(x);
    for (int i = 0; i < x.length; i++) {
      for (int j = i + 1; j < x.length; j++) {
        if (x[i] + T >= x[j] - T) {
          result += 0.25;
        }
      }
    }
    return result;
  }

}
