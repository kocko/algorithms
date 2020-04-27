package codeforces.contests1301_1400.problemset1342;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class YetAnotherCountingProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int a = in.ni(), b = in.ni(), q = in.ni();
      int ab = a * b;
      int[] count = new int[ab];

      for (int i = 1; i < ab; i++) {
        if (i % a % b != i % b % a) {
          count[i]++;
        }
        count[i] += count[i - 1];
      }
      while (q-- > 0) {
        long left = in.nl() - 1, right = in.nl();
        long L = left / ab, R = right / ab;
        out.println((R - L) * count[ab - 1] + count[(int) (right % ab)] - count[(int) (left % ab)]);
      }
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
    try (YetAnotherCountingProblem instance = new YetAnotherCountingProblem()) {
      instance.solve();
    }
  }
}
