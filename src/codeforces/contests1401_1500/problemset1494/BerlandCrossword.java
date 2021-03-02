package codeforces.contests1401_1500.problemset1494;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BerlandCrossword implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    final int MAX = 1 << 4;
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), up = in.ni(), right = in.ni(), down = in.ni(), left = in.ni();
      boolean possible = false;
      for (int mask = 0; mask < MAX; mask++) {
        possible |= check(n, mask, up, right, down, left);
      }
      out.println(possible ? "YES" : "NO");
    }
  }

  private boolean check(int n, int mask, int up, int right, int down, int left) {
    int upLeft = (mask & 8) != 0 ? 1 : 0;
    up -= upLeft;
    left -= upLeft;

    int upRight = (mask & 4) != 0 ? 1 : 0;
    up -= upRight;
    right -= upRight;

    int downLeft = (mask & 2) != 0 ? 1 : 0;
    down -= downLeft;
    left -= downLeft;

    int downRight = (mask & 1) != 0 ? 1 : 0;
    down -= downRight;
    right -= downRight;

    boolean possible = true;
    possible &= up >= 0 && up <= n - 2;
    possible &= left >= 0 && left <= n - 2;
    possible &= right >= 0 && right <= n - 2;
    possible &= down >= 0 && down <= n - 2;

    return possible;
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
    try (BerlandCrossword instance = new BerlandCrossword()) {
      instance.solve();
    }
  }
}
