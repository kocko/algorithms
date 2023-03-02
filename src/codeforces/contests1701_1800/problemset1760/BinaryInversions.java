package codeforces.contests1701_1800.problemset1760;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class BinaryInversions implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public BinaryInversions() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      long[] ones = new long[n];
      long inversions = 0;
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (x[i] == 1) {
          ones[i]++;
        }
        if (i > 0) {
          ones[i] += ones[i - 1];
        }
        if (x[i] == 0) {
          inversions += ones[i];
        }
      }
      long[] zeroes = new long[n];
      for (int i = n - 1; i >= 0; i--) {
        if (x[i] == 0) {
          zeroes[i]++;
        }
        if (i + 1 < n) {
          zeroes[i] += zeroes[i + 1];
        }
      }
      long max = inversions;
      for (int i = 0; i < n; i++) {
        long score;
        if (x[i] == 1) {
          score = inversions - zeroes[i] + ones[i] - 1;
        } else {
          score = inversions - ones[i] + zeroes[i] - 1;
        }
        max = max(max, score);
      }
      out.println(max);
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
    try (BinaryInversions instance = new BinaryInversions()) {
      instance.solve();
    }
  }
}
