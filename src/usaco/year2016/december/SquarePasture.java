package usaco.year2016.december;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class SquarePasture implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SquarePasture() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("square.in"));
    out = new PrintWriter(new FileOutputStream("square.out"));
  }

  private class Rectangle {
    private int x1, y1, x2, y2;

    private Rectangle(int x1, int y1, int x2, int y2) {
      this.x1 = x1;
      this.y1 = y1;
      this.x2 = x2;
      this.y2 = y2;
    }
  }

  public void solve() {
    Rectangle a = new Rectangle(in.ni(), in.ni(), in.ni(), in.ni());
    Rectangle b = new Rectangle(in.ni(), in.ni(), in.ni(), in.ni());
    int xSide = Math.max(a.x2, b.x2) - Math.min(a.x1, b.x1);
    int ySide = Math.max(a.y2, b.y2) - Math.min(a.y1, b.y1);
    int side = Math.max(xSide, ySide);
    out.println(side * side);
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
    try (SquarePasture instance = new SquarePasture()) {
      instance.solve();
    }
  }
}
