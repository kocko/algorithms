package codeforces.contests1301_1400.problemset1335;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AntiSudoku implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int[][] sq = new int[9][9];
      for (int i = 0; i < 9; i++) {
        char[] next = in.next().toCharArray();
        for (int j = 0; j < 9; j++) {
          sq[i][j] = next[j] - '0';
        }
      }
      int[][] centers = {{0, 0}, {1, 3}, {2, 6},
                         {3, 1}, {4, 4}, {5, 7},
                         {6, 2}, {7, 5}, {8, 8}};
      for (int[] center : centers) {
        int row = center[0], col = center[1];
        sq[row][col]++;
        if (sq[row][col] == 10) {
          sq[row][col] = 1;
        }
      }
      for (int row = 0; row < 9; row++) {

      }
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          out.print(sq[i][j]);
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
    try (AntiSudoku instance = new AntiSudoku()) {
      instance.solve();
    }
  }
}
