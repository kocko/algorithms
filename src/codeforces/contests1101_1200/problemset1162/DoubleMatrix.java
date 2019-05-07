package codeforces.contests1101_1200.problemset1162;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DoubleMatrix implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    int[][] a = new int[n][m], b = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = in.ni();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        b[i][j] = in.ni();
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int min = Math.min(a[i][j], b[i][j]), max = Math.max(a[i][j], b[i][j]);
        a[i][j] = min;
        b[i][j] = max;
      }
    }
    boolean possible = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j > 0) {
          possible &= a[i][j] > a[i][j - 1];
          possible &= b[i][j] > b[i][j - 1];
        }
        if (i > 0) {
          possible &= a[i][j] > a[i - 1][j];
          possible &= b[i][j] > b[i - 1][j];
        }
      }
    }
    out.println(possible ? "Possible" : "Impossible");
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
    try (DoubleMatrix instance = new DoubleMatrix()) {
      instance.solve();
    }
  }
}
