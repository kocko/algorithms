package topcoder.contests401_500.srm402;

import java.util.TreeMap;

public class RandomSort {

  private TreeMap<int[], Double> dp = new TreeMap<>((x, y) -> {
    for (int i = 0; i < x.length; i++) {
      if (x[i] != y[i]) return x[i] - y[i];
    }
    return 0;
  });

  public double getExpected(int[] permutation) {
    if (dp.containsKey(permutation)) return dp.get(permutation);

    double result = 0;
    int count = 0;
    for (int i = 0; i < permutation.length; i++) {
      for (int j = i + 1; j < permutation.length; j++) {
        if (permutation[i] > permutation[j]) {
          count++;
          int[] copy = permutation.clone();
          int tmp = copy[i];
          copy[i] = copy[j];
          copy[j] = tmp;
          result += 1 + getExpected(copy);
        }
      }
    }
    if (count > 0) {
      result /= count;
    }
    dp.put(permutation, result);
    return result;
  }

}
