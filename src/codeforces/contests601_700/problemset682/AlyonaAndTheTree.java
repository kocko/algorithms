package codeforces.contests601_700.problemset682;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AlyonaAndTheTree implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    size = new int[n + 1];
    value = new long[n + 1];
    tree = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      value[i] = in.nl();
    }
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 1; i <= n - 1; i++) {
      int p = in.ni();
      long weight = in.nl();
      tree.get(i + 1).add(new Edge(p, weight));
      tree.get(p).add(new Edge(i + 1, weight));
    }
    visited = new boolean[n + 1];
    dfs1(1);
    dfs2(1, 0);
    out.println(deleted);
  }

  private int deleted;
  private int[] size;
  private boolean[] visited;
  private long[] value;
  private List<List<Edge>> tree;

  private class Edge {
    private int to;
    private long weight;

    private Edge(int to, long weight) {
      this.to = to;
      this.weight = weight;
    }
  }

  private int dfs1(int u) {
    visited[u] = true;
    int result = 1;
    for (Edge edge : tree.get(u)) if (!visited[edge.to]) {
      result += dfs1(edge.to);
    }
    return size[u] = result;
  }

  private void dfs2(int u, long dist) {
    visited[u] = false;
    if (value[u] < dist) {
      deleted += size[u];
    } else {
      for (Edge edge : tree.get(u)) if (visited[edge.to]) {
        dfs2(edge.to, Math.max(dist + edge.weight, edge.weight));
      }
    }
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
    try (AlyonaAndTheTree instance = new AlyonaAndTheTree()) {
      instance.solve();
    }
  }
}
