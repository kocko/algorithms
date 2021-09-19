package atcoder.beginner.contest212;

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

public class MinDifference implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MinDifference() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public MinDifference(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    TreeSet<Integer> a = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      a.add(in.ni());
    }
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < m; i++) {
      int next = in.ni();
      Integer ge = a.ceiling(next);
      if (ge != null) {
        result = Math.min(result, ge - next);
      }
      Integer le = a.floor(next);
      if (le != null) {
        result = Math.min(result, next - le);
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
    try (MinDifference instance = new MinDifference()) {
      instance.solve();
    }
  }
}
