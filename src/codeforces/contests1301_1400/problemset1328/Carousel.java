package codeforces.contests1301_1400.problemset1328;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Carousel implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      Set<Integer> set = new HashSet<>();
      type = new int[n];
      for (int i = 0; i < n; i++) {
        type[i] = in.ni();
        set.add(type[i]);
      }
      result = new int[n];
      if (set.size() > 1) {
        dp = new Integer[n][3];
        next = new Integer[n][3];
        int ans = 2 + recurse(0, 0);
        out.println(ans);
        restore();
        for (int i = 0; i < n; i++) {
          if (i == n - 1) {
            out.print(ans == 3 ? 3 : result[i] + 1);
          } else {
            out.print(result[i] + 1);
          }
          out.print(' ');

        }
        out.println();
      } else {
        out.println(1);
        for (int i = 0; i < n; i++) {
          out.print(result[i] + 1);
          out.print(' ');
        }
        out.println();
      }
    }
  }

  private int n;
  private int[] type;
  private Integer[][] dp;
  private Integer[][] next;
  private int[] result;

  private int recurse(int idx, int color) {
    if (idx == n - 1) {
      if (type[0] == type[n - 1]) {
        next[idx][color] = 0;
        return 0;
      } else {
        if (color == 0) {
          next[idx][color] = 1;
          return 1;
        }
      }
      next[idx][color] = 1;
      return 0;
    }

    if (dp[idx][color] != null) return dp[idx][color];

    int ans = Integer.MAX_VALUE;
    int bestNext = 2;
    if (type[idx + 1] != type[idx]) {
      //we must switch the color
      int gain = recurse(idx + 1, color ^ 1);
      if (gain < ans) {
        ans = gain;
        bestNext = color ^ 1;
      }
    } else {
      //we can keep the same color or switch
      int gain = recurse(idx + 1, color ^ 1);
      if (gain < ans) {
        ans = gain;
        bestNext = color ^ 1;
      }
      gain = recurse(idx + 1, color);
      if (gain < ans) {
        ans = gain;
        bestNext = color;
      }
    }

    next[idx][color] = bestNext;
    return dp[idx][color] = ans;
  }

  private void restore() {
    int idx = 0, color = 0;
    while (idx < n) {
      result[idx] = color;
      color = next[idx][color];
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
    try (Carousel instance = new Carousel()) {
      instance.solve();
    }
  }
}
