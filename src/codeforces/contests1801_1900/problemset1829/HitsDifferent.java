package codeforces.contests1801_1900.problemset1829;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class HitsDifferent implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public HitsDifferent() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    init();
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      out.println(resultFor(n));
    }
  }

  private final int MAX_N = 2023;
  private long[][] dp = new long[MAX_N + 1][MAX_N + 1];
  private Map<Integer, int[]> where = new HashMap<>();

  private void init() {
    dp[1][1] = 1;
    where.put(1, new int[]{1, 1});
    int number = 2;
    for (int row = 2; row <= MAX_N; row++) {
      for (int col = 1; col <= row; col++, number++) {
        where.put(number, new int[]{row, col});
        dp[row][col] = 1L * number * number + dp[row - 1][col - 1] + dp[row - 1][col] - dp[row - 2][col - 1];
      }
    }
  }

  private long resultFor(int n) {
    int[] cell = where.get(n);
    return dp[cell[0]][cell[1]];
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
    try (HitsDifferent instance = new HitsDifferent()) {
      instance.solve();
    }
  }
}
