package uva.volume114;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BusyProgrammer implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int testCase = 1;
    int total;
    while ((total = in.ni()) != -1 | (max = in.ni()) != -1) {
      dp = new Long[total + 1][total + 1][2];
      long ans = 0;
      if (total > 0) {
        ans = recurse(total, total, 0) << 1;
      }
      out.printf("Case %d: %d\n", testCase++, ans);
    }
  }

  private int max;
  private Long[][][] dp;

  private long recurse(int a, int b, int type) {
    if (a > 0 && b == 0) return 0;
    if (a == 0 && b == 0) return 1;

    if (dp[a][b][type] != null) return dp[a][b][type];

    long ans = 0;
    if (type == 0) {
      for (int take = 1; take <= max; take++) {
        if (a >= take) {
          ans += recurse(a - take, b, 1);
        }
      }
    } else {
      if (a > 0) {
        for (int take = 1; take <= max; take++) {
          if (b >= take) {
            ans += recurse(a, b - take, 0);
          }
        }
      } else {
        ans++;
      }
    }

    return dp[a][b][type] = ans;
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
    try (BusyProgrammer instance = new BusyProgrammer()) {
      instance.solve();
    }
  }
}
