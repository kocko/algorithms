package google.kickstart.year2021.a;

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

public class KGoodnessString implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public KGoodnessString() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    for (int testCase = 1; testCase <= t; testCase++) {
      int n = in.ni(), k = in.ni();
      char[] x = in.next().toCharArray();
      int score = 0;
      for (int i = 0; i < n / 2; i++) {
        if (x[i] != x[n - i - 1]) {
          score++;
        }
      }
      out.printf("Case #%d: %d\n", testCase, Math.abs(k - score));
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
    try (KGoodnessString instance = new KGoodnessString()) {
      instance.solve();
    }
  }
}
