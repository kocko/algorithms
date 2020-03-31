package codeforces.contests1301_1400.problemset1332;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ExercisingWalk implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int left = in.ni(), right = in.ni(), down = in.ni(), up = in.ni();
      int x = in.ni(), y = in.ni(), x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
      boolean possible = true;
      if (x1 == x2 && left + right > 0) possible = false;
      if (left >= right) {
        left -= right;
        possible &= left <= (x - x1);
      } else {
        right -= left;
        possible &= right <= (x2 - x);
      }

      if (y1 == y2 && up + down > 0) possible = false;
      if (up >= down) {
        up -= down;
        possible &= up <= (y2 - y);
      } else {
        down -= up;
        possible &= down <= (y - y1);
      }

      out.println(possible ? "Yes" : "No");
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
    try (ExercisingWalk instance = new ExercisingWalk()) {
      instance.solve();
    }
  }
}
