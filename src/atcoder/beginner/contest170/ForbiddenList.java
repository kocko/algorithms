package atcoder.beginner.contest170;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ForbiddenList implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int x = in.ni(), n = in.ni();
    boolean[] forbidden = new boolean[201];
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      forbidden[next] = true;
    }
    int result = 500, diff = 500;
    for (int i = 0; i <= 200; i++) {
      if (!forbidden[i]) {
        int abs = Math.abs(x - i);
        if (abs < diff) {
          result = i;
          diff = abs;
        } else if (abs == diff) {
          result = Math.min(result, i);
        }
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
    try (ForbiddenList instance = new ForbiddenList()) {
      instance.solve();
    }
  }
}
