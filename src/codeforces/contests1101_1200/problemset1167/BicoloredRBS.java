package codeforces.contests1101_1200.problemset1167;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BicoloredRBS implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    int[] result = new int[n];
    int black = 0, white = 0;
    for (int i = 0; i < n; i++) {
      if (x[i] == '(') {
        if (black >= white) {
          white++;
        } else {
          black++;
          result[i] = 1;
        }
      } else {
        if (black >= white) {
          black--;
          result[i] = 1;
        } else {
          white--;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
    }
    out.println();
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
    try (BicoloredRBS instance = new BicoloredRBS()) {
      instance.solve();
    }
  }
}
