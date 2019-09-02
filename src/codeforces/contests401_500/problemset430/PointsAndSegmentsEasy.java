package codeforces.contests401_500.problemset430;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class PointsAndSegmentsEasy implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Point {
    private int idx, value;

    private Point(int idx, int value) {
      this.idx = idx;
      this.value = value;
    }
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      points.add(new Point(i, in.ni()));
    }
    points.sort(Comparator.comparingInt(p -> p.value));
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[points.get(i).idx] = i % 2;
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
      out.print(' ');
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
    try (PointsAndSegmentsEasy instance = new PointsAndSegmentsEasy()) {
      instance.solve();
    }
  }
}
