package codeforces.contests1301_1400.problemset1391;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CyclicPermutations implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = 1;
    final int MAX_N = (int) 1e6, MOD = (int) 1e9 + 7;
    long[] dp = new long[MAX_N + 1];
    long[] fact = new long[MAX_N + 1];
    long[] two = new long[MAX_N + 1];
    two[0] = fact[0] = fact[1] = 1;
    for (int i = 1; i <= MAX_N; i++) {
      two[i] = (two[i - 1] << 1) % MOD;
      fact[i] = (fact[i - 1] * i) % MOD;
    }
    dp[1] = dp[2] = 0;
    for (int i = 3; i <= MAX_N; i++) {
      dp[i] = (fact[i] - two[i - 1] + MOD) % MOD;
    }
    while (t-- > 0) {
      int n = in.ni();
      out.println(dp[n]);
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
    try (CyclicPermutations instance = new CyclicPermutations()) {
      instance.solve();
    }
  }
}
