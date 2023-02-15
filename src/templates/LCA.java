package templates;

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

public class LCA implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public LCA() {
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

  private class Query {
    private int idx, to;

    private Query(int idx, int to) {
      this.idx = idx;
      this.to = to;
    }
  }

  public void solve() {
    input();
    result = new int[q];
    ancestor = new int[n];
    visited = new boolean[n];
    dsu = new DisjointSet(n);
    dfs(0);
    for (int i = 0; i < q; i++) {
      out.println(result[i]);
    }
  }

  private void input() {
    n = in.ni();
    q = in.ni();
    tree = new ArrayList<>();
    queries = new HashMap<>();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 1; i < n; i++) {
      int parent = in.ni();
      tree.get(parent).add(i);
      tree.get(i).add(parent);
    }
    for (int i = 0; i < q; i++) {
      int u = in.ni(), v = in.ni();
      List<Query> list = queries.getOrDefault(u, new ArrayList<>());
      list.add(new Query(i, v));
      queries.put(u, list);

      list = queries.getOrDefault(v, new ArrayList<>());
      list.add(new Query(i, u));
      queries.put(v, list);
    }
  }

  private int n, q;
  private List<List<Integer>> tree;
  private Map<Integer, List<Query>> queries;
  
  private int[] result;
  private DisjointSet dsu;
  private boolean[] visited;
  private int[] ancestor;

  private void dfs(int u) {
    visited[u] = true;
    ancestor[u] = u;
    for (int v : tree.get(u)) {
      if (!visited[v]) {
        dfs(v);
        dsu.join(u, v);
        ancestor[dsu.root(v)] = u;
      }
    }
    for (Query query : queries.getOrDefault(u, new ArrayList<>())) {
      if (visited[query.to]) {
        result[query.idx] = ancestor[dsu.root(query.to)];
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
    try (LCA instance = new LCA()) {
      instance.solve();
    }
  }
}
