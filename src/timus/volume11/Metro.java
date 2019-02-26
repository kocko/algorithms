package timus.volume11;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Metro implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    m = in.ni();
    dp = new Double[n + 1][m + 1];
    int k = in.ni();
    for (int i = 0; i < k; i++) {
      int x = in.ni() - 1, y = in.ni() - 1;
      Set<Integer> set = diagonal.getOrDefault(x, new HashSet<>());
      set.add(y);
      diagonal.put(x, set);
    }
    out.println((int) Math.round(recurse(0, 0)));
  }

  private int n, m;
  private final double d = Math.sqrt(20000);
  private Map<Integer, Set<Integer>> diagonal = new HashMap<>();
  private Double[][] dp;

  private Double recurse(int x, int y) {
    if (x == n && y == m) return 0d;

    if (dp[x][y] != null) return dp[x][y];

    double ans = (double) Integer.MAX_VALUE;
    if (x + 1 <= n) ans = Math.min(ans, 100d + recurse(x + 1, y));
    if (y + 1 <= m) ans = Math.min(ans, 100d + recurse(x, y + 1));
    if (diagonal.containsKey(x) && diagonal.get(x).contains(y)) {
      if (x + 1 <= n && y + 1 <= m) {
        ans = Math.min(ans, d + recurse(x + 1, y + 1));
      }
    }
    return dp[x][y] = ans;
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
    try (Metro instance = new Metro()) {
      instance.solve();
    }
  }
}
