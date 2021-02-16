package codeforces.contests1401_1500.problemset1490;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PermutationTransformation implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      x = new int[n];
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
      }
      result = new int[n];
      recurse(0, n - 1, 0);
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
    }
  }

  private int[] x;
  private int[] result;

  private void recurse(int left, int right, int d) {
    if (left > right) return;
    if (left == right) result[left] = d;

    int maxValue = -1, idx = -1;
    for (int i = left; i <= right; i++) {
      if (x[i] > maxValue) {
        maxValue = x[i];
        idx = i;
      }
    }
    result[idx] = d;
    recurse(left, idx - 1, d + 1);
    recurse(idx + 1, right, d + 1);
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
    try (PermutationTransformation instance = new PermutationTransformation()) {
      instance.solve();
    }
  }
}
