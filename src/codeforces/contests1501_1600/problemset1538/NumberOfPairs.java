package codeforces.contests1501_1600.problemset1538;

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

public class NumberOfPairs implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public NumberOfPairs() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public NumberOfPairs(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      min = in.ni();
      max = in.ni();
      x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      Arrays.sort(x);
      long result = 0;
      for (int idx = n - 1; idx >= 0; idx--) {
        int lft = leftmost(idx), rht = rightmost(idx);
        if (lft <= rht) {
          result += (rht - lft + 1L);
        }
      }
      out.println(result);
    }
  }

  private int n;
  private int min, max;
  private int[] x;

  private int leftmost(int i) {
    int left = i + 1, right = n - 1;
    int result = n;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (x[i] + x[mid] >= min) {
        result = Math.min(result, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return result;
  }

  private int rightmost(int i) {
    int left = i + 1, right = n - 1;
    int result = i;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (x[i] + x[mid] <= max) {
        result = Math.max(result, mid);
        left = mid + 1;
      } else {
        right = mid - 1;
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
    try (NumberOfPairs instance = new NumberOfPairs()) {
      instance.solve();
    }
  }
}
