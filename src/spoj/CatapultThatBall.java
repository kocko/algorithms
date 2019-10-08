package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class CatapultThatBall implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int q = in.ni();
    x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    sparseTable();
    int result = 0;
    while (q-- > 0) {
      int left = in.ni(), right = in.ni() - 2;
      if (left >= right) {
        result++;
      } else {
        int j = log[right - left + 1];
        int max = max(st[left][j], st[right - (1 << j)][j]);
        if (max <= x[left - 1]) {
          result++;
        }
      }
    }
    out.println(result);
  }

  private int n;
  private int MAX_N = 50000, MAX_K = 17;
  private int[] log = new int[MAX_N + 1], x;
  private int[][] st = new int[MAX_N][MAX_K];

  private void sparseTable() {
    log[1] = 0;
    for (int i = 2; i <= MAX_N; i++) {
      log[i] = log[i / 2] + 1;
    }
    for (int i = 0; i < n; i++) {
      st[i][0] = x[i];
    }
    for (int j = 1; j <= MAX_K; j++) {
      for (int i = 0; i + (1 << j) <= n; i++) {
        st[i][j] = max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
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
    try (CatapultThatBall instance = new CatapultThatBall()) {
      instance.solve();
    }
  }
}
