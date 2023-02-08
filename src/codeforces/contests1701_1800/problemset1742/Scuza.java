package codeforces.contests1701_1800.problemset1742;

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

public class Scuza implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Scuza() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), q = in.ni();
      int[] max = new int[n + 1];
      long[] prefix = new long[n + 1];
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        max[i + 1] = Math.max(max[i], next);
        prefix[i + 1] = prefix[i] + next;
      }
      while (q-- > 0) {
        int k = in.ni();
        int idx = binarySearch(max, k);
        out.print(prefix[idx]);
        out.print(' ');
      }
      out.println();
    }
  }

  private int binarySearch(int[] max, int k) {
    int left = 1, right = max.length - 1;
    int result = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (max[mid] <= k) {
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
    try (Scuza instance = new Scuza()) {
      instance.solve();
    }
  }
}
