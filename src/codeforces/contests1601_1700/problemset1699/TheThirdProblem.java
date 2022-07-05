package codeforces.contests1601_1700.problemset1699;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TheThirdProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final long MOD = (long) 1e9 + 7;
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] pos = new int[n];
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        pos[next] = i;
      }

      long result = 1L;
      if (n > 1) {
        int left = min(pos[0], pos[1]), right = max(pos[0], pos[1]);
        for (int i = 2; i < n; i++) {
          int where = pos[i];
          if (where > left && where < right) {
            result *= ((right - left + 1L) - i);
            result %= MOD;
          } else {
            left = min(left, pos[i]);
            right = max(right, pos[i]);
          }
        }
      }
      out.println(result);
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
    try (TheThirdProblem instance = new TheThirdProblem()) {
      instance.solve();
    }
  }
}