package topcoder.contests701_800.srm796;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChristmasBatteries {

  public int mostFun(int b, int n, int x, int y, int z, int m) {
    this.fun = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      fun.add(new ArrayList<>());
    }
    int result = 0;
    long X = (long) x;
    for (int i = 0; i < n; i++) {
      int idx = i % 5;
      int f = (int) (((X * i) % m * i) % m + y * i % m + z) % m;
      if (idx == 0) {
        result += f;
      } else {
        fun.get(idx).add(f);
      }
    }
    for (int i = 0; i < 5; i++) {
      fun.get(i).sort(Comparator.reverseOrder());
    }
    this.dp = new int[5][b + 1];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j <= b; j++) {
        dp[i][j] = -1;
      }
    }
    result += recurse(1, b);
    return result;
  }

  private List<List<Integer>> fun;

  private int[][] dp;

  private int recurse(int idx, int rem) {
    if (idx == 5) return 0;

    if (dp[idx][rem] != -1) return dp[idx][rem];

    int ans = recurse(idx + 1, rem);
    int sum = 0;
    for (int take = 1; take <= fun.get(idx).size(); take++) {
      sum += fun.get(idx).get(take - 1);
      if (rem >= take * idx) {
        ans = Math.max(ans, sum + recurse(idx + 1, rem - take * idx));
      }
    }

    return dp[idx][rem] = ans;
  }

}
