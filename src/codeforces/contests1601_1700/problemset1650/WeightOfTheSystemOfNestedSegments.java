package codeforces.contests1601_1700.problemset1650;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class WeightOfTheSystemOfNestedSegments implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public WeightOfTheSystemOfNestedSegments() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  private class Point {
    private int idx, where, weight;

    private Point(int idx, int where, int weight) {
      this.idx = idx;
      this.where = where;
      this.weight = weight;
    }

    public int getWeight() {
      return weight;
    }

    public int getWhere() {
      return where;
    }
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      List<Point> list = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        list.add(new Point(i + 1, in.ni(), in.ni()));
      }
      list.sort(Comparator.comparingInt(Point::getWeight));
      int totalWeight = 0;
      List<Point> remaining = new ArrayList<>();
      for (int idx = 0; idx < 2 * n; idx++) {
        totalWeight += list.get(idx).weight;
        remaining.add(list.get(idx));
      }
      remaining.sort(Comparator.comparingInt(Point::getWhere));
      out.println(totalWeight);
      int left = 0, right = 2 * n - 1;
      while (left < right) {
        out.println(remaining.get(left).idx + " " + remaining.get(right).idx);
        left++;
        right--;
      }
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
    try (WeightOfTheSystemOfNestedSegments instance = new WeightOfTheSystemOfNestedSegments()) {
      instance.solve();
    }
  }
}
