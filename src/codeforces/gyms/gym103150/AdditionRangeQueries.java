package codeforces.gyms.gym103150;

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

public class AdditionRangeQueries implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public AdditionRangeQueries() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public AdditionRangeQueries(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        max = Math.max(max, next);
        min = Math.min(min, next);
      }
      out.println(Math.abs(max - min));
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
    try (AdditionRangeQueries instance = new AdditionRangeQueries()) {
      instance.solve();
    }
  }
}
