package codeforces.contests501_600.problemset546;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SoldierAndNumberGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int t = in.ni();
    while (t-- > 0) {
      out.println(prefix[in.ni()] - prefix[in.ni()]);
    }
  }

  private final int MAX_N = (int) 5e6;
  private int[] sieve = new int[MAX_N + 1];
  private int[] dp = new int[MAX_N + 1];
  private int[] prefix = new int[MAX_N + 1];

  private void init() {
    for (int i = 1; i <= MAX_N; i++) {
      sieve[i] = i;
    }
    for (int i = 2; i <= MAX_N; i++) {
      if (sieve[i] == i) {
        for (long j = (long) i * i; j <= MAX_N; j += i) {
          sieve[(int) j] = i;
        }
        dp[i] = 1;
      }
    }
    for (int i = 1; i <= MAX_N; i++) {
      if (dp[i] == 0) {
        dp[i] = dp[i / sieve[i]] + 1;
      }
    }
    for (int i = 1; i <= MAX_N; i++) {
      prefix[i] = prefix[i - 1] + dp[i];
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
    try (SoldierAndNumberGame instance = new SoldierAndNumberGame()) {
      instance.solve();
    }
  }
}
