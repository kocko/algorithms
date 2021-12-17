package codeforces.contests1601_1700.problemset1618;

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

public class PolycarpAndSumsOfSubsequences implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PolycarpAndSumsOfSubsequences() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public PolycarpAndSumsOfSubsequences(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int[] x = new int[7];
      for (int i = 0; i < 7; i++) {
        x[i] = in.ni();
      }
      int[] result = new int[3];
      result[0] = x[0];
      out: for (int i = 1; i < 5; i++) {
        for (int j = i + 1; j < 6; j++) {
          if (x[i] + x[j] == x[5]) {
            result[1] = x[i];
            result[2] = x[j];
            break out;
          }
        }
      }
      for (int i = 0; i < 3; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
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
    try (PolycarpAndSumsOfSubsequences instance = new PolycarpAndSumsOfSubsequences()) {
      instance.solve();
    }
  }
}
