package codeforces.contests1401_1500.problemset1465;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FairNumbers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long n = in.nl();
      while (!isFair(n)) {
        n++;
      }
      out.println(n);
    }
  }

  private boolean isFair(long n) {
    boolean fair = true;
    List<Long> digits = new ArrayList<>();
    long m = n;
    while (m > 0) {
      long rem = m % 10;
      if (rem > 0) {
        digits.add(rem);
      }
      m /= 10;
    }
    for (long d : digits) {
      fair &= n % d == 0;
    }
    return fair;
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
    try (FairNumbers instance = new FairNumbers()) {
      instance.solve();
    }
  }
}
