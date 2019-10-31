package codeforces.contests1201_1300.problemset1217;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ColoringEdges implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    color = new int[m];
    node = new int[n];
    visited = new boolean[n];
    graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(new Edge(i, v));
    }
    for (int u = 0; u < n; u++) {
      if (!visited[u]) {
        dfs(u);
      }
    }
    out.println(cycle ? 2 : 1);
    for (int i = 0; i < m; i++) {
      out.print(color[i]);
      out.print(' ');
    }
  }

  private class Edge {
    private int idx, to;

    private Edge(int idx, int to) {
      this.idx = idx;
      this.to = to;
    }
  }

  private List<List<Edge>> graph = new ArrayList<>();
  private boolean[] visited;
  private int[] color, node;
  private boolean cycle;

  private void dfs(int u) {
    visited[u] = true;
    node[u] = 1;
    for (Edge v : graph.get(u)) {
      if (!visited[v.to]) {
        color[v.idx] = 1;
        dfs(v.to);
      } else if (node[v.to] == 1) {
        color[v.idx] = 2;
        cycle = true;
      } else if (node[v.to] == 2) {
        color[v.idx] = 1;
      }
    }
    node[u] = 2;
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
    try (ColoringEdges instance = new ColoringEdges()) {
      instance.solve();
    }
  }
}
