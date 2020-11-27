package uva.volume106;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BuyingCoke implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      cokes = in.ni();
      int one = in.ni(), five = in.ni(), ten = in.ni();
      totalMoney = one + five * 5 + ten * 10;
      dp = new Integer[cokes][five + ten + 1][ten + 1];
      out.println(recurse(0, five, ten));
    }
  }

  private int totalMoney, cokes;

  private Integer[][][] dp;

  private int recurse(int idx, int five, int ten) {
    if (idx == cokes) return 0;

    if (dp[idx][five][ten] != null) return dp[idx][five][ten];

    int have = totalMoney - 8 * idx;
    int ones = have - 5 * five - 10 * ten;
    int ans = Integer.MAX_VALUE;
    //insert a ten
    if (ten > 0) {
      ans = Math.min(ans, 1 + recurse(idx + 1, five, ten - 1));
    }
    //insert two fives
    if (five >= 2) {
      ans = Math.min(ans, 2 + recurse(idx + 1, five - 2, ten));
    }
    //insert a five + three ones
    if (five > 0 && ones >= 3) {
      ans = Math.min(ans, 4 + recurse(idx + 1, five - 1, ten));
    }
    //insert eight ones
    if (ones >= 8) {
      ans = Math.min(ans, 8 + recurse(idx + 1, five, ten));
    }
    //insert a ten + three ones
    if (ten > 0 && ones >= 3) {
      ans = Math.min(ans, 4 + recurse(idx + 1, five + 1, ten - 1));
    }
    return dp[idx][five][ten] = ans;
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
    try (BuyingCoke instance = new BuyingCoke()) {
      instance.solve();
    }
  }
}
