package codeforces.contests101_200.problemset155;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.min;

public class Hometask implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    x = in.next().toCharArray();
    forbidden = new int[27];
    for (int i = 0; i <= 26; i++) {
      forbidden[i] = -1;
    }
    int k = in.ni();
    for (int i = 0; i < k; i++) {
      char[] pair = in.next().toCharArray();
      int u = pair[0] - 'a' + 1, v = pair[1] - 'a' + 1;
      forbidden[u] = v;
      forbidden[v] = u;
    }
    dp = new Integer[x.length][27];
    out.println(recurse(0, 0));
  }

  private char[] x;
  private int[] forbidden = new int[27];
  private Integer[][] dp;

  private int recurse(int idx, int last) {
    if (idx == x.length) return 0;

    if (dp[idx][last] != null) return dp[idx][last];

    int ans = 1 + recurse(idx + 1, last);
    int u = x[idx] - 'a' + 1;
    if (forbidden[u] == last) {
      ans = min(ans, 1 + recurse(idx + 1, last));
    } else {
      ans = min(ans, recurse(idx + 1, u));
    }
    return dp[idx][last] = ans;
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
    try (Hometask instance = new Hometask()) {
      instance.solve();
    }
  }
}
