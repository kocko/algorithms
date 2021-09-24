package atcoder.beginner.contest219;

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

public class StrangeLunchbox implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public StrangeLunchbox() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public StrangeLunchbox(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    n = in.ni();
    x = in.ni();
    y = in.ni();
    a = new int[n];
    b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
      b[i] = in.ni();
    }
    dp = new int[MAX_N + 1][MAX_N + 1][MAX_N + 1];
    for (int i = 0; i <= MAX_N; i++) {
      for (int j = 0; j <= MAX_N; j++) {
        for (int k = 0; k <= MAX_N; k++) {
          dp[i][j][k] = -1;
        }
      }
    }
    int result = recurse(0, 0, 0);
    out.println(result >= oo ? -1 : result);
  }

  private final int oo = 1000, MAX_N = 300;
  private int n, x, y;
  private int[] a, b;
  private int[][][] dp;

  private int recurse(int idx, int octopus, int cake) {
    if (idx == n) return (octopus == x && cake == y) ? 0 : oo;

    if (dp[idx][octopus][cake] != -1) return dp[idx][octopus][cake];

    int take = 1 + recurse(idx + 1, min(octopus + a[idx], x), min(cake + b[idx], y));
    int skip = recurse(idx + 1, octopus, cake);

    return dp[idx][octopus][cake] = min(take, skip);
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
    try (StrangeLunchbox instance = new StrangeLunchbox()) {
      instance.solve();
    }
  }
}
