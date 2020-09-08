package codeforces.contests1401_1500.problemset1407;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BigVova implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), max = 0, maxIdx = -1;
      int[] x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        if (x[i] > max) {
          max = x[i];
          maxIdx = i;
        }
      }
      boolean[] used = new boolean[n];
      used[maxIdx] = true;
      int[] result = new int[n];
      int GCD = result[0] = max;
      for (int i = 1; i < n; i++) {
        int maxGcd = 0, index = -1;
        for (int j = 0; j < n; j++) {
          if (!used[j]) {
            int tmp = gcd(GCD, x[j]);
            if (tmp > maxGcd) {
              index = j;
              maxGcd = tmp;
            }
          }
        }
        result[i] = x[index];
        used[index] = true;
        GCD = gcd(GCD, x[index]);
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
    }
  }

  private int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
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
    try (BigVova instance = new BigVova()) {
      instance.solve();
    }
  }
}
