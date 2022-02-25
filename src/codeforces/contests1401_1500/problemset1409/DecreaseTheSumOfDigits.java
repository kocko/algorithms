package codeforces.contests1401_1500.problemset1409;

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

public class DecreaseTheSumOfDigits implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public DecreaseTheSumOfDigits() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long n = in.nl();
      int s = in.ni();
      long moves = 0;
      long offset = 1L;
      while (sum(n) > s) {
        int batch = 0;
        while (true) {
          n++;
          batch++;
          if (n % 10 == 0 || sum(n) <= s) break;
        }
        moves += batch * offset;
        n /= 10;
        offset *= 10L;
      }
      out.println(moves);
    }
  }

  private int sum(long n) {
    int result = 0;
    while (n > 0) {
      result += n % 10;
      n /= 10;
    }
    return result;
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
    try (DecreaseTheSumOfDigits instance = new DecreaseTheSumOfDigits()) {
      instance.solve();
    }
  }
}
