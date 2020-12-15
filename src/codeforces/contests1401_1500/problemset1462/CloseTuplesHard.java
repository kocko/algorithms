package codeforces.contests1401_1500.problemset1462;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CloseTuplesHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni(), k = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      Arrays.sort(x);
      long result = 0;
      int left = 0, right = 0;
      while (right < n) {
        while (left <= right && x[right] - x[left] > k) {
          left++;
        }
        int total = right - left;
        if (total >= m - 1) {
          result += nCk(total, m - 1);
          result %= MOD;
        }
        right++;
      }
      out.println(result);
    }
  }

  private final int MAX_N = (int) 2e5;
  private final long MOD = (long) 1e9 + 7;
  private long[] fact = new long[MAX_N + 1];
  private long[] ifact = new long[MAX_N + 1];

  private void init() {
    fact[0] = ifact[0] = 1L;
    for (int i = 1; i <= MAX_N; i++) {
      fact[i] = fact[i - 1] * i;
      fact[i] %= MOD;
      ifact[i] = power(fact[i], MOD - 2);
    }
  }

  private long power(long a, long b) {
    if (b == 0) return 1L;
    long half = power(a, b >> 1), result = half * half % MOD;
    if (b % 2 == 1) {
      result *= a;
      result %= MOD;
    }
    return result;
  }

  private long nCk(int n, int k) {
    long result = fact[n];
    result *= ifact[k];
    result %= MOD;
    result *= ifact[n - k];
    result %= MOD;
    return result;
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
    try (CloseTuplesHard instance = new CloseTuplesHard()) {
      instance.solve();
    }
  }
}
