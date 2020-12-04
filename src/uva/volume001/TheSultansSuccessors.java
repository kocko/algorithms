package uva.volume001;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheSultansSuccessors implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      x = new int[8][8];
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          x[i][j] = in.ni();
        }
      }
      result = 0;
      col = new boolean[8];
      main = new boolean[16];
      secondary = new boolean[16];
      recurse(0, 0);
      out.printf("%5d\n", result);
    }
  }

  private int[][] x;
  private boolean[] col, main, secondary;
  private int result;

  private void recurse(int r, int score) {
    if (r == 8) {
      result = Math.max(result, score);
    } else {
      for (int c = 0; c < 8; c++) {
        if (!col[c] && !main[r + c] && !secondary[8 + r - c]) {
          col[c] = main[r + c] = secondary[8 + r - c] = true;
          recurse(r + 1, score + x[r][c]);
          col[c] = main[r + c] = secondary[8 + r - c] = false;
        }
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
    try (TheSultansSuccessors instance = new TheSultansSuccessors()) {
      instance.solve();
    }
  }
}
