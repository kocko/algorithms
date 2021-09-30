package atcoder.beginner.contest220;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class DistanceSums2 implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public DistanceSums2() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    n = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    nodes = new long[n + 1];
    sum = new long[n + 1];
    recurse(1, 0);
    result = new long[n + 1];
    result[1] = sum[1];
    for (int next : tree.get(1)) {
      reRoot(next, 1);
    }
    for (int i = 1; i <= n; i++) {
      out.println(result[i]);
    }
  }

  private int n;
  private List<List<Integer>> tree;
  private long[] nodes, sum, result;

  private void recurse(int u, int parent) {
    nodes[u] = 1L;
    for (int v : tree.get(u)) {
      if (v != parent) {
        recurse(v, u);
        sum[u] += (sum[v] + nodes[v]);
        nodes[u] += nodes[v];
      }
    }
  }

  private void reRoot(int now, int parent) {
    result[now] = result[parent] - nodes[now] + n - nodes[now];

    for (int next : tree.get(now)) {
      if (next != parent) {
        reRoot(next, now);
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
    try (DistanceSums2 instance = new DistanceSums2()) {
      instance.solve();
    }
  }
}
