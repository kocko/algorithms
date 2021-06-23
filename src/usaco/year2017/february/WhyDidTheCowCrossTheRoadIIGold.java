//package usaco.year2017.february;

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

public class WhyDidTheCowCrossTheRoadIIGold implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public WhyDidTheCowCrossTheRoadIIGold() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public WhyDidTheCowCrossTheRoadIIGold(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni();
    a = new int[n];
    b = new int[n];
    for (int i = 0; i < n; i++) a[i] = in.ni();
    for (int i = 0; i < n; i++) b[i] = in.ni();
    dp = new Integer[n][n];
    out.println(recurse(0, 0));
  }

  private int n;
  private int[] a, b;

  private Integer[][] dp;

  private int recurse(int i, int j) {
    if (i == n || j == n) return 0;

    if (dp[i][j] != null) return dp[i][j];
    int ans = Math.max(recurse(i + 1, j), recurse(i, j + 1));

    if (Math.abs(a[i] - b[j]) <= 4) {
      ans = Math.max(ans, 1 + recurse(i + 1, j + 1));
    }

    return dp[i][j] = ans;
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
    try (WhyDidTheCowCrossTheRoadIIGold instance = new WhyDidTheCowCrossTheRoadIIGold("nocross.in", "nocross.out")) {
      instance.solve();
    }
  }
}
