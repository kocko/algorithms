package codeforces.contests1601_1700.problemset1676;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MaximumCrossings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public class FenwickTree {
    private int MAX;
    private long[] tree;

    private FenwickTree(int n) {
      MAX = n;
      tree = new long[MAX + 1];
    }

    private void update(int idx, int delta) {
      for (; idx > 0; idx -= (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private long query(int idx) {
      long result = 0;
      for (; idx <= MAX; idx += (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      FenwickTree tree = new FenwickTree(n);
      long result = 0;
      for (int from = 1; from <= n; from++) {
        int to = in.ni();
        result += tree.query(to);
        tree.update(to, +1);
      }
      out.println(result);
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
    try (MaximumCrossings instance = new MaximumCrossings()) {
      instance.solve();
    }
  }
}