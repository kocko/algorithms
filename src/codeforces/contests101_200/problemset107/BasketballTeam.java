package codeforces.contests101_200.problemset107;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BasketballTeam implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int m = in.ni(), h = in.ni() - 1;

    for (int i = 0; i < m; i++) {
      int current = in.ni();
      if (i == h) {
        p = current;
      }
      total += current;
    }
    if (total-- < n--) {
      out.println(-1);
      return;
    }
    dp = new Double[n][101];
    out.println(recurse(0, --p));
  }

  private int total, n, p;
  private Double[][] dp;

  private double recurse(int idx, int mine) {
    if (idx == n) return mine == p ? 0 : 1;
    if (dp[idx][mine] != null) return dp[idx][mine];

    double totalRemaining = total - idx;
    double prob = (1. * mine) / totalRemaining;

    double takeOther = (1 - prob) * recurse(idx + 1, mine);
    double takeMine = 0d;
    if (mine > 0) {
      takeMine = prob * recurse(idx + 1, mine - 1);
    }
    return dp[idx][mine] = takeOther + takeMine;
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
    try (BasketballTeam instance = new BasketballTeam()) {
      instance.solve();
    }
  }
}
