package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class Smiley1807 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] input = in.next().toCharArray();
    char[] index = {'1', '8', '0', '7'};
    n = input.length;
    x = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 4; j++) {
        if (input[i] == index[j]) {
          x[i] = j;
          break;
        }
      }
    }
    dp = new Integer[n][5];
    out.println(Math.max(0, recurse(0, 0)));
  }

  private int n;
  private int[] x;
  private Integer[][] dp;

  private Integer recurse(int idx, int last) {
    if (idx == n) return last == 4 ? 0 : -(int) 1e6;

    if (dp[idx][last] != null) return dp[idx][last];

    int result = recurse(idx + 1, last);
    if (x[idx] == last) {
      int best = 1 + max(result, recurse(idx + 1, (last + 1) % 5));
      result = max(result, best);
    }

    return dp[idx][last] = result;
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
    try (Smiley1807 instance = new Smiley1807()) {
      instance.solve();
    }
  }
}
