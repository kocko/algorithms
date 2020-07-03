package codeforces.contests1301_1400.problemset1334;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MinimumEulerCycle implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      long n = in.nl(), l = in.nl() - 1, r = in.nl() - 1;
      long row = findRow(n, l);
      long rem = n - row;
      long firstIndex = n * (n - 1) - rem * (rem - 1);
      long dist = (l - firstIndex + (l % 2)) / 2;

      long even = row + 1;
      long odd = row + dist + 2 - (l % 2);
      if (even == n) {
        even = 1;
      }
      boolean printRow = l % 2 == 0;
      for (int i = 0; i < r - l + 1; i++) {
        if (printRow) {
          out.print(even);
        } else {
          out.print(odd);
          if (odd == n) {
            even++;
            if (even == n) {
              even = 1;
            }
            odd = even + 1;
          } else {
            odd++;
          }
        }
        out.print(' ');
        printRow = !printRow;
      }
      out.println();
    }
  }

  private long findRow(long n, long idx) {
    long left = 1, right = n - 1, result = 0;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long rem = n - mid;
      long nodes = n * (n - 1) - rem * (rem - 1);
      if (nodes <= idx) {
        left = mid + 1;
        result = Math.max(result, mid);
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
    try (MinimumEulerCycle instance = new MinimumEulerCycle()) {
      instance.solve();
    }
  }
}
