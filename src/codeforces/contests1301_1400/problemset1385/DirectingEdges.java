package codeforces.contests1301_1400.problemset1385;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DirectingEdges implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      graph = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
      }
      int[] degree = new int[n];
      List<int[]> edges = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        int directed = in.ni(), u = in.ni() - 1, v = in.ni() - 1;
        edges.add(new int[]{u, v});
        if (directed == 1) {
          graph.get(u).add(v);
          degree[v]++;
        }
      }
      order = new ArrayList<>();
      visited = new boolean[n];
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          dfs(i);
        }
      }
      int[] pos = new int[n];
      for (int i = 0; i < n; i++) {
        pos[order.get(i)] = n - i - 1;
      }

      boolean possible = true;
      for (int u = 0; u < n; u++) {
        for (int v : graph.get(u)) {
          possible &= pos[u] < pos[v];
        }
      }
      if (possible) {
        out.println("YES");
        for (int[] edge : edges) {
          int u = edge[0], v = edge[1];
          if (pos[u] < pos[v]) {
            out.println((edge[0] + 1) + " " + (edge[1] + 1));
          } else {
            out.println((edge[1] + 1) + " " + (edge[0] + 1));
          }
        }
      } else {
        out.println("NO");
      }
    }
  }

  private boolean[] visited;
  private List<List<Integer>> graph;
  private List<Integer> order;

  private void dfs(int u) {
    visited[u] = true;
    for (int v : graph.get(u)) {
      if (!visited[v]) {
        dfs(v);
      }
    }
    order.add(u);
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (DirectingEdges instance = new DirectingEdges()) {
      instance.solve();
    }
  }
}
