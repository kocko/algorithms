package spoj;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EulerTotientFunction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    phi();
    int q = in.ni();
    while (q-- > 0) {
      out.println(phi[in.ni()]);
    }
  }

  private final int MAX_N = (int) 1e6;
  private int[] phi = new int[MAX_N + 1];

  private void phi() {
    for (int i = 0; i <= MAX_N; i++) {
      phi[i] = i;
    }
    for (int i = 1; i <= MAX_N; i++) {
      for (int j = 2 * i; j <= MAX_N; j += i) {
        phi[j] -= phi[i];
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
    try (EulerTotientFunction instance = new EulerTotientFunction()) {
      instance.solve();
    }
  }
}
