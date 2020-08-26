package codeforces.contests1301_1400.problemset1400;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinaryStringReconstruction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] result = in.next().toCharArray();
      int x = in.ni(), n = result.length;
      char[] original = new char[n];
      for (int i = 0; i < n; i++) {
        original[i] = '1';
      }
      for (int i = 0; i < n; i++) {
        if (result[i] == '0') {
          if (i - x >= 0) {
            original[i - x] = '0';
          }
          if (i + x < n) {
            original[i + x] = '0';
          }
        }
      }
      boolean possible = true;
      for (int i = 0; i < n; i++) {
        boolean one = (i - x >= 0 && original[i - x] == '1');
        one |= (i + x < n && original[i + x] == '1');

        if (result[i] == '1') {
          possible &= one;
        } else {
          possible &= !one;
        }
      }
      if (possible) {
        for (int i = 0; i < n; i++) {
          out.print(original[i]);
        }
        out.println();
      } else {
        out.println(-1);
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
    try (BinaryStringReconstruction instance = new BinaryStringReconstruction()) {
      instance.solve();
    }
  }
}
