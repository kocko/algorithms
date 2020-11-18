package uva.volume118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AccountBook implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX_SUM = 40000;
    while ((n = in.ni()) != 0 | (f = in.ni()) != 0) {
      f += MAX_SUM;
      x = new int[n];
      info = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      dp = new Boolean[n][2][80005];

      boolean possible = false;
      if (recurse(1, 0, MAX_SUM - x[0])) {
        possible = true;
        info[0] = 1;
      }
      if (recurse(1, 1, MAX_SUM + x[0])) {
        possible = true;
        info[0] |= 2;
      }
      if (possible) {
        for (int i = 0; i < n; i++) {
          if (info[i] == 3) {
            out.print('?');
          } else if (info[i] == 2) {
            out.print('+');
          } else {
            out.print('-');
          }
        }
        out.println();
      } else {
        out.println('*');
      }
    }
  }

  private int n, f;
  private int[] x;
  private int[] info;
  private Boolean[][][] dp;

  private boolean recurse(int idx, int positive, int sum) {
    if (idx == n) return sum == f;

    if (dp[idx][positive][sum] != null) return dp[idx][positive][sum];

    boolean ans = false;
    if (recurse(idx + 1, 0, sum - x[idx])) {
      ans = true;
      info[idx] |= 1;
    }
    if (recurse(idx + 1, 1, sum + x[idx])) {
      ans = true;
      info[idx] |= 2;
    }

    return dp[idx][positive][sum] = ans;
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
    try (AccountBook instance = new AccountBook()) {
      instance.solve();
    }
  }
}
