package acm.regionals.year2010.africa.middleeast;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class TriGraphs implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int testCase = 1, n;
    while ((n = in.ni()) != 0) {
      int[][] graph = new int[n][3];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
          graph[i][j] = in.ni();
        }
      }
      out.printf("%d. %d\n", testCase++, dp(graph));
    }
  }

  private long dp(int[][] graph) {
    int n = graph.length;
    long[] dp = new long[3];
    dp[0] = graph[n - 1][0] + graph[n - 1][1];
    dp[1] = graph[n - 1][1];
    dp[2] = Integer.MAX_VALUE;

    for (int row = n - 2; row >= 0; row--) {
      long[] next = new long[3];

      next[2] = graph[row][2] + min(dp[1], dp[2]);
      next[1] = graph[row][1] + min(next[2], min(min(dp[0], dp[1]), dp[2]));
      next[0] = graph[row][0] + min(next[1], min(dp[0], dp[1]));
      dp = next;
    }
    return dp[1];
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
    try (TriGraphs instance = new TriGraphs()) {
      instance.solve();
    }
  }
}
