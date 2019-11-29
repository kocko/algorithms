package codeforces.contests1201_1300.problemset1263;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SweetProblem implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int[] x = new int[3];
      for (int i = 0; i < 3; i++) {
        x[i] = in.ni();
      }
      Arrays.sort(x);
      int diff = x[2] - x[1];
      int result = Math.min(diff, x[0]);
      x[2] -= diff;
      x[0] -= diff;
      if (x[0] > 0) {
        int pairs = x[0] / 2;
        result += 2 * Math.min(x[1], pairs);
        x[1] -= pairs;
        x[2] -= pairs;
        x[0] %= 2;
      }
      if (x[0] == 1) {
        x[1]--;
        result++;
      }
      result += Math.min(x[1], x[2]);
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
    try (SweetProblem instance = new SweetProblem()) {
      instance.solve();
    }
  }
}
