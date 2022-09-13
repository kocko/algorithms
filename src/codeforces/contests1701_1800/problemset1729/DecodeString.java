package codeforces.contests1701_1800.problemset1729;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DecodeString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      char[] x = in.next().toCharArray();
      StringBuilder result = new StringBuilder();
      for (int idx = n - 1; idx >= 0;) {
        int p;
        if (x[idx] == '0') {
          p = (x[idx - 1] - '0' - 1) + 10 * (x[idx - 2] - '0');
          idx -= 3;
        } else {
          p = x[idx] - '0' - 1;
          idx--;
        }
        result.append((char) ('a' + p));
      }
      out.println(result.reverse());
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
    try (DecodeString instance = new DecodeString()) {
      instance.solve();
    }
  }
}