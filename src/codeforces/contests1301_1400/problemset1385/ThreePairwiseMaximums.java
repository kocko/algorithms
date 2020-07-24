package codeforces.contests1301_1400.problemset1385;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ThreePairwiseMaximums implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int[] x = new int[3];
      for (int i = 0; i < 3; i++) {
        x[i] = in.ni();
      }
      Arrays.sort(x);
      boolean possible = x[2] == x[1];
      if (possible) {
        int[] result = new int[3];
        result[2] = x[2];
        result[1] = x[0];
        result[0] = x[0];
        possible = result[0] > 0;
        if (possible) {
          out.println("YES");
          for (int i = 0; i < 3; i++) {
            out.print(result[i]);
            out.print(' ');
          }
          out.println();
        } else {
          out.println("NO");
        }
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
    try (ThreePairwiseMaximums instance = new ThreePairwiseMaximums()) {
      instance.solve();
    }
  }
}
