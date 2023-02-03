package codeforces.contests1701_1800.problemset1791;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class RangeUpdatePointQuery implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public RangeUpdatePointQuery() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class FenwickTree {
    private int MAX;
    private int[] tree;

    private FenwickTree(int n) {
      MAX = n;
      tree = new int[MAX + 1];
    }

    private void update(int idx, int delta) {
      for (; idx <= MAX; idx += (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private int query(int idx) {
      int result = 0;
      for (; idx > 0; idx -= (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), q = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      FenwickTree tree = new FenwickTree(n);
      while (q-- > 0) {
        int t = in.ni();
        if (t == 1) {
          int left = in.ni(), right = in.ni();
          tree.update(left, + 1);
          tree.update(right + 1, -1);
        } else {
          int idx = in.ni();
          int times = tree.query(idx);
          out.println(transform(x[idx - 1], times));
        }
      }
    }
  }

  private int transform(int x, int times) {
    while (x >= 10 && times > 0) {
      int sum = 0;
      while (x > 0) {
        sum += x % 10;
        x /= 10;
      }
      times--;
      x = sum;
    }
    return x;
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
    try (RangeUpdatePointQuery instance = new RangeUpdatePointQuery()) {
      instance.solve();
    }
  }
}
