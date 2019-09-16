package codeforces.contests601_700.problemset687;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class TheValuesYouCanMake implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    int price = in.ni();
    x = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
    }
    int k = price / 2 + price % 2;
    dp = new int[n][k + 1][price + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= k; j++) {
        for (int l = 0; l <= price; l++) {
          dp[i][j][l] = -1;
        }
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int target = 0; target <= price - target; target++) {
      if (recurse(0, target, price - target) == 1) {
        result.add(target);
        if (price - target != target) {
          result.add(price - target);
        }
      }
    }
    result.sort(Comparator.naturalOrder());
    out.println(result.size());
    for (int p : result) {
      out.print(p);
      out.print(' ');
    }
  }

  private int n;
  private int[] x;
  private int[][][] dp;

  private int recurse(int idx, int a, int b) {
    if (idx == n) return a == 0 && b == 0 ? 1 : 0;

    if (dp[idx][a][b] != -1) return dp[idx][a][b];

    int result = recurse(idx + 1, a, b);
    if (a >= x[idx]) {
      result |= recurse(idx + 1, a - x[idx], b);
    }
    if (b >= x[idx]) {
      result |= recurse(idx + 1, a, b - x[idx]);
    }
    return dp[idx][a][b] = result;
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
    try (TheValuesYouCanMake instance = new TheValuesYouCanMake()) {
      instance.solve();
    }
  }
}
