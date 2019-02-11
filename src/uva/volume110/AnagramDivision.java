package uva.volume110;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AnagramDivision implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      x = in.next();
      d = in.ni();
      MAX = (1 << x.length()) - 1;
      dp = new Integer[MAX][10000];
      out.println(recurse(0, 0));
    }
  }

  private int MAX;
  private String x;
  private int d;

  private Integer[][] dp;

  private Integer recurse(int mask, int remainder) {
    if (mask == MAX) return remainder == 0 ? 1 : 0;

    if (dp[mask][remainder] != null) return dp[mask][remainder];

    int ans = 0;
    for (int digit = 0; digit < 10; digit++) {
      for (int i = 0; i < x.length(); i++) {
        if ((mask & (1 << i)) == 0 && x.charAt(i) - '0' == digit) {
          ans += recurse(mask | (1 << i), (remainder * 10 + digit) % d);
          break;
        }
      }
    }

    return dp[mask][remainder] = ans;
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
    try (AnagramDivision instance = new AnagramDivision()) {
      instance.solve();
    }
  }
}
