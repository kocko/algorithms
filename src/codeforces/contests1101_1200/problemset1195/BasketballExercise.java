package codeforces.contests1101_1200.problemset1195;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BasketballExercise implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    h1 = new int[n];
    h2 = new int[n];
    for (int i = 0; i < n; i++) {
      h1[i] = in.ni();
    }
    for (int i = 0; i < n; i++) {
      h2[i] = in.ni();
    }
    dp = new Long[n][3];
    out.println(recurse(0, 0));
  }
  
  private int n;
  private int[] h1, h2;
  
  private Long[][] dp;
  
  private Long recurse(int idx, int last) {
    if (idx == n) return 0L;
    if (dp[idx][last] != null) return dp[idx][last];
    
    long ans = 0;
    if (last == 0) {
      ans = Math.max(h1[idx] + recurse(idx + 1, 1), h2[idx] + recurse(idx + 1, 2));
    } else if (last == 1) {
      ans = Math.max(h2[idx] + recurse(idx + 1, 2), recurse(idx + 1, 0));
    } else if (last == 2) {
      ans = Math.max(h1[idx] + recurse(idx + 1, 1), recurse(idx + 1, 0));
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
    try (BasketballExercise instance = new BasketballExercise()) {
      instance.solve();
    }
  }
}
