package codeforces.gyms.gym102254;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class BuildingBridges implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    x = in.next().toCharArray();
    y = in.next().toCharArray();
    n = x.length;
    m = y.length;
    dp = new Integer[n][m];
    out.println(recurse(0, 0));
  }
  
  private char[] x, y;
  private int n, m;
  private Integer[][] dp;
  
  private Integer recurse(int i, int j) {
    if (i >= n || j >= m) return 0;
    
    if (dp[i][j] != null) return dp[i][j];
    
    int ans = max(recurse(i, j + 1), recurse(i + 1, j));
    if (x[i] == y[j]) {
      ans = max(ans, 1 + recurse(i + 1, j + 1));
    }
    return dp[i][j] = ans;
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
    try (BuildingBridges instance = new BuildingBridges()) {
      instance.solve();
    }
  }
}
