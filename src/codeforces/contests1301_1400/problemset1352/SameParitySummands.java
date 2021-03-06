package codeforces.contests1301_1400.problemset1352;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SameParitySummands implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int[] result = new int[k];
      int evenSum = 2 * k;
      int rem = n - evenSum;
      boolean possible = false;
      if (n >= evenSum) {
        if (rem % 2 == 0) {
          possible = true;
          result[0] += rem;
          for (int i = 0; i < k; i++) {
            result[i] += 2;
          }
        }
      }
      if (!possible) {
        if (n >= k) {
          rem = n - k;
          if (rem % 2 == 0) {
            possible = true;
            result[0] += rem;
            for (int i = 0; i < k; i++) {
              result[i]++;
            }
          }
        }
      }
      if (possible) {
        out.println("YES");
        for (int i = 0; i < k; i++) {
          out.print(result[i]);
          out.print(' ');
        }
        out.println();
      } else {
        out.println("NO");
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
    try (SameParitySummands instance = new SameParitySummands()) {
      instance.solve();
    }
  }
}
