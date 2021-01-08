package atcoder.beginner.contest184;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class SuperRyuma implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int r1 = in.ni(), c1 = in.ni();
    int r2 = in.ni(), c2 = in.ni();
    int r = r2 - r1;
    int c = c2 - c1;
    int ans;
    if (r == 0 && c == 0) ans = 0;
    else if (r == c || r == -c) ans = 1;
    else if (abs(r) + abs(c) <= 3) ans = 1;
    else if (((r ^ c ^ 1) & 1) != 0) ans = 2;
    else if (abs(r) + abs(c) <= 6) ans = 2;
    else if (abs(r + c) <= 3 || abs(r - c) <= 3) ans = 2;
    else ans = 3;
    out.println(ans);
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
    try (SuperRyuma instance = new SuperRyuma()) {
      instance.solve();
    }
  }
}
