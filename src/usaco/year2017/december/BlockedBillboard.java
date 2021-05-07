package usaco.year2017.december;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BlockedBillboard implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public BlockedBillboard() throws IOException {
    in = new InputReader(new FileInputStream("billboard.in"));
    out = new PrintWriter(new FileOutputStream("billboard.out"));
  }

  private class Rectangle {
    private int x1, y1, x2, y2;

    private Rectangle(int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
    }

    private int area() {
      return (x2 - x1) * (y2 - y1);
    }
  }

  public void solve() {
    Rectangle a = new Rectangle(in.ni(), in.ni(), in.ni(), in.ni());
    Rectangle b = new Rectangle(in.ni(), in.ni(), in.ni(), in.ni());
    Rectangle c = new Rectangle(in.ni(), in.ni(), in.ni(), in.ni());
    int result = a.area() + b.area() - intersection(a, c) - intersection(b, c);
    out.println(result);
  }

  private int intersection(Rectangle p, Rectangle q) {
    int xOverlap = Math.max(0, Math.min(p.x2, q.x2) - Math.max(p.x1, q.x1));
    int yOverlap = Math.max(0, Math.min(p.y2, q.y2) - Math.max(p.y1, q.y1));
    return xOverlap * yOverlap;
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
    try (BlockedBillboard instance = new BlockedBillboard()) {
      instance.solve();
    }
  }
}
