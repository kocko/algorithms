package codeforces.contests1801_1900.problemset1843;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TrackingSegments implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TrackingSegments() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), m = in.ni();
      List<int[]> segments = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        int left = in.ni(), right = in.ni();
        segments.add(new int[]{left, right});
      }

      int q = in.ni();
      int[] queries = new int[q];
      for (int i = 0; i < q; i++) {
        queries[i] = in.ni();
      }
      int result = n + 5;
      int left = 0, right = q;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int[] prefix = new int[n + 1];
        for (int idx = 0; idx < mid; idx++) {
          prefix[queries[idx]]++;
        }
        for (int idx = 1; idx <= n; idx++) {
          prefix[idx] += prefix[idx - 1];
        }
        boolean hasBeautiful = false;
        for (int[] segment : segments) {
          int start = segment[0], end = segment[1];
          int size = end - start + 1;
          int count = prefix[end] - prefix[start - 1];
          if (count * 2 > size) {
            hasBeautiful = true;
            break;
          }
        }
        if (hasBeautiful) {
          result = Math.min(result, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      out.println(result == n + 5 ? -1 : result);
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
    try (TrackingSegments instance = new TrackingSegments()) {
      instance.solve();
    }
  }
}
