package codeforces.contests1501_1600.problemset1525;

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

public class PermutationSort implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public PermutationSort() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public PermutationSort(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int prev = -1;
      boolean sorted = true;
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        sorted &= x[i] > prev;
        prev = x[i];
      }
      if (sorted) {
        out.println(0);
      } else if (x[0] == 1 || x[n - 1] == n) {
        out.println(1) ;
      } else if (x[0] == n && x[n - 1] == 1) {
        out.println(3);
      } else {
        out.println(2);
      }
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
    try (PermutationSort instance = new PermutationSort()) {
      instance.solve();
    }
  }
}
