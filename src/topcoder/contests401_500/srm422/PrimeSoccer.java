package topcoder.contests401_500.srm422;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrimeSoccer {

  public double getProbability(int a, int b) {
    this.a = a;
    this.b = b;
    this.dp = new Double[18][18][18];
    return recurse(0, 0, 0);
  }

  private int a, b;
  private Double[][][] dp;

  private double recurse(int idx, int first, int second) {
    if (idx == 18) return (primes.contains(first) || primes.contains(second)) ? 1 : 0;

    if (dp[idx][first][second] != null) return dp[idx][first][second];

    double result = 0;
    result += (100 - a) * (100 - b) * recurse(idx + 1, first, second);
    result += a * (100 - b) * recurse(idx + 1, first + 1, second);
    result += (100 - a) * b * recurse(idx + 1, first, second + 1);
    result += a * b * recurse(idx + 1, first + 1, second + 1);
    result /= 10000d;

    return dp[idx][first][second] = result;
  }

  private Set<Integer> primes = new HashSet<Integer>() {{
    addAll(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));
  }};

}


