package uva.volume103;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class ZerosAndOnes implements Closeable {

  private Scanner in = new Scanner(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int testCase = 1;
    while (in.hasNext()) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      int[] zeroes = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        zeroes[i] = zeroes[i - 1];
        if (x[i - 1] == '0') {
          zeroes[i]++;
        }
      }
      out.printf("Case %d:\n", testCase++);
      int q = in.nextInt();
      while (q-- > 0) {
        int i = in.nextInt(), j = in.nextInt();
        int left = min(i, j) + 1, right = max(i, j) + 1;
        int z = zeroes[right] - zeroes[left - 1];
        out.println(z == right - left + 1 || z == 0 ? "Yes" : "No");
      }
    }
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    try (ZerosAndOnes instance = new ZerosAndOnes()) {
      instance.solve();
    }
  }
}
