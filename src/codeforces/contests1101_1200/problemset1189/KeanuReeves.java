package codeforces.contests1101_1200.problemset1189;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KeanuReeves implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    int ones = 0, zeroes = 0;
    for (int i = 0; i < n; i++) {
      if (x[i] == '1') ones++;
      else zeroes++;
    }
    if (ones == zeroes) {
      out.println(2);
      for (int i = 0; i < n - 1; i++) {
        out.print(x[i]);
      }
      out.print(' ');
      out.print(x[n - 1]);
    } else {
      out.println(1);
      for (int i = 0; i < n; i++) {
        out.print(x[i]);
      }
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
    try (KeanuReeves instance = new KeanuReeves()) {
      instance.solve();
    }
  }
}
