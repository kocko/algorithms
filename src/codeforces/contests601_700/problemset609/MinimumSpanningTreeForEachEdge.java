package codeforces.contests601_700.problemset609;

import java.io.*;
import java.util.*;

import static java.lang.Integer.max;
import static java.util.Comparator.comparingLong;

public class MinimumSpanningTreeForEachEdge implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    for (int i = 0; i < n; i++) {
      tree.add(new ArrayList<>());
    }
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      edges.add(new Edge(i, in.ni() - 1, in.ni() - 1, in.nl()));
    }
    DisjointSet dsu = new DisjointSet(n);
    PriorityQueue<Edge> queue = new PriorityQueue<>(comparingLong(e -> e.w));
    queue.addAll(edges);
    boolean[] mst = new boolean[m];
    long total = 0;
    while (queue.size() > 0) {
      Edge top = queue.poll();
      if (dsu.join(top.u, top.v)) {
        tree.get(top.u).add(new Edge(top.idx, top.u, top.v, top.w));
        tree.get(top.v).add(new Edge(top.idx, top.v, top.u, top.w));
        mst[top.idx] = true;
        total += top.w;
      }
    }
    depth = new int[n];
    pa = new int[n][18][2];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 18; j++) {
        for (int k = 0; k < 2; k++) {
          pa[i][j][k] = -1;
        }
      }
    }
    dfs(0, -1, -1, 0);
    for (int i = 1; i <= 17; i++) {
      for (int j = 0; j < n; j++) {
        if (pa[j][i - 1][0] != -1) {
          pa[j][i][0] = pa[pa[j][i - 1][0]][i - 1][0];
          pa[j][i][1] = max(pa[j][i - 1][1], pa[pa[j][i - 1][0]][i - 1][1]);
        }
      }
    }
    long[] result = new long[m];
    for (int i = 0; i < m; i++) {
      if (mst[i]) {
        result[i] = total;
      } else {
        Edge edge = edges.get(i);
        int max = lca(edge.u, edge.v);
        result[edge.idx] = total - max + edge.w;
      }
    }
    for (int i = 0; i < m; i++) {
      out.println(result[i]);
    }
  }

  private class DisjointSet {
    private int[] root, size;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
    }

    private int root(int x) {
      return x == root[x] ? x : (root[x] = root(root[x]));
    }

    private boolean join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) y = x ^ y ^ (x = y);
        root[y] = x;
        size[x] += size[y];
        return true;
      }
      return false;
    }
  }
  
  private class Edge {
    private int idx, u, v;
    private long w;

    private Edge(int idx, int u, int v, long w) {
      this.idx = idx;
      this.u = u;
      this.v = v;
      this.w = w;
    }
  }
  
  private List<List<Edge>> tree = new ArrayList<>();
  
  private int[] depth;
  private int[][][] pa;
  
  private void dfs(int node, int parent, int weight, int d) {
    pa[node][0][0] = parent;
    pa[node][0][1] = weight;
    depth[node] = d;
    
    for (Edge next : tree.get(node)) if (next.v != parent) {
      dfs(next.v, node, (int) next.w, d + 1);
    }
  }
  
  private int lca(int u, int v) {
    if (depth[u] < depth[v]) {
      int t = u;
      u = v;
      v = t;
    }
    int result = 0;
    for (int i = 17; i >= 0; i--) {
      if (depth[u] - (1 << i) >= depth[v]) {
        result = max(result, pa[u][i][1]);
        u = pa[u][i][0];
      }
    }
    if (u == v) {
      return result;
    }
    for (int i = 17; i >= 0; i--) {
      if (pa[u][i][0] != -1 && pa[u][i][0] != pa[v][i][0]) {
        result = max(result, max(pa[u][i][1], pa[v][i][1]));
        u = pa[u][i][0];
        v = pa[v][i][0];
      }
    }
    return max(result, max(pa[u][0][1], pa[v][0][1]));
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
    try (MinimumSpanningTreeForEachEdge instance = new MinimumSpanningTreeForEachEdge()) {
      instance.solve();
    }
  }
}
