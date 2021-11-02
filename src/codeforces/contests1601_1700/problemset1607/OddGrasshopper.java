package codeforces.contests1601_1700.problemset1607;

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

public class OddGrasshopper implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public OddGrasshopper() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public OddGrasshopper(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long now = in.nl(), n = in.nl();
      long rem = n % 4;
      for (long step = n - rem + 1; step <= n; step++) {
        if (now % 2 == 0) {
          now -= step;
        } else {
          now += step;
        }
      }
      out.println(now);
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
    try (OddGrasshopper instance = new OddGrasshopper()) {
      instance.solve();
    }
  }
}
