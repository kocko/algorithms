package uva.volume104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class CollectingBeepers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      int xo = in.ni(), yo = in.ni();
      b = in.ni();
      x = new int[b + 1];
      y = new int[b + 1];
      x[0] = xo;
      y[0] = yo;
      for (int i = 1; i <= b; i++) {
        x[i] = in.ni();
        y[i] = in.ni();
      }
      dist = new int[b + 1][b + 1];
      calculateDistances();
      dp = new Integer[1 << (b + 1)][b + 1];
      out.printf("The shortest path has length %d\n", recurse(0, 0));
    }
  }

  private int b;
  private int[] x, y;
  private int[][] dist;

  private final Integer oo = (int) 1e6;
  private Integer[][] dp;

  private void calculateDistances() {
    int b = x.length;
    for (int i = 0; i < b; i++) {
      for (int j = i + 1; j < b; j++) {
        dist[i][j] = dist[j][i] = abs(x[i] - x[j]) + abs(y[i] - y[j]);
      }
    }
  }

  private Integer recurse(int mask, int last) {
    if (mask == (1 << (b + 1)) - 2) return dist[last][0];

    if (dp[mask][last] != null) return dp[mask][last];

    int ans = oo;
    for (int i = 1; i <= b; i++) {
      if ((mask & (1 << i)) == 0) {
        ans = min(ans, dist[last][i] + recurse(mask | (1 << i), i));
      }
    }
    return dp[mask][last] = ans;
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
    try (CollectingBeepers instance = new CollectingBeepers()) {
      instance.solve();
    }
  }
}
