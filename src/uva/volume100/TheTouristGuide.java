package uva.volume100;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class TheTouristGuide implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int testCase = 1, n, m;
    while ((n = in.ni()) != 0 | (m = in.ni()) != 0) {
      PriorityQueue<Edge> queue = new PriorityQueue<>();
      for (int i = 0; i < m; i++) {
        int u = in.ni() - 1, v = in.ni() - 1, w = in.ni() - 1;
        queue.offer(new Edge(u, v, w));
        queue.offer(new Edge(v, u, w));
      }
      int start = in.ni() - 1;
      end = in.ni() - 1;
      int passengers = in.ni();
      DisjointSet dsu = new DisjointSet(n);
      tree = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        tree.add(new ArrayList<>());
      }
      while (queue.size() > 0) {
        Edge edge = queue.poll();
        if (dsu.join(edge.u, edge.v)) {
          tree.get(edge.u).add(new Edge(edge.u, edge.v, edge.w));
          tree.get(edge.v).add(new Edge(edge.v, edge.u, edge.w));
        }
      }
      visited = new boolean[n];
      dfs(start, Integer.MAX_VALUE);
      int ans = passengers / min + (passengers % min != 0 ? 1 : 0);
      out.printf("Scenario #%d\n", testCase++);
      out.printf("Minimum Number of Trips = %d\n", ans);
      out.println();
    }
  }
  
  private class Edge implements Comparable<Edge> {
    private int u, v, w;

    private Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(o.w, w);
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
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        root[y] = x;
        size[x] += size[y];
        return true;
      }
      return false;
    }
  }
  
  private int end, min = Integer.MAX_VALUE;
  private boolean[] visited;
  private List<List<Edge>> tree;
  
  private void dfs(int u, int minSoFar) {
    if (u == end) {
      min = minSoFar;
    } else {
      visited[u] = true;
      for (Edge edge : tree.get(u)) {
        if (!visited[edge.v]) {
          dfs(edge.v, min(minSoFar, edge.w));
        }
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
    try (TheTouristGuide instance = new TheTouristGuide()) {
      instance.solve();
    }
  }
}
