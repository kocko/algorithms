package google.kickstart.year2020.c;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class CandiesHard implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public CandiesHard() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public class FenwickTree {
    private int MAX;
    private long[] tree;

    private FenwickTree(int n) {
      MAX = n;
      tree = new long[MAX + 1];
    }

    private void update(int idx, long delta) {
      for (; idx <= MAX; idx += (idx & -idx)) {
        tree[idx] += delta;
      }
    }

    private long query(int idx) {
      long result = 0;
      for (; idx > 0; idx -= (idx & -idx)) {
        result += tree[idx];
      }
      return result;
    }
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni(), q = in.ni();
      long[] x = new long[n];
      FenwickTree prefix = new FenwickTree(n);
      FenwickTree sweetness = new FenwickTree(n);
      long multiplier = 1L;
      for (int idx = 0; idx < n; idx++, multiplier *= -1L) {
        x[idx] = in.nl();
        prefix.update(idx + 1, multiplier * x[idx]);
        sweetness.update(idx + 1, multiplier * (idx + 1) * x[idx]);
      }
      long result = 0;
      while (q-- > 0) {
        char type = in.next().charAt(0);
        if (type == 'U') {
          int idx = in.ni();
          long value = in.nl();
          long delta = value - x[idx - 1];
          if (idx % 2 == 0) {
            delta *= -1L;
          }
          prefix.update(idx, delta);
          sweetness.update(idx, delta * idx);
          x[idx - 1] = value;
        } else {
          int left = in.ni(), right = in.ni();
          long score = sweetness.query(right) - sweetness.query(left - 1) - (left - 1) * (prefix.query(right) - prefix.query(left - 1));
          if (left % 2 == 0) {
            score *= -1L;
          }
          result += score;
        }
      }
      out.printf("Case #%d: %d\n", testCase, result);
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
    try (CandiesHard instance = new CandiesHard()) {
      instance.solve();
    }
  }
}
