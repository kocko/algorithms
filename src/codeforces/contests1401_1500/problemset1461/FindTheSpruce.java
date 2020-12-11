package codeforces.contests1401_1500.problemset1461;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FindTheSpruce implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[][] x = new char[n][m];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      int result = 0;
      int[][] prefix = new int[n + 1][m + 1];
      for (int i = 0; i < n; i++) {
        for (int j = 1; j <= m; j++) {
          prefix[i][j] += prefix[i][j - 1];
          if (x[i][j - 1] == '*') {
            prefix[i][j]++;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (x[i][j] == '*') {
            int row = i, left = j + 1, right = j + 1;
            while (row < n && left > 0 && right <= m && prefix[row][right] - prefix[row][left - 1] == right - left + 1) {
              result++;
              row++;
              left--;
              right++;
            }
          }
        }
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
    try (FindTheSpruce instance = new FindTheSpruce()) {
      instance.solve();
    }
  }
}
