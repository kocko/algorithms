package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Keys implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int m = in.ni(), empty = 0;
    keys = new int[n];
    for (int i = 0; i < n; i++) {
      char[] key = in.next().toCharArray();
      for (int j = 0; j < m; j++) {
        if (key[j + 1] == '^') {
          keys[i] |= (1 << j);
        }
      }
      if (keys[i] == 0) {
        empty++;
      }
    }
    dp = new int[1 << m];
    Arrays.fill(dp, -1);
    out.println(empty + recurse(0));
  }
  
  private int n;
  private int[] keys;
  private int[] dp;
  
  private int recurse(int mask) {
    if (dp[mask] != -1) return dp[mask];
    
    int ans = 0;
    for (int i = 0; i < n; i++) {
      if (keys[i] != 0 && (mask & keys[i]) == 0) {
        ans = Math.max(ans, 1 + recurse(mask | keys[i]));
      }
    }
    return dp[mask] = ans;
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
    try (Keys instance = new Keys()) {
      instance.solve();
    }
  }
}
