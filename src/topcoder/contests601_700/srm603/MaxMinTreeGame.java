package topcoder.contests601_700.srm603;

public class MaxMinTreeGame {

  public int findend(int[] edges, int[] costs) {
    int n = costs.length;
    int[] degree = new int[n];
    for (int i = 1; i <= edges.length; i++) {
      degree[edges[i - 1]]++;
      degree[i]++;
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (degree[i] == 1) {
        result = Math.max(costs[i], result);
      }
    }
    return result;
  }

}
