package codeforces.contests1201_1300.problemset1287;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Garland implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    x = new int[n];
    boolean[] has = new boolean[n + 1];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      has[x[i]] = true;
    }
    int odd = 0, even = 0;
    for (int i = 1; i <= n; i++) {
      if (!has[i]) {
        if (i % 2 == 0) {
          even++;
        } else {
          odd++;
        }
      }
    }
    dp = new Integer[n][2][n][n];
    int result = 1000;
    if (x[0] == 0) {
      if (odd > 0) {
        result = Math.min(result, recurse(1, 1, odd - 1, even));
      }
      if (even > 0) {
        result = Math.min(result, recurse(1, 0, odd, even - 1));
      }
    } else {
      result = Math.min(result, recurse(1, x[0] % 2, odd, even));
    }
    out.println(result);
  }

  private int n;
  private int[] x;

  private Integer[][][][] dp;

  private int recurse(int idx, int prev, int odd, int even) {
    if (idx == n) return 0;

    if (dp[idx][prev][odd][even] != null) return dp[idx][prev][odd][even];

    int ans = 1000;
    if (x[idx] != 0) {
      int score = (prev + (x[idx] % 2)) % 2;
      ans = score + recurse(idx + 1, x[idx] % 2, odd, even);
    } else {
      //place odd
      if (odd > 0) {
        if (prev == 0) {
          ans = Math.min(ans, 1 + recurse(idx + 1, 1, odd - 1, even));
        } else {
          ans = Math.min(ans, recurse(idx + 1, 1, odd - 1, even));
        }
      }
      //place even
      if (even > 0) {
        if (prev == 0) {
          ans = Math.min(ans, recurse(idx + 1, 0, odd, even - 1));
        } else {
          ans = Math.min(ans, 1 + recurse(idx + 1, 0, odd, even - 1));
        }
      }
    }
    return dp[idx][prev][odd][even] = ans;
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
    try (Garland instance = new Garland()) {
      instance.solve();
    }
  }
}
