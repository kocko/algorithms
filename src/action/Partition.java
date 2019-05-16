package action;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Partition implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX = 100000, MOD = (int) 1e9 + 7;
    int[] dp = new int[MAX + 1];
    int[] prefix = new int[MAX + 1];
    dp[3] = prefix[3] = 1;
    for (int idx = 4; idx <= MAX; idx++) {
      dp[idx] = 1 + prefix[idx - 3];
      dp[idx] %= MOD;
      prefix[idx] = prefix[idx - 1] + dp[idx];
      prefix[idx] %= MOD;
    }
    out.println(dp[in.ni()]);
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
    try (Partition instance = new Partition()) {
      instance.solve();
    }
  }
}
