package uva.volume112;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Long.max;

public class StringPartition implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      x = in.next().toCharArray();
      dp = new Long[x.length][x.length];
      out.println(recurse(0, 0));
    }
  }

  private char[] x;
  private Long[][] dp;

  private Long recurse(int start, int end) {
    if (end == x.length) return 0L;
    if (dp[start][end] != null) return dp[start][end];

    if (start < end && x[start] == '0') return 0L;

    long result = 0L;
    for (int i = start; i <= end; i++) {
      result *= 10;
      result += (x[i] - '0');
    }
    if (result <= MAX_VALUE) {
      result = max(recurse(start, end + 1), result + recurse(end + 1, end + 1));
    } else {
      result = 0;
    }

    return dp[start][end] = result;
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
    try (StringPartition instance = new StringPartition()) {
      instance.solve();
    }
  }
}
