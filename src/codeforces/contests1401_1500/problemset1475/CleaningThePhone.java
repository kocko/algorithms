package codeforces.contests1401_1500.problemset1475;

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

public class CleaningThePhone implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int N = in.ni(), M = in.ni();
      List<Long> x = new ArrayList<>(), y = new ArrayList<>();
      long[] memory = new long[N];
      for (int i = 0; i < N; i++) {
        memory[i] = in.nl();
      }
      for (int i = 0; i < N; i++) {
        int type = in.ni();
        if (type == 1) {
          x.add(memory[i]);
        } else {
          y.add(memory[i]);
        }
      }
      x.sort(Comparator.reverseOrder());
      y.sort(Comparator.reverseOrder());
      int n = x.size();
      long[] one = new long[n];
      for (int i = 0; i < n; i++) {
        one[i] = x.get(i);
        if (i > 0) {
          one[i] += one[i - 1];
        }
      }
      int m = y.size();
      long[] two = new long[m];
      for (int i = 0; i < m; i++) {
        two[i] = y.get(i);
        if (i > 0) {
          two[i] += two[i - 1];
        }
      }

      int result = Integer.MAX_VALUE;
      long need = M;
      if (m >= 1 && two[m - 1] >= need) {
        int left = 0, right = m - 1, idx = m;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          if (two[mid] >= need) {
            idx = Math.min(idx, mid);
            right = mid - 1;
          } else {
            left = mid + 1;
          }
        }
        result = Math.min(result, 2 * (idx + 1));
      }

      for (int i = 0; i < n; i++) {
        need = M - one[i];
        if (need <= 0) {
          result = Math.min(result, i + 1);
        } else {
          if (m >= 1 && two[m - 1] >= need) {
            int left = 0, right = m - 1, idx = m;
            while (left <= right) {
              int mid = left + (right - left) / 2;
              if (two[mid] >= need) {
                idx = Math.min(idx, mid);
                right = mid - 1;
              } else {
                left = mid + 1;
              }
            }
            result = Math.min(result, (i + 1) + 2 * (idx + 1));
          }
        }
      }
      out.println(result == Integer.MAX_VALUE ? -1 : result);
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
    try (CleaningThePhone instance = new CleaningThePhone()) {
      instance.solve();
    }
  }
}
