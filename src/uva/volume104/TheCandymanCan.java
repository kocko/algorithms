package uva.volume104;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheCandymanCan implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    for (int testCase = 1; testCase <= T; testCase++) {
      n = in.ni();
      candies = new int[n];
      prefix = new int[n];
      for (int i = 0; i < n; i++) {
        candies[i] = in.ni();
        prefix[i] = candies[i];
        if (i > 0) {
          prefix[i] += prefix[i - 1];
        }
      }
      dp = new Integer[n][641][641];
      int result = recurse(0, 0, 0);
      out.printf("Case %d: %d\n", testCase, result);
    }
  }

  private int n;
  private int[] candies;
  private int[] prefix;
  private Integer[][][] dp;

  private int recurse(int idx, int max, int min) {
    if (idx == n) return max - min;

    if (dp[idx][max][min] != null) return dp[idx][max][min];

    int ans = Integer.MAX_VALUE;
    int middle = prefix[idx] - max - min - candies[idx];
    //give to max
    ans = Math.min(ans, recurse(idx + 1, max + candies[idx], min));
    //give to middle
    if (middle + candies[idx] > max) {
      ans = Math.min(ans, recurse(idx + 1, candies[idx] + middle, min));
    } else {
      ans = Math.min(ans, recurse(idx + 1, max, min));
    }
    //give to min
    if (min + candies[idx] > middle) {
      ans = Math.min(ans, recurse(idx + 1, Math.max(max, min + candies[idx]), middle));
    } else {
      ans = Math.min(ans, recurse(idx + 1, max, min + candies[idx]));
    }
    return dp[idx][max][min] = ans;
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
    try (TheCandymanCan instance = new TheCandymanCan()) {
      instance.solve();
    }
  }
}
