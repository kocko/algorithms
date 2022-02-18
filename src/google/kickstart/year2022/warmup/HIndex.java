package google.kickstart.year2022.warmup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HIndex implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public HIndex() {
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
      for (; idx > 0; idx -= (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private int query(int idx) {
      int result = 0;
      for (; idx <= MAX; idx += (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  public void solve() {
    int T = in.ni();
    final int MAX_N = (int) 1e5;
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni();
      FenwickTree tree = new FenwickTree(MAX_N);
      out.printf("Case #%d: ", testCase);
      for (int idx = 1; idx <= n; idx++) {
        int next = in.ni();
        tree.update(next, +1);
        int left = 1, right = idx, result = 0;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          int cnt = tree.query(mid);
          if (cnt < mid) {
            right = mid - 1;
          } else {
            result = Math.max(result, mid);
            left = mid + 1;
          }
        }
        out.print(result);
        out.print(' ');
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
    try (HIndex instance = new HIndex()) {
      instance.solve();
    }
  }
}
