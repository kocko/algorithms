package atcoder.beginner.contest163;

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

public class ActiveInfants implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    for (int i = 0; i < n; i++) {
      children.add(new Child(i, in.ni()));
    }
    children.sort(Comparator.comparingLong(c -> -c.activeness));
    dp = new Long[n][n];
    out.println(recurse(0, 0));
  }

  private class Child {
    private int pos;
    private long activeness;

    private Child(int pos, long activeness) {
      this.pos = pos;
      this.activeness = activeness;
    }
  }

  private int n;
  private List<Child> children = new ArrayList<>();
  private Long[][] dp;

  private long recurse (int idx, int left) {
    if (idx == n) return 0;

    if (dp[idx][left] != null) return dp[idx][left];

    int position = children.get(idx).pos;
    long activeness = children.get(idx).activeness;
    int right = n - 1 - (idx - left);
    //place on the left
    int d1 = Math.abs(position - left);
    long ans = d1 * activeness + recurse(idx + 1, left + 1);

    //place on the right
    int d2 = Math.abs(right - position);
    ans = Math.max(ans, d2 * activeness + recurse(idx + 1, left));

    return dp[idx][left] = ans;
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
    try (ActiveInfants instance = new ActiveInfants()) {
      instance.solve();
    }
  }
}
