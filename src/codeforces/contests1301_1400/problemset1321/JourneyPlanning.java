package codeforces.contests1301_1400.problemset1321;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class JourneyPlanning implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long[] b = new long[n];
    for (int i = 0; i < n; i++) {
      b[i] = in.nl();
    }
    long[] cost = new long[n];
    for (int i = 0; i < n; i++) {
      cost[i] = i + 1 - b[i];
    }
    Map<Long, Integer> closest = new HashMap<>();
    long[] dp = new long[n];
    long max = 0;
    for (int i = n - 1; i >= 0; i--) {
      int next = closest.getOrDefault(cost[i], -1);
      if (next == -1) {
        dp[i] = b[i];
      } else {
        dp[i] = b[i] + dp[next];
      }
      closest.put(cost[i], i);
      max = Math.max(max, dp[i]);
    }
    out.println(max);
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
    try (JourneyPlanning instance = new JourneyPlanning()) {
      instance.solve();
    }
  }
}
