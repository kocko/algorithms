package codeforces.contests1401_1500.problemset1451;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StringEquality implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      char[] a = in.next().toCharArray(), b = in.next().toCharArray();
      boolean possible = true;
      int prev = 0;
      for (char c = 'a'; c <= 'z'; c++) {
        int first = 0, second = 0;
        for (int i = 0; i < n; i++) {
          if (a[i] == c) {
            first++;
          }
          if (b[i] == c) {
            second++;
          }
        }
        if (first + prev < second || (second - first) % k != 0) {
          possible = false;
          break;
        }
        prev += (first - second);
      }

      out.println(possible ? "Yes" : "No");
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
    try (StringEquality instance = new StringEquality()) {
      instance.solve();
    }
  }
}
