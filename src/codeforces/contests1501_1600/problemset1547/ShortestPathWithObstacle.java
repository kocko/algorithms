package codeforces.contests1501_1600.problemset1547;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShortestPathWithObstacle implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ShortestPathWithObstacle() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public ShortestPathWithObstacle(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni(), xf = in.ni(), yf = in.ni();
      int result = Math.abs(x1 - x2) + Math.abs(y1 - y2);
      boolean between = false;
      between |= y1 == y2 && y1 == yf && xf >= Math.min(x1, x1) && xf <= Math.max(x1, x2);
      between |= x1 == x2 && x1 == xf && yf >= Math.min(y1, y2) && yf <= Math.max(y1, y2);
      if (between) {
        result += 2;
      }
      out.println(result);
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
    try (ShortestPathWithObstacle instance = new ShortestPathWithObstacle()) {
      instance.solve();
    }
  }
}
