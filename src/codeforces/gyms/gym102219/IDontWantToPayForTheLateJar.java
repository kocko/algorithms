package codeforces.gyms.gym102219;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IDontWantToPayForTheLateJar implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int D = in.ni();
    for (int day = 1; day <= D; day++) {
      int n = in.ni(), s = in.ni(), result = -1;
      
      for (int i = 0; i < n; i++) {
        int f = in.ni(), t = in.ni();
        if (t <= s) {
          result = Math.max(result, f);
        } else {
          result = Math.max(result, f - t + s);
        }
      }
      result = Math.max(result, -1);
      out.printf("Case #%d: %d\n", day, result);
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
    try (IDontWantToPayForTheLateJar instance = new IDontWantToPayForTheLateJar()) {
      instance.solve();
    }
  }
}
