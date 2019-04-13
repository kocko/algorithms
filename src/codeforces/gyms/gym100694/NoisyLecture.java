package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NoisyLecture implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int max = 0;
    int[] a = new int[n], b = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.ni();
      max = Math.max(max, a[i]);
    }
    for (int i = 0; i < n; i++) {
      b[i] = in.ni();
    }
    int k = in.ni();
    int result = 0;
    for (int i = 0; i < k; i++) {
      result += in.ni();
    }
    result += k * max;
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
    try (NoisyLecture instance = new NoisyLecture()) {
      instance.solve();
    }
  }
}
