package atcoder.beginner.contest194;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JobAssignment implements Closeable {

  private final InputReader in = new InputReader(System.in);
  private final PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] a = new int[n];
    int[] b = new int[n];
    final int oo = (int) 1e9 + 10;
    int result = oo;
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
      b[i] = in.ni();
      result = Math.min(result, a[i] + b[i]);
    }
    int[] aMinLeft = new int[n];
    int[] bMinLeft = new int[n];
    int aMin = oo, bMin = oo;
    for (int i = 0; i < n; i++) {
      aMinLeft[i] = aMin;
      aMin = Math.min(aMin, a[i]);

      bMinLeft[i] = bMin;
      bMin = Math.min(bMin, b[i]);
    }
    aMin = bMin = oo;
    int[] aMinRight = new int[n];
    int[] bMinRight = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      aMinRight[i] = aMin;
      aMin = Math.min(aMin, a[i]);

      bMinRight[i] = bMin;
      bMin = Math.min(bMin, b[i]);
    }
    for (int i = 0; i < n; i++) {
      result = Math.min(result, Math.max(a[i], Math.min(bMinLeft[i], bMinRight[i])));
      result = Math.min(result, Math.max(b[i], Math.min(aMinLeft[i], aMinRight[i])));
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
    try (JobAssignment instance = new JobAssignment()) {
      instance.solve();
    }
  }
}
