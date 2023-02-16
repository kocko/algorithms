package codeforces.contests101_200.problemset192;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FoolsAndRoads implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public FoolsAndRoads() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class DisjointSet {

    private int[] root, size;

    public DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          int t = x;
          x = y;
          y = t;
        }
        size[x] += size[y];
        root[y] = x;
      }
    }

  }

  private class Edge {
    private int idx, to, delta;

    Edge(int idx, int to) {
      this.idx = idx;
      this.to = to;
    }
  }

  public void solve() {
    n = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(new Edge(i, v));
      tree.get(v).add(new Edge(i, u));
    }
    int q = in.ni();
    queries = new HashMap<>();
    for (int i = 0; i < q; i++) {
      int u = in.ni(), v = in.ni();
      List<Edge> list = queries.getOrDefault(u, new ArrayList<>());
      list.add(new Edge(i, v));
      queries.put(u, list);

      list = queries.getOrDefault(v, new ArrayList<>());
      list.add(new Edge(i, u));
      queries.put(v, list);
    }
    delta = new int[n + 1];
    visited = new boolean[n + 1];
    ancestor = new int[n + 1];
    answered = new boolean[q];
    dsu = new DisjointSet(n + 1);
    dfs(1);
    result = new int[n - 1];
    visited = new boolean[n + 1];
    dfs2(1);
    for (int i = 0; i < n - 1; i++) {
      out.print(result[i]);
      out.print(' ');
    }
    out.println();
  }

  private int n;
  private List<List<Edge>> tree;
  private Map<Integer, List<Edge>> queries;
  private DisjointSet dsu;
  private boolean[] visited, answered;
  private int[] ancestor, delta, result;

  private void dfs(int node) {
    visited[node] = true;
    ancestor[node] = node;
    for (Edge edge : tree.get(node)) {
      if (!visited[edge.to]) {
        dfs(edge.to);
        dsu.join(node, edge.to);
        ancestor[dsu.root(edge.to)] = node;
      }
    }
    for (Edge query : queries.getOrDefault(node, new ArrayList<>())) {
      if (visited[query.to] && !answered[query.idx]) {
        int lca = ancestor[dsu.root(query.to)];
        answered[query.idx] = true;
        delta[query.to]++;
        delta[node]++;
        delta[lca] -= 2;
      }
    }
  }

  private int dfs2(int node) {
    visited[node] = true;
    int accumulated = delta[node];
    for (Edge edge : tree.get(node)) {
      if (!visited[edge.to]) {
        int score = dfs2(edge.to);
        result[edge.idx] = score;
        accumulated += score;
      }
    }
    return accumulated;
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
    try (FoolsAndRoads instance = new FoolsAndRoads()) {
      instance.solve();
    }
  }
}
