package codeforces.contests1701_1800.problemset1703;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class GoodKeyBadKey implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      k = in.nl();
      x = new long[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.nl();
      }
      dp = new Long[n][MAX_SHIFTS];
      out.println(recurse(0, 0));
    }
  }

  private final int MAX_SHIFTS = 30;

  private int n;
  private long k;
  private long[] x;
  private Long[][] dp;

  private long recurse(int idx, int shifts) {
    if (idx == n) return 0L;

    if (dp[idx][shifts] != null) return dp[idx][shifts];

    long result = 0;

    //apply previous usages of a bad key
    long take = (x[idx] >> shifts);

    //buy a good key and use it
    result = Math.max(result, take - k + recurse(idx + 1, shifts));

    //get a bad key and use it
    if (shifts + 1 < MAX_SHIFTS) {
      result = Math.max(result, (take >> 1L) + recurse(idx + 1, shifts + 1));
    }
    return dp[idx][shifts] = result;
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
    try (GoodKeyBadKey instance = new GoodKeyBadKey()) {
      instance.solve();
    }
  }
}