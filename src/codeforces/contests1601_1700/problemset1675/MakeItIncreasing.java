package codeforces.contests1601_1700.problemset1675;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItIncreasing implements Closeable {

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
      int result = 0;
      while (!isIncreasing(x) && !hasZero(x)) {
        for (int i = 0; i < n - 1; i++) {
          while (x[i] >= x[i + 1]) {
            x[i] >>= 1;
            result++;
          }
        }
      }
      if (hasZero(x)) {
        result = -1;
      }
      out.println(result);
    }
  }

  private boolean hasZero(int[] x) {
    boolean result = false;
    for (int i = 1; i < x.length; i++) {
      result |= x[i] == 0;
    }
    return result;
  }

  private boolean isIncreasing(int[] x) {
    boolean increasing = true;
    for (int i = 0; i < x.length - 1; i++) {
      increasing &= x[i] < x[i + 1];
    }
    return increasing;
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
    try (MakeItIncreasing instance = new MakeItIncreasing()) {
      instance.solve();
    }
  }
}
