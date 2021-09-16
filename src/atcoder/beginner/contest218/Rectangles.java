package atcoder.beginner.contest218;

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

public class Rectangles implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Rectangles() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public Rectangles(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int n = in.ni();
    int[][] points = new int[n][2];
    Set<String> has = new HashSet<>();
    for (int i = 0; i < n; i++) {
      points[i][0] = in.ni();
      points[i][1] = in.ni();
      has.add(points[i][0] + "_" + points[i][1]);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      int[] a = points[i];
      for (int j = i + 1; j < n; j++) {
        int[] b = points[j];
        if (a[0] != b[0] && a[1] != b[1]) {
          int[] c = {a[0], b[1]};
          int[] d = {b[0], a[1]};
          if (has.contains(c[0] + "_" + c[1]) && has.contains(d[0] + "_" + d[1])) {
            result++;
          }
        }
      }
    }
    out.println(result >> 1);
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
    try (Rectangles instance = new Rectangles()) {
      instance.solve();
    }
  }
}
