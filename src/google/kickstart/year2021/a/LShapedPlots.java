package google.kickstart.year2021.a;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class LShapedPlots implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public LShapedPlots() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      int n = in.ni(), m = in.ni();
      int[][] x = new int[n + 1][m + 1];
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          x[i][j] = in.ni();
        }
      }
      int[][] left = new int[n + 1][m + 1], right = new int[n + 1][m + 1];
      int[][] up = new int[n + 1][m + 1], down = new int[n + 1][m + 1];
      for (int row = 1; row <= n; row++) {
        int prev = 0;
        for (int col = 1; col <= m; col++) {
          if (x[row][col] == 0) {
            prev = col;
          }
          left[row][col] = prev;
        }
        int next = m + 1;
        for (int col = m; col >= 1; col--) {
          if (x[row][col] == 0) {
            next = col;
          }
          right[row][col] = next;
        }
      }
      for (int col = 1; col <= m; col++) {
        int prev = 0;
        for (int row = 1; row <= n; row++) {
          if (x[row][col] == 0) {
            prev = row;
          }
          up[row][col] = prev;
        }
        int next = n + 1;
        for (int row = n; row >= 1; row--) {
          if (x[row][col] == 0) {
            next = row;
          }
          down[row][col] = next;
        }
      }
      long result = 0;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          if (x[i][j] == 1) {
            int d1 = i - up[i][j], d2 = j - left[i][j];
            result += max(0, (min(d1 / 2, d2) - 1));
            result += max(0, (min(d1, d2 / 2) - 1));

            d1 = down[i][j] - i; d2 = j - left[i][j];
            result += max(0, (min(d1 / 2, d2) - 1));
            result += max(0, (min(d1, d2 / 2) - 1));

            d1 = i - up[i][j]; d2 = right[i][j] - j;
            result += max(0, (min(d1 / 2, d2) - 1));
            result += max(0, (min(d1, d2 / 2) - 1));

            d1 = down[i][j] - i; d2 = right[i][j] - j;
            result += max(0, (min(d1 / 2, d2) - 1));
            result += max(0, (min(d1, d2 / 2) - 1));
          }
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
    try (LShapedPlots instance = new LShapedPlots()) {
      instance.solve();
    }
  }
}
