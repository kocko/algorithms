package atcoder.beginner.contest160;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DistributingIntegers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    tree = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      tree.add(new ArrayList<>());
    }
    for (int i = 1; i < n; i++) {
      int u = in.ni(), v = in.ni();
      tree.get(u).add(v);
      tree.get(v).add(u);
    }
    size = new int[n + 1];
    fact = new long[n + 1];
    fact[0] = fact[1] = 1;
    for (int i = 2; i <= n; i++) {
      fact[i] = fact[i - 1] * i;
      fact[i] %= MOD;
    }
    dfs(1, 0);

    dp = new long[n + 1];
    dp(1, 0);

    ans = new long[n + 1];
    reroot(1, 0);
    for (int i = 1; i <= n; i++) {
      out.println(ans[i]);
    }
  }

  private List<List<Integer>> tree;

  private final long MOD = (int) 1e9 + 7;
  private int[] size;
  private long[] fact;
  private long[] dp;

  private void dfs(int u, int p) {
    size[u] = 1;
    for (int v : tree.get(u)) {
      if (v != p) {
        dfs(v, u);
        size[u] += size[v];
      }
    }
  }

  private void dp(int u, int p) {
    dp[u] = fact[size[u] - 1];
    for (int v : tree.get(u)) {
      if (v != p) {
        dp(v, u);
        dp[u] = (dp[u] * dp[v]) % MOD;
        dp[u] = (dp[u] * power(fact[size[v]], MOD - 2)) % MOD;
      }
    }
  }

  private long power(long a, long b) {
    if (b == 0) return 1;
    if (b == 1) return a;

    long half = power(a, b / 2);
    long ans = half * half % MOD;
    if (b % 2 == 1) {
      ans *= a;
      ans %= MOD;
    }
    return ans;
  }

  private long[] ans;

  private void reroot(int u, int p) {
    ans[u] = dp[u];
    for (int v : tree.get(u)) {
      if (v != p) {
        long dp_u = dp[u];
        int size_u = size[u];
        long dp_v = dp[v];
        int size_v = size[v];

        size[u] -= size_v;
        dp[u] = (dp[u] * power(fact[size_u - 1], MOD - 2)) % MOD;
        dp[u] = (dp[u] * fact[size[u] - 1]) % MOD;
        dp[u] = (dp[u] * power(dp_v, MOD - 2)) % MOD;
        dp[u] = (dp[u] * fact[size_v]) % MOD;

        size[v] += size[u];
        dp[v] = (dp[v] * power(fact[size_v - 1], MOD - 2)) % MOD;
        dp[v] = (dp[v] * fact[size[v] - 1]) % MOD;
        dp[v] = (dp[v] * dp[u]) % MOD;
        dp[v] = (dp[v] * power(fact[size[u]], MOD - 2)) % MOD;

        reroot(v, u);

        dp[u] = dp_u;
        size[u] = size_u;
        dp[v] = dp_v;
        size[v] = size_v;
      }
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
    try (DistributingIntegers instance = new DistributingIntegers()) {
      instance.solve();
    }
  }
}
