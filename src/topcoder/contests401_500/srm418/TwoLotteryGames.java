package topcoder.contests401_500.srm418;

import java.util.ArrayList;
import java.util.List;

public class TwoLotteryGames {

  public double getHigherChanceGame(int n, int m, int k) {
    this.n = n;
    this.m = m;
    this.k = k;
    this.entry = new int[m];
    recurse(0, 1);
    double probability = 0d;
    for (List<Integer> list : choose) {
      probability += match(list);
    }
    return probability;
  }

  private int n, m, k;
  private List<List<Integer>> choose = new ArrayList<>();
  private int[] entry;

  private void recurse(int idx, int current) {
    if (idx == m) {
      List<Integer> result = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        result.add(entry[i]);
      }
      choose.add(result);
      return;
    }
    if (current <= n) {
      if (idx < n) {
        entry[idx] = current;
        recurse(idx + 1, current + 1);
      }
      recurse(idx, current + 1);
    }
  }

  private double match(List<Integer> list) {
    double result = 0d;
    for (List<Integer> select : choose) {
      if (common(select, list) >= k) {
        result++;
      }
    }
    int d = choose.size() * choose.size();
    return result / d;
  }

  private int common(List<Integer> first, List<Integer> second) {
    boolean[] has = new boolean[9];
    for (int value : first) {
      has[value] = true;
    }
    int result = 0;
    for (int value : second) {
      if (has[value]) {
        result++;
      }
    }
    return result;
  }

}
