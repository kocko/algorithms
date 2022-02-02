package atcoder.beginner.contest124;

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

public class ColoringColorfully implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public ColoringColorfully() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    char[] x = in.next().toCharArray();
    int a = 0, b = 0;
    for (int i = 0; i < x.length; i++) {
      if (i % 2 == 0) {
        if (x[i] == '0') b++;
        else a++;
      } else {
        if (x[i] == '0') a++;
        else b++;
      }
    }
    out.println(Math.min(a, b));
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
    try (ColoringColorfully instance = new ColoringColorfully()) {
      instance.solve();
    }
  }
}
