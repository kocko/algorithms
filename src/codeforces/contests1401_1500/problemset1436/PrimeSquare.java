package codeforces.contests1401_1500.problemset1436;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PrimeSquare implements Closeable {

  private final InputReader in = new InputReader(System.in);
  private final PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[][] result = new int[n][n];
      if (n % 2 == 0) {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (i == j || (i + j) == n - 1) {
              result[i][j] = 1;
            }
          }
        }
      } else {
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
            if (i == j || (i + j) == n - 1) {
              result[i][j] = 1;
            }
          }
        }
        result[0][n / 2] = result[n / 2][0] = result[n / 2][n - 1] = result[n - 1][n / 2] = 1;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          out.print(result[i][j]);
          out.print(' ');
        }
        out.println();
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
    try (PrimeSquare instance = new PrimeSquare()) {
      instance.solve();
    }
  }
}
