package codeforces.contests1301_1400.problemset1343;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BalancedArray implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), half = n / 2;
      if (half % 2 == 0) {
        int[] result = new int[n];
        int diff = 0;
        for (int i = 0; i < half; i++) {
          result[i] = 2 * (i + 1);
          result[half + i] = result[i] - 1;
          diff++;
        }
        result[n - 1] += diff;
        out.println("YES");
        for (int i = 0; i < n; i++) {
          out.print(result[i]);
          out.print(' ');
        }
        out.println();
      } else {
        out.println("NO");
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
    try (BalancedArray instance = new BalancedArray()) {
      instance.solve();
    }
  }
}
