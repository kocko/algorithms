package uva.volume012;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.max;

public class ICPCTeamStrategy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      a = new int[n];
      b = new int[n];
      c = new int[n];
      for (int i = 0; i < n; i++) a[i] = in.ni();
      for (int i = 0; i < n; i++) b[i] = in.ni();
      for (int i = 0; i < n; i++) c[i] = in.ni();
      dp = new Integer[281][1 << n][3];
      int result = 0;
      for (int task = 0; task < n; task++) {
        if (a[task] <= 280) result = max(result, 1 + recurse(a[task], 1 << task, 0));
        if (b[task] <= 280) result = max(result, 1 + recurse(b[task], 1 << task, 1));
        if (c[task] <= 280) result = max(result, 1 + recurse(c[task], 1 << task, 2));
      }
      out.println(result);
    }
  }

  private int n;
  private int[] a, b, c;
  private Integer[][][] dp;

  private int recurse(int time, int mask, int last) {
    if (time >= 280) return 0;
    if (dp[time][mask][last] != null) return dp[time][mask][last];

    int count = 0;
    for (int task = 0; task < n; task++) {
      if ((mask & (1 << task)) == 0) {
        if (last == 0) {
          if (time + b[task] <= 280) count = max(count, 1 + recurse(time + b[task], mask | (1 << task), 1));
          if (time + c[task] <= 280) count = max(count, 1 + recurse(time + c[task], mask | (1 << task), 2));
        } else if (last == 1) {
          if (time + a[task] <= 280) count = max(count, 1 + recurse(time + a[task], mask | (1 << task), 0));
          if (time + c[task] <= 280) count = max(count, 1 + recurse(time + c[task], mask | (1 << task), 2));
        } else if (last == 2) {
          if (time + a[task] <= 280) count = max(count, 1 + recurse(time + a[task], mask | (1 << task), 0));
          if (time + b[task] <= 280) count = max(count, 1 + recurse(time + b[task], mask | (1 << task), 1));
        }
      }
    }
    return dp[time][mask][last] = count;
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
    try (ICPCTeamStrategy instance = new ICPCTeamStrategy()) {
      instance.solve();
    }
  }
}
