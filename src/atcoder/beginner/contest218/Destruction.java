package atcoder.beginner.contest218;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Destruction implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Destruction() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Destruction(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
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

    private boolean join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (size[x] < size[y]) {
          int t = x;
          x = y;
          y = t;
        }
        size[x] += size[y];
        root[y] = x;
        return true;
      }
      return false;
    }

  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    PriorityQueue<Edge> queue = new PriorityQueue<>();
    DisjointSet dsu = new DisjointSet(n);
    long result = 0;
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1, w = in.ni();
      if (w >= 0) {
        queue.offer(new Edge(u, v, w));
        result += w;
      } else {
        dsu.join(u, v);
      }
    }
    while (queue.size() > 0) {
      Edge top = queue.poll();
      if (dsu.join(top.from, top.to)) {
        result -= top.weight;
      }
    }
    out.println(result);
  }

  private class Edge implements Comparable<Edge> {
    private int from, to;
    private long weight;

    private Edge(int from, int to, long weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
      return Long.compare(this.weight, other.weight);
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
    try (Destruction instance = new Destruction()) {
      instance.solve();
    }
  }
}
