package codeforces.contests1201_1300.problemset1250;

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

public class Wires implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class DisjointSet {
    private int[] root, size;
    private int components;

    private DisjointSet(int n) {
      root = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        root[i] = i;
        size[i] = 1;
      }
      components = n;
    }

    private int root(int x) {
      return (x == root[x]) ? x : (root[x] = root(root[x]));
    }

    private boolean join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          y = x ^ y ^ (x = y);
        }
        size[x] += size[y];
        root[y] = x;
        components--;
        return true;
      }
      return false;
    }

    public int getComponents() {
      return components;
    }
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      Map<Integer, Integer> index = new HashMap<>();
      Map<Integer, Integer> inverse = new HashMap<>();
      int idx = 0;
      List<int[]> edges = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int a = in.ni(), b = in.ni();
        int u, v;
        if (!index.containsKey(a)) {
          u = idx++;
          index.put(a, u);
          inverse.put(u, a);
        } else {
          u = index.get(a);
        }
        if (!index.containsKey(b)) {
          v = idx++;
          index.put(b, v);
          inverse.put(v, b);
        } else {
          v = index.get(b);
        }
        edges.add(new int[]{i + 1, u, v});
      }

      graph = new ArrayList<>();
      for (int i = 0; i < idx; i++) {
        graph.add(new ArrayList<>());
      }

      int N = graph.size();
      DisjointSet dsu = new DisjointSet(N);
      for (int[] edge : edges) {
        if (dsu.join(edge[1], edge[2])) {
          graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
          graph.get(edge[2]).add(new Edge(edge[0], edge[1]));
        }
      }
      int components = dsu.getComponents();
      int[][] component = new int[components][4];
      idx = 0;
      for (int i = 0; i < N; i++) {
        if (dsu.root(i) == i) {
          component[idx++][0] = i;
        }
      }
      visited = new boolean[N + 1];
      for (int i = 0; i < components; i++) {
        dfs(component[i][0]);
        component[i][1] = last;
        component[i][2] = graph.get(last).get(0).to;
        component[i][3] = graph.get(last).get(0).idx;
      }

      List<int[]> swaps = new ArrayList<>();
      for (int i = 0; i < components - 1; i++) {
        swaps.add(new int[]{component[i][3], component[i][1], component[i + 1][0]});
      }
      out.println(swaps.size());
      for (int[] swap : swaps) {
        out.print(swap[0]);
        out.print(' ');
        out.print(inverse.get(swap[1]));
        out.print(' ');
        out.print(inverse.get(swap[2]));
        out.println();
      }
    }
  }

  private class Edge {
    private int idx, to;

    private Edge(int idx, int to) {
      this.idx = idx;
      this.to = to;
    }
  }

  private List<List<Edge>> graph;
  private boolean[] visited;
  private int last = -1;

  private void dfs(int u) {
    visited[u] = true;
    last = u;
    for (Edge v : graph.get(u)) {
      if (!visited[v.to]) {
        dfs(v.to);
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
    try (Wires instance = new Wires()) {
      instance.solve();
    }
  }
}
