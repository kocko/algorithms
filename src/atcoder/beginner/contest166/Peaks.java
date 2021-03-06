package atcoder.beginner.contest166;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Peaks implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    int[] h = new int[n + 1];
    boolean[] good = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      h[i] = in.ni();
      good[i] = true;
    }
    for (int i = 0; i < m; i++) {
      int u = in.ni(), v = in.ni();
      if (h[u] > h[v]) {
        good[v] = false;
      } else if (h[u] < h[v]) {
        good[u] = false;
      } else {
        good[u] = good[v] = false;
      }
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (good[i]) {
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
    try (Peaks instance = new Peaks()) {
      instance.solve();
    }
  }
}
