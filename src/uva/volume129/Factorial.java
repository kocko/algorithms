package uva.volume129;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Factorial implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX_N = (int) 1e5;
    int[] f = {0, 1, 2, 6, 24, 120, 720, 5040, 40320};
    int[] dp = new int[MAX_N + 1];
    for (int idx = 1; idx <= MAX_N; idx++) {
      dp[idx] = 1000;
      for (int jump : f) {
        if (idx - jump >= 0) {
          dp[idx] = Math.min(dp[idx], 1 + dp[idx - jump]);
        }
      }
    }
    while (in.hasNextInt()) {
      int next = in.nextInt();
      out.println(dp[next]);
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (Factorial instance = new Factorial()) {
      instance.solve();
    }
  }
}
