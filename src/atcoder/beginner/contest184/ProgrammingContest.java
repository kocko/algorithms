package atcoder.beginner.contest184;

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

public class ProgrammingContest implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    T = in.ni();
    a = new long[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nl();
    }
    split();
    if (result == -1) {
      meetInTheMiddle();
    } else {
      out.println(result);
    }
  }

  private long T;
  private int n;
  private long[] a;

  private List<Long> left = new ArrayList<>();
  private Set<Long> right = new HashSet<>();

  private void split() {
    int half = n / 2;
    for (int mask = 0; mask < (1 << half); mask++) {
      long sum = 0;
      for (int i = 0; i < half; i++) {
        int bit = 1 << i;
        if ((mask & bit) != 0) {
          sum += a[i];
        }
      }
      if (sum < T) {
        left.add(sum);
      } else if (sum == T) {
        result = T;
        return;
      }
    }
    int rem = n - half;
    for (int mask = 0; mask < (1 << rem); mask++) {
      long sum = 0;
      for (int i = half; i < n; i++) {
        int bit = (1 << (i - half));
        if ((mask & bit) != 0) {
          sum += a[i];
        }
      }
      if (sum < T) {
        right.add(sum);
      } else if (sum == T) {
        result = T;
        return;
      }
    }
  }

  private long result = -1;

  private void meetInTheMiddle() {
    left.sort(Comparator.naturalOrder());
    for (long s : right) {
      long need = T - s;
      long max = -1;
      int l = 0, r = left.size() - 1;
      while (l <= r) {
        int mid = l + (r - l) / 2;
        if (left.get(mid) <= need) {
          max = Math.max(max, left.get(mid));
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      if (max != -1) {
        result = Math.max(result, s + max);
      } else break;
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
    try (ProgrammingContest instance = new ProgrammingContest()) {
      instance.solve();
    }
  }
}
