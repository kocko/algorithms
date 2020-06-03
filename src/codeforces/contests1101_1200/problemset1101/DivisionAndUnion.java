package codeforces.contests1101_1200.problemset1101;

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

public class DivisionAndUnion implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      List<Interval> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        int left = in.ni(), right = in.ni();
        list.add(new Interval(i, left, right));
      }
      list.sort(Comparator.naturalOrder());
      Interval first = list.get(0);
      int right = first.right;
      int[] result = new int[n];
      int idx = 1;
      result[first.idx] = idx;
      for (int i = 1; i < n; i++) {
        Interval current = list.get(i);
        if (current.left <= right) {
          result[current.idx] = idx;
          right = Math.max(right, current.right);
        } else {
          if (idx == 1) {
            idx++;
          }
          result[current.idx] = idx;
          right = current.right;
        }
      }
      if (idx == 2) {
        for (int i = 0; i < n; i++) {
          out.print(result[i]);
          out.print(' ');
        }
        out.println();
      } else {
        out.println(-1);
      }
    }
  }

  private class Interval implements Comparable<Interval> {
    private int idx, left, right;

    private Interval(int idx, int left, int right) {
      this.idx = idx;
      this.left = left;
      this.right = right;
    }

    @Override
    public int compareTo(Interval interval) {
      int x = Integer.compare(this.left, interval.left);
      return x != 0 ? x : Integer.compare(this.right, interval.right);
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
    try (DivisionAndUnion instance = new DivisionAndUnion()) {
      instance.solve();
    }
  }
}
