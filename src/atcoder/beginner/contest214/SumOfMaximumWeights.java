package atcoder.beginner.contest214;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class SumOfMaximumWeights implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SumOfMaximumWeights() {
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

  public void solve() {
    int n = in.ni();
    List<Edge> edges = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
      edges.add(new Edge(in.ni() - 1, in.ni() - 1, in.nl()));
    }
    edges.sort(Comparator.comparingLong(Edge::getWeight));
    DisjointSet dsu = new DisjointSet(n);
    long result = 0;
    for (Edge edge : edges) {
      int u = dsu.root(edge.from), v = dsu.root(edge.to);
      result += edge.weight * dsu.size[u] * dsu.size[v];
      dsu.join(u, v);
    }
    out.println(result);
  }

  private class Edge {
    private int from, to;
    private long weight;

    private Edge(int from, int to, long weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    public long getWeight() {
      return weight;
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
    try (SumOfMaximumWeights instance = new SumOfMaximumWeights()) {
      instance.solve();
    }
  }
}
