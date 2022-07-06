package codeforces.contests1601_1700.problemset1676;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class EatingQueries implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), q = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      Arrays.sort(x);
      int[] prefix = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        prefix[i] += prefix[i - 1];
        prefix[i] += x[n - i];
      }
      while (q-- > 0) {
        int target = in.ni();
        int left = 1, right = n, result = n + 1;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (prefix[mid] >= target) {
            result = min(result, mid);
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
        out.println(result == n + 1 ? -1 : result);
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
    try (EatingQueries instance = new EatingQueries()) {
      instance.solve();
    }
  }
}