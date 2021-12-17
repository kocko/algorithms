package codeforces.contests1601_1700.problemset1618;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class MissingBigram implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MissingBigram() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public MissingBigram(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      String[] s = new String[n - 2];
      for (int i = 0; i < n - 2; i++) {
        s[i] = in.next();
      }
      char[] prev = s[0].toCharArray();
      char[] result = new char[n];
      result[0] = prev[0];
      result[1] = prev[1];
      int idx = 2;
      for (int i = 1; i < n - 2; i++) {
        char[] next = s[i].toCharArray();
        if (next[0] == prev[1]) {
          result[idx++] = next[1];
          prev = next;
        } else {
          result[idx++] = next[0];
          i--;
          prev = new char[]{prev[1], next[0]};
        }
      }
      if (idx == n - 1) {
        result[n - 1] = 'a';
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
      }
      out.println();
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
    try (MissingBigram instance = new MissingBigram()) {
      instance.solve();
    }
  }
}
