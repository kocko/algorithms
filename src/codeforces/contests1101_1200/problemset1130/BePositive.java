package codeforces.contests1101_1200.problemset1130;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BePositive implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), pos = 0, neg = 0;
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      if (next > 0) {
        pos++;
      } else if (next < 0) {
        neg++;
      }
    }
    if (n == 1) {
      if (pos == 1) {
        out.println(1);
      } else if (neg == 1) {
        out.println(-1);
      } else {
        out.println(0);
      }
      return;
    }
    int half = n / 2 + n % 2;
    int result;
    if (pos >= half) {
      result = 1;
    } else if (neg >= half) {
      result = -1;
    } else {
      result = 0;
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
    try (BePositive instance = new BePositive()) {
      instance.solve();
    }
  }
}
