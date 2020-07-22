package codeforces.gyms.gym102646;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class MaximizingSCCs implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

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
        size[x] += size[y];
        root[y] = x;
        return true;
      }
      return false;
    }
  }

  public void solve() {
    int n = in.ni(), m = in.ni(), k = in.ni();
    DisjointSet dsu = new DisjointSet(n);
    ArrayDeque<Integer> edges = new ArrayDeque<>();
    for (int i = 1; i <= m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      if (dsu.join(u, v)) {
        edges.add(i);
      }
    }
    while (edges.size() > k) {
      edges.removeLast();
    }
    out.println(n);
    for (int idx : edges) {
      out.print(idx);
      out.print(' ');
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
    try (MaximizingSCCs instance = new MaximizingSCCs()) {
      instance.solve();
    }
  }
}
