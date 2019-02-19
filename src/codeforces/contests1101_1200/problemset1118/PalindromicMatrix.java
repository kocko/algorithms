package codeforces.contests1101_1200.problemset1118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromicMatrix implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] cnt = new int[1001];
    for (int i = 0; i < n * n; i++) {
      cnt[in.ni()]++;
    }
    int[][] result = new int[n][n];
    int half = n / 2;
    for (int i = 0; i < half; i++) {
      for (int j = 0; j < half; j++) {
        int value = -1;
        for (int k = 1; k <= 1000; k++) {
          if (cnt[k] >= 4) {
            value = k;
            break;
          }
        }
        if (value == -1) {
          out.println("NO");
          return;
        }
        result[i][j] = result[n - i - 1][j] = result[i][n - j - 1] = result[n - i - 1][n - j - 1] = value;
        cnt[value] -= 4;
      }
    }
    if (n % 2 == 1) {
      for (int i = 0; i < half; i++) {
        int value = -1;
        for (int j = 1; j <= 1000; j++) {
          if (cnt[j] >= 2) {
            value = j;
            break;
          }
        }
        if (value == -1) {
          out.println("NO");
          return;
        }
        result[n / 2][i] = result[n / 2][n - i - 1] = value;
        cnt[value] -= 2;
      }
      for (int i = 0; i < half; i++) {
        int value = -1;
        for (int j = 1; j <= 1000; j++) {
          if (cnt[j] >= 2) {
            value = j;
            break;
          }
        }
        if (value == -1) {
          out.println("NO");
          return;
        }
        result[i][n / 2] = result[n - i - 1][n / 2] = value;
        cnt[value] -= 2;
      }
      int value = -1;
      for (int i = 1; i <= 1000; i++) {
        if (cnt[i] == 1) {
          value = i;
          break;
        }
      }
      if (value == -1) {
        out.println("NO");
        return;
      }
      result[n / 2][n / 2] = value;
    }

    out.println("YES");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        out.print(result[i][j]);
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
    try (PalindromicMatrix instance = new PalindromicMatrix()) {
      instance.solve();
    }
  }
}
