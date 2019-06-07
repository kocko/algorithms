package topcoder.contests601_700.srm617;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Family {

  public String isFamily(int[] parent1, int[] parent2) {
    int n = parent1.length;
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      if (parent1[i] != -1) {
        graph.get(parent1[i]).add(parent2[i]);
        graph.get(parent2[i]).add(parent1[i]);
      }
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    boolean[] visited = new boolean[n];
    boolean possible = true;
    Integer[] color = new Integer[n];
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        queue.add(i);
        visited[i] = true;
        color[i] = 0;
        while (queue.size() > 0) {
          int u = queue.pollFirst();
          for (int v : graph.get(u)) {
            if (!visited[v]) {
              if (color[v] == null) {
                color[v] = color[u] ^ 1;
              } else {
                possible &= (color[v] ^ color[u]) == 1;
              }
              queue.add(v);
              visited[v] = true;
            } else {
              possible &= (color[v] ^ color[u]) == 1;
            }
          }
        }
      }
    }
    return possible ? "Possible" : "Impossible";
  }

}
