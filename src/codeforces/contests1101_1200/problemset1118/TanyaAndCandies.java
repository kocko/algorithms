package codeforces.contests1101_1200.problemset1118;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TanyaAndCandies implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.ni();
    }
    int[] leftOdd = new int[n + 2], leftEven = new int[n + 2];
    int[] rightOdd = new int[n + 2], rightEven = new int[n + 2];
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        leftEven[i] = a[i];
      } else {
        leftOdd[i] = a[i];
      }
      if (i >= 2) {
        if (i % 2 == 0) {
          leftEven[i] += leftEven[i - 2];
        } else {
          leftOdd[i] += leftOdd[i - 2];
        }
      }
    }
    for (int i = n; i >= 1; i--) {
      if (i % 2 == 0) {
        rightEven[i] = a[i];
      } else {
        rightOdd[i] = a[i];
      }
      if (i <= n - 2) {
        if (i % 2 == 0) {
          rightEven[i] += rightEven[i + 2];
        } else {
          rightOdd[i] += rightOdd[i + 2];
        }
      }
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      int odd, even;
      if (i % 2 == 1) {
        odd = rightEven[i + 1];
        if (i >= 2) odd += leftOdd[i - 2];
        even = leftEven[i - 1];
        if (i <= n - 2) even += rightOdd[i + 2];
      } else {
        odd = leftOdd[i - 1];
        if (i <= n - 2) odd += rightEven[i + 2];

        even = rightOdd[i + 1];
        if (i >= 2) even += leftEven[i - 2];
      }
      if (odd == even) {
        result++;
      }
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
    try (TanyaAndCandies instance = new TanyaAndCandies()) {
      instance.solve();
    }
  }
}
