package codeforces.contests601_700.problemset628;

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

public class TennisTournament implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public TennisTournament() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public TennisTournament(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), b = in.ni(), p = in.ni(), towels = n * p, bottles = 0;
    while (n > 1) {
      int k = 1;
      while (k * 2 <= n) {
        k *= 2;
      }
      bottles += k * b + k / 2;
      n = (n - k) + k / 2;
    }
    out.println(bottles + " " + towels);
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
    try (TennisTournament instance = new TennisTournament()) {
      instance.solve();
    }
  }
}
