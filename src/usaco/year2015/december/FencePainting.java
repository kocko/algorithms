package usaco.year2015.december;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class FencePainting implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FencePainting() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("paint.in"));
    out = new PrintWriter(new FileOutputStream("paint.out"));
  }

  public void solve() {
    int a = in.ni(), b = in.ni(), c = in.ni(), d = in.ni();
    int result = b - a + d - c - Math.max(Math.min(b, d) - Math.max(a, c), 0);
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
    try (FencePainting instance = new FencePainting()) {
      instance.solve();
    }
  }
}
