package uva.volume007;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

import static java.lang.String.valueOf;
import static java.util.Collections.singletonList;

public class CopyingBooks implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      long[] books = new long[n];
      for (int i = 0; i < n; i++) {
        books[i] = in.nl();
      }
      long left = 1, right = 1L << 33;
      while (left < right) {
        long mid = left + (right - left) / 2;
        long current = 0;
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
          while (books[i] + current > mid && j < m) {
            current = 0;
            j++;
          }
          current += books[i];
        }
        if (j >= m) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      long max = right;
      List<List<Long>> best = new ArrayList<>();
      long current = 0;
      int total = m - 1, idx;
      List<Long> group = new ArrayList<>();
      for (idx = n - 1; idx >= 0; idx--) {
        if (current + books[idx] <= max) {
          group.add(books[idx]);
          current += books[idx];
        } else {
          best.add(group);
          group = new ArrayList<>();
          group.add(books[idx]);
          current = books[idx];
          total--;
        }
        if (idx == total) break;
      }
      idx--;
      if (group.size() > 0) {
        best.add(group);
      }
      while (idx >= 0) {
        if (books[idx] <= max) {
          best.add(singletonList(books[idx]));
        }
        idx--;
      }

      StringJoiner joiner = new StringJoiner(" / ");
      for (idx = m - 1; idx >= 0; idx--) {
        List<Long> values = best.get(idx);
        StringJoiner inner = new StringJoiner(" ");
        for (int i = values.size() - 1; i >= 0; i--) {
          inner.add(valueOf(values.get(i)));
        }
        joiner.add(inner.toString());
      }
      out.println(joiner.toString());
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
    try (CopyingBooks instance = new CopyingBooks()) {
      instance.solve();
    }
  }
}
