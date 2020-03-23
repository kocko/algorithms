package uva.volume003;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.min;

public class Network implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while ((n = Integer.parseInt(in.nextLine())) != 0) {
      reset();
      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
      }
      String[] split;
      while ((split = in.nextLine().split("\\s+")).length > 1) {
        int u = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length; i++) {
          int v = Integer.parseInt(split[i]);
          graph.get(u).add(v);
          graph.get(v).add(u);
        }
      }
      dfs(1, 0);
      int result = 0;
      for (int i = 1; i <= n; i++) {
        if (articulationPoint[i]) {
          result++;
        }
      }
      out.println(result);
    }
  }

  private int n;
  private int[] low, level;
  private boolean[] articulationPoint;
  private List<List<Integer>> graph;

  private void reset() {
    graph = new ArrayList<>();
    level = new int[n + 1];
    low = new int[n + 1];
    Arrays.fill(low, Integer.MAX_VALUE);
    articulationPoint = new boolean[n + 1];
  }

  private void dfs(int v, int p) {
    level[v] = low[v] = level[p] + 1;
    int children = 0;
    for (int to : graph.get(v)) {
      if (to == p) continue;
      if (level[to] != 0) {
        low[v] = min(low[v], level[to]);
      } else {
        dfs(to, v);
        low[v] = min(low[v], low[to]);
        if (low[to] >= level[v] && p != 0) {
          articulationPoint[v] = true;
        }
        ++children;
      }
    }
    if (p == 0 && children > 1) {
      articulationPoint[v] = true;
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (Network instance = new Network()) {
      instance.solve();
    }
  }
}
