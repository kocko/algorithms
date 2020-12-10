package codeforces.gyms.gym102873;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountSubstrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    char[] s = in.next().toCharArray();
    boolean[] end = new boolean[n];
    for (int i = 0; i < n - 1; i++) {
      if (x[i] == s[0] && x[i + 1] == s[1]) {
        end[i + 1] = true;
      }
    }
    long result = 0, lastEnd = 0;
    for (int i = 0; i < n; i++) {
      if (end[i]) {
        lastEnd = i;
      }
      result += lastEnd;
    }
    out.println(result);
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
    try (CountSubstrings instance = new CountSubstrings()) {
      instance.solve();
    }
  }
}
