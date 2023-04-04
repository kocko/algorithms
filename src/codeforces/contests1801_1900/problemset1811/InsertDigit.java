package codeforces.contests1801_1900.problemset1811;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class InsertDigit implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public InsertDigit() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public InsertDigit(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      char[] x = in.next().toCharArray();
      boolean inserted = false;
      StringBuilder result = new StringBuilder();
      for (char c : x) {
        if (!inserted) {
          if ((c - '0') >= k) {
            result.append(c);
          } else {
            result.append(k);
            result.append(c);
            inserted = true;
          }
        } else {
          result.append(c);
        }
      }
      if (!inserted) {
        result.append(k);
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
    try (InsertDigit instance = new InsertDigit()) {
      instance.solve();
    }
  }
}
