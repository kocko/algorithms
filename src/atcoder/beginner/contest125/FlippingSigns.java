package atcoder.beginner.contest125;

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

public class FlippingSigns implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public FlippingSigns() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni();
    long[] x = new long[n];
    int negative = 0;
    long moduloMin = Long.MAX_VALUE;
    int where = -1;
    for (int i = 0; i < n; i++) {
      x[i] = in.nl();
      if (x[i] < 0) {
        negative++;
      }
      if (abs(x[i]) < moduloMin) {
        where = i;
        moduloMin = abs(x[i]);
      }
    }
    long result = 0;
    if (negative % 2 == 1) {
      for (int i = 0; i < n; i++) {
        if (i == where) {
          result -= abs(x[i]);
        } else {
          result += abs(x[i]);
        }
      }
    } else {
      for (int i = 0; i < n; i++) {
        result += abs(x[i]);
      }
    }
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
    try (FlippingSigns instance = new FlippingSigns()) {
      instance.solve();
    }
  }
}
