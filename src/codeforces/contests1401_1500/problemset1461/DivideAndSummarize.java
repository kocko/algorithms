package codeforces.contests1401_1500.problemset1461;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class DivideAndSummarize implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), q = in.ni();
      List<Long> list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list.add(in.nl());
      }
      list.sort(Comparator.naturalOrder());
      prefix = new long[n + 1];
      x = new long[n + 1];
      for (int i = 1; i <= n; i++) {
        x[i] = list.get(i - 1);
        prefix[i] = prefix[i - 1] + list.get(i - 1);
      }
      info = new HashSet<>();
      recurse(1, n);
      while (q-- > 0) {
        out.println(info.contains(in.nl()) ? "Yes" : "No");
      }
    }
  }

  private long[] x;
  private long[] prefix;

  private Set<Long> info;

  private void recurse(int left, int right) {
    info.add(sum(left, right));

    if (x[left] == x[right]) return;

    long mid = (x[left] + x[right]) / 2;

    int p = left;
    int l = left, r = right;
    while (l <= r) {
      int m = l + (r - l) / 2;
      if (x[m] <= mid) {
        p = Math.max(p, m);
        l = m + 1;
      } else {
        r = m - 1;
      }
    }

    recurse(left, p);
    recurse(p + 1, right);
  }

  private long sum(int left, int right) {
    return prefix[right] - prefix[left - 1];
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
    try (DivideAndSummarize instance = new DivideAndSummarize()) {
      instance.solve();
    }
  }
}
