package codeforces.contests1301_1400.problemset1324;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SleepingSchedule implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    a = new int[n];

    day = in.ni();
    left = in.ni();
    right = in.ni();
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
    }
    dp = new Integer[2001][2001];
    out.println(recurse(0, 0));
  }

  private int n, day, left, right;
  private int[] a;
  private Integer[][] dp;

  private Integer recurse(int idx, int hour) {
    if (idx == n) return 0;

    if (dp[idx][hour] != null) return dp[idx][hour];

    int w1 = (hour + a[idx] - 1 + day) % day;
    int w2 = (hour + a[idx]) % day;
    int gain1 = w1 >= left && w1 <= right ? 1 : 0;
    int gain2 = w2 >= left && w2 <= right ? 1 : 0;
    return dp[idx][hour] = Math.max(gain1 + recurse(idx + 1, w1), gain2 + recurse(idx + 1, w2));
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
    try (SleepingSchedule instance = new SleepingSchedule()) {
      instance.solve();
    }
  }
}
