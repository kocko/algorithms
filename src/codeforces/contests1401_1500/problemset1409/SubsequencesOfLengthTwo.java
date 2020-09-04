package codeforces.contests1401_1500.problemset1409;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SubsequencesOfLengthTwo implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    s = in.next().toCharArray();
    t = in.next().toCharArray();
    if (t[0] == t[1]) {
      for (int i = 0; i < n && k > 0; i++) {
        if (s[i] != t[0]) {
          s[i] = t[0];
          k--;
        }
      }
      int count = 0;
      for (int i = 0; i < n; i++) {
        if (s[i] == t[0]) {
          count++;
        }
      }
      out.println(count * (count - 1) / 2);
    } else {
      dp = new Integer[n][n][k + 1];
      out.println(recurse(n - 1, 0, k));
    }
  }

  private Integer[][][] dp;
  private char[] s, t;

  private int recurse(int idx, int second, int remaining) {
    if (idx < 0) return 0;

    if (dp[idx][second][remaining] != null) return dp[idx][second][remaining];

    int ans = 0;

    if (remaining > 0) {
      //change to first letter
      if (s[idx] != t[0]) {
        ans = Math.max(ans, second + recurse(idx - 1, second, remaining - 1));
      }
      //change to second letter
      if (s[idx] != t[1]) {
        ans = Math.max(ans, recurse(idx - 1, second + 1, remaining - 1));
      }
    }

    //don't change anything
    //first letter found
    if (s[idx] == t[0]) {
      ans = Math.max(ans, second + recurse(idx - 1, second, remaining));
    }
    //second letter found
    if (s[idx] == t[1]) {
      ans = Math.max(ans, recurse(idx - 1, second + 1, remaining));
    }
    //leave as it is
    if (s[idx] != t[0] && s[idx] != t[1]) {
      ans = Math.max(ans, recurse(idx - 1, second, remaining));
    }

    return dp[idx][second][remaining] = ans;
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
    try (SubsequencesOfLengthTwo instance = new SubsequencesOfLengthTwo()) {
      instance.solve();
    }
  }
}
