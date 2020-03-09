package codeforces.contests1301_1400.problemset1303;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ErasingZeroes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      int start = -1;
      for (int i = 0; i < n; i++) {
        if (x[i] == '1') {
          start = i;
          break;
        }
      }
      int end = n;
      for (int i = n - 1; i >= 0; i--) {
        if (x[i] == '1') {
          end = i;
          break;
        }
      }
      int result = 0, current = 0;
      if (start >= 0) {
        for (int i = start; i < end; i++) {
          if (x[i] == '0') {
            current++;
          } else {
            result += current;
            current = 0;
          }
        }
        result += current;
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
    try (ErasingZeroes instance = new ErasingZeroes()) {
      instance.solve();
    }
  }
}
