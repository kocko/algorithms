package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AdaAndTeams implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    init();
    while (in.hasNextInt()) {
      int n = in.nextInt(), a = in.nextInt(), b = in.nextInt(), d = in.nextInt();
      out.println(nCk(n, a) * power(nCk(b, d), a) % MOD);
    }
  }
  
  private final int MAX_N = (int) 1e6;
  private final int MOD = (int) 1e9 + 7;
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

  public static void main(String[] args) throws IOException {
    try (AdaAndTeams instance = new AdaAndTeams()) {
      instance.solve();
    }
  }
}
