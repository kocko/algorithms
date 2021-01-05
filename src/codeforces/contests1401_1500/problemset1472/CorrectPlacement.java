package codeforces.contests1401_1500.problemset1472;

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

public class CorrectPlacement implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      List<Friend> list = new ArrayList<>();
      for (int i = 0; i < 2 * n; i += 2) {
        int h = in.ni(), w = in.ni();
        list.add(new Friend(i, w, h));
        list.add(new Friend(i | 1, h, w));
      }
      list.sort(Comparator.naturalOrder());
      int[] prefix = new int[2 * n];
      prefix[0] = 0;
      int minWidth = list.get(0).w, index = 0;
      for (int i = 1; i < 2 * n; i++) {
        int w = list.get(i).w;
        if (w < minWidth) {
          minWidth = w;
          index = i;
        }
        prefix[i] = index;
      }
      int[] result = new int[n];
      for (int i = 0; i < 2 * n; i++) {
        Friend f = list.get(i);
        if (f.idx % 2 == 0) {
          int h = f.h, w = f.w;
          int left = 0, right = i - 1;
          int best = -1;
          while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid).h < h) {
              best = Math.max(best, mid);
              left = mid + 1;
            } else {
              right = mid - 1;
            }
          }
          if (best != -1) {
            int min = list.get(prefix[best]).w;
            if (min < w) {
              result[f.idx / 2] = list.get(prefix[best]).idx / 2 + 1;
            } else {
              result[f.idx / 2] = -1;
            }
          } else {
            result[f.idx / 2] = -1;
          }
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(result[i]);
        out.print(' ');
      }
      out.println();
    }
  }

  private class Friend implements Comparable<Friend> {
    private int idx, w, h;

    private Friend(int idx, int h, int w) {
      this.idx = idx;
      this.h = h;
      this.w = w;
    }

    @Override
    public int compareTo(Friend friend) {
      return Integer.compare(this.h, friend.h);
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
    try (CorrectPlacement instance = new CorrectPlacement()) {
      instance.solve();
    }
  }
}
