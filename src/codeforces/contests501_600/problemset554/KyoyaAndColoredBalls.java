package codeforces.contests501_600.problemset554;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KyoyaAndColoredBalls implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int k = in.ni();
    int[] color = new int[k];
    for (int i = 0; i < k; i++) {
      color[i] = in.ni();
    }
    final int MOD = (int) 1e9 + 7, MAX_N = 1001;
    int[][] binom = new int[MAX_N][MAX_N];
    binom[0][0] = 1;
    for (int i = 1; i < MAX_N; i++) {
      binom[i][0] = 1;
      for (int j = 1; j <= i; j++) {
        binom[i][j] = (binom[i - 1][j] + binom[i - 1][j - 1]) % MOD;
      }
    }
    
    long result = 1;
    int total = 0;
    for (int i = 0; i < k; i++) {
      result = (result * binom[total + color[i] - 1][color[i] - 1]) % MOD;
      total += color[i];
    }
    out.println(result);
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
    try (KyoyaAndColoredBalls instance = new KyoyaAndColoredBalls()) {
      instance.solve();
    }
  }
}
