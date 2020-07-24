package codeforces.contests1301_1400.problemset1385;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItGood implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      int left = 0, right = n - 1, result = n;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (isGood(x, mid)) {
          result = Math.min(result, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      out.println(result);
    }
  }

  private boolean isGood(int[] x, int left) {
    boolean good = true;
    int right = x.length - 1;
    int last = 0;
    while (left <= right) {
      int next;
      if (x[left] <= x[right]) {
        next = x[left++];
      } else {
        next = x[right--];
      }
      good &= last <= next;
      last = next;
    }
    return good;
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
    try (MakeItGood instance = new MakeItGood()) {
      instance.solve();
    }
  }
}
