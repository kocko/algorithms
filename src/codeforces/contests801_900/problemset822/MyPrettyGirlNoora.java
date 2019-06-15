package codeforces.contests801_900.problemset822;

import java.io.*;
import java.util.StringTokenizer;

public class MyPrettyGirlNoora implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    sieve();
    int t = in.ni(), left = in.ni(), right = in.ni();
    long ans = 0;
    long multiplier = 1;
    for (int i = left; i <= right; i++, multiplier = (multiplier * t) % MOD) {
      ans = (ans + (multiplier * recurse(i)) % MOD) % MOD;
    }
    out.println(ans);
  }
  
  private int MAX_N = 5000000;
  private int[] divisor = new int[MAX_N + 1];
  
  private void sieve() {
    for (int i = 0; i <= MAX_N; i++) {
      divisor[i] = i;
    }
    int limit = (int) Math.sqrt(MAX_N);
    for (int i = 2; i <= MAX_N; i++) {
      if (divisor[i] == i) {
        if (i <= limit) {
          for (int j = i * i; j <= MAX_N; j += i) {
            divisor[j] = Math.min(divisor[j], i);
          }
        }
      }
    }
  }
  
  private final int MOD = (int) 1e9 + 7;
  private Long[] dp = new Long[MAX_N + 1];
  
  private long recurse(int p) {
    if (p == 1) return 0;
    
    if (dp[p] != null) return dp[p];
    
    long groups = p / divisor[p], size = divisor[p];
    long ans = groups * (size * (size - 1)) / 2;
    ans += recurse(p / divisor[p]);
    
    return dp[p] = ans % MOD;
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
    try (MyPrettyGirlNoora instance = new MyPrettyGirlNoora()) {
      instance.solve();
    }
  }
}
