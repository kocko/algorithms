package atcoder.beginner.contest212;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SafetyJourney implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SafetyJourney() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public SafetyJourney(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    final long MOD = 998244353;
    int n = in.ni(), m = in.ni(), k = in.ni();
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni() - 1, v = in.ni() - 1;
      graph.get(u).add(v);
      graph.get(v).add(u);
    }
    long[] dp = new long[n];
    dp[0] = 1;
    long prevSum = 1;
    for (int i = 1; i <= k; i++) {
      long[] dp2 = new long[n];
      long sum = 0;
      for (int u = 0; u < n; u++) {
        dp2[u] = (prevSum - dp[u] + MOD) % MOD;
        for (int v : graph.get(u)) {
          dp2[u] = (dp2[u] - dp[v] + MOD) % MOD;
        }
        sum += dp2[u];
        sum %= MOD;
      }
      dp = dp2;
      prevSum = sum;
    }
    out.println(dp[0]);
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
    try (SafetyJourney instance = new SafetyJourney()) {
      instance.solve();
    }
  }
}
