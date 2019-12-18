package codeforces.contests1201_1300.problemset1266;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiverseMatrix implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    if (n == 1 && m == 1) {
      out.println(0);
      return;
    }
    if (n == 1 || m == 1) {
      for (int i = 1; i <= Math.max(n, m); i++) {
        out.print(i + 1);
        out.print(' ');
      }
      return;
    }
    long[][] matrix = new long[n][m];
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < m; col++) {
        matrix[row][col] = (row + 1) * (n + col + 1);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        out.print(matrix[i][j]);
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
    try (DiverseMatrix instance = new DiverseMatrix()) {
      instance.solve();
    }
  }
}
