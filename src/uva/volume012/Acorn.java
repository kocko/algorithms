package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Acorn implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int t = in.ni(), h = in.ni(), f = in.ni();
      int[][] acorns = new int[t][h + 1];
      for (int i = 0; i < t; i++) {
        int count = in.ni();
        for (int j = 0; j < count; j++) {
          int pos = in.ni();
          acorns[i][pos]++;
        }
      }
      int[][] dp = new int[t][h + 1];
      int[][] best = new int[h + 1][2];
      for (int height = 0; height <= h; height++) {
        int[] jump = new int[]{-1, -1};
        for (int tree = 0; tree < t; tree++) {
          int fly = 0;
          if (height >= f) {
            if (best[height - f][0] != tree) {
              fly = dp[best[height - f][0]][height - f];
            } else {
              fly = dp[best[height - f][1]][height - f];
            }
          }
          int down = 0;
          if (height > 0) {
            down = dp[tree][height - 1];
          }
          dp[tree][height] = acorns[tree][height] + Math.max(fly, down);
          if (jump[0] == -1) {
            jump[0] = tree;
          } else if (dp[tree][height] >= dp[jump[0]][height]) {
            jump[1] = jump[0];
            jump[0] = tree;
          } else if (jump[1] == -1) {
            jump[1] = tree;
          } else if (dp[tree][height] > dp[jump[1]][height]) {
            jump[1] = tree;
          }
        }
        best[height] = jump;
      }
      int result = 0;
      for (int tree = 0; tree < t; tree++) {
        result = Math.max(result, dp[tree][h]);
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
    try (Acorn instance = new Acorn()) {
      instance.solve();
    }
  }
}
