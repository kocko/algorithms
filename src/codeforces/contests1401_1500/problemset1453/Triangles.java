package codeforces.contests1401_1500.problemset1453;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Triangles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      char[][] x = new char[n][n];
      for (int i = 0; i < n; i++) {
        x[i] = in.next().toCharArray();
      }
      int[][][] row = new int[10][n][2];
      int[][][] col = new int[10][n][2];
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < n; j++) {
          row[i][j][0] = col[i][j][0] = Integer.MAX_VALUE;
          row[i][j][1] = col[i][j][1] = -1;
        }
      }
      int[][] rowOuter = new int[10][2];
      int[][] colOuter = new int[10][2];
      for (int i = 0; i < 10; i++) {
        rowOuter[i][0] = colOuter[i][0] = Integer.MAX_VALUE;
        rowOuter[i][1] = colOuter[i][1] = -1;
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          int digit = x[i][j] - '0';
          row[digit][i][0] = Math.min(row[digit][i][0], j);
          row[digit][i][1] = Math.max(row[digit][i][1], j);

          col[digit][j][0] = Math.min(col[digit][j][0], i);
          col[digit][j][1] = Math.max(col[digit][j][1], i);

          rowOuter[digit][0] = Math.min(rowOuter[digit][0], j);
          rowOuter[digit][1] = Math.max(rowOuter[digit][1], j);

          colOuter[digit][0] = Math.min(colOuter[digit][0], i);
          colOuter[digit][1] = Math.max(colOuter[digit][1], i);
        }
      }

      for (int d = 0; d < 10; d++) {
        int max = 0;
        for (int r = 0; r < n; r++) {
          int begin = row[d][r][0], end = row[d][r][1];
          if (begin != Integer.MAX_VALUE) {
            int side = end - begin;
            int height = Math.max(r, n - r - 1);
            max = Math.max(max, side * height);
            for (int p : new int[]{begin, end}) {
              side = Math.max(p, n - p - 1);
              int h1 = colOuter[d][0] != Integer.MAX_VALUE ? r - colOuter[d][0] : 0;
              int h2 = colOuter[d][1] != -1 ? colOuter[d][1] - r : 0;
              max = Math.max(max, side * h1);
              max = Math.max(max, side * h2);
            }
          }
        }

        for (int c = 0; c < n; c++) {
          int begin = col[d][c][0], end = col[d][c][1];
          if (begin != Integer.MAX_VALUE) {
            int side = end - begin;
            int height = Math.max(c, n - c - 1);
            max = Math.max(max, side * height);
            for (int p : new int[]{begin, end}) {
              side = Math.max(p, n - p - 1);
              int h1 = rowOuter[d][0] != Integer.MAX_VALUE ? c - rowOuter[d][0] : 0;
              int h2 = rowOuter[d][1] != -1 ? rowOuter[d][1] - c : 0;
              max = Math.max(max, side * h1);
              max = Math.max(max, side * h2);
            }
          }
        }
        out.print(max);
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
    try (Triangles instance = new Triangles()) {
      instance.solve();
    }
  }
}
