package codeforces.contests1101_1200.problemset1162;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ZoningRestrictionsAgain implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), h = in.ni(), m = in.ni();
    int[] max = new int[55];
    for (int i = 0; i < max.length; i++) {
      max[i] = h;
    }
    for (int i = 0; i < m; i++) {
      int left = in.ni(), right = in.ni(), mx = in.ni();
      for (int j = left; j <= right; j++) {
        max[j] = Math.min(max[j], mx);
      }
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      result += max[i] * max[i];
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
    try (ZoningRestrictionsAgain instance = new ZoningRestrictionsAgain()) {
      instance.solve();
    }
  }
}
