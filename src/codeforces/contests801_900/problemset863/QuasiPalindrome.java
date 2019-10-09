package codeforces.contests801_900.problemset863;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QuasiPalindrome implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char[] x = in.next().toCharArray();
    int n = x.length;
    boolean quasi = false;
    for (int i = 0; i < n; i++) {
      char[] copy = new char[i + 1];
      for (int j = 0; j <= i; j++) {
        copy[j] = x[j];
      }
      boolean ok = isPalindrome(copy);
      for (int j = i + 1; j < n; j++) {
        ok &= x[j] == '0';
      }
      quasi |= ok;
    }
    out.println(quasi ? "YES" : "NO");
  }

  private boolean isPalindrome(char[] c) {
    int n = c.length;
    for (int i = 0; i < n / 2; i++) {
      if (c[i] != c[n - i - 1]) return false;
    }
    return true;
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
    try (QuasiPalindrome instance = new QuasiPalindrome()) {
      instance.solve();
    }
  }
}
