package uva.volume012;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.min;

public class AGTC implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while (in.hasNextInt()) {
      n = in.nextInt();
      x = in.next().toCharArray();
      m = in.nextInt();
      y = in.next().toCharArray();
      dp = new Integer[n][m];
      out.println(recurse(0, 0));
    }
  }

  private int n, m;
  private char[] x, y;
  private Integer[][] dp;

  private Integer recurse(int i, int j) {
    if (i == n) return (m - j);
    if (j == m) return (n - i);
    if (dp[i][j] != null) return dp[i][j];

    int ans;
    if (x[i] == y[j]) {
      ans = recurse(i + 1, j + 1);
    } else {
      int change = 1 + recurse(i + 1, j + 1);
      int delete = 1 + min(recurse(i + 1, j), recurse(i, j + 1));
      ans = min(change, delete);
    }
    return dp[i][j] = ans;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (AGTC instance = new AGTC()) {
      instance.solve();
    }
  }
}
