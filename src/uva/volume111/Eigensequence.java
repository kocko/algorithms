package uva.volume111;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Eigensequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int first;
    while ((first = in.ni()) != 0 | (last = in.ni()) != 0) {
      dp = new Integer[45];
      int ans = recurse(first);
      out.printf("%d %d %d\n", first, last, ans);
    }
  }

  private int last;
  private Integer[] dp;

  private int recurse(int idx) {
    if (idx == last) return 1;

    if (dp[idx] != null) return dp[idx];

    int ans = 0;
    for (int delta = 1; delta <= last; delta++) {
      if (idx + delta <= last && (idx + delta) % delta == 0) {
        ans += recurse(idx + delta);
      }
    }
    return dp[idx] = ans;
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
    try (Eigensequence instance = new Eigensequence()) {
      instance.solve();
    }
  }
}
