package codeforces.contests1601_1700.problemset1675;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ReplaceWithThePreviousMinimize implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

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

    private int join(int a, int b) {
      int x = root(a), y = root(b);
      if (x != y) {
        if (x > y) {
          int t = x;
          x = y;
          y = t;
        }
        size[x] += size[y];
        root[y] = x;
      }
      return x;
    }
  }


  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      DisjointSet dsu = new DisjointSet(26);
      char[] x = in.next().toCharArray();
      for (int idx = 0; idx < n; idx++) {
        if (x[idx] > 'a') {
          int p = x[idx] - 'a';
          p = dsu.root(p);
          x[idx] = (char) ('a' + p);
          while (k > 0 && p > 0) {
            k--;
            p = dsu.join(p, p - 1);
            x[idx] = (char) ('a' + p);
          }
        }
      }
      for (int idx = 0; idx < n; idx++) {
        out.print(x[idx]);
      }
      out.println();
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
    try (ReplaceWithThePreviousMinimize instance = new ReplaceWithThePreviousMinimize()) {
      instance.solve();
    }
  }
}
