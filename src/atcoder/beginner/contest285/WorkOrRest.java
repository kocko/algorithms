package atcoder.beginner.contest285;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WorkOrRest implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public WorkOrRest() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    n = in.ni();
    prefix = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      prefix[i] = prefix[i - 1] + in.nl();
    }
    dp = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp[i][j] = -1;
      }
    }
    long result = recurse(1, 0);
    out.println(result);
  }

  private int n;
  private long[] prefix;
  private long[][] dp;

  private long recurse(int idx, int last) {
    if (idx == n) return score(n - last - 1);

    if (dp[idx][last] != -1) return dp[idx][last];

    int len = idx - last - 1;
    long result = Math.max(score(len) + recurse(idx + 1, idx), recurse(idx + 1, last));
    return dp[idx][last] = result;
  }

  private long score(int x) {
    return prefix[x / 2] + prefix[x / 2 + x % 2];
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
    try (WorkOrRest instance = new WorkOrRest()) {
      instance.solve();
    }
  }
}