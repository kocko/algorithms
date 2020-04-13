package codeforces.contests1301_1400.problemset1335;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreeBlocksPalindromeEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    final int MAX_A = 26;
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }

      int[][] count = new int[MAX_A + 1][n + 1];
      for (int i = 1; i <= 26; i++) {
        for (int j = 1; j <= n; j++) {
          count[i][j] += count[i][j - 1];
          if (x[j - 1] == i) {
            count[i][j]++;
          }
        }
      }
      int result = 0;
      for (int left = 1; left <= n; left++) {
        for (int right = left; right <= n; right++) {
          if (x[left - 1] == x[right - 1]) {
            int value = x[left - 1];
            int middle = count[value][right] - count[value][left - 1];
            for (int a = 1; a <= MAX_A; a++) {
              int first = count[a][left - 1];
              int second = count[a][n] - count[a][right];
              int min = Math.min(first, second);
              result = Math.max(min + middle + min, result);
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
    try (ThreeBlocksPalindromeEasy instance = new ThreeBlocksPalindromeEasy()) {
      instance.solve();
    }
  }
}
