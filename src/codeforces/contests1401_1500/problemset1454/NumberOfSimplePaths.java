package codeforces.contests1401_1500.problemset1454;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class NumberOfSimplePaths implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      init();
      List<int[]> edges = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int u = in.ni(), v = in.ni();
        edges.add(new int[]{u, v});
        graph.get(u).add(v);
        graph.get(v).add(u);
      }
      compress();
      visited = new boolean[n + 1];
      Map<Integer, Long> components = new HashMap<>();
      for (int[] edge : edges) {
        if (cycle[edge[0]] && !cycle[edge[1]]) {
          long c = dfs2(edge[1], edge[0]);
          components.put(edge[0], components.getOrDefault(edge[0], 0L) + c);
        } else if (cycle[edge[1]] && !cycle[edge[0]]) {
          long c = dfs2(edge[0], edge[1]);
          components.put(edge[1], components.getOrDefault(edge[1], 0L) + c);
        }
      }
      Collection<Long> tmp = components.values();
      long result = c * (c - 1);
      long sum = 0;
      for (long s : tmp) {
        sum += s;
      }
      result += sum;
      for (long s : tmp) {
        result += (s * (s - 1)) / 2;
        result += (sum - s) * s;
        result += 2 * s * (c - 1);
      }
      out.println(result);
    }
  }

  private int n;
  private List<List<Integer>> graph;
  private boolean[] visited;
  private boolean[] cycle;
  private int[] next;
  private int[] depth;
  private long c;

  private void init() {
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    visited = new boolean[n + 1];
    cycle = new boolean[n + 1];
    next = new int[n + 1];
    depth = new int[n + 1];
    c = 0;
  }

  private void compress() {
    dfs(1, 0);
    for (int i = 1; i <= n; i++) {
      if (cycle[i]) {
        c++;
      }
    }
  }

  private void dfs(int u, int p) {
    visited[u] = true;
    depth[u] = depth[p] + 1;
    for (int v : graph.get(u)) {
      if (v != p) {
        if (!visited[v]) {
          next[u] = v;
          dfs(v, u);
        } else {
          if (!cycle[u]) {
            int vertex = v;
            while (vertex != u) {
              cycle[vertex] = true;
              vertex = next[vertex];
            }
            cycle[u] = true;
          }
        }
      }
    }
  }

  private long dfs2(int u, int p) {
    visited[u] = true;
    long result = 1;
    for (int v : graph.get(u)) {
      if (v != p) {
        result += dfs2(v, u);
      }
    }
    return result;
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
    try (NumberOfSimplePaths instance = new NumberOfSimplePaths()) {
      instance.solve();
    }
  }
}
