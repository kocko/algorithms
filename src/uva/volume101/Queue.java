package uva.volume101;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Queue implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Queue() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    calculate();
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), l = in.ni(), r = in.ni();
      out.println(dp[n][l][r]);
    }
  }

  private final int MAX_N = 15;
  private int[][][] dp;

  private void calculate() {
    dp = new int[MAX_N][MAX_N][MAX_N];
    dp[1][1][1] = 1;
    for (int n = 2; n < MAX_N; n++) {
      for (int l = 1; l <= n; l++) {
        for (int r = 1; r <= n; r++) {
          dp[n][l][r] = dp[n - 1][l][r] * (n - 2) + dp[n - 1][l - 1][r] + dp[n - 1][l][r - 1];
        }
      }
    }
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
    try (Queue instance = new Queue()) {
      instance.solve();
    }
  }
}
