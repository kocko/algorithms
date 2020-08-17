package codeforces.contests1301_1400.problemset1398;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ColoredRectangles implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = 1;
    while (t-- > 0) {
      R = in.ni();
      G = in.ni();
      B = in.ni();
      red = new long[R];
      green = new long[G];
      blue = new long[B];
      for (int i = 0; i < R; i++) red[i] = in.nl();
      for (int i = 0; i < G; i++) green[i] = in.nl();
      for (int i = 0; i < B; i++) blue[i] = in.nl();
      Arrays.sort(red);
      Arrays.sort(green);
      Arrays.sort(blue);
      dp = new long[R + 1][G + 1][B + 1];
      for (int i = 0; i <= R; i++) {
        for (int j = 0; j <= G; j++) {
          for (int k = 0; k <= B; k++) {
            dp[i][j][k] = -1L;
          }
        }
      }
      out.println(recurse(0, 0, 0));
    }
  }

  private int R, G, B;
  private long[] red, green, blue;

  private long[][][] dp;

  private long recurse(int r, int g, int b) {
    int remaining = R - r + G - g + B - b;
    if (remaining <= 1) return 0;

    if (dp[r][g][b] != -1) return dp[r][g][b];

    long ans = 0;
    if (r < R && g < G) {
      ans = Math.max(ans, red[r] * green[g] + recurse(r + 1, g + 1, b));
    }
    if (r < R && b < B) {
      ans = Math.max(ans, red[r] * blue[b] + recurse(r + 1, g, b + 1));
    }
    if (g < G && b < B) {
      ans = Math.max(ans, green[g] * blue[b] + recurse(r, g + 1, b + 1));
    }
    for (int skip = 1; skip <= 7; skip++) {
      int p = (skip & 1) != 0 ? 1 : 0;
      int q = (skip & 2) != 0 ? 1 : 0;
      int t = (skip & 4) != 0 ? 1 : 0;
      if (r + p < R && g + q < G && b + t < B) {
        ans = Math.max(ans, recurse(r + p, g + q, b + t));
      }
    }
    return dp[r][g][b] = ans;
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
    try (ColoredRectangles instance = new ColoredRectangles()) {
      instance.solve();
    }
  }
}
