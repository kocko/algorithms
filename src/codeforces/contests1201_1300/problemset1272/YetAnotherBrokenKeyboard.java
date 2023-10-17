package codeforces.contests1201_1300.problemset1272;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class YetAnotherBrokenKeyboard implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public YetAnotherBrokenKeyboard() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), k = in.ni();
    char[] x = in.next().toCharArray();
    boolean[] broken = new boolean[26];
    Arrays.fill(broken, true);
    for (int i = 0; i < k; i++) {
      char next = in.next().charAt(0);
      broken[next - 'a'] = false;
    }
    long current = 0, result = 0;
    for (int i = 0; i < n; i++) {
      int idx = x[i] - 'a';
      if (!broken[idx]) {
        current++;
      } else {
        result += (current * (current + 1)) / 2;
        current = 0;
      }
    }
    result += (current * (current + 1)) / 2;
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
    try (YetAnotherBrokenKeyboard instance = new YetAnotherBrokenKeyboard()) {
      instance.solve();
    }
  }
}
