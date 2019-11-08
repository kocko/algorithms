package codeforces.contests401_500.problemset414;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MashmokhAndACM implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    MAX_N = in.ni();
    n = in.ni();
    dp = new Integer[n][MAX_N + 1];
    int result = 0;
    for (int start = 1; start <= MAX_N; start++) {
      result += recurse(1, start);
      result %= MOD;
    }
    out.println(result);
  }

  private final int MOD = (int) 1e9 + 7;
  private int MAX_N, n;

  private Integer[][] dp;

  private int recurse(int idx, int current) {
    if (idx == n) return 1;
    if (dp[idx][current] != null) return dp[idx][current];

    int ans = 0;
    for (int multiply = 1; current * multiply <= MAX_N; multiply++) {
      ans += recurse(idx + 1, current * multiply);
      ans %= MOD;
    }
    return dp[idx][current] = ans;
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
    try (MashmokhAndACM instance = new MashmokhAndACM()) {
      instance.solve();
    }
  }
}
