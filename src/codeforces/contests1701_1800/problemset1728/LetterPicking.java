package codeforces.contests1701_1800.problemset1728;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LetterPicking implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public LetterPicking() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      int left = 0, right = n - 1;
      while (left < right && x[left] == x[right]) {
        left++;
        right--;
      }
      boolean draw = true;
      if (left < right) {
        for (int i = left; i < right; i += 2) {
          draw &= x[i] == x[i + 1];
        }
      }
      out.println(draw ? "Draw" : "Alice");
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
    try (LetterPicking instance = new LetterPicking()) {
      instance.solve();
    }
  }
}
