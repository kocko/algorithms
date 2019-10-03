package codeforces.contests1201_1300.problemset1215;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheNumberOfProducts implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    long negative = 0;
    int positivePrefixes = 0, negativePrefixes = 0, prefix = 1;
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      if (next < 0) {
        prefix *= -1;
      }
      if (prefix > 0) {
        positivePrefixes++;
        negative += negativePrefixes;
      } else {
        negativePrefixes++;
        negative++;
        negative += positivePrefixes;
      }

    }
    long total = n * (n + 1L) / 2L;
    out.println(negative + " " + (total - negative));
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
    try (TheNumberOfProducts instance = new TheNumberOfProducts()) {
      instance.solve();
    }
  }
}
