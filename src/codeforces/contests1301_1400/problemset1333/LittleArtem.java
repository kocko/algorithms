package codeforces.contests1301_1400.problemset1333;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleArtem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int[][] result = new int[n][m];
      int white = 0, black = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          result[i][j] = (i + j) % 2;
          if (result[i][j] == 0) {
            white++;
          } else {
            black++;
          }
        }
      }
      if (black <= white) {
        int sw = white - black + 1;
        outside:
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
            if (result[i][j] == 0) {
              result[i][j] = 1;
              sw--;
            }
            if (sw == 0) break outside;
          }
        }
      }
//      verify(result);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          out.print(result[i][j] == 1 ? 'B' : 'W');
        }
        out.println();
      }

    }
  }

  private void verify(int[][] arr) {
    int n = arr.length, m = arr[0].length;
    int w = 0, b = 0;
    int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int[] d : dir) {
          int x = i + d[0], y = j + d[1];
          if (x >= 0 && x < n && y >= 0 && y < m) {
            if (arr[i][j] == 1) {
              if (arr[x][y] == 0) {
                b++;
                break;
              }
            } else {
              if (arr[x][y] == 1) {
                w++;
                break;
              }
            }
          }
        }
      }
    }
    out.println(w + " " + b);
    if (b != w + 1) {
      out.println("WA [n = " + n + "; m = " + m + "]");
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
    try (LittleArtem instance = new LittleArtem()) {
      instance.solve();
    }
  }
}
