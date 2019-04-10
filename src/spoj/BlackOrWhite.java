package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlackOrWhite implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while ((n = in.ni()) != -1) {
      x = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        x[i] = in.ni();
      }
      dp = new Integer[n + 1][n + 1][n + 1];
      out.println(n - recurse(1, 0, 0));
    }
  }
  
  private int n;
  private int[] x;
  private Integer[][][] dp;
  
  private int recurse(int idx, int black, int white) {
    if (idx == n + 1) return 0;
    
    if (dp[idx][black][white] != null) return dp[idx][black][white];
    
    //leave unpainted
    int ans = recurse(idx + 1, black, white);
    
    //paint black
    if (x[idx] > x[black]) {
      ans = Math.max(ans, 1 + recurse(idx + 1, idx, white));
    }
    
    //paint white
    if (x[idx] < x[white] || white == 0) {
      ans = Math.max(ans, 1 + recurse(idx + 1, black, idx));
    }
    return dp[idx][black][white] = ans;
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
    try (BlackOrWhite instance = new BlackOrWhite()) {
      instance.solve();
    }
  }
}
