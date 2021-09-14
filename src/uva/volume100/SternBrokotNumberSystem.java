package uva.volume100;

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

public class SternBrokotNumberSystem implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public SternBrokotNumberSystem() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public SternBrokotNumberSystem(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n, m;
    while ((n = in.ni()) != 1 | (m = in.ni()) != 1) {
      int la = 0, lb = 1;
      int ra = 1, rb = 0;
      StringBuilder sb = new StringBuilder();
      while (true) {
        int ma = la + ra;
        int mb = lb + rb;
        if (ma * m < mb * n) {
          sb.append('R');
          la = ma;
          lb = mb;
        } else if (ma * m > mb * n) {
          sb.append('L');
          ra = ma;
          rb = mb;
        } else break;
      }
      out.println(sb);
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
    try (SternBrokotNumberSystem instance = new SternBrokotNumberSystem()) {
      instance.solve();
    }
  }
}
