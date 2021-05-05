package codeforces.contests1501_1600.problemset1520;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class OrdinaryNumbers implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public OrdinaryNumbers() throws FileNotFoundException {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    List<Long> list = new ArrayList<>();
    final long MAX_N = (long) 1e9;
    for (int i = 1; i <= 9; i++) {
      long n = i;
      while (n <= MAX_N) {
        list.add(n);
        n = (n * 10 + i);
      }
    }
    int t = in.ni();
    while (t-- > 0) {
      int limit = in.ni(), ans = 0;
      for (long value : list) {
        if (value <= limit) {
          ans++;
        }
      }
      out.println(ans);
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
    try (OrdinaryNumbers instance = new OrdinaryNumbers()) {
      instance.solve();
    }
  }
}
