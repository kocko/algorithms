package usaco.year2018.january;

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

public class BlockedBillboardII implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public BlockedBillboardII() throws FileNotFoundException {
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
    int xOverlap = Math.max(0, Math.min(a.x2, b.x2) - Math.max(a.x1, b.x1));
    int yOverlap = Math.max(0, Math.min(a.y2, b.y2) - Math.max(a.y1, b.y1));
    int intersection = xOverlap * yOverlap;

    int corners = 0;
    if (covers(b, a.x1, a.y1)) corners++;
    if (covers(b, a.x1, a.y2)) corners++;
    if (covers(b, a.x2, a.y1)) corners++;
    if (covers(b, a.x2, a.y2)) corners++;
    int result;
    if (corners < 2) {
      result = a.area();
    } else if (corners == 4) {
      result = 0;
    } else {
      result = a.area() - intersection;
    }
    out.println(result);
  }

  private boolean covers(Rectangle rect, int x, int y) {
    return x >= rect.x1 && x <= rect.x2 && y >= rect.y1 && y <= rect.y2;
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
    try (BlockedBillboardII instance = new BlockedBillboardII()) {
      instance.solve();
    }
  }
}
