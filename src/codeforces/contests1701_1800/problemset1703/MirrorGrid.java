package codeforces.contests1701_1800.problemset1703;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MirrorGrid implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      char[][] grid = new char[n][n];
      for (int i = 0; i < n; i++) {
        grid[i] = in.next().toCharArray();
      }
      int result = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int cnt = 0;
          cnt += grid[i][j] - '0';
          cnt += grid[j][n - i - 1] - '0';

          cnt += grid[n - i - 1][n - j - 1] - '0';
          cnt += grid[n - j - 1][i] - '0';
          if (cnt == 3) result++;
          if (cnt == 1) result++;
          if (cnt == 2) result += 2;
        }
      }
      out.println(result >> 2);
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
    try (MirrorGrid instance = new MirrorGrid()) {
      instance.solve();
    }
  }
}