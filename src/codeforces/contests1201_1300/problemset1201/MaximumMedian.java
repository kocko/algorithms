package codeforces.contests1201_1300.problemset1201;

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

public class MaximumMedian implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    List<Long> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list.add(in.nl());
    }
    list.sort(Comparator.naturalOrder());
    int[] next = new int[n];
    next[n - 1] = n;
    for (int i = n - 2; i >= 0; i--) {
      if (list.get(i) < list.get(i + 1)) {
        next[i] = i + 1;
      } else {
        next[i] = next[i + 1];
      }
    }
    int mid = n / 2;
    while (k > 0) {
      long same = next[mid] - mid;
      long increase;
      if (next[mid] < n) {
        long bigger = list.get(next[mid]), diff = bigger - list.get(mid);
        if (same * diff <= k) {
          increase = diff;
        } else {
          increase = k / same;
        }
      } else {
        increase = k / same;
      }
      if (increase > 0) {
        k -= increase * same;
        list.set(mid, list.get(mid) + increase);
        next[mid] = next[mid] < n ? next[next[mid]] : n;
      } else break;
    }
    out.println(list.get(mid));
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
    try (MaximumMedian instance = new MaximumMedian()) {
      instance.solve();
    }
  }
}
