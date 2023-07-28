package codeforces.contests1801_1900.problemset1851;

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

public class PrefixPermutationSums implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public PrefixPermutationSums() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long[] x = new long[n];
      long[] perm = new long[n];
      long prev = 0;
      boolean[] has = new boolean[n + 1];
      long outlier = -1;
      for (int i = 0; i < n - 1; i++) {
        x[i] = in.nl();
        perm[i] = (x[i] - prev);
        prev = x[i];
        if (perm[i] > n || has[(int) perm[i]]) {
          outlier = perm[i];
        }
        if (perm[i] >= 1 && perm[i] <= n) {
          has[(int) perm[i]] = true;
        }
      }
      long sumOfMissing = 0;
      int cnt = 0;
      for (int i = 1; i <= n; i++) {
        if (!has[i]) {
          sumOfMissing += i;
          cnt++;
        }
      }
      if ((cnt <= 2 && sumOfMissing == outlier) || outlier == -1) {
        out.println("YES");
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
    try (PrefixPermutationSums instance = new PrefixPermutationSums()) {
      instance.solve();
    }
  }
}
