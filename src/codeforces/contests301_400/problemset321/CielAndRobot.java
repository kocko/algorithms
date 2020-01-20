package codeforces.contests301_400.problemset321;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CielAndRobot implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int a = in.ni(), b = in.ni();
    char[] instruction = in.next().toCharArray();
    int dx = 0, dy = 0;
    for (char c : instruction) {
      if (c == 'L') dx--;
      if (c == 'R') dx++;
      if (c == 'U') dy++;
      if (c == 'D') dy--;
    }
    int dxp = 0, dyp = 0;
    boolean possible = reachable(a, b, dxp, dyp, dx, dy);
    for (char c : instruction) {
      if (c == 'L') dxp--;
      if (c == 'R') dxp++;
      if (c == 'U') dyp++;
      if (c == 'D') dyp--;
      possible |= reachable(a, b, dxp, dyp, dx, dy);
    }
    out.println(possible ? "Yes" : "No");
  }

  private boolean reachable(int a, int b, int xx, int yy, int x, int y) {
    if (x == 0 || y == 0) {
      if (x == 0 && a != xx) return false;
      if (y == 0 && b != yy) return false;
      if (x != 0 && ((a - xx) / x < 0 || (a - xx) % x != 0)) return false;
      return y == 0 || ((b - yy) / y >= 0 && (b - yy) % y == 0);
    } else {
      int p = (a - xx) / x;
      int q = (b - yy) / y;
      return (a - xx) % x == 0 && (b - yy) % y == 0 && p >= 0 && p == q;
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
    try (CielAndRobot instance = new CielAndRobot()) {
      instance.solve();
    }
  }
}
