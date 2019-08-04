package codeforces.gyms.gym102219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OptimalSlots implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    while ((t = in.ni()) != 0) {
      n = in.ni();
      events = new int[n];
      for (int i = 0; i < n; i++) {
        events[i] = in.ni();
      }
      dp = new Integer[n][t + 1];
      next = new Integer[n][t + 1];
      int ans = recurse(0, t);
      if (ans > 0) {
        restore();
      }
      out.println(ans);
    }
  }
  
  private int n, t;
  private int[] events;
  private Integer[][] dp;
  private Integer[][] next;
  
  private int recurse(int idx, int remaining) {
    if (idx == n) return 0;
    
    if (dp[idx][remaining] != null) return dp[idx][remaining];
    
    int ans = 0;
    
    if (remaining >= events[idx]) {
      int take = events[idx] + recurse(idx + 1, remaining - events[idx]);
      if (take > ans) {
        ans = take;
        next[idx][remaining] = remaining - events[idx];
      }
    }
    int skip = recurse(idx + 1, remaining);
    if (skip > ans) {
      ans = skip;
      next[idx][remaining] = remaining;
    }
    return dp[idx][remaining] = ans;
  }
  
  private void restore() {
    int idx = 0, remaining = t;
    while (idx < n && remaining > 0) {
      if (next[idx][remaining] != null && next[idx][remaining] != remaining) {
        out.print(events[idx]);
        out.print(' ');
        remaining = next[idx][remaining];
      }
      idx++;
    }
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
    try (OptimalSlots instance = new OptimalSlots()) {
      instance.solve();
    }
  }
}
