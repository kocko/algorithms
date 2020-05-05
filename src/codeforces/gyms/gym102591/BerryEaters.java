package codeforces.gyms.gym102591;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BerryEaters implements Closeable {

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

    private void join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (x < y) {
          y = x ^ y ^ (x = y);
        }
        size[x] += size[y];
        root[y] = x;
      }
    }
  }

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int[] pos = new int[n + 1];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      pos[x[i]] = i;
    }
    DisjointSet dsu = new DisjointSet(n + 1);
    for (int i = 1; i <= n; i++) {
      int p = pos[i];
      int prev = p >= 1 ? dsu.root(x[p - 1]) : dsu.root(x[n - 1]);
      int next = p < n - 1 ? dsu.root(x[p + 1]) : dsu.root(x[0]);
      if (i - prev == 1) {
        dsu.join(i, prev);
      }
      if (i - next == 1) {
        dsu.join(i, next);
      }
    }
    out.println(dsu.size[n] == n ? "YES" : "NO");
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
    try (BerryEaters instance = new BerryEaters()) {
      instance.solve();
    }
  }
}
