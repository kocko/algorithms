package codeforces.contests1701_1800.problemset1791;

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

public class DistinctSplit implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public DistinctSplit() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public DistinctSplit(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      StringBuilder sb = new StringBuilder(in.next());
      int[] left = score(sb);
      int[] right = score(sb.reverse());
      int result = 0;
      for (int i = 0; i < n - 1; i++) {
        result = Math.max(result, left[i] + right[n - i - 2]);
      }
      out.println(result);
    }
  }

  private int[] score(StringBuilder input) {
    int n = input.length();
    int[] result = new int[n];
    int mask = 0;
    char[] x = input.toString().toCharArray();
    mask |= (1 << (x[0] - 'a'));
    result[0] = 1;
    for (int i = 1; i < n; i++) {
      int p = x[i] - 'a';
      if ((mask & (1 << p)) == 0) {
        result[i] = result[i - 1] + 1;
        mask |= (1 << p);
      } else {
        result[i] = result[i - 1];
      }
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
    try (DistinctSplit instance = new DistinctSplit()) {
      instance.solve();
    }
  }
}
