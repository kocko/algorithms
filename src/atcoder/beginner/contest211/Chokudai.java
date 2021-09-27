package atcoder.beginner.contest211;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class Chokudai implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Chokudai() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Chokudai(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    a = in.next().toCharArray();
    dp = new Long[a.length][9];
    out.println(recurse(0, 0));
  }

  private final long MOD = (long) 1e9 + 7;
  private final char[] x = "chokudai".toCharArray();
  private char[] a;

  private Long[][] dp;

  private long recurse(int idx, int target) {
    if (idx == a.length) return (target == 8) ? 1 : 0;

    if (dp[idx][target] != null) return dp[idx][target];

    long ans = 0;
    if (target < 8) {
      if (a[idx] == x[target]) {
        ans += recurse(idx + 1, target + 1);
        ans %= MOD;
      }
    }
    ans += recurse(idx + 1, target);
    ans %= MOD;
    return dp[idx][target] = ans;
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
    try (Chokudai instance = new Chokudai()) {
      instance.solve();
    }
  }
}
