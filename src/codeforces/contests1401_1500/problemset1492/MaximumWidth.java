package codeforces.contests1401_1500.problemset1492;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class MaximumWidth implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    char[] x = in.next().toCharArray();
    char[] y = in.next().toCharArray();
    int[] left = new int[m];
    int idx = 0;
    for (int i = 0; i < n && idx < m; i++) {
      if (x[i] == y[idx]) {
        left[idx] = i;
        idx++;
      }
    }
    int[] right = new int[m];
    idx = m - 1;
    for (int i = n - 1; i >= 0 && idx >= 0; i--) {
      if (x[i] == y[idx]) {
        right[idx] = i;
        idx--;
      }
    }
    int result = 0;
    for (int i = 0; i < m - 1; i++) {
      result = Math.max(result, right[i + 1] - left[i]);
    }
    out.println(result);
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
    try (MaximumWidth instance = new MaximumWidth()) {
      instance.solve();
    }
  }
}
