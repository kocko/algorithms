package codeforces.contests1101_1200.problemset1133;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class KBalancedTeams implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    k = in.ni();
    x = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      x.add(in.ni());
    }
    x.sort(Comparator.naturalOrder());
    dp = new int[n][k];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < k; j++) {
        dp[i][j] = -1;
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, recurse(i, 0));
    }
    out.println(ans);
  }

  private int n, k;
  private List<Integer> x;
  private int[][] dp;

  private int recurse(int first, int team) {
    if (first == n) return 0;
    if (dp[first][team] != -1) return dp[first][team];

    int max = 0;
    for (int next = first; next < n; next++) {
      if (x.get(next) - x.get(first) <= 5) {
        max = Math.max(max, next - first + 1 + recurse(next + 1, team + 1));
      } else {
        max += recurse(next, team + 1);
        break;
      }
    }
    return dp[first][team] = max;
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
    try (KBalancedTeams instance = new KBalancedTeams()) {
      instance.solve();
    }
  }
}
