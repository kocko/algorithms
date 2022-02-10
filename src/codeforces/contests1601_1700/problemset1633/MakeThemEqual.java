package codeforces.contests1601_1700.problemset1633;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeThemEqual implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MakeThemEqual() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    init();
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      int k = Math.min(in.ni(), MAX_K);
      b = new int[n];
      c = new int[n];
      for (int i = 0; i < n; i++) {
        b[i] = in.ni();
      }
      for (int i = 0; i < n; i++) {
        c[i] = in.ni();
      }
      dp = new int[n][k + 1];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j <= k; j++) {
          dp[i][j] = -1;
        }
      }
      out.println(recurse(0, k));
    }
  }

  private int n;
  private final int MAX_N = 1000, MAX_K = 12000;
  private int[] cost = new int[MAX_N + 1];
  private int[] b, c;

  private void init() {
    Arrays.fill(cost, MAX_N + 5);
    cost[1] = 0;
    for (int i = 1; i <= MAX_N; i++) {
      for (int x = 1; x <= i; x++) {
        int where = i + i / x;
        if (where <= MAX_N) {
          cost[where] = Math.min(cost[where], cost[i] + 1);
        }
      }
    }
  }

  private int[][] dp;

  private int recurse(int idx, int remaining) {
    if (idx == n) return 0;

    if (dp[idx][remaining] != -1) return dp[idx][remaining];

    int score = recurse(idx + 1, remaining);
    if (remaining >= cost[b[idx]]) {
      score = Math.max(score, c[idx] + recurse(idx + 1, remaining - cost[b[idx]]));
    }
    return dp[idx][remaining] = score;
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
    try (MakeThemEqual instance = new MakeThemEqual()) {
      instance.solve();
    }
  }
}
