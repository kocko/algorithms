package uva.volume108;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TrafficFlow implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int test = 1; test <= T; test++) {
      int n = in.ni(), m = in.ni();
      int[][] graph = new int[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          graph[i][j] = -1;
        }
      }
      while (m-- > 0) {
        int u = in.ni(), v = in.ni(), c = in.ni();
        if (u != v) {
          if (c > graph[u][v]) {
            graph[u][v] = graph[v][u] = c;
          }
        }
      }
      PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> -e.w));
      for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
          if (graph[i][j] != -1) {
            queue.add(new Edge(i, j, graph[i][j]));
          }
        }
      }
      DisjointSet dsu = new DisjointSet(n);
      int last = Integer.MAX_VALUE;
      while (queue.size() > 0) {
        Edge top = queue.poll();
        if (dsu.join(top.u, top.v)) {
          last = top.w;
        }
      }
      out.printf("Case #%d: %d\n", test, last);
    }
  }

  private class Edge {
    private int u, v, w;

    private Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
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
    try (TrafficFlow instance = new TrafficFlow()) {
      instance.solve();
    }
  }
}
